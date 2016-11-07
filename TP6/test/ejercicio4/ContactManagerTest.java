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
        assertEquals(1, cm.getGrupo("Facu").getListaDeContactos().size());
    }

    @Test
    public void modificarContacto() throws Exception {
        Contacto contacto = new Contacto("Pepe", "Gomez", "+5491140941369", "pepe@gmail.com", new Grupo("Facu"));
        cm.modificarContacto(cm.getListaDeContactos().get(0), contacto);
        assertEquals("Pepe", cm.getContacto("+5491140941369").nombre);
    }

    @Test
    public void agregarGrupo() throws Exception {
        cm.agregarGrupo(new Grupo("TestGroup"));
        assertEquals(2, cm.getListaDeGrupos().size());
    }

    @Test
    public void eliminarGrupo() throws Exception {
        cm.agregarGrupo(new Grupo("TestGroup"));
        cm.eliminarGrupo(cm.getListaDeGrupos().get(0));
        assertEquals(1, cm.getListaDeGrupos().size());
        assertNull(cm.getListaDeContactos().get(0).getGrupo());
    }

    @Test
    public void modificarGrupo() throws Exception {
        cm.modificarGrupo(cm.getListaDeGrupos().get(0), new Grupo("Test2"));
        assertTrue("Test2" == cm.getListaDeGrupos().get(0).nombre);
    }

    @Test
    public void agregarContactoAGrupo() throws Exception {
        cm.altaContacto(new Contacto("Juan", "Gomez", "02442-35326", "juang@hotmail.com"));
        cm.agregarContactoAGrupo(cm.getContacto("02442-35326"), cm.getGrupo("Facu"));
        assertEquals(2 , cm.getGrupo("Facu").getListaDeContactos().size());
    }

    @Test
    public void eliminarContactoDeGrupo() throws Exception {
        cm.eliminarContactoDeGrupo(cm.getContacto("115143252"), cm.getGrupo("Facu"));
        assertEquals(0 , cm.getGrupo("Facu").getListaDeContactos().size());
    }
}