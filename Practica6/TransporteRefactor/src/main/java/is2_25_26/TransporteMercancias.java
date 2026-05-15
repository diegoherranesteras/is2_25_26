package is2_25_26;

public class TransporteMercancias extends Transporte {

	protected static final double EXTRA_POR_TONELADA = 2.0;

	protected int toneladas;

	public TransporteMercancias(double horas, int toneladas) {
		super(horas);
		if (toneladas <= 0) { // +1
			throw new IllegalArgumentException();
		}
		this.toneladas = toneladas;
	} // CC=2 CCog=1

	public int getToneladas() { return toneladas; } // CC=1

	@Override
	public double sueldoTransporte() {
		return horas * EXTRA_POR_HORA + toneladas * EXTRA_POR_TONELADA;
	} // CC=1

	// WMC=4 CCog=1
}
