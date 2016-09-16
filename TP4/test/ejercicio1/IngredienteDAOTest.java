package ejercicio1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


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
    public void altaIngrediente() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
        IngredienteDAO.limpiarTablaIngredientes();
    }

}