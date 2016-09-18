package ejercicio1;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static helperCargaDatos.CargaDatosPrueba.cargarIngredientes;
import static ejercicio1.IngredienteDAO.*;

/**
 * Created by Julian on 16/9/16.
 */
public class IngredienteDAOTest {

    @Before
    public void setUp() throws Exception {
        cargarIngredientes();
    }

    @Test
    public void testCargaInicial() throws Exception {
        List<String> esperado = asList("papa","carneParaMilanesa","panRallado","huevo","lechuga","tomate","fideos","salsa","cebolla");
        List<String> resultado = devolverIngredientes();
        assertArrayEquals(esperado.toArray(),resultado.toArray());
    }

    @Test
    public void testAltaIngrediente() throws Exception {
        altaIngrediente("manteca", "lacteo");

        List<String> ingredientes = devolverIngredientes();
        assertTrue(ingredientes.contains("manteca"));
        assertEquals(10, ingredientes.size());
    }

    @Test
    public void testBajaIngrediente() throws Exception {
        String ingredienteBorrar = "huevo";
        int resultado = bajaIngrediente(ingredienteBorrar);
        assertEquals(1,resultado);

        List<String> ingredientes = devolverIngredientes();
        assertFalse(ingredientes.contains(ingredienteBorrar));
    }

    @Test
    public void testModificarIngrediente() throws Exception {
        int result = modificarIngrediente("salsa", "cafe", "otros");
        assertEquals(1, result);

        List<String> ingredientes = devolverIngredientes();
        assertTrue(ingredientes.size() == 9);
        assertTrue(ingredientes.contains("cafe"));
        assertFalse(ingredientes.contains("salsa"));
    }

    @After
    public void tearDown() throws Exception {
        limpiarTablaIngredientes();
    }
}