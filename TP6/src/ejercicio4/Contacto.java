package ejercicio4;

/**
<<<<<<< HEAD
 * Created by Julian on 22/10/16.
 */
public class Contacto {

    public String nombre;
    public String apellido;
    public String mail;
    public String telefono;

=======
 * Created by julianpascual on 10/21/16.
 */
public class Contacto {
    String nombre;
    String apellido;
    String telefono;
    String email;
    Grupo grupo;

    public Contacto(String nombre, String apellido, String telefono, String email, Grupo grupo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.grupo = grupo;
        this.getGrupo().agregarContacto(this);
    }

    public Contacto(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;

    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
>>>>>>> 8800a5ca5fa0ac2c20c975901a44b6fe18bd3d5f
}
