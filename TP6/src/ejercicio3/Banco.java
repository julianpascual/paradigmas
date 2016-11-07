package ejercicio3;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Julian on 22/10/16.
 */
public class Banco {
    List<Cliente> listaClientes = new ArrayList<Cliente>();
    List<Cuenta> listaCuentas = new ArrayList<Cuenta>();

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    public Cuenta obtenerCuenta(int numeroCuenta){
        Cuenta cuenta=null;
        for (Cuenta c: getListaCuentas()) {
            if (numeroCuenta == c.getNumero()){
                cuenta = c;
            }
        }
        return cuenta;
    }

    public Cliente obtenerCliente(int dniCliente){
        Cliente cliente=null;
        for (Cliente cl: getListaClientes()) {
            if (dniCliente == cl.getDni()){
                cliente = cl;
            }
        }
        return cliente;
    }

    public void depositar(Cliente cliente, int numeroCuenta, int pin, int deposito){
        Cuenta cuenta = obtenerCuenta(numeroCuenta);
        if (cliente.getPin() == pin){
            cuenta.setSaldo(cuenta.getSaldo() + deposito);
            cobrar(cliente, cuenta);
            System.out.println("Operacion exitosa");
        } else {
            System.out.println("Clave incorrecta");
        }
    }

    public void extraer(Cliente cliente, int numeroCuenta, int pin, int extraccion){
        Cuenta cuenta = obtenerCuenta(numeroCuenta);
        if (cliente.getPin() == pin){
            if (cuenta.getSaldo()>extraccion) {
                cuenta.setSaldo(cuenta.getSaldo() - extraccion);
                cobrar(cliente, cuenta);
                System.out.println("Operacion Exitosa");
                System.out.println("Se extrajo de su cuenta el monto de $" + extraccion );
            } else {
                System.out.println("No hay saldo suficiente para realizar la operación");
            }
        } else {
            System.out.println("Clave incorrecta");
        }
    }

    public double consultarSaldo(Cliente cliente, int numeroCuenta, int pin){
        Cuenta cuenta=obtenerCuenta(numeroCuenta);
        cobrar(cliente,cuenta);
        System.out.println("Operacion exitosa");
        return cuenta.getSaldo();
    }

    public void cambiarPin(Cliente cliente, int numeroCuenta, int pinActual, int pinNuevo){
        Cuenta cuenta=obtenerCuenta(numeroCuenta);
        if (cliente.getPin() == pinActual) {
            cliente.setPin(pinNuevo);
            cobrar(cliente, cuenta);
            System.out.println("Operacion exitosa");
        } else {
            System.out.println("Clave incorrecta");
        }
    }

    public void cobrar(Cliente cliente, Cuenta cuenta){
        Cuenta c=cliente.getCuenta(cuenta.getNumero(), cliente.getPin());
        if (cliente instanceof ClienteVip){
            if (((ClienteVip) cliente).isViveEnCapital()) {
                c.setSaldo(c.getSaldo() - 2);
            }
        } else {
            c.setSaldo(c.getSaldo()-6);
        }
    }

    public double generarInforme(){
        double saldo=0;
        for (Cuenta c:getListaCuentas()) {
            saldo+=c.getSaldo();
        }
        System.out.print("Saldo del banco a la fecha: $" + saldo + "\n");
        return saldo;
    }

    public void agregarCliente(Cliente cliente){
        getListaClientes().add(cliente);
    }

    public void agregarCuenta(Cuenta cuenta){
        getListaCuentas().add(cuenta);
    }
}
