package ejercicio1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by julianpascual on 8/24/16.
 */
public class Ejercicio1Test {
    private Ejercicio1 ej1;

    @Before
    public void setUp(){
        ej1 = new Ejercicio1();
    }

    @Test
    public void pertenece() throws Exception {
        boolean resultado = ej1.perteneceRecta(1,10);
        Assert.assertTrue(resultado);
    }

    @Test
    public void noPertenece() throws Exception {
        boolean resultado = ej1.perteneceRecta(1,8);
        Assert.assertFalse(resultado);
    }

}