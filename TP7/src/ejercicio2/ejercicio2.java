package ejercicio2;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by julianpascual on 10/21/16.
 */
public class ejercicio2 {

    public static void main(String args[])
    {
        set();
    }
    private static void set(){
        TreeSet<Integer> set= new TreeSet<Integer>();
        set.add(1);
        set.add(1); /** No agrega valores repetidos*/
        set.add(3);
        System.out.println(set.size());
        System.out.println(set);

        ArrayList<Integer> arrayList =new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(1);   /** Permite repetidos */
        arrayList.add(3);
        System.out.println(arrayList.size());
        System.out.println(arrayList);
    }
}
