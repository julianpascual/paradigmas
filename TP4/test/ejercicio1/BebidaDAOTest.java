package ejercicio1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * Created by Julian on 17/9/16.
 */
public class BebidaDAOTest {
    @Before
    public void setUp() throws Exception {
        BebidaDAO.altaBebida("cervezaStella","litro",80);
        BebidaDAO.altaBebida("cervezaStella","porron",40);
        BebidaDAO.altaBebida("cocaCola","600cm3",40);
        BebidaDAO.altaBebida("aguaSinGas","500cm3",30);
    }

    @Test
    public void testCargaInicial() throws Exception {
        List<String> esperado = asList("cervezaStella","cervezaStella","cocaCola","aguaSinGas");
        List<String> resultado = BebidaDAO.devolverBebidas();
        assertArrayEquals(esperado.toArray(),resultado.toArray());
    }

    @Test
    public void testAltaBebida() throws Exception {
        int result = BebidaDAO.altaBebida("cervezaQuilmes","litro",60);
        assertEquals(1,result);

        List<String> bebidas = BebidaDAO.devolverBebidas();
        assertTrue(bebidas.contains("cervezaQuilmes"));
        assertEquals(5, bebidas.size());
    }

    @Test
    public void testBajaBebida() throws Exception {
        int resultado = BebidaDAO.bajaBebida("aguaSinGas", "500cm3");
        assertEquals(1,resultado);

        List<String> bebidas = BebidaDAO.devolverBebidas();
        assertFalse(bebidas.contains("aguaSinGas"));
    }

    @Test
    public void testModificarBebida() throws Exception {
        int result = BebidaDAO.modificarBebida("cervezaStella", "cervezaQuilmes", "litro", "chop",35);
        assertEquals(1, result);

        List<String> bebidas = BebidaDAO.devolverBebidas();
        assertTrue(bebidas.size() == 4);
//        TODO get item
    }

    @After
    public void tearDown() throws Exception {
        BebidaDAO.limpiarTablaBebidas();
    }

}