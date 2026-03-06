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
    public Cliente nuevoCliente(Cliente c) {
        // TODO: Implementar alta de cliente [cite: 2473]
        return null;
    }

    @Override
    public Cliente bajaCliente(String dni) {
        // TODO: Implementar baja de cliente [cite: 2475]
        return null;
    }


    public Cliente cliente(String dni) {
        // TODO: Implementar consulta de cliente (Caso de uso Consulta Cliente) [cite: 2537]
        return null;
    }


    @Override
    public Seguro nuevoSeguro(Seguro s, String dni) {
        // TODO: Implementar nuevo seguro asociado a un cliente [cite: 2502]
        return null;
    }

    @Override
    public Seguro bajaSeguro(String matricula, String dni) {
        // TODO: Implementar baja de un seguro [cite: 2505]
        return null;
    }

    @Override
    public Seguro anhadeConductorAdicional(String matricula, String conductor) {
        // TODO: Implementar añadir conductor adicional [cite: 2508]
        return null;
    }
    public Seguro seguro(String matricula) {
        // Implementa el CU: Consulta Seguro [cite: 1, 106]
        return null;
    }
}