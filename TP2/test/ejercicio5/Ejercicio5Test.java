package ejercicio5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 9/4/16.
 */
public class Ejercicio5Test {
    private Ejercicio5 ej5;

    @Before
    public void setUp() throws Exception {
        ej5 = new Ejercicio5();
    }

    //TODO: faltan los test!!!

    @Test
    public void generarArchivoResultados() throws Exception {
        ej5.generarArchivoResultados(new int[]{1,2,5,4,8,9,7,12,1000,1500});
    }

}