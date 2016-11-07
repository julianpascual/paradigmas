package ejercicio7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 11/7/16.
 */
public class LacteosTest {
    private  Lacteos lacteo;
    @Before
    public void setUp() throws Exception {
        lacteo=new Lacteos();
        lacteo.setPrecio(20);
    }

    @Test
    public void getPrecioVenta() throws Exception {
        Assert.assertTrue(16 == lacteo.getPrecioVenta());
    }

}