package is2_25_26;
import java.util.List;
import fundamentos.*;

/**
 * Gestion de una empresa de transportes
 */
public class GestionTransportesGUI {

	private static final int ANHADE_CONDUCTOR = 0;
	private static final int ANHADE_TRANSPORTE = 1;
	private static final int SUELDO_CONDUCTOR = 2;
	private static final int MEJOR_CONDUCTOR = 3;

	private GestionTransportes gt = new GestionTransportes();

	/**
	 * Programa principal basado en menu
	 */
	public static void main(String[] args) {
		new GestionTransportesGUI().ejecuta();
	} // CC=1

	public void ejecuta() {
		Menu menu = creaMenu();
		while (true) { // +1
			int opcion = menu.leeOpcion();
			switch (opcion) { // +2 (n=1)
				case ANHADE_CONDUCTOR:
					anhadeConductor();
					break;
				case ANHADE_TRANSPORTE:
					anhadeTransporte();
					break;
				case SUELDO_CONDUCTOR:
					consultaSueldo();
					break;
				case MEJOR_CONDUCTOR:
					consultaMejorConductor();
					break;
			}
		}
	} // CC=6 CCog=3

	private Menu creaMenu() {
		Menu menu = new Menu("Transportes");
		menu.insertaOpcion("Anhade conductor", ANHADE_CONDUCTOR);
		menu.insertaOpcion("Anhade transporte", ANHADE_TRANSPORTE);
		menu.insertaOpcion("Sueldo conductor", SUELDO_CONDUCTOR);
		menu.insertaOpcion("Mejor conductor", MEJOR_CONDUCTOR);
		return menu;
	} // CC=1

	private void anhadeConductor() {
		Lectura lect = new Lectura("Datos Conductor");
		lect.creaEntrada("DNI", "");
		lect.creaEntrada("Nombre", "");
		lect.creaEntrada("Apellido1", "");
		lect.creaEntrada("Apellido2", "");
		lect.creaEntrada("Direccion", "");
		lect.esperaYCierra();
		String dni = lect.leeString("DNI");
		String nombre = lect.leeString("Nombre");
		String apellido1 = lect.leeString("Apellido1");
		String apellido2 = lect.leeString("Apellido2");
		String direccion = lect.leeString("Direccion");
		if (!gt.anhadeConductor(dni, nombre, apellido1, apellido2, direccion)) { // +1
			mensaje("ERROR", "Ya existe un conductor con DNI " + dni);
		}
	} // CC=2 CCog=1

	private void anhadeTransporte() {
		Lectura lect = new Lectura("Nuevo transporte");
		lect.creaEntrada("DNI", "");
		lect.creaEntrada("Tipo Transporte: P | M | MP", "");
		lect.creaEntrada("Horas", 0);
		lect.creaEntrada("Personas", 0);
		lect.creaEntrada("Toneladas", 0);
		lect.esperaYCierra();
		String dni = lect.leeString("DNI");
		String tipo = lect.leeString("Tipo Transporte: P | M | MP");
		int horas = lect.leeInt("Horas");
		int personas = lect.leeInt("Personas");
		int toneladas = lect.leeInt("Toneladas");

		Conductor c = gt.buscaConductor(dni);
		if (c == null) { // +1
			mensaje("ERROR", "No existe un conductor con DNI " + dni);
			return;
		}
		Transporte t = creaTransporte(tipo, horas, personas, toneladas);
		if (t != null) { // +1
			c.anhadeTransporte(t);
		}
	} // CC=3 CCog=2

	private Transporte creaTransporte(String tipo, int horas, int personas, int toneladas) {
		switch (tipo) { // +1
			case "P":
				return new TransportePersonas(horas, personas);
			case "M":
				return new TransporteMercancias(horas, toneladas);
			case "MP":
				return new TransporteMercanciasPeligrosas(horas, toneladas);
		}
		return null;
	} // CC=4 CCog=1

	private void consultaSueldo() {
		Lectura lect = new Lectura("Sueldo conductor");
		lect.creaEntrada("DNI", "");
		lect.esperaYCierra();
		String dni = lect.leeString("DNI");
		Conductor c = gt.buscaConductor(dni);
		if (c == null) { // +1
			mensaje("ERROR", "No existe un conductor con DNI " + dni);
			return;
		}
		mensaje("Sueldo", "El sueldo del conductor es: " + c.sueldo());
	} // CC=2 CCog=1

	private void consultaMejorConductor() {
		List<Conductor> mejores = gt.mejoresConductores();
		String msj;
		if (mejores.isEmpty()) { // +1
			msj = "No hay conductores";
		} else { // +1
			StringBuilder sb = new StringBuilder();
			for (Conductor c : mejores) { // +2 (n=1)
				sb.append(c.getNombre()).append(" ").append(c.getApellido1()).append("\n");
			}
			msj = sb.toString();
		}
		mensaje("MEJOR CONDUCTOR", msj);
	} // CC=3 CCog=4

	/**
	 * Metodo auxiliar que muestra un ventana de mensaje
	 * @param titulo titulo de la ventana
	 * @param txt texto contenido en la ventana
	 */
	private static void mensaje(String titulo, String txt) {
		Mensaje msj = new Mensaje(titulo);
		msj.escribe(txt);
	} // CC=1

	// WMC=23 CCog=12
}
