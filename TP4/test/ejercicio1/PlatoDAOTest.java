package ejercicio1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static helperCargaDatos.CargaDatosPrueba.*;

/**
 * Created by Julian on 17/9/16.
 */
public class PlatoDAOTest {


    @Before
    public void setUp() throws Exception {
        cargarIngredientes();
        cargarPlatos();
    }

    @Test
    public void testCargaInicial() throws Exception {
        ArrayList<String> esperado = new ArrayList<>(Arrays.asList("milanesa", "ensaladaMixta", "fideosConSalsa"));
        ArrayList<String> resultado = PlatoDAO.devolverPlatos();
        assertArrayEquals(esperado.toArray(),resultado.toArray());
    }

    @Test
    public void testAltaPlato() throws Exception {

    }

    @Test
    public void testBajaPlato() throws Exception {

    }

    @Test
    public void testModificarPlato() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        PlatoDAO.limpiarTablaPlatos();
        IngredienteDAO.limpiarTablaIngredientes();
    }
}