package ejercicio2;

import java.util.ArrayList;

/**
 * Created by julianpascual on 10/21/16.
 */
public class Pila {

    private ArrayList<String> pila;


    public Pila(ArrayList<String> valores) {
        this.pila = valores;
    }

    public Pila(ArrayList<String> valores, int longitud) {

        //TODO implementar constructor

    }


    public void push() {

    }

    public void pop() {

    }

    public boolean isEmpty() {
        return this.pila.size() > 0 ? true : false;
    }

    public int length() {
        return this.pila.size();
    }

}
