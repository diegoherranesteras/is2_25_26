package es.unican.is2.seguros.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.unican.is2.Cobertura;
import es.unican.is2.Seguro;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class SeguroTest {

    private LocalDate hoy;
    private LocalDate maniana;
    private LocalDate hace6Meses;
    private LocalDate haceExacto1Anio;
    private LocalDate hace2Anios;

    @BeforeEach
    public void setUp() {
        hoy = LocalDate.now();
        maniana = hoy.plusDays(1);
        hace6Meses = hoy.minusMonths(6);
        haceExacto1Anio = hoy.minusYears(1);
        hace2Anios = hoy.minusYears(2);
    }

    @Test
    public void testCoberturaTerceros() {
        Seguro s = new Seguro(1L, "1111AAA", 15, Cobertura.TERCEROS, hace2Anios);
        assertEquals(400.0, s.precio(), 0.001);
    }

    @Test
    public void testCoberturaTercerosLunas() {
        Seguro s = new Seguro(1L, "2222AAA", 25, Cobertura.TERCEROS_LUNAS, hace2Anios);
        assertEquals(600.0, s.precio(), 0.001);
    }

    @Test
    public void testCoberturasTodoRiesgo() {
        Seguro s = new Seguro(2L, "1111BBB", 20, Cobertura.TODO_RIESGO, hace2Anios);
        assertEquals(1000.0, s.precio(), 0.001);
    }

    @Test
    public void testPotencia89() {
        Seguro s = new Seguro(1L, "1111AAA", 89, Cobertura.TERCEROS, hace2Anios);
        assertEquals(400.0, s.precio(), 0.001);
    }

    @Test
    public void testPotencia90() {
        Seguro s = new Seguro(1L, "1111AAA", 90, Cobertura.TERCEROS, hace2Anios);
        assertEquals(420.0, s.precio(), 0.001);
    }

    @Test
    public void testPotencia110() {
        Seguro s = new Seguro(1L, "1111AAA", 110, Cobertura.TERCEROS, hace2Anios);
        assertEquals(420.0, s.precio(), 0.001);
    }

    @Test
    public void testPotencia111() {
        Seguro s = new Seguro(1L, "1111AAA", 111, Cobertura.TERCEROS, hace2Anios);
        assertEquals(480.0, s.precio(), 0.001);
    }

    @Test
    public void testPotenciaAlta() {
        Seguro s = new Seguro(1L, "4444BBB", 300, Cobertura.TERCEROS, hace2Anios);
        assertEquals(480.0, s.precio(), 0.001);
    }

    @Test
    public void testDescuento20pct() {
        Seguro s = new Seguro(1L, "1111AAA", 15, Cobertura.TERCEROS, hace6Meses);
        assertEquals(320.0, s.precio(), 0.001);
    }

    @Test
    public void testSinDescuento() {
        Seguro s = new Seguro(1L, "1111AAA", 15, Cobertura.TERCEROS, haceExacto1Anio);
        assertEquals(400.0, s.precio(), 0.001);
    }

    @Test
    public void testFechaInicioNull() {
        Seguro s = new Seguro(1L, "1111AAA", 50, Cobertura.TERCEROS, null);
        assertEquals(0.0, s.precio(), 0.001);
    }

    @Test
    public void testFechaInicioFutura() {
        Seguro s = new Seguro(1L, "1111AAA", 50, Cobertura.TERCEROS, maniana);
        assertEquals(0.0, s.precio(), 0.001);
    }

    @Test
    public void testCoberturaNull() {
        Seguro s = new Seguro(1L, "1111AAA", 50, null, hace2Anios);
        assertEquals(0.0, s.precio(), 0.001);
    }
}