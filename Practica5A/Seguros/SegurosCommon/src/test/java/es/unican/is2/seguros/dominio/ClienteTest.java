package es.unican.is2.seguros.dominio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.unican.is2.Cliente;
import es.unican.is2.Cobertura;
import es.unican.is2.Seguro;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    private LocalDate hace2Anios;
    private LocalDate hace6Meses;
    private LocalDate maniana;

    @BeforeEach
    public void setUp() {
        hace2Anios = LocalDate.now().minusYears(2);
        hace6Meses = LocalDate.now().minusMonths(6);
        maniana = LocalDate.now().plusDays(1);
    }

    @Test
    public void testTotalSeguros_SinSeguros() {
        Cliente c = new Cliente("11111111A", "Juan", false);
        assertEquals(0.0, c.totalSeguros(), 0.001);
    }

    @Test
    public void testTotalSeguros_SinSeguros_ConMinusvalia() {
        Cliente c = new Cliente("33333333A", "Luis", true);
        assertEquals(0.0, c.totalSeguros(), 0.001);
    }

    @Test
    public void testUnSeguro() {
        Cliente c = new Cliente("22222222A", "Ana", false);
        Seguro s = new Seguro(1L, "2222AAA", 25, Cobertura.TERCEROS_LUNAS, hace2Anios);
        List<Seguro> lista = new ArrayList<>();
        lista.add(s);
        c.setSeguros(lista);
        assertEquals(600.0, c.totalSeguros(), 0.001);
    }

    @Test
    public void testUnSeguro_ConMinusvalia() {
        Cliente c = new Cliente("22222222A", "Ana", true);
        Seguro s = new Seguro(1L, "2222AAA", 25, Cobertura.TERCEROS_LUNAS, hace2Anios);
        List<Seguro> lista = new ArrayList<>();
        lista.add(s);
        c.setSeguros(lista);
        assertEquals(450.0, c.totalSeguros(), 0.001);
    }

    @Test
    public void testDosSeguros() {
        Cliente c = new Cliente("44444444A", "Pepe", false);
        Seguro s1 = new Seguro(1L, "4444AAA", 40, Cobertura.TERCEROS, hace2Anios);
        Seguro s2 = new Seguro(2L, "4444BBB", 300, Cobertura.TERCEROS_LUNAS, hace2Anios);
        List<Seguro> lista = new ArrayList<>();
        lista.add(s1);
        lista.add(s2);
        c.setSeguros(lista);
        assertEquals(1120.0, c.totalSeguros(), 0.001);
    }

    @Test
    public void testSeguroNoVigente() {
        Cliente c = new Cliente("11111111A", "Juan", false);
        Seguro s = new Seguro(1L, "1111AAA", 50, Cobertura.TERCEROS, maniana);
        List<Seguro> lista = new ArrayList<>();
        lista.add(s);
        c.setSeguros(lista);
        assertEquals(0.0, c.totalSeguros(), 0.001);
    }
}