package ejercicio3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 8/25/16.
 */
public class FactorialTest {
    private Factorial factorial;

    @Before
    public void setUp(){
        factorial = new Factorial();
    }

    @Test
    public void obtenerFactorial() throws Exception {
        int fact = factorial.obtenerFactorial(5);
        assertEquals(120,fact);
    }

    @Test
    public void obtenerFactorialCero() throws Exception {
        int fact = factorial.obtenerFactorial(0);
        assertEquals(1,fact);
    }

    @Test
    public void obtenerFactorialNumeroNegativoNoExiste() throws Exception {
        int fact = factorial.obtenerFactorial(-3);
        assertEquals(-1,fact);
    }


}