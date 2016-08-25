package ejercicio4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 8/25/16.
 */
public class Ejercicio4Test {
    private Ejercicio4 ej4;

    @Before
    public void setUp(){
        ej4 = new Ejercicio4();
    }

    @Test
    public void retornarValorFuncionSumaMayorAUno() throws Exception {
        int valor = ej4.retornarValorFuncion(2,4);
        assertEquals(16, valor);
    }

    @Test
    public void retornarValorFuncionSumaIgualAUno() throws Exception {
        int valor = ej4.retornarValorFuncion(8,-7);
        assertEquals(49, valor);
    }

    @Test
    public void retornarValorFuncionSumaMenorAUno() throws Exception {
        int valor = ej4.retornarValorFuncion(2,-4);
        assertEquals(5, valor);
    }

}