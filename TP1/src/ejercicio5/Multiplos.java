package ejercicio5;

/**
 * Created by julianpascual on 8/25/16.
 */
public class Multiplos {

    public int multiplo(int x, int y) {
        int resultado = -1;
        int multiplo = 1000;
        boolean existe = false;

        while (multiplo > 0 && !existe){
            if((multiplo % x == 0) && (multiplo % y == 0)){
                resultado = multiplo;
                existe = true;
            }
            multiplo --;
        }

        return resultado;
    }
}
