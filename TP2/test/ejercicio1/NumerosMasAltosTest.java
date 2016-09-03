package ejercicio1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by julianpascual on 8/28/16.
 */
public class NumerosMasAltosTest {
    private NumerosMasAltos numAltos;

    @Before
    public void setUp() throws Exception {
        numAltos = new NumerosMasAltos();
    }

    @Test
    public void losMasAltos() throws Exception {
        int[] numeros = {6,2,8,10};
        int[] losMasAltos = numAltos.losMasAltos(numeros);

        Assert.assertEquals(10, losMasAltos[0]);
        Assert.assertEquals(8, losMasAltos[1]);
    }

    @Test
    public void losMasAltos2() throws Exception {
        int[] numeros = {4,1,3,2};
        int[] losMasAltos = numAltos.losMasAltos(numeros);

        Assert.assertEquals(4, losMasAltos[0]);
        Assert.assertEquals(3, losMasAltos[1]);
    }

    @Test
    public void losMasAltos3() throws Exception {
        int[] numeros = {7,1,2,9,125,9,12};
        int[] losMasAltos = numAltos.losMasAltos(numeros);

        Assert.assertEquals(125, losMasAltos[0]);
        Assert.assertEquals(12, losMasAltos[1]);
    }

    @Test
    public void losMasAltos4() throws Exception {
        int[] numeros = {7,7,1,2,3,4,5};
        int[] losMasAltos = numAltos.losMasAltos(numeros);

        Assert.assertEquals(7, losMasAltos[0]);
        Assert.assertEquals(7, losMasAltos[1]);
    }

}