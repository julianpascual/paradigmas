package ejercicio6;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 11/7/16.
 */
public class CongresoTest {
    Congreso congreso;
    Asistente asistente;

    @Before
    public void setUp() throws Exception {
        this.congreso = new Congreso("Google dev group", 100);
        this.asistente = new Alumno("Julian", "Pascual", "UAI", congreso, 3);
    }

    @Test
    public void crearAsistente() throws Exception{
        Particular particular = new Particular("Pablo", "Gomez", "Google dev group", congreso, true);
        Presentador presentador = new Presentador("Jeff", "Bezos", "Google dev group", congreso);
        asistente.agregarAListaDeAsistentes();
        particular.agregarAListaDeAsistentes();
        presentador.agregarAListaDeAsistentes();
        assertEquals(3 , congreso.getListaDeAsistentes().size());
    }

    @Test
    public void agregarAsistente() throws Exception {
        this.asistente.agregarAListaDeAsistentes();
        assertEquals(1 , congreso.getListaDeAsistentes().size());
    }

    @Test
    public void mostrarAsistentes() throws Exception {
        Particular particular = new Particular("Pablo", "Gomez", "Google dev group", congreso, true);
        Presentador presentador = new Presentador("Jeff", "Bezos", "Google dev group", congreso);
        this.asistente.agregarAListaDeAsistentes();
        particular.agregarAListaDeAsistentes();
        presentador.agregarAListaDeAsistentes();

        List<String> lista = congreso.mostrarAsistentes();

        assertEquals("Julian Pascual",lista.get(0));
    }

    @Test
    public void precioEntrada() throws Exception {
        assertEquals(75, congreso.cobrarEntrada(asistente), 0.1);

        Particular particular = new Particular("Pablo", "Gomez", "Google dev group", congreso, true);
        particular.agregarAListaDeAsistentes();
        assertEquals(90, congreso.cobrarEntrada(particular), 0.1);

        Presentador presentador = new Presentador("Jeff", "Bezos", "Google dev group", congreso);
        presentador.agregarAListaDeAsistentes();
        assertEquals(25, congreso.cobrarEntrada(presentador), 0.1);
    }

    @Test
    public void imprimirCredencial() throws Exception {
        String credencialEsperada = congreso.getNombre() + "\n" + asistente.getApellido() + " " + asistente.getNombre() + "\n" + asistente.getInstitucion();
        assertEquals(credencialEsperada, congreso.imprimirCredencial(asistente));
    }
}