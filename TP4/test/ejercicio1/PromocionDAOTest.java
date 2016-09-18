package ejercicio1;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static ejercicio1.BebidaDAO.limpiarTablaBebidas;
import static ejercicio1.IngredienteDAO.limpiarTablaIngredientes;
import static ejercicio1.PlatoDAO.altaPlato;
import static ejercicio1.PlatoDAO.limpiarTablaPlatos;
import static ejercicio1.PromocionDAO.*;
import static helperCargaDatos.CargaDatosPrueba.cargarPlatosYPromociones;
import static org.junit.Assert.*;

/**
 * Created by Julian on 17/9/16.
 */
public class PromocionDAOTest {
    @Before
    public void setUp() throws Exception {
        cargarPlatosYPromociones();
    }

    @Test
    public void testCargaInicial() throws Exception {
        ArrayList<String> esperado = new ArrayList<>(Arrays.asList("Mila Con Ensalada", "Fideos Con Bebida"));
        ArrayList<String> resultado = devolverPromociones();
        assertArrayEquals(esperado.toArray(),resultado.toArray());
    }

    @Test
    public void testAltaPromocion() throws Exception {

        ArrayList<String> ingredientes = new ArrayList<>(Arrays.asList("papa", "cebolla", "huevo"));
        altaPlato("tortilla", ingredientes, 40);

        ArrayList<String> platos = new ArrayList<>(Arrays.asList("milanesa", "tortilla"));
        altaPromocion("Milanesa con Tortilla y Cerveza", platos, "cervezaStella", "litro", 130);

        ArrayList<String> promociones = devolverPromociones();
        assertTrue(promociones.contains("Milanesa con Tortilla y Cerveza"));
        assertEquals(3, promociones.size());
    }

    @Test
    public void testBajaPromocion() throws Exception {
        bajaPromocion("Mila Con Ensalada");
        ArrayList<String> promociones = devolverPromociones();
        assertFalse(promociones.contains("milanesa"));
        assertEquals(1, promociones.size());
    }

    @Test
    public void testModificarPromocion() throws Exception {
        ArrayList<String> ingredientes = new ArrayList<>(Arrays.asList("papa", "cebolla", "huevo"));
        altaPlato("tortilla", ingredientes, 40);

        ArrayList<String> platos = new ArrayList<>(Arrays.asList("milanesa", "tortilla"));

        modificarPromocion("Mila Con Ensalada", "Mila Con Tortilla", platos, "aguaSinGas", "500cm3", 115);
        ArrayList<String> promociones = devolverPromociones();
        assertEquals(2, promociones.size());
        assertFalse(promociones.contains("Mila Con Ensalada"));
        assertTrue(promociones.contains("Mila Con Tortilla"));
    }

    @After
    public void tearDown() throws Exception {
        limpiarTablaPromociones();
        limpiarTablaBebidas();
        limpiarTablaPlatos();
        limpiarTablaIngredientes();
    }
}