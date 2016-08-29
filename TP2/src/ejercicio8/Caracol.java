package ejercicio8;

/**
 * Created by julianpascual on 8/28/16.
 */
public class Caracol {

    //TODO: Revisar algoritmo, creo que calcula mal
    public int cuantoTardaEnSalir(int profundidad, int sube, int retrocede){
        int cantDias = -1;
        boolean salio = false;
        int distRestante;
        if (sube > retrocede){
            cantDias = 0;
            distRestante = profundidad;
            while (!salio){
                distRestante = distRestante - (sube - retrocede);
                if (distRestante <= 0) {
                    salio = true;
                } else {
                    cantDias = cantDias + 1;
                }
            }
        }
        return cantDias;
    }
}
