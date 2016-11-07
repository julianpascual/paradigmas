package ejercicio2;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Julian on 22/10/16.
 */
public class PilaTest {
    private ArrayList<Character> val;

    @Before
    public void setUp() throws Exception {
        val = new ArrayList<>();
        val.add('t');
        val.add('e');
        val.add('s');
        val.add('t');
        val.add('A');
    }


    @Test
    public void testConstructor() throws Exception {
        Pila pila = new Pila();
        inicializarPila(pila);
        assertEquals(5, pila.length());
    }


    @Test
    public void testConstructorConLongitud() throws Exception {
        Pila pila = new Pila(3);
        inicializarPila(pila);
        assertEquals(3, pila.length());
    }

    @Test
    public void testConstructorConLongitud2() throws Exception {
        Pila pila = new Pila(7);
        inicializarPila(pila);
        assertEquals(5, pila.length());
    }

    @Test
    public void testPop() throws Exception {
        Pila pila = new Pila();
        inicializarPila(pila);
        pila.pop();
        assertEquals(4, pila.length());
    }

    @Test
    public void testPush() throws Exception {
        Pila pila = new Pila();
        inicializarPila(pila);
        pila.push('c');
        assertEquals(6, pila.length());
    }


    public void inicializarPila(Pila pila){
        for (Character c : val) {
            pila.push(c);
        }
    }
}