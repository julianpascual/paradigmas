package ejercicio8;

/**
 * Created by julianpascual on 8/28/16.
 */
public class Caracol {

    public int cuantoTardaEnSalir(int profundidad, int sube, int retrocede){
        int cantDias = -1;
        boolean salio = false;
        int distRestante;
        if (sube > retrocede){
            cantDias = 1;
            distRestante = profundidad;
            while (!salio){
                distRestante = distRestante - sube;
                if (distRestante <= 0) {
                    salio = true;
                } else {
                    distRestante = distRestante + retrocede;
                    cantDias = cantDias + 1;
                }
            }
        }
        return cantDias;
    }
}
