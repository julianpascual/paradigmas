package ejercicio4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 9/5/16.
 */
public class BalanceadorTest {
    private Balanceador balanceador;

    @Before
    public void setUp() throws Exception {
        balanceador = new Balanceador();
    }

    @Test
    public void evaluarExpresion() throws Exception {
        boolean estaBalanceada = balanceador.expresionBalanceada("{[1+2+(3*4)]/4}");
        assertTrue(estaBalanceada);
    }

    @Test
    public void evaluarExpresionCompleja() throws Exception {
        boolean estaBalanceada = balanceador.expresionBalanceada("-3-[(-2)+(-1+4)]-{-2-[(-1+3)-2]}");
        assertTrue(estaBalanceada);
    }

    @Test
    public void evaluarExpresionSoloParentesis() throws Exception {
        boolean estaBalanceada = balanceador.expresionBalanceada("(3*4)/4");
        assertTrue(estaBalanceada);
    }

    @Test
    public void evaluarExpresionFalsa() throws Exception {
        boolean estaBalanceada = balanceador.expresionBalanceada("{[1+2+(3*4)]/4");
        assertFalse(estaBalanceada);
    }

}

