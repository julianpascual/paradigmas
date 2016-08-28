package ejercicio7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 8/28/16.
 */
public class GPSTest {
    private GPS gps;

    @Before
    public void setUp(){
        gps = new GPS();
    }

    @Test
    public void obtenerTiempoRestante() throws Exception {
        int tiempo = gps.obtenerTiempoRestante(60,60);
        Assert.assertEquals(60,tiempo);
    }

}