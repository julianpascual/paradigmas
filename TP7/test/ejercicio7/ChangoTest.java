package ejercicio7;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 11/7/16.
 */
public class ChangoTest {
    private Chango chango;
    private Carne carneroja;
    private Lacteos lacteo1;
    private Enlatados enlatado1;
    private Perfume perfume;

    @Before
    public void setUp() throws Exception {
        chango=new Chango();
        carneroja=new Carne(Carne.tipoCarne.roja);
        carneroja.setNombre("Vacio");
        lacteo1=new Lacteos();
        lacteo1.setNombre("Leche La Serenisi,a");
        enlatado1=new Enlatados();
        enlatado1.setNombre("Arvejas");
        perfume=new Perfume(950);
        perfume.setNombre("Polo Blue");
        chango.agregarProducto(carneroja);
        chango.agregarProducto(lacteo1);
        chango.agregarProducto(enlatado1);
        chango.agregarProducto(perfume);
    }

    @Test
    public void agregarProducto() throws Exception {
        Indumentaria remera =new Indumentaria("Nike", "Large");
        remera.setNombre("Remera");
        chango.agregarProducto(remera);
        Assert.assertTrue(5==chango.getProductos().size());
    }

    @Test
    public void getProductos() throws Exception {
        assertEquals(950, chango.getProductos().get(3).getPrecioVenta(), 0.1);
    }

    @Test
    public void testCalculoDePromocion() throws Exception {
        chango = new Chango();
        Indumentaria remera = new Indumentaria("Nike", "L");
        remera.setPrecio(10);
        remera.setNombre("remera");
        chango.agregarProducto(remera);
        remera = new Indumentaria("Nike", "L");
        remera.setPrecio(10);
        remera.setNombre("remera");
        chango.agregarProducto(remera);
        remera = new Indumentaria("Nike", "L");
        remera.setPrecio(10);
        remera.setNombre("remera");
        chango.agregarProducto(remera);
        int cantDeProductosEnPromocion = 0;
        for (ProductoDeVenta prod : chango.getProductos()) {
            if (prod.getPrecioVenta() == 3.0) {
                cantDeProductosEnPromocion ++;
            }
        }
        assertEquals(1, cantDeProductosEnPromocion);
    }

}