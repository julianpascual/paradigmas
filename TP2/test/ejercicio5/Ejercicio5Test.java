package ejercicio5;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static helpers.Helpers.leerArchivo;
import static org.junit.Assert.*;

/**
 * Created by julianpascual on 9/4/16.
 */
public class Ejercicio5Test {
    private Ejercicio5 ej5;

    @Before
    public void setUp() throws Exception {
        ej5 = new Ejercicio5();
        ej5.generarArchivoResultados(new int[]{1,2,5,4,8,9,7,12,1000,1500});
    }

    @Test
    public void validarDivisoresDe3000() throws Exception {
        ArrayList<String> esperado = new ArrayList<>(Arrays.asList("1","2","5","4","8","12","1000","1500"));
        ArrayList<String> divisores = leerArchivo("divisoresDe3000.txt");

        assertArrayEquals(esperado.toArray(), divisores.toArray());
    }

    @Test
    public void validarPrimos() throws Exception {
        ArrayList<String> esperado = new ArrayList<>(Arrays.asList("2","5","7"));
        ArrayList<String> primos = leerArchivo("primos.txt");

        assertArrayEquals(esperado.toArray(), primos.toArray());
    }

    @Test
    public void validarPromedios() throws Exception {

        ArrayList<String> promedios = leerArchivo("promedios.txt");

        assertEquals("Promedio de pares: 421", promedios.get(0));
        assertEquals("Promedio de impares: 5", promedios.get(1));
    }
}