package ejercicio1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static ejercicio1.IngredienteDAO.limpiarTablaIngredientes;
import static org.junit.Assert.*;
import static helperCargaDatos.CargaDatosPrueba.*;
import static ejercicio1.PlatoDAO.*;
/**
 * Created by Julian on 17/9/16.
 */
public class PlatoDAOTest {


    @Before
    public void setUp() throws Exception {
        cargarPlatosEIngredientes();
    }

    @Test
    public void testCargaInicial() throws Exception {
        ArrayList<String> esperado = new ArrayList<>(Arrays.asList("milanesa", "ensaladaMixta", "fideosConSalsa"));
        ArrayList<String> resultado = devolverPlatos();
        assertArrayEquals(esperado.toArray(),resultado.toArray());
    }

    @Test
    public void testAltaPlato() throws Exception {
        ArrayList<String> ingredientes = new ArrayList<>(Arrays.asList("huevo", "papa", "cebolla"));
        altaPlato("tortilla",ingredientes,65);

        ArrayList<String> platos = devolverPlatos();
        assertTrue(platos.contains("tortilla"));
        assertEquals(4, platos.size());
    }

    @Test
    public void testBajaPlato() throws Exception {
        bajaPlato("milanesa");
        ArrayList<String> platos = devolverPlatos();
        assertFalse(platos.contains("milanesa"));
        assertEquals(2, platos.size());
    }

    @Test
    public void testModificarPlato() throws Exception {
        ArrayList<String> ingredientes = new ArrayList<>(Arrays.asList("huevo", "papa", "cebolla"));
        modificarPlato("ensaladaMixta", "tortilla",ingredientes, 65);
        ArrayList<String> platos = devolverPlatos();
        assertFalse(platos.contains("ensaladaMixta"));
        assertTrue(platos.contains("tortilla"));
        assertEquals(3, platos.size());
    }

    @After
    public void tearDown() throws Exception {
        limpiarTablaPlatos();
        limpiarTablaIngredientes();
    }
}