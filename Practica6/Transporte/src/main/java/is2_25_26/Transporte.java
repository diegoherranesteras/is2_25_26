/* Clase que representa un transporte realizado por un conductor */
package is2_25_26;

public class Transporte {

	private double horas;
	private int ton;
	private int personas;
	private CategoriaTransporte cat;

	/**
	 * Constructor de la clase Transporte
	 * @param horas Horas que ha durado el transporte
	 * @param cat Categoria del transporte
	 * @param valor En caso de ser un transporte de tipo Personas,
	 * representa el numero de personas, en caso de ser de tipo Mercancias
	 * representa las toneladas
	 */
	public Transporte(double horas, CategoriaTransporte cat, int valor) throws IllegalArgumentException {
		if (horas <= 0 || valor <= 0 || cat == null) { // +1 +1
			throw new IllegalArgumentException();
		}
		this.horas = horas;
		this.cat = cat;
		if (cat.equals(CategoriaTransporte.Personas)) { // +1
			this.personas = valor;
		} else { // +1
			this.ton = valor;
		}
	} // CC=5 CCog=4

	public double horas() { return horas; } // CC=1

	public CategoriaTransporte categoria() { return cat; } // CC=1

	public int ton() { return ton; } // CC=1

	public int getPersonas() { return personas; } // CC=1

	// WMC=9 CCog=4
}
