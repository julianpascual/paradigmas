package ejercicio1;

import java.util.ArrayList;

/**
 * Created by julianpascual on 10/21/16.
 */
public class Ejercicio1 {

    ArrayList arrayListNoTipado = new ArrayList();
    ArrayList<String> arrayListTipado = new ArrayList<String>();

    /** Compilan perfecto */
    public void intento1()
    {
        arrayListNoTipado.add("unElemento");
        arrayListTipado.add("unElemento");
    }
        String unElemento;
    String otroElemento;
    public void intento2()
    {
       /** String unElemento=arrayListNoTipado.get(0);  falla porque no sabe que objeto tiene la lista dentro, para que funcione hay que hacer un cast*/
         unElemento = (String)arrayListNoTipado.get(0);
         otroElemento = arrayListTipado.get(0);
    }
    public void intento3()
    {
        arrayListNoTipado.add(3);
        /** arrayListTipado.add(3); falla porque espera que le pase un string**/
        arrayListTipado.add("3");
    }
}
