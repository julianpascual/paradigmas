package ejercicio4;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Julian on 7/11/16.
 */
public class ContactManagerTest {
    ContactManager cm;

    @Before
    public void setUp() throws Exception {
        cm = new ContactManager();
        cm.altaContacto(new Contacto("Julian", "Pascual", "115143252", "julianpascual@gmail.com", new Grupo("Facu")));
    }

    @Test
    public void altaContacto() throws Exception {
        cm.altaContacto(new Contacto("Pepe", "Gomez", "+5491140941369", "pepe@gmail.com", new Grupo("Facu")));
        assertTrue(2==cm.getListaDeContactos().size());
        assertTrue(1==cm.getListaDeGrupos().size());
    }

    @Test
    public void bajaContacto() throws Exception {
        Contacto contacto = new Contacto("Pepe", "Gomez", "+5491140941369", "pepe@gmail.com", new Grupo("Facu"));
        cm.altaContacto(contacto);
        cm.bajaContacto(cm.getListaDeContactos().get(0));
        assertEquals(1, cm.getListaDeContactos().size());
        assertEquals(1, cm.getGrupo("UAI").getListaDeContactos().size());
    }

    @Test
    public void modificarContacto() throws Exception {
        Contacto contacto = new Contacto("Pepe", "Gomez", "+5491140941369", "pepe@gmail.com", new Grupo("Facu"));
        cm.modificarContacto(cm.getListaDeContactos().get(0), contacto);
        assertEquals("Pepe", cm.getContacto("+5491140941369").nombre);
    }

    @Test
    public void agregarGrupo() throws Exception {
        cm.agregarGrupo(new Grupo("Paradigmas"));
        Assert.assertTrue(2==cm.getListaDeGrupos().size());
    }

    @Test
    public void eliminarGrupo() throws Exception {
        cm.agregarGrupo(new Grupo("Paradigmas"));
        cm.eliminarGrupo(cm.getListaDeGrupos().get(0));
        Assert.assertTrue(1==cm.getListaDeGrupos().size());
        Assert.assertTrue(null==cm.getListaDeContactos().get(0).getGrupo());
    }

    @Test
    public void modificarGrupo() throws Exception {
        cm.modificarGrupo(cm.getListaDeGrupos().get(0), new Grupo("Universidad"));
        Assert.assertTrue("Universidad"==cm.getListaDeGrupos().get(0).nombre);
    }

    @Test
    public void agregarContactoAGrupo() throws Exception {
        cm.altaContacto(new Contacto("Juan", "Perez", 1146631281, "juan.perez@gmail.com"));
        cm.agregarContactoAGrupo(cm.getContacto(1146631281), cm.getGrupo("UAI"));
        Assert.assertTrue(2==cm.getGrupo("UAI").getListaDeContactos().size());
    }

    @Test
    public void eliminarContactoDeGrupo() throws Exception {
        cm.eliminarContactoDeGrupo(cm.getContacto(1151385486), cm.getGrupo("UAI"));
        Assert.assertTrue(0==cm.getGrupo("UAI").getListaDeContactos().size());
    }
}