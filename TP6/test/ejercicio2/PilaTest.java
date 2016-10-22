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
        Pila pila = new Pila(val);
        assertEquals(5, pila.length());
    }


    @Test
    public void testConstructorConLongitud() throws Exception {
        Pila pila = new Pila(val, 4);
        assertEquals(4, pila.length());
    }

    @Test
    public void testConstructorConLongitud2() throws Exception {
        Pila pila = new Pila(val, 7);
        assertEquals(7, pila.length());
    }

    @Test
    public void testPush() throws Exception {
        Pila pila = new Pila(val);
        pila.push();
        assertEquals(4, pila.length());
    }

    @Test
    public void testPop() throws Exception {
        Pila pila = new Pila(val);
        pila.pop('c');
        assertEquals(6, pila.length());
    }

}