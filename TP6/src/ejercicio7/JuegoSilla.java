package ejercicio7;

import java.util.*;

/**
 * Created by julianpascual on 11/7/16.
 */
public class JuegoSilla {
    static int cantDeSillas;
    static List<String> listaJugadores = new ArrayList<String>();
    static int nroRonda;

    public static int getCantDeSillas() {
        return cantDeSillas;
    }

    public static void setCantDeSillas(int cantDeSillas) {
        cantDeSillas = cantDeSillas;
    }

    public static List<String> getListaJugadores() {
        return listaJugadores;
    }

    public static void setListaJugadores(List<String> listaJugadores) {
        listaJugadores = listaJugadores;
    }

    public static void agregarJugadores(){
        Scanner cantScanner = new Scanner(System.in);
        Scanner nombreScanner = new Scanner(System.in);
        String nombre;
        System.out.print("Cantidad de jugadores: \n");
        int cantJugadores = cantScanner.nextInt();
        cantDeSillas=cantJugadores-1;
        for (int i=1;i<=cantJugadores;i++){
            System.out.print("Nombre del jugador " + i + ": \n");
            nombre=nombreScanner.nextLine();
            listaJugadores.add(nombre);
        }
    }

    public static void nuevaVuelta(){
        int musica;
        Random tiempo = new Random();
        Random jugador = new Random();
        String perdedor = getListaJugadores().get(jugador.nextInt(getListaJugadores().size()));
        eliminarJugador(perdedor);
        Map<String, Integer> mapaJuego = new HashMap<String, Integer>();

        cantDeSillas--;
        musica=tiempo.nextInt(60);
        try{
            Thread.sleep(musica);
        }catch (Exception e){
            System.out.print("FALLO");
        }
        System.out.print("Ronda "+ nroRonda + ": La música sonó " + musica + " segundos y cuando paró, perdió " + perdedor+"\n");
    }

    public static void eliminarJugador(String jugador){
        getListaJugadores().remove(jugador);
    }

    public static void jugar(){
        do{
            nroRonda++;
            nuevaVuelta();
        }while (getCantDeSillas()>=1);
        if (cantDeSillas==0){
            System.out.print("Ganó " + getListaJugadores().get(0) + "\n");
        }
    }

    public static void main(String[] args){
        agregarJugadores();
        getCantDeSillas();
        jugar();
    }
}
