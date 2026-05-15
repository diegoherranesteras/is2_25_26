package is2_25_26;

public class TransportePersonas extends Transporte {

	private static final int UMBRAL_COLECTIVO = 10;
	private static final double EXTRA_NO_COLECTIVO = 0.5;
	private static final double EXTRA_COLECTIVO = 1.0;

	private int personas;

	public TransportePersonas(double horas, int personas) {
		super(horas);
		if (personas <= 0) { // +1
			throw new IllegalArgumentException();
		}
		this.personas = personas;
	} // CC=2 CCog=1

	public int getPersonas() { return personas; } // CC=1

	@Override
	public double sueldoTransporte() {
		if (personas < UMBRAL_COLECTIVO) { // +1
			return horas * (EXTRA_POR_HORA + EXTRA_NO_COLECTIVO);
		}
		return horas * (EXTRA_POR_HORA + EXTRA_COLECTIVO);
	} // CC=2 CCog=1

	// WMC=5 CCog=2
}
