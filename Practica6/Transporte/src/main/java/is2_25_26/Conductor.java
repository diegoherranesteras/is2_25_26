package is2_25_26;
import java.util.ArrayList;

/**
 * Clase que representa a un conductor, con sus datos personales
 * y los transportes que ha realizado.
 */
public class Conductor {

	private ArrayList<Transporte> transportes = new ArrayList<Transporte>();
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dire;

	public Conductor(String dni, String nombre, String apellido1,
			String apellido2, String direccion) {
		if (dni == null || nombre == null || apellido1 == null || direccion == null) { // +1 +1
			throw new IllegalArgumentException();
		}
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dire = direccion;
	} // CC=5 CCog=2

	public String dni() { return dni; } // CC=1

	public String getDni() { return dni; } // CC=1

	public String getNombre() { return nombre; } // CC=1

	public String getApellido1() { return apellido1; } // CC=1

	public String apellido2() { return apellido2; } // CC=1

	public String getDire() { return dire; } // CC=1

	public double sueldo() {
		double sueldoTransportes = 0;
		for (Transporte t : transportes) { // +1
			double sueldoExtraTransporte = 0.0;
			switch (t.categoria()) { // +2 (n=1)
				case Mercancias:
					sueldoExtraTransporte = t.ton() * 2;
					break;
				case MercanciasPeligrosas:
					sueldoExtraTransporte = t.ton() * 2 + 50;
					break;
				case Personas:
					if (t.getPersonas() < 10) // +3 (n=2)
						sueldoExtraTransporte = t.horas() * 0.5;
					else // +1
						sueldoExtraTransporte = t.horas();
					break;
			}
			sueldoTransportes += t.horas() * 5 + sueldoExtraTransporte;
		}
		return 700 + sueldoTransportes;
	} // CC=6 CCog=7

	public void anhadeTransporte(Transporte t) { transportes.add(t); } // CC=1

	// WMC=18 CCog=9
}
