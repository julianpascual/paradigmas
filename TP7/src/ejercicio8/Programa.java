package ejercicio8;

/**
 * Created by julianpascual on 10/21/16.
 */
public class Programa {

    public static void main(String args[])
    {
        C c=new C();
        IA a=c;
        IB b=c;         /** como C implementa IA e IB, puede
                        ser asignada a una variable del tipo IA o del tipo IB*/
        a.x();
        b.y();
    }
}
