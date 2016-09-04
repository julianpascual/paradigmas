package ejercicio6;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 9/4/16.
 */
public class Ejercicio6Test {
    private Ejercicio6 ej6;

    @Before
    public void setUp() throws Exception {
        ej6 = new Ejercicio6();
    }

    @Test
    public void primosGemelos() throws Exception {
        int[] resultado = ej6.primosGemelos(10);
        assertArrayEquals(new int[]{11,13}, resultado);
    }

    @Test
    public void primosGemelos2() throws Exception {
        int[] resultado = ej6.primosGemelos(2);
        assertArrayEquals(new int[]{3,5}, resultado);
    }

    @Test
    public void primosGemelos3() throws Exception {
        int[] resultado = ej6.primosGemelos(398);
        assertArrayEquals(new int[]{419,421}, resultado);
    }
}