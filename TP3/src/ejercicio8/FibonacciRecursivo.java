package ejercicio8;

/**
 * Created by Julian on 14/9/16.
 */
public class FibonacciRecursivo {

    public int obtenerNumeroFibonacci(int nro) {

        if (nro < 2) {
            return nro;
        } else {
            return obtenerNumeroFibonacci(nro - 2) + obtenerNumeroFibonacci(nro - 1);
        }

    }
}
