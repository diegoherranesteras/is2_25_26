package es.unican.is2.practica5b;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConjuntoOrdenadoTest {

    private ConjuntoOrdenado<Integer> conjunto;

    @BeforeEach
    public void setUp() {
        conjunto = new ConjuntoOrdenado<>();
    }

    // add
    // CP1-CE1
    @Test
    public void testAddNull() {
        assertThrows(NullPointerException.class, () -> conjunto.add(null));
    }

    // CP2-CE2
    @Test
    public void testAddDuplicado() {
        conjunto.add(5);
        boolean resultado = conjunto.add(5);
        assertFalse(resultado);
        assertEquals(1, conjunto.size());
    }

    // CP3 - CE3, CE4 
    @Test
    public void testAddConjuntoVacio() {
        boolean resultado = conjunto.add(5);
        assertTrue(resultado);
        assertEquals(1, conjunto.size());
        assertEquals(5, conjunto.get(0));
    }

    // CP4-CE3,CE5
    @Test
    public void testAddAlInicio() {
        conjunto.add(3);
        conjunto.add(5);
        conjunto.add(1);
        assertEquals(1, conjunto.get(0));
        assertEquals(3, conjunto.get(1));
        assertEquals(5, conjunto.get(2));
    }

    // CP5 - CE3, CE6
    @Test
    public void testAddAlFinal() {
        conjunto.add(3);
        conjunto.add(5);
        conjunto.add(7);
        assertEquals(7, conjunto.get(2));
    }

    //CP6 - CE3, CE7
    @Test
    public void testAddEnMedio() {
        conjunto.add(1);
        conjunto.add(5);
        conjunto.add(3);
        assertEquals(1, conjunto.get(0));
        assertEquals(3, conjunto.get(1));
        assertEquals(5, conjunto.get(2));
    }

    // get

    //CP7 - CE8
    @Test
    public void testGetIndiceNegativo() {
        conjunto.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> conjunto.get(-1));
    }

    // CP8 - CE9
    @Test
    public void testGetIndiceIgualSize() {
        conjunto.add(1);
        assertThrows(IndexOutOfBoundsException.class,
            () -> conjunto.get(conjunto.size()));
    }

    // CP9 - CE10: si el índice mayor que size lanza IndexOutOfBoundsException
    @Test
    public void testGetIndiceMayorSize() {
        conjunto.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> conjunto.get(10));
    }

    // CP10 - CE11, CE12 accede al primer elemento
    @Test
    public void testGetPrimerElemento() {
        conjunto.add(1);
        conjunto.add(3);
        assertEquals(1, conjunto.get(0));
    }

    // CP11 - CE11, CE13 accede al último elemento
    @Test
    public void testGetUltimoElemento() {
        conjunto.add(1);
        conjunto.add(3);
        assertEquals(3, conjunto.get(conjunto.size() - 1));
    }

    // CP12 - CE11, CE14 accede a elemento por medio
    @Test
    public void testGetElementoMedio() {
        conjunto.add(1);
        conjunto.add(3);
        conjunto.add(5);
        assertEquals(3, conjunto.get(1));
    }

    // remove()

    // CP13 - CE15
    @Test
    public void testRemoveIndiceNegativo() {
        conjunto.add(1);
        assertThrows(IndexOutOfBoundsException.class, () -> conjunto.remove(-1));
    }

    // CP14 - CE16
    @Test
    public void testRemoveIndiceIgualSize() {
        conjunto.add(1);
        assertThrows(IndexOutOfBoundsException.class,
            () -> conjunto.remove(conjunto.size()));
    }

    // CP15 - CE17, CE18
    @Test
    public void testRemovePrimerElemento() {
        conjunto.add(1);
        conjunto.add(3);
        conjunto.add(5);
        Integer eliminado = conjunto.remove(0);
        assertEquals(1, eliminado);
        assertEquals(2, conjunto.size());
        assertEquals(3, conjunto.get(0));
    }

    // CP16 - CE17, CE19
    @Test
    public void testRemoveUltimoElemento() {
        conjunto.add(1);
        conjunto.add(3);
        Integer eliminado = conjunto.remove(conjunto.size() - 1);
        assertEquals(3, eliminado);
        assertEquals(1, conjunto.size());
    }

    // CP17 -CE17, CE20
    @Test
    public void testRemoveElementoMedio() {
        conjunto.add(1);
        conjunto.add(3);
        conjunto.add(5);
        Integer eliminado = conjunto.remove(1);
        assertEquals(3, eliminado);
        assertEquals(2, conjunto.size());
        assertEquals(1, conjunto.get(0));
        assertEquals(5, conjunto.get(1));
    }

    //size()

    // CP18
    @Test
    public void testSizeVacio() {
        assertEquals(0, conjunto.size());
    }

    // cp19
    @Test
    public void testSizeConElementos() {
        conjunto.add(1);
        conjunto.add(2);
        assertEquals(2, conjunto.size());
    }

    // clear

    // cp20
    @Test
    public void testClearConElementos() {
        conjunto.add(1);
        conjunto.add(2);
        conjunto.clear();
        assertEquals(0, conjunto.size());
    }

    // CP21
    @Test
    public void testClearVacio() {
        conjunto.clear();
        assertEquals(0, conjunto.size());
    }
}