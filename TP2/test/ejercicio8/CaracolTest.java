package ejercicio8;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 8/28/16.
 */
public class CaracolTest {
    private Caracol caracol;

    @Before
    public void setUp() throws Exception {
        caracol = new Caracol();
    }

    @Test
    public void cuantoTardaEnSalir() throws Exception {
        int cantDias = caracol.cuantoTardaEnSalir(10,5,2);
        assertEquals(3,cantDias);
    }

    @Test
    public void noSaleSiRetrocedeMasDeLoQueAvanza() throws Exception {
        int cantDias = caracol.cuantoTardaEnSalir(10,3,4);
        assertEquals(-1,cantDias);
    }

    @Test
    public void caracolRapido() throws Exception {
        int cantDias = caracol.cuantoTardaEnSalir(10,10,0);
        assertEquals(0,cantDias);
    }

    @Test
    public void otroTest() throws Exception {
        int cantDias = caracol.cuantoTardaEnSalir(25,3,1);
        assertEquals(12, cantDias);
    }

}