package ejercicio1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

import static helperCargaDatos.CargaDatosPrueba.cargarBebidas;
import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static ejercicio1.BebidaDAO.*;

/**
 * Created by Julian on 17/9/16.
 */
public class BebidaDAOTest {
    @Before
    public void setUp() throws Exception {
        cargarBebidas();
    }

    @Test
    public void testCargaInicial() throws Exception {
        List<String> esperado = asList("cervezaStella","cervezaStella","cocaCola","aguaSinGas");
        List<String> resultado = devolverBebidas();
        assertArrayEquals(esperado.toArray(),resultado.toArray());
    }

    @Test
    public void testAltaBebida() throws Exception {
        int result = altaBebida("cervezaQuilmes","litro",60);
        assertEquals(1,result);

        List<String> bebidas = devolverBebidas();
        assertTrue(bebidas.contains("cervezaQuilmes"));
        assertEquals(5, bebidas.size());
    }

    @Test
    public void testBajaBebida() throws Exception {
        int resultado = bajaBebida("aguaSinGas", "500cm3");
        assertEquals(1,resultado);

        List<String> bebidas = devolverBebidas();
        assertFalse(bebidas.contains("aguaSinGas"));
    }

    @Test
    public void testModificarBebida() throws Exception {
        int result = modificarBebida("cervezaStella", "cervezaImperial", "litro", "chop",35);
        assertEquals(1, result);

        List<String> bebidas = devolverBebidas();
        assertTrue(bebidas.size() == 4);

        assertTrue(bebidas.contains("cervezaImperial"));
    }

    @After
    public void tearDown() throws Exception {
        limpiarTablaBebidas();
    }

}