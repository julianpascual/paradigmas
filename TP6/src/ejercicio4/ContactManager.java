package ejercicio4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julianpascual on 10/21/16.
 */
public class ContactManager {
    List<Contacto> listaDeContactos= new ArrayList<Contacto>();
    List<Grupo> listaDeGrupos= new ArrayList<Grupo>();

    public List<Contacto> getListaDeContactos() {
        return listaDeContactos;
    }

    public void setListaDeContactos(List<Contacto> listaDeContactos) {
        this.listaDeContactos = listaDeContactos;
    }

    public List<Grupo> getListaDeGrupos() {
        return listaDeGrupos;
    }

    public void setListaDeGrupos(List<Grupo> listaDeGrupos) {
        this.listaDeGrupos = listaDeGrupos;
    }

    public Contacto getContacto(String telefono){
        Contacto contacto=null;
        for (Contacto c: getListaDeContactos()){
            if (c.telefono==telefono){
                contacto=c;
            }
        }
        return contacto;
    }

    public Grupo getGrupo(String nombreGrupo){
        Grupo grupo= null;
        for (Grupo g: getListaDeGrupos()){
            if (g.nombre==nombreGrupo){
                grupo=g;
            }
        }
        return grupo;
    }

    public void altaContacto(Contacto contacto){
        getListaDeContactos().add(contacto);
        if (contacto.grupo!=null){
            if (existeGrupo(contacto.grupo)) {
                getGrupo(contacto.getGrupo().nombre).agregarContacto(contacto);
            } else {
                getListaDeGrupos().add(contacto.getGrupo());
            }
        }
    }

    public void bajaContacto(Contacto contacto){
        for (Contacto c: getListaDeContactos()) {
            if (c == contacto){
                if (!(contacto.grupo == null)){
                    contacto.getGrupo().eliminarContacto(contacto);
                }
                getListaDeContactos().remove(c);
            }
        }
    }

    public void modificarContacto(Contacto contactoActual, Contacto contactoNuevo) {
        for (Contacto c : getListaDeContactos()) {
            if (c == contactoActual) {
                c.setNombre(contactoNuevo.nombre);
                c.setApellido(contactoNuevo.apellido);
                c.setTelefono(contactoNuevo.telefono);
                c.setEmail(contactoNuevo.email);
            }
        }
    }

    public void agregarGrupo(Grupo grupoNuevo){
        if (!existeGrupo(grupoNuevo)){
            getListaDeGrupos().add(grupoNuevo);
        }
    }

    private boolean existeGrupo(Grupo grupoNuevo) {
        boolean existe = false;
        for (Grupo grupo: getListaDeGrupos()){
            if (grupo == grupoNuevo){
                existe = true;
            }
        }
        return existe;
    }

    public void eliminarGrupo(Grupo grupo){
        for (Contacto c: grupo.getListaDeContactos()){
            c.grupo=null;
        }
        getListaDeGrupos().remove(grupo);
    }

    public void modificarGrupo(Grupo grupoActual, Grupo grupoNuevo){
        for (Grupo grupo: getListaDeGrupos()){
            if ( grupo == grupoActual) {
                grupo.nombre = grupoNuevo.nombre;
            }
        }
    }

    public void agregarContactoAGrupo(Contacto contacto, Grupo grupo){
        grupo.agregarContacto(contacto);
    }

    public void eliminarContactoDeGrupo(Contacto contacto,Grupo grupo){
        grupo.eliminarContacto(contacto);
    }
}
