/* Clase que representa un transporte realizado por un conductor */
package is2_25_26;

public abstract class Transporte {

	protected static final double EXTRA_POR_HORA = 5.0;

	protected double horas;

	protected Transporte(double horas) {
		if (horas <= 0) { // +1
			throw new IllegalArgumentException();
		}
		this.horas = horas;
	} // CC=2 CCog=1

	public double getHoras() { return horas; } // CC=1

	public abstract double sueldoTransporte();

	// WMC=3 CCog=1
}
