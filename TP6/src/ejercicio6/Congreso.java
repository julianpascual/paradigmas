package ejercicio6;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julianpascual on 11/1/16.
 */
public class Congreso {

    List<Asistente> listaDeAsistenteCreados = new ArrayList<Asistente>();
    List<Asistente> listaDeAsistentes = new ArrayList<Asistente>();
    String nombre;
    double precioBase;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Asistente> getListaDeAsistentes() {
        return listaDeAsistentes;
    }

    public void setListaDeAsistentes(List<Asistente> listaDeAsistentes) {
        this.listaDeAsistentes = listaDeAsistentes;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public List<Asistente> getListaDeAsistenteCreados() {
        return listaDeAsistenteCreados;
    }

    public void setListaDeAsistenteCreados(List<Asistente> listaDeAsistenteCreados) {
        this.listaDeAsistenteCreados = listaDeAsistenteCreados;
    }

    public void crearAsistente(Asistente asistente){
        getListaDeAsistenteCreados().add(asistente);
    }

    public List<String> mostrarAsistentes(){
        List<String> lista = new ArrayList<String>();

        for (Asistente asistente: getListaDeAsistentes()){
            lista.add(asistente.getNombre() + " " + asistente.getApellido());
        }
        System.out.println("---Lista de asistentes---");
        for (String persona: lista){
            System.out.println(persona);
        }
        return lista;
    }

    public double cobrarEntrada(Asistente asistente){
        return this.getPrecioBase()-asistente.getDescuento();
    }

    public String imprimirCredencial(Asistente asistente) {
        String credencial = getNombre() + "\n" + asistente.getApellido() + " " + asistente.getNombre() + "\n" + asistente.getInstitucion();
        System.out.println(credencial);
        return credencial;
    }

    public Congreso(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }
}
