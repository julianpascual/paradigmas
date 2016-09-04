package ejercicio3;


import java.util.Random;
import java.util.Scanner;

/**
 * Valores:
 *
 * piedra = 0
 * papel = 1
 * tijera = 2
 *
 */
public class Ejercicio3 {
    private static boolean seguimosJugando = true;

    public static void main (String args[]) {
        String resultado;
        while (seguimosJugando) {
            System.out.println("Ingresa un valor para jugar:");

            Scanner sc = new Scanner(System.in);
            String valor = sc.next();

            resultado = jugar(valor.toLowerCase());

            System.out.println(resultado);

            System.out.println("Queres seguir jugando? y/n");
            String respuesta = sc.next();

            if (!respuesta.toLowerCase().startsWith("y")) {
                seguimosJugando = false;
            }

        }
    }

    public static String jugar(String valor) {
        String resultado= null;
        String valorRandom = devolverValorRandomDesdeNumero();

        if (esValido(valor)) {
            if (valor.equals(valorRandom)) {
                resultado = "Empate, los dos eligieron " + valor;
            } else {
                if (valor.equals("piedra") && valorRandom.equals("papel")) {
                    resultado = "" + valor + " vs " + valorRandom + ", perdiste!";
                }
                if (valor.equals("piedra") && valorRandom.equals("tijera")) {
                    resultado = "" + valor + " vs " + valorRandom + ", ganaste!";
                }
                if (valor.equals("papel") && valorRandom.equals("tijera")) {
                    resultado = "" + valor + " vs " + valorRandom + ", perdiste!";
                }
                if (valor.equals("papel") && valorRandom.equals("piedra")) {
                    resultado = "" + valor + " vs " + valorRandom + ", ganaste!";
                }
                if (valor.equals("tijera") && valorRandom.equals("piedra")) {
                    resultado = "" + valor + " vs " + valorRandom + ", perdiste!";
                }
                if (valor.equals("tijera") && valorRandom.equals("papel")) {
                    resultado = "" + valor + " vs " + valorRandom + ", ganaste!";
                }
            }
        } else  {
            resultado = "Valor ingresado invalido.";
        }
        return resultado;
    }

    public static String devolverValorRandomDesdeNumero() {
        int valorNumerico = new Random().nextInt(3);
        String valor = null;
        switch (valorNumerico) {
            case  0: valor = "piedra";
                break;
            case 1: valor = "papel";
                break;
            case 2: valor = "tijera";
                break;
        }
        return valor;
    }

    public static boolean esValido(String valor) {
        boolean valido = false;

        if (valor.equals("piedra") || valor.equals("papel") || valor.equals("tijera")) {
            valido = true;
        }
        return valido;
    }
}
