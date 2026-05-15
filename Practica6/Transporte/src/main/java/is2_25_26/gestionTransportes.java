package is2_25_26;
import java.util.ArrayList;
import java.util.List;

public class gestionTransportes {

	private ArrayList<Conductor> cs = new ArrayList<Conductor>();

	public Conductor buscaConductor(String DNI) {
		for (Conductor c : cs) // +1
			if (c.dni().equals(DNI)) // +2 (n=1)
				return c;
		return null;
	} // CC=3 CCog=3

	public boolean anhadeConductor(String dni, String nombre, String apellido1, String apellido2, String direccion) {
		if (buscaConductor(dni) != null) // +1
			return false;
		cs.add(new Conductor(dni, nombre, apellido1, apellido2, direccion));
		return true;
	} // CC=2 CCog=1

	public List<Conductor> conductores() { return cs; } // CC=1

	// WMC=6 CCog=4
}
