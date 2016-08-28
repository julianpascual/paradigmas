package ejercicio2;


import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.Assert.*;

/**
 * Created by julianpascual on 8/28/16.
 */
public class Ejercicio2Test {
    private Ejercicio2 ej2;

    @Before
    public void setUp(){
        ej2 = new Ejercicio2();
    }

    @Test
    public void numeroConMasPares() throws Exception {
        int[] numeros = {2,141,1536,626,235,6466689,231};
        int numMayorCant = ej2.numeroConMasPares(numeros);
        Assert.assertEquals(6466689,numMayorCant);
    }

    @Test
    public void cantidadDePares() throws Exception {
        int nro = 98912;
        int cant = ej2.cantidadDePares(nro);
        Assert.assertEquals(2, cant);
    }

}