package ejercicio7;

/**
 * Created by julianpascual on 8/25/16.
 */
public class GPS {

    public int obtenerTiempoRestante(int velocidad, int kmRestantes){
        int tiempoRestante = -1;

        if (velocidad > 0 && kmRestantes > 0) {
            tiempoRestante = (kmRestantes / velocidad) * 60;
        }

        return tiempoRestante;
    }
}
