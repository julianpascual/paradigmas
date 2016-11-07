package ejercicio7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julianpascual on 10/21/16.
 */
public class Chango {

    private List<ProductoDeVenta> productos =new ArrayList<ProductoDeVenta>();

    public void agregarProducto(ProductoDeVenta pProducto){
        boolean flag=false;
        for (int i= 0;i<productos.size();i++)
            if (flag==false && pProducto.equals(productos.get(i)))
            {
                pProducto.promoDescuento70SegundaUnidad();
                flag=true;
            }
        this.productos.add(pProducto);}
    public List<ProductoDeVenta> getProductos(){return this.productos;}

}
