package ejercicio6;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;

import static helpers.Helpers.leerArchivo;
import static org.junit.Assert.*;

/**
 * Created by Julian on 18/9/16.
 */
public class MatrizTranspuestaTest {
    private MatrizTranspuesta matTr;
    private String path;



    @Before
    public void setUp() throws Exception {
        matTr = new MatrizTranspuesta();
    }

    @Test
    public void transponerMatriz() throws Exception {
        ClassLoader classloader = this.getClass().getClassLoader();
        path = new File(classloader.getResource("matriz.txt").getPath()).getParent();
        matTr.transponerMatriz(path + "/matriz.txt", path);


        ArrayList<ArrayList<Integer>> matrizTranspuesta = matTr.obtenerMatrizDeArchivo(path + "matrizTranspuesta.txt");
        ArrayList<ArrayList<Integer>> matrizOriginal = matTr.obtenerMatrizDeArchivo(path + "/matriz.txt");

//      Como resultado la transpuesta debe tener 4 columnas y 6 filas
        assertEquals(matrizOriginal.size(), matrizTranspuesta.get(0).size());
        assertEquals(matrizOriginal.get(0).size(), matrizTranspuesta.size());
    }

    @After
    public void tearDown() throws Exception {
        File file = new File(path + "matrizTranspuesta.txt");
        file.delete();
    }
}