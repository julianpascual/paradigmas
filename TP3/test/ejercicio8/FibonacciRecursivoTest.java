package ejercicio8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Julian on 14/9/16.
 */
public class FibonacciRecursivoTest {
    private FibonacciRecursivo fib;

    @Before
    public void setUp() throws Exception {
        fib = new FibonacciRecursivo();
    }

    @Test
    public void obtenerNumeroFibonacciCero() throws Exception {
        int nro = fib.obtenerNumeroFibonacci(0);
        assertEquals(0, nro);
    }

    @Test
    public void obtenerNumeroFibonacciUno() throws Exception {
        int nro = fib.obtenerNumeroFibonacci(1);
        assertEquals(1, nro);
    }

    @Test
    public void obtenerSegundoNumeroFibonacci() throws Exception {
        int nro = fib.obtenerNumeroFibonacci(2);
        assertEquals(1, nro);
    }

    @Test
    public void obtenerQuintoNumeroFibonacci() throws Exception {
        int nro = fib.obtenerNumeroFibonacci(5);
        assertEquals(5, nro);
    }

    @Test
    public void obtenerDecimoNumeroFibonacci() throws Exception {
        int nro = fib.obtenerNumeroFibonacci(10);
        assertEquals(55, nro);
    }

    @Test
    public void obtenerVigecimoNumeroFibonacci() throws Exception {
        int nro = fib.obtenerNumeroFibonacci(20);
        assertEquals(6765, nro);
    }

}