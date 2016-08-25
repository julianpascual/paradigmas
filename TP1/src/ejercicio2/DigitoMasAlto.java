package ejercicio2;

/**
 * Created by julianpascual on 8/25/16.
 */
public class DigitoMasAlto {

    public int digitoMasAlto(int nro) {
        int digMayor,resto,cociente;
        digMayor = 0;
        cociente = nro;
        while (cociente > 0){
            resto = cociente % 10;
            if (resto > digMayor){
                digMayor = resto;
            }
            cociente = cociente / 10;
        }
        return digMayor;
    }
}
