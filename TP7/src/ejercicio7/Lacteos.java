package ejercicio7;

/**
 * Created by julianpascual on 10/21/16.
 */
public class Lacteos extends ProductoAlimenticio {
    @Override
    public double getPrecioVenta() {
        return super.getPrecioVenta()*0.80;
    } /**Restando el 20% de descuento*/
}
