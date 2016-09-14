package helpers;

/**
 * Created by julianpascual on 9/4/16.
 */
public final class Helpers {

    public static boolean esPrimo(int num) {
        int cantDivisores = 0;
        for (int i = 1; i <= num ; i++) {
            if (num % i == 0) {
                cantDivisores ++;
            }
        }
        if (cantDivisores == 2) {
            return true;
        } else {
            return false;
        }
    }
}
