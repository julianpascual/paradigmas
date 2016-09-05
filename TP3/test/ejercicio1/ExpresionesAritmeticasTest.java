package ejercicio1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 9/5/16.
 */
public class ExpresionesAritmeticasTest {
    private ExpresionesAritmeticas expAritm;

    @Before
    public void setUp() throws Exception {
        expAritm = new ExpresionesAritmeticas();
    }

    @Test
    public void resolverExpresionSuma() throws Exception {
        double result = expAritm.resolverExpresion("2 + 542");
        assertEquals(544, result, 0.1);
    }

    @Test
    public void resolverExpresionResta() throws Exception {
        double result = expAritm.resolverExpresion("32 - 19");
        assertEquals(13, result, 0.1);
    }

    @Test
    public void resolverExpresionDivision() throws Exception {
        double result = expAritm.resolverExpresion("250 / 50");
        assertEquals(5, result, 0.1);
    }

    @Test
    public void resolverExpresionMultiplicacion() throws Exception {
        double result = expAritm.resolverExpresion("51 * 2");
        assertEquals(102, result, 0.1);
    }

    @Test
    public void resolverExpresionInvalida() throws Exception {
        double result = expAritm.resolverExpresion("51 @ 2");
        assertEquals(-1, result, 0.1);
    }

    @Test
    public void resolverExpresionInvalida2() throws Exception {
        double result = expAritm.resolverExpresion("51 @");
        assertEquals(-1, result, 0.1);
    }
}