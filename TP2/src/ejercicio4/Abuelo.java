package ejercicio4;

import java.io.*;
/**
 * Created by julianpascual on 8/28/16.
 */
public class Abuelo {

    public int resolverEcuacion(){
        boolean resuelta = false;
        int aux = 9999;
        int respuesta = 0;

        while (!resuelta && aux > 0){
            int[] digitos = obtenerDigitos(aux);
                if (aux == Math.pow(digitos[3], digitos[2]) * Math.pow(digitos[1], digitos[0])) {
                    respuesta = aux;
                    resuelta = true;
                }
            aux = aux -1;
        }
        return respuesta;
    }


    //como utilizo el modulo para obtener cada digito, el array me queda invertido
    //por lo que si quiero tomar el valor de X por ejemplo, va a ser el ultimo del array
    public int[] obtenerDigitos(int nro){
        int digito;
        int i = 0;
        int[] digitos = new int[4];
        while (nro > 0) {
            digito = nro % 10;
            nro = nro / 10;
            digitos[i] = digito;
            i = i + 1;
        }
        return digitos;
    }

}
