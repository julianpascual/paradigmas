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

    public boolean getViveEnCapital() {
        return viveEnCapital;
    }

    public void cobrarComision(Cuenta cuenta) {
        if (viveEnCapital) {
            cuenta.setSaldo(cuenta.getSaldo() - 2);
        }
    }

    public void setViveEnCapital(boolean viveEnCapital) {
        this.viveEnCapital = viveEnCapital;
    }
}
