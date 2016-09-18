package ejercicio3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Julian on 18/9/16.
 */
public class VerificadorTest {
    private Verificador verificador;

    @Before
    public void setUp() throws Exception {
        verificador = new Verificador();
    }

    @Test
    public void emailValido() throws Exception {
        String email = "julian.pascual96@gmail.com";
        assertTrue(verificador.emailValido(email));
    }

    @Test
    public void emailValido2() throws Exception {
        String email = "julian-pascual_96@gmail.com";
        assertTrue(verificador.emailValido(email));
    }

    @Test
    public void emailInvalido() throws Exception {
        String email = "julian.pas@cual96@gmail.com";
        assertFalse(verificador.emailValido(email));
    }

    @Test
    public void emailInvalido2() throws Exception {
        String email = "julian.pascual96@gmail.com214";
        assertFalse(verificador.emailValido(email));
    }

}