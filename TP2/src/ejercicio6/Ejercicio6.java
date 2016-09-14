package ejercicio6;

import static helpers.Helpers.esPrimo;

/**
 * Created by julianpascual on 9/4/16.
 */
public class Ejercicio6 {

    public int[] primosGemelos(int desdeNum) {

        int[] gemelos = new int[2];
        boolean encontrados = false;

        while (!encontrados) {
            desdeNum ++;
            if (esPrimo(desdeNum) & esPrimo(desdeNum + 2)){
                gemelos[0] = desdeNum;
                gemelos[1] = desdeNum + 2;
                encontrados = true;
            }
        }

        return  gemelos;
    }
}
