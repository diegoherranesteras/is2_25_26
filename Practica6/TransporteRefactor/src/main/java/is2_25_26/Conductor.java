package is2_25_26;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa a un conductor, con sus datos personales
 * y los transportes que ha realizado.
 */
public class Conductor {

	private static final double SUELDO_BASE = 700.0;

	private List<Transporte> transportes = new ArrayList<>();
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String direccion;

	public Conductor(String dni, String nombre, String apellido1,
			String apellido2, String direccion) {
		if (dni == null || nombre == null || apellido1 == null || direccion == null) { // +1 +1
			throw new IllegalArgumentException();
		}
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
	} // CC=5 CCog=2

	public String getDni() { return dni; } // CC=1

	public String getNombre() { return nombre; } // CC=1

	public String getApellido1() { return apellido1; } // CC=1

	public String getApellido2() { return apellido2; } // CC=1

	public String getDireccion() { return direccion; } // CC=1

	public double sueldo() {
		double total = SUELDO_BASE;
		for (Transporte t : transportes) { // +1
			total += t.sueldoTransporte();
		}
		return total;
	} // CC=2 CCog=1

	public void anhadeTransporte(Transporte t) { transportes.add(t); } // CC=1

	// WMC=13 CCog=3
}
