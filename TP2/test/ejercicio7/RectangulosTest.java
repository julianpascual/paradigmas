package ejercicio7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 9/4/16.
 */
public class RectangulosTest {
    private Rectangulos rect;

    @Before
    public void setUp() throws Exception {
        rect = new Rectangulos();
    }

    @Test
    public void encajanSinGirar() throws Exception {
        String respuesta = rect.encajan(3,4,1,2);
        assertEquals("Encajan sin girar", respuesta);
    }

    @Test
    public void encajanGirando() throws Exception {
        String respuesta = rect.encajan(3,4,4,2);
        assertEquals("Encajan girando", respuesta);
    }

    @Test
    public void noEncajan() throws Exception {
        String respuesta = rect.encajan(3,2,4,1);
        assertEquals("No encajan", respuesta);
    }
}