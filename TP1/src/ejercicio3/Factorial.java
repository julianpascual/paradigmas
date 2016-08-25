package ejercicio3;

/**
 * Created by julianpascual on 8/25/16.
 */
public class Factorial {

    /**
     *
     * @param nro
     * @return factorial si el numero es mayor o igual a cero sino devuelve por default -1
     */
    public int obtenerFactorial(int nro){
        int factorial = 1;
        int contador = 0;

        if (nro >= 0) {
            for (int i = 1; i <= nro; i++){
                factorial = factorial * i;
            }
        }
        else {
            factorial = -1;
        }
        return factorial;
    }
}
