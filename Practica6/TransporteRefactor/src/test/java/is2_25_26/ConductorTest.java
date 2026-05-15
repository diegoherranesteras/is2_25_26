package is2_25_26;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ConductorTest {

	private static Conductor sut;

	@Test
	public void testConstructor() {
		sut = new Conductor("123123123X", "Pepe", "Martinez", "Fernandez", "Avda. de los Castros s/n");
		assertEquals("123123123X", sut.getDni());
		assertEquals("Pepe", sut.getNombre());
		assertEquals("Martinez", sut.getApellido1());
		assertEquals("Fernandez", sut.getApellido2());
		assertEquals("Avda. de los Castros s/n", sut.getDireccion());

		sut = new Conductor("123123123X", "Pepe", "Martinez", null, "Avda. de los Castros s/n");
		assertEquals("123123123X", sut.getDni());
		assertEquals("Pepe", sut.getNombre());
		assertEquals("Martinez", sut.getApellido1());
		assertNull(sut.getApellido2());
		assertEquals("Avda. de los Castros s/n", sut.getDireccion());

		assertThrows(IllegalArgumentException.class, () -> new Conductor(null, "Pepe", "Martinez", "Fernandez", "Avda. de los Castros s/n"));
		assertThrows(IllegalArgumentException.class, () -> new Conductor("123123123X", null, "Martinez", "Fernandez", "Avda. de los Castros s/n"));
		assertThrows(IllegalArgumentException.class, () -> new Conductor("123123123X", "Pepe", null, "Fernandez", "Avda. de los Castros s/n"));
		assertThrows(IllegalArgumentException.class, () -> new Conductor("123123123X", "Pepe", "Martinez", "Fernandez", null));
	}

	@Test
	public void testSueldoYAnhadeTransporte() {
		sut = new Conductor("123123123X", "Pepe", "Martinez", "Fernandez", "Avda. de los Castros s/n");

		assertTrue(sut.sueldo() == 700);

		sut.anhadeTransporte(new TransportePersonas(1, 1));
		assertEquals(705.5, sut.sueldo());

		sut.anhadeTransporte(new TransportePersonas(10, 9));
		assertEquals(760.5, sut.sueldo());

		sut.anhadeTransporte(new TransportePersonas(1, 10));
		assertEquals(766.5, sut.sueldo());

		sut.anhadeTransporte(new TransportePersonas(10, 20));
		assertEquals(826.5, sut.sueldo());

		sut.anhadeTransporte(new TransporteMercancias(1, 1));
		assertEquals(833.5, sut.sueldo());

		sut.anhadeTransporte(new TransporteMercanciasPeligrosas(10, 100));
		assertEquals(1133.5, sut.sueldo());
	}

}
