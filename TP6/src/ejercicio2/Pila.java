package ejercicio2;

import java.util.ArrayList;

/**
 * Created by julianpascual on 10/21/16.
 */
public class Pila {

    private ArrayList<Character> pila = new ArrayList<>();
    private int longMax = 0;

    public Pila() {
    }

    public Pila(int longitud) {
        longMax = longitud;
    }

    public void pop() {
        if (! this.isEmpty()) {
            this.pila.remove(this.pila.size() - 1);
        }
    }

    public void push(Character c) {
        if (longMax != 0) {
            if (this.length() < longMax) {
                this.pila.add(c);
            }
        } else {
            this.pila.add(c);
        }
    }

    public boolean isEmpty() {
        return this.length() > 0 ? false : true;
    }

    public int length() {
        return this.pila.size();
    }

}
