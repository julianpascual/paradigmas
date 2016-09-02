package ejercicio4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 9/2/16.
 */
public class AbueloTest {
    private Abuelo abuelo;

    @Before
    public void setUp() {
        abuelo = new Abuelo();
    }

    @Test
    public void resolverEcuacion() throws Exception {
        int respuesta = abuelo.resolverEcuacion();
        assertTrue(respuesta > 0);
    }

    @Test
    public void obtenerDigitos() throws Exception {
        int[] digitos = abuelo.obtenerDigitos(92);
        assertTrue(digitos.length == 4);
    }

}