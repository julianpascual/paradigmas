package ejercicio7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 11/7/16.
 */
public class CarneTest {
    Carne carneBlanca;
    Carne carneRoja;
    @Before
    public void setUp() throws Exception {
        carneBlanca=new Carne(Carne.tipoCarne.blanca);
        carneBlanca.setPrecio(60);
        carneRoja=new Carne(Carne.tipoCarne.roja);
        carneRoja.setPrecio(90);
    }

    @Test
    public void getPrecioVenta() throws Exception {
        Assert.assertTrue(81 == carneRoja.getPrecioVenta());
        Assert.assertTrue(60 == carneBlanca.getPrecioVenta());
    }

}