package ejercicio4;

import java.util.ArrayList;
import java.util.Scanner;

import static helpers.Helpers.leerArchivo;

/**
 * Created by Julian on 18/9/16.
 */
public class Ahorcado {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int maxFallos = 5;
        int aciertos = 0;
        int tamañoPalabra;
        char[] respuesta;
        boolean encontrada = false;

        String palabra = obtenerPalabraRandomDeArchivo();
        tamañoPalabra = palabra.length();
        respuesta = new char[tamañoPalabra];

        String opcion;
        int contador = 0;

        for (int i = 0; i < tamañoPalabra; i++) {
            respuesta[i] = '-';
        }

        while (aciertos != tamañoPalabra && maxFallos != 0 && !encontrada) {
            System.out.println("Vidas= "+ maxFallos +" Aciertos= "+ aciertos);
            System.out.println("");
            for (int i = 0; i < tamañoPalabra; i++) {

                System.out.print(" " + respuesta[i] + " ");
            }
            System.out.println("\nIngresa una letra o arriesgue una palabra: ");
            opcion = s.next();
            if(opcion.length() > 1) {
                if (opcion.equals(palabra)) {
                    encontrada = true;
                    respuesta = opcion.toCharArray();
                } else {
                    maxFallos--;
                }
            } else {
                if (palabra.contains(opcion)) {
                    for (int i = 0; i < tamañoPalabra; i++) {
                        if (palabra.charAt(i) == opcion.charAt(0)) {
                            respuesta[i] = opcion.charAt(0);
                            contador++;
                        }
                    }
                    aciertos = aciertos + contador;
                } else {
                    maxFallos--;
                }
            }
            contador = 0;
        }

        if(maxFallos == 0){
            System.out.println("Perdiste!!");

        } else {
            System.out.println("\nGanaste!!!");
        }

        System.out.println("La palabra era: " + palabra);
    }

    public static String obtenerPalabraRandomDeArchivo() {
        ArrayList<String> palabras;
        String palabra;

        palabras = leerArchivo("palabras.txt");

        int num = (int)(Math.random()*(palabras.size()));
        palabra = palabras.get(num);

        return palabra;
    }
}
