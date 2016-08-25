package ejercicio5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 8/25/16.
 */
public class MultiplosTest {
    private Multiplos multiplos;

    @Before
    public void setUp() {
        multiplos = new Multiplos();
    }

    @Test
    public void multiploTest1() throws Exception {
        int resultado = multiplos.multiplo(3,9);
        assertEquals(999, resultado);
    }

    @Test
    public void multiploTest2() throws Exception {
        int resultado = multiplos.multiplo(2,250);
        assertEquals(1000, resultado);
    }

    @Test
    public void multiploTest3() throws Exception {
        int resultado = multiplos.multiplo(300,4);
        assertEquals(900, resultado);
    }

    @Test
    public void noExisteMultiplo() throws Exception {
        int resultado = multiplos.multiplo(2,2500);
        assertEquals(-1, resultado);
    }

}