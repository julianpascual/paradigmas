package ejercicio2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 8/25/16.
 */
public class DigitoMasAltoTest {

    private DigitoMasAlto digMasAlto;

    @Before
    public void setUp(){
        digMasAlto = new DigitoMasAlto();
    }

    @Test
    public void digitoMasAltoCuatroCifras() throws Exception {
        int dig = digMasAlto.digitoMasAlto(1298);
        assertEquals(dig, 9);
    }

    @Test
    public void digitoMasAltoDiezCifras() throws Exception {
        int dig = digMasAlto.digitoMasAlto(237451245);
        assertEquals(dig, 7);
    }

}