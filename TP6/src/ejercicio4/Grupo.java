package ejercicio4;

<<<<<<< HEAD
/**
 * Created by Julian on 22/10/16.
 */
public class Grupo {

=======
import java.util.ArrayList;
import java.util.List;

/**
 * Created by julianpascual on 10/21/16.
 */
public class Grupo {
    String nombre;
    List<Contacto> listaDeContactos=new ArrayList<Contacto>();

    public Grupo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Contacto> getListaDeContactos() {
        return listaDeContactos;
    }

    public void setListaDeContactos(List<Contacto> listaDeContactos) {
        this.listaDeContactos = listaDeContactos;
    }

    public void agregarContacto(Contacto contacto){
        contacto.grupo = this;
        this.listaDeContactos.add(contacto);
    }

    public void eliminarContacto(Contacto contacto){
        contacto.grupo=null;
        this.listaDeContactos.remove(contacto);
    }
>>>>>>> 8800a5ca5fa0ac2c20c975901a44b6fe18bd3d5f
}
