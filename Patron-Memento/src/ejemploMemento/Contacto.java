package ejemploMemento;

import java.util.Objects;

/**
 * Created by julianpascual on 10/28/16.
 */
public class Contacto {

    private String nombre;
    private String apellido;
    private String telefono;

    public Contacto(String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido(String apellido) {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String toString() {
        return "Nombre: " + nombre + ", Apellido: " + apellido + ", telefono: " + telefono;
    }

    public Memento saveMemento() {
        return new Memento(nombre,apellido,telefono);
    }

    public void restore(Object objMemento) {
        Memento memento = (Memento) objMemento;
        nombre = memento.getNombre();
        apellido = memento.getApellido();
        telefono = memento.getTelefono();
    }
}
