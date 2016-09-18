package helperCargaDatos;

import java.util.ArrayList;
import java.util.Arrays;

import static ejercicio1.BebidaDAO.altaBebida;
import static ejercicio1.IngredienteDAO.altaIngrediente;
import static ejercicio1.PlatoDAO.altaPlato;
import static ejercicio1.PromocionDAO.altaPromocion;

/**
 * Created by Julian on 17/9/16.
 */
public final class CargaDatosPrueba {

    public static void cargarIngredientes() throws Exception{
        altaIngrediente("papa", "verdura");
        altaIngrediente("carneParaMilanesa", "carne");
        altaIngrediente("panRallado","otros");
        altaIngrediente("huevo","otros");
        altaIngrediente("lechuga","verdura");
        altaIngrediente("tomate","verdura");
        altaIngrediente("fideos","pasta");
        altaIngrediente("salsa","salsa");
        altaIngrediente("cebolla","verdura");
    }

    public static void cargarPlatosEIngredientes() throws Exception{

        cargarIngredientes();

        ArrayList<String> ingredientes;

        ingredientes = new ArrayList<>(Arrays.asList("carneParaMilanesa", "panRallado", "huevo"));
        altaPlato("milanesa", ingredientes, 70);

        ingredientes = new ArrayList<>(Arrays.asList("lechuga", "tomate", "cebolla"));
        altaPlato("ensaladaMixta", ingredientes, 50);

        ingredientes = new ArrayList<>(Arrays.asList("fideos", "salsa"));
        altaPlato("fideosConSalsa", ingredientes, 70);
    }

    public static void cargarBebidas() throws Exception{
        altaBebida("cervezaStella","litro",80);
        altaBebida("cervezaStella","porron",40);
        altaBebida("cocaCola","600cm3",40);
        altaBebida("aguaSinGas","500cm3",30);
    }

    public static void cargarPlatosYPromociones() throws Exception{
        cargarPlatosEIngredientes();
        cargarBebidas();

        ArrayList<String> platos;

        platos = new ArrayList<>(Arrays.asList("milanesa", "ensaladaMixta"));
        altaPromocion("Mila Con Ensalada",platos,"aguaSinGas","500cm3",100);

        platos = new ArrayList<>(Arrays.asList("fideosConSalsa"));
        altaPromocion("Fideos Con Bebida",platos,"cervezaStella","porron",100);
    }

}
