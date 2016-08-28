package ejercicio6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/**
 * Created by julianpascual on 8/25/16.
 */
public class OrdenarRealesTest {
    private OrdenarReales ordReales;

    @Before
    public void setUp(){
        ordReales = new OrdenarReales();
    }

    @Test
    public void ordenarNumerosPositivos() throws Exception {
        float[] resultado = ordReales.ordenarNumeros(3,5,7);
        float[] esperado = {7,5,3};
        Assert.assertArrayEquals(esperado,resultado, 0);
    }

    @Test
    public void ordenarNumerosNegativos() throws Exception {
        float[] resultado = ordReales.ordenarNumeros(-3,-5,-7);
        float[] esperado = {-3,-5,-7};
        Assert.assertArrayEquals(esperado,resultado, 0);
    }

    @Test
    public void ordenarNumerosMixtos() throws Exception {
        float[] resultado = ordReales.ordenarNumeros(7,-1,-7);
        float[] esperado = {7,-1,-7};
        Assert.assertArrayEquals(esperado,resultado, 0);
    }

    @Test
    public void ordenarNumerosMixtos2() throws Exception {
        float[] resultado = ordReales.ordenarNumeros((float) 2.97,3,2);
        float[] esperado = {3,(float) 2.97,2};
        Assert.assertArrayEquals(esperado,resultado, (float) .01);
    }

    @Test
    public void ordenarNumerosMixtos3() throws Exception {
        float[] resultado = ordReales.ordenarNumeros((float) -2.97,3,2);
        float[] esperado = {3,2,(float) -2.97};
        Assert.assertArrayEquals(esperado,resultado, (float).01);
    }

    @Test
    public void ordenarNumerosDecimales() throws Exception {
        float[] resultado = ordReales.ordenarNumeros((float)2.9,(float)2.98,(float)2.99);
        float[] esperado = {(float)2.99,(float)2.98,(float)2.9};
        Assert.assertArrayEquals(esperado,resultado, (float).01);
    }

}