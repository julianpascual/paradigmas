package ejercicio3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by julianpascual on 9/5/16.
 */
public class Verificador {
    private static final String email_rgEx = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public boolean emailValido(String email) {
        Pattern pattern = Pattern.compile(email_rgEx);
        Matcher match = pattern.matcher(email);
        return match.matches();
    }

}
