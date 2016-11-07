package ejercicio7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 11/7/16.
 */
public class JuegoSillaTest {
    private JuegoSilla juego;

    @Before
    public void setUp() throws Exception {
        juego = new JuegoSilla();
    }

    @Test
    public void jugar() throws Exception {
        juego.cantDeSillas=5;
        juego.getListaJugadores().add("Julian");
        juego.getListaJugadores().add("Pablo");
        juego.getListaJugadores().add("Lucia");
        juego.getListaJugadores().add("Roberto");
        juego.getListaJugadores().add("Ivana");
        juego.getListaJugadores().add("Carlos");
        juego.jugar();
        assertEquals(1, juego.getListaJugadores().size());
        assertEquals(0, juego.getCantDeSillas());
    }

}