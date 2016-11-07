package ejercicio4;

import ejercicio3.Persona;

/**
 * Created by julianpascual on 10/21/16.
 */
public class Ejercicio4 {
    public static void main(String args[])
    {
        testIgualdad();
    }
    private static void testIgualdad(){

        System.out.println(new Persona("56897124") == new Persona("56897124"));
        System.out.println(new Persona("23578945").equals(new Persona("23578945")));

    }
}
