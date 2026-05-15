package is2_25_26;

public class TransporteMercanciasPeligrosas extends TransporteMercancias {

	private static final double SUPLEMENTO_PELIGRO = 50.0;

	public TransporteMercanciasPeligrosas(double horas, int toneladas) {
		super(horas, toneladas);
	} // CC=1

	@Override
	public double sueldoTransporte() {
		return super.sueldoTransporte() + SUPLEMENTO_PELIGRO;
	} // CC=1

	// WMC=2 CCog=0
}
