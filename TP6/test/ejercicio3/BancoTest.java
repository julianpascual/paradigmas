package ejercicio3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 11/7/16.
 */
public class BancoTest {
    Banco banco;
    Cuenta cuenta;

    @Before
    public void setUp() throws Exception {
        banco = new Banco();
        banco.agregarCliente(new Cliente("Juan", "Gomez", 25890765, 1234));
        banco.agregarCliente(new ClienteVip("Julian", "Pascual", 33282108, 4563, true));
        banco.agregarCliente(new ClienteVip("Pedro", "Marmol", 23567432, 9876, false));
        cuenta = new Cuenta(2632, banco.obtenerCliente(25890765), banco);
        Cuenta cuenta2 = new Cuenta(23523, banco.obtenerCliente(33282108), banco);
        Cuenta cuenta3 = new Cuenta(10151, banco.obtenerCliente(23567432), banco);
        banco.depositar(banco.obtenerCliente(25890765), 2632,1234, 2000);
        banco.depositar(banco.obtenerCliente(33282108), 23523, 4563, 1560);
    }

    @Test
    public void obtenerCuenta() throws Exception {
        Cuenta cuentaPedida = banco.obtenerCuenta(23523);
        Cliente clienteDueño = banco.obtenerCliente(33282108);
        assertEquals(clienteDueño, cuentaPedida.cliente);
    }

    @Test
    public void depositar() throws Exception {
        Cliente clienteDueño = banco.obtenerCliente(25890765);
        banco.depositar(clienteDueño, 2632, 1234, 20);
        assertEquals(2008, cuenta.getSaldo(), 0.1);
    }

    @Test
    public void extraer() throws Exception {
        Cliente clienteDueño = banco.obtenerCliente(25890765);
        banco.extraer(clienteDueño, 2632, 1234, 20);
        assertEquals(1968, cuenta.getSaldo(), 0.1);
    }

    @Test
    public void consultarSaldo() throws Exception {
        Cliente clienteDueño = banco.obtenerCliente(33282108);
        double saldo=banco.consultarSaldo(clienteDueño, 23523, 4563);
        assertEquals(1556, saldo, 0.1);
    }

    @Test
    public void cambiarPin() throws Exception {
        Cliente clienteDueño = banco.obtenerCliente(33282108);
        banco.cambiarPin(clienteDueño,23523, 4563, 8989);
        assertTrue(8989 == clienteDueño.getPin());
    }

    @Test
    public void generarInforme() throws Exception {
        double informe = banco.generarInforme();
        assertEquals(3552 , informe, 0.1);
    }
}