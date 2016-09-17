package helperCargaDatos;

import ejercicio1.IngredienteDAO;
import ejercicio1.PlatoDAO;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Julian on 17/9/16.
 */
public final class CargaDatosPrueba {

    public static void cargarIngredientes() throws Exception{
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

    public static void cargarPlatos() throws Exception{
        ArrayList<String> ingredientes;

        ingredientes = new ArrayList<>(Arrays.asList("carneParaMilanesa", "panRallado", "huevo"));
        PlatoDAO.altaPlato("milanesa", ingredientes, 70);

        ingredientes = new ArrayList<>(Arrays.asList("lechuga", "tomate", "cebolla"));
        PlatoDAO.altaPlato("ensaladaMixta", ingredientes, 50);

        ingredientes = new ArrayList<>(Arrays.asList("fideos", "salsa"));
        PlatoDAO.altaPlato("fideosConSalsa", ingredientes, 70);
    }

}
