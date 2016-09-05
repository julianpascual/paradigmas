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
    public void checkExpression() throws Exception {
        boolean estaBalanceada = balanceador.checkExpression("{[1+2+(3*4)]/4}");
        assertTrue(estaBalanceada);
    }

    @Test
    public void checkExpressionSoloParentesis() throws Exception {
        boolean estaBalanceada = balanceador.checkExpression("(3*4)/4");
        assertTrue(estaBalanceada);
    }

    @Test
    public void checkExpressionFalse() throws Exception {
        boolean estaBalanceada = balanceador.checkExpression("{[1+2+3*4)]/4}");
        assertFalse(estaBalanceada);
    }

}