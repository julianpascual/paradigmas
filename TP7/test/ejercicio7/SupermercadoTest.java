package ejercicio7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by julianpascual on 11/7/16.
 */
public class SupermercadoTest {
    private Supermercado supermercado;
    private Caja caja;
    private Chango chango;

    @Before
    public void setUp() throws Exception {
    supermercado=new Supermercado();
        caja = new Caja();
        chango = new Chango();

        Carne carne1 = new Carne(Carne.tipoCarne.roja);
        carne1.setNombre("Tapa de Asado");
        carne1.setPrecio(180);

        Lacteos lacteo1 = new Lacteos();
        lacteo1.setNombre("Leche LaSerenisima");
        lacteo1.setPrecio(25);

        chango.agregarProducto(carne1);
        chango.agregarProducto(lacteo1);
        caja.facturar(chango);

        chango = new Chango();

        Perfume perfume1 = new Perfume(500);
        perfume1.setNombre("212");

        chango.agregarProducto(perfume1);

        caja.facturar(chango);

        supermercado.agregarCaja(caja);

        caja = new Caja();
        chango = new Chango();

        Enlatados enlatados=new Enlatados();
        enlatados.setNombre("Porotos");
        enlatados.setPrecio(24);

        Indumentaria remera=new Indumentaria("Nike","Medium");
        remera.setNombre("Remera");
        remera.setPrecio(250);

        Indumentaria bolso= new Indumentaria("Nike","Large");
        bolso.setNombre("Bolso");
        bolso.setPrecio(900);

        chango.agregarProducto(enlatados);
        chango.agregarProducto(remera);
        chango.agregarProducto(bolso);

        caja.facturar(chango);

        supermercado.agregarCaja(caja);
    }

    @Test
    public void agregarCaja() throws Exception {
        supermercado.agregarCaja(new Caja());
        assertEquals(3, supermercado.cantCajas());
    }

    @Test
    public void liquidacionDelDia() throws Exception {
        assertEquals(1856, supermercado.liquidacionDelDia(), 0.1);
    }

}