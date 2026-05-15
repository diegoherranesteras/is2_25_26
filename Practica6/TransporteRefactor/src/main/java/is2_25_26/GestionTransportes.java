package is2_25_26;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GestionTransportes {

	private List<Conductor> conductores = new ArrayList<>();

	public Conductor buscaConductor(String dni) {
		for (Conductor c : conductores) { // +1
			if (c.getDni().equals(dni)) { // +2 (n=1)
				return c;
			}
		}
		return null;
	} // CC=3 CCog=3

	public boolean anhadeConductor(String dni, String nombre, String apellido1, String apellido2, String direccion) {
		if (buscaConductor(dni) != null) { // +1
			return false;
		}
		conductores.add(new Conductor(dni, nombre, apellido1, apellido2, direccion));
		return true;
	} // CC=2 CCog=1

	public List<Conductor> conductores() { return conductores; } // CC=1

	public List<Conductor> mejoresConductores() {
		List<Conductor> mejores = new LinkedList<>();
		double maxSueldo = 0.0;
		for (Conductor c : conductores) { // +1
			double sueldo = c.sueldo();
			if (sueldo > maxSueldo) { // +2 (n=1)
				maxSueldo = sueldo;
				mejores.clear();
				mejores.add(c);
			} else if (sueldo == maxSueldo) { // +1
				mejores.add(c);
			}
		}
		return mejores;
	} // CC=4 CCog=4

	// WMC=10 CCog=8
}
