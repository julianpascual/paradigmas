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

    }

    @Test
    public void testBajaIngrediente() throws Exception {
        int resultado = IngredienteDAO.bajaIngrediente("huevo");
        assertEquals(1,resultado);
    }

    @After
    public void tearDown() throws Exception {
        IngredienteDAO.limpiarTablaIngredientes();
    }

}