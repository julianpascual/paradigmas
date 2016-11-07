package ejercicio7;


/**
 * Created by julianpascual on 10/21/16.
 */
public class Caja {

    private double liquidacionCaja=0;

    /**Getters y Setters*/
    public double getLiquidacionCaja(){
        return this.liquidacionCaja;}

    /**Metodos*/
    public void facturar(Chango pChango){
        for (int i=0;i<pChango.getProductos().size();i++)
        {
            liquidacionCaja+=pChango.getProductos().get(i).getPrecioVenta();
        }
    }
}
