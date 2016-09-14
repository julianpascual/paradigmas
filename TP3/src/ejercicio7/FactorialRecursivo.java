package ejercicio7;

/**
 * Created by Julian on 14/9/16.
 */
public class FactorialRecursivo {

    public double factorialRecursivo(int nro) {
        if (nro == 0) {
            return 1;
        } else {
            return nro * (factorialRecursivo(nro -1));
        }

    }

}
