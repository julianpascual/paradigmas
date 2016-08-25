package ejercicio4;

/**
 * Created by julianpascual on 8/25/16.
 */
public class Ejercicio4 {

    public int retornarValorFuncion(int x, int y){
        int valor = 0;
        if((x + y) < 1) {
            valor = 5;
        }
        else {
            if ((x + y) >= 1) {
                valor = y * y;
            }
        }
        return valor;
    }
}
