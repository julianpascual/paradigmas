package ejercicio6;

import helpers.Helpers;

/**
 * Created by julianpascual on 9/4/16.
 */
public class Ejercicio6 {
    private Helpers helper = new Helpers();

    public int[] primosGemelos(int desdeNum) {

        int[] gemelos = new int[2];
        boolean encontrados = false;

        while (!encontrados) {
            desdeNum ++;
            if (helper.esPrimo(desdeNum) & helper.esPrimo(desdeNum + 2)){
                gemelos[0] = desdeNum;
                gemelos[1] = desdeNum + 2;
                encontrados = true;
            }
        }

        return  gemelos;
    }
}
