package ejercicio7;

/**
 * Created by julianpascual on 9/4/16.
 */
public class Rectangulos {

    /*
    * Valores
    * a - altura rectangulo 1
    * b - base rectangulo 1
    * c - altura rectangulo 2
    * d - base rectangulo 2
    * */
    public String encajan(int a, int b, int c, int d) {

        if ((a >= c && b >= d) || (c >= a && d >= b)) {
            return "Encajan sin girar";
        } else if ((b >= c && a >= d) || (c >= b && d >= a)) {
            return "Encajan girando";
        } else {
            return "No encajan";
        }
    }
}
