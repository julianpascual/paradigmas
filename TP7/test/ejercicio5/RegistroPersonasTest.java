package ejercicio5;
import ejercicio3.Direccion;
import ejercicio3.Persona;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 11/7/16.
 */
public class RegistroPersonasTest {
    private RegistroPersonas registro;

    @Before
    public void setUp() throws Exception {
        registro=new RegistroPersonas();
        Persona persona = new Persona("35262624");
        persona.setNombre("Julian");
        persona.setApellido("Pascual");
        Direccion direccion = new Direccion();
        direccion.setCalle("Salguero");
        direccion.setNumero(1829);
        persona.setDireccion(direccion);
        registro.agregarPersona(persona);
        persona = new Persona("12356897");
        persona.setNombre("Lucia");
        persona.setApellido("Gonzalez");
        direccion = new Direccion();
        direccion.setCalle("Medrano");
        direccion.setNumero(1709);
        persona.setDireccion(direccion);
        registro.agregarPersona(persona);

    }

    @Test
    public void agregarPersona() throws Exception {
        registro.agregarPersona(new Persona("781122"));
        assertEquals(3,registro.cantidadPersonas());
    }

    @Test
    public void recuperarPersona() throws Exception {
        Persona pPersona=registro.recuperarPersona("12356897");
        System.out.println(pPersona);
        assertEquals("Lucia",pPersona.getNombre());
    }

    @Test
    public void cantidadPersonas() throws Exception {
        Persona pPersona =new Persona("35262624"); //Lo agrega por mas que este repetido pero despues cuando quiera traerlo por el dni me trae el ultimo agregado
        pPersona.setNombre("Lucas");
        pPersona.setApellido("Lopez");
        registro.agregarPersona(pPersona);
        registro.imprimirListaDePersonas();
        assertEquals(3,registro.cantidadPersonas());
    }

}