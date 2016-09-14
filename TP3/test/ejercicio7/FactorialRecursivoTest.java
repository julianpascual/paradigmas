package ejercicio7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Julian on 14/9/16.
 */
public class FactorialRecursivoTest {
    private FactorialRecursivo fact;

    @Before
    public void setUp() throws Exception {
        fact = new FactorialRecursivo();
    }

    @Test
    public void factorialRecursivoDeCero() throws Exception {
        double resultado = fact.factorialRecursivo(0);
        assertEquals(1, resultado, 0.1);
    }

    @Test
    public void factorialRecursivoDeCinco() throws Exception {
        double resultado = fact.factorialRecursivo(5);
        assertEquals(120, resultado, 0.1);
    }

    @Test
    public void factorialRecursivoDeNumeroAlto() throws Exception {
        double resultado = fact.factorialRecursivo(58);
        assertEquals(2.350561331282879E78, resultado, 0.1);
    }
}