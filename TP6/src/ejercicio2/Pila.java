package ejercicio2;

import java.util.ArrayList;

/**
 * Created by julianpascual on 10/21/16.
 */
public class Pila {

    private ArrayList<Character> pila;

    public Pila(ArrayList<Character> valores) {
        this.pila = valores;
    }

    public Pila(ArrayList<Character> valores, int longitud) {
        //TODO review constructor
        int i = 0;
        pila = new ArrayList<>(longitud);
        while (i < valores.size() && i < longitud) {
            pila.add(valores.get(i));
            i++;
        }
    }

    public void push() {
        this.pila.remove(this.pila.size() -1);
    }

    public void pop(Character c) {
        this.pila.add(c);
    }

    public boolean isEmpty() {
        return this.pila.size() > 0 ? true : false;
    }

    public int length() {
        return this.pila.size();
    }

}
