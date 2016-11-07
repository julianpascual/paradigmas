package ejercicio3;

/**
 * Created by Julian on 22/10/16.
 */
public class Cuenta {
    int numero;
    double saldo;
    Cliente cliente;

    public Cuenta(int numero, Cliente cliente, Banco banco) {
        this.numero = numero;
        this.cliente= cliente;
        cliente.agregarCuenta(this);
        banco.agregarCuenta(this);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
