package es.unican.is2;
import java.util.List;

/**
 * Gestion Seguros
 * Implementa las interfaces IGestionClientes e IGestionSeguros.
 */
public class GestionSeguros implements IGestionClientes, IGestionSeguros, IInfoSeguros {

	private IClientesDAO clientesDAO; 
	private ISegurosDAO segurosDAO;

	public GestionSeguros(IClientesDAO clientesDAO, ISegurosDAO segurosDAO) {
		this.clientesDAO = clientesDAO;
		this.segurosDAO = segurosDAO;
	}

	@Override

	public Cliente nuevoCliente(Cliente c) throws DataAccessException{
		return clientesDAO.creaCliente(c);
	}

	@Override
	public Cliente bajaCliente(String dni) throws DataAccessException{
		return clientesDAO.eliminaCliente(dni);
	}


	public Cliente cliente(String dni) throws DataAccessException{
		return clientesDAO.cliente(dni);
	}


	@Override
	public Seguro nuevoSeguro(Seguro s, String dni) throws OperacionNoValida, DataAccessException {
		Cliente cli =clientesDAO.cliente(dni);
		if (cli == null) {
			return null;
		}
		Seguro seg = segurosDAO.seguroPorMatricula(s.getMatricula());
		if (seg != null) {
			throw new OperacionNoValida("Error ya exite seguro");
		}
		return segurosDAO.creaSeguro(s);
	}

	@Override
	public Seguro bajaSeguro(String matricula, String dni) throws OperacionNoValida, DataAccessException {
		Cliente cli =clientesDAO.cliente(dni);
		if (cli == null) {
			return null;
		}
		Seguro seg = segurosDAO.seguroPorMatricula(matricula);
		if (seg == null) {
			return seg;
		}
		boolean esPropietario = false;
		for (Seguro segcli : cli.getSeguros()) {
			if (segcli.getMatricula().equals(matricula)) {
				esPropietario = true;
				break;
			}
		}
		if (!esPropietario) {
			throw new OperacionNoValida("Error: el seguro no pertenece al cliente");
		}
		return segurosDAO.eliminaSeguro(seg.getId());

	}
	
	@Override
    public Seguro anhadeConductorAdicional(String matricula, String conductor) throws DataAccessException {
    	Seguro s = segurosDAO.seguroPorMatricula(matricula);
        
        if (s == null) {
            return null;
        }
        
        s.setConductorAdicional(conductor);
        return segurosDAO.actualizaSeguro(s);
    }
    
    public Seguro seguro(String matricula) throws DataAccessException {
    	return segurosDAO.seguroPorMatricula(matricula);
    }
}
