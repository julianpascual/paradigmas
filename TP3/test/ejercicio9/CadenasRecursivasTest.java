package ejercicio9;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by Julian on 14/9/16.
 */
public class CadenasRecursivasTest {
    private CadenasRecursivas cad;

    @Before
    public void setUp() throws Exception {
        cad = new CadenasRecursivas();
    }

    @Test
    public void obtenerCadenaTamaño2() throws Exception {
        ArrayList<String> arrayEsperado = new ArrayList<>(Arrays.asList("AA", "AN", "NA", "NN"));
        ArrayList<String> resultado = cad.obtenerCadena(2);
        assertArrayEquals(arrayEsperado.toArray(), resultado.toArray());
        assertEquals(4, resultado.size());
    }

    @Test
    public void obtenerCadenaTamaño3() throws Exception {
        ArrayList<String> arrayEsperado = new ArrayList<>(Arrays.asList("AAA","AAN","ANA","ANN","NAA","NAN","NNA","NNN"));
        ArrayList<String> resultado = cad.obtenerCadena(3);
        assertArrayEquals(arrayEsperado.toArray(), resultado.toArray());
        assertEquals(8, resultado.size());
    }

    @Test
    public void obtenerCadenaTamaño4() throws Exception {
        ArrayList<String> resultado = cad.obtenerCadena(4);
        assertEquals(16, resultado.size());
    }

    @Test
    public void obtenerCadenaTamaño8() throws Exception {
        ArrayList<String> resultado = cad.obtenerCadena(8);
        assertEquals(256, resultado.size());
    }

}