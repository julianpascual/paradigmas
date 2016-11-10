package ejercicio7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julianpascual on 10/21/16.
 */
public class Chango {

    private List<ProductoDeVenta> productos =new ArrayList<ProductoDeVenta>();

    public void agregarProducto(ProductoDeVenta pProducto){
        int cantProductos = 0;
        for (int i= 0; i < productos.size(); i++) {
            if (pProducto.equals(productos.get(i))) {
                cantProductos ++;
            }
        }
        if ((cantProductos + 1) % 2 == 0 ) {
            pProducto.promoDescuento70SegundaUnidad();
        }
        this.productos.add(pProducto);
    }

    public List<ProductoDeVenta> getProductos(){return this.productos;}

}
