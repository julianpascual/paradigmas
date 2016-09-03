package ejercicio1;

/**
 * Created by julianpascual on 8/28/16.
 */
public class NumerosMasAltos {

    public int[] losMasAltos(int[] numeros){

        int[] masAltos = new int[2];
        masAltos[0] = 0;
        masAltos[1] = 0;

        for (int i = 0; i < numeros.length ; i++) {

            if (numeros[i] > masAltos[0]) {

                masAltos[1] = masAltos[0];
                masAltos[0] = numeros[i];

            } else if (numeros[i] > masAltos[1]) {

                masAltos[1] = numeros[i];

            }
        }
        return masAltos;
    }
}
