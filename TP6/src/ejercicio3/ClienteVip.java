package ejercicio3;

/**
 * Created by Julian on 22/10/16.
 */
public class ClienteVip extends Cliente{
    boolean viveEnCapital;

    public ClienteVip(String nombre, String apellido, int dni, int pin, boolean viveEnCapital) {
        super(nombre, apellido, dni, pin);
        this.viveEnCapital = viveEnCapital;
    }

    public boolean isViveEnCapital() {
        return viveEnCapital;
    }

    public void setViveEnCapital(boolean viveEnCapital) {
        this.viveEnCapital = viveEnCapital;
    }
}
