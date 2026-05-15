package is2_25_26;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TransporteTest {

	@Test
	public void testMercancias() {
		TransporteMercancias sut = new TransporteMercancias(1, 1);
		assertEquals(1, sut.getHoras());
		assertEquals(1, sut.getToneladas());

		sut = new TransporteMercancias(10, 1000);
		assertEquals(10, sut.getHoras());
		assertEquals(1000, sut.getToneladas());

		assertThrows(IllegalArgumentException.class, () -> new TransporteMercancias(0, 1));
		assertThrows(IllegalArgumentException.class, () -> new TransporteMercancias(10, 0));
	}

	@Test
	public void testMercanciasPeligrosas() {
		TransporteMercanciasPeligrosas sut = new TransporteMercanciasPeligrosas(10, 1000);
		assertEquals(10, sut.getHoras());
		assertEquals(1000, sut.getToneladas());

		assertThrows(IllegalArgumentException.class, () -> new TransporteMercanciasPeligrosas(0, 1));
		assertThrows(IllegalArgumentException.class, () -> new TransporteMercanciasPeligrosas(10, 0));
	}

	@Test
	public void testPersonas() {
		TransportePersonas sut = new TransportePersonas(10, 10);
		assertEquals(10, sut.getHoras());
		assertEquals(10, sut.getPersonas());

		assertThrows(IllegalArgumentException.class, () -> new TransportePersonas(0, 1));
		assertThrows(IllegalArgumentException.class, () -> new TransportePersonas(10, 0));
	}

}
