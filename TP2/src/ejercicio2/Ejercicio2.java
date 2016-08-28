package ejercicio2;

/**
 * Created by julianpascual on 8/28/16.
 */
public class Ejercicio2 {

    public int numeroConMasPares(int[] numeros){
        int cantPares;
        int numMayorCantPares = 0;
        int mayorCantidad = 0;

        for (int i = 0; i < numeros.length; i++) {
            cantPares = cantidadDePares(numeros[i]);
            if (i == 0 || cantPares > mayorCantidad){
                numMayorCantPares = numeros[i];
                mayorCantidad = cantPares;
            }

        }

        return numMayorCantPares;
    }

    public int cantidadDePares(int numero) {
        int resto,cociente,cantPares;
        cantPares = 0;
        cociente = numero;
        while (cociente > 0){
            resto = cociente % 10;
            if (resto % 2 == 0){
                cantPares = cantPares + 1;
            }
            cociente = cociente / 10;
        }
        return cantPares;
    }
}
