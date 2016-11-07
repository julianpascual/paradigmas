package ejercicio7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julianpascual on 10/21/16.
 */
public class Supermercado {

    private List<Caja> cajas = new ArrayList<Caja>();

    public void agregarCaja(Caja pCaja)
    {
        this.cajas.add(pCaja);
    }
    /**Metodos*/
    public double liquidacionDelDia()
    {
        double facturacion=0;
    for (int i=0;i<cajas.size();i++)
    {
        facturacion+=cajas.get(i).getLiquidacionCaja();
    }
        return facturacion;
    }
    public int cantCajas()
    {return this.cajas.size();}
}
