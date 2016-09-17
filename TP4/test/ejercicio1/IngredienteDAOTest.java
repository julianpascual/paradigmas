package ejercicio1;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * Created by Julian on 16/9/16.
 */
public class IngredienteDAOTest {

    @Before
    public void setUp() throws Exception {
        IngredienteDAO.altaIngrediente("papa", "verdura");
        IngredienteDAO.altaIngrediente("carneParaMilanesa", "carne");
        IngredienteDAO.altaIngrediente("panRallado","otros");
        IngredienteDAO.altaIngrediente("huevo","otros");
        IngredienteDAO.altaIngrediente("lechuga","verdura");
        IngredienteDAO.altaIngrediente("tomate","verdura");
        IngredienteDAO.altaIngrediente("fideos","pasta");
        IngredienteDAO.altaIngrediente("salsa","salsa");
        IngredienteDAO.altaIngrediente("cebolla","verdura");
    }

    @Test
    public void testCargaInicial() throws Exception {
        List<String> esperado = asList("papa","carneParaMilanesa","panRallado","huevo","lechuga","tomate","fideos","salsa","cebolla");
        List<String> resultado = IngredienteDAO.devolverIngredientes();
        assertArrayEquals(esperado.toArray(),resultado.toArray());
    }

    @Test
    public void testAltaIngrediente() throws Exception {
        IngredienteDAO.altaIngrediente("manteca", "lacteo");

        List<String> ingredientes = IngredienteDAO.devolverIngredientes();
        assertTrue(ingredientes.contains("manteca"));
        assertEquals(10, ingredientes.size());
    }

    @Test
    public void testBajaIngrediente() throws Exception {
        String ingredienteBorrar = "huevo";
        int resultado = IngredienteDAO.bajaIngrediente(ingredienteBorrar);
        assertEquals(1,resultado);

        List<String> ingredientes = IngredienteDAO.devolverIngredientes();
        assertFalse(ingredientes.contains(ingredienteBorrar));
    }

    @Test
    public void testModificarIngrediente() throws Exception {
        int result = IngredienteDAO.modificarIngrediente("salsa", "cafe", "otros");
        assertEquals(1, result);

        List<String> ingredientes = IngredienteDAO.devolverIngredientes();
        assertTrue(ingredientes.size() == 9);
        assertTrue(ingredientes.contains("cafe"));
        assertFalse(ingredientes.contains("salsa"));
    }

    @After
    public void tearDown() throws Exception {
        IngredienteDAO.limpiarTablaIngredientes();
    }
}