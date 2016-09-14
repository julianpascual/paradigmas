package ejercicio9;

import java.util.*;

/**
 * Created by Julian on 14/9/16.
 */
public class CadenasRecursivas {
    public String[] caracteres = {"A","N"};

    public ArrayList<String> obtenerCadena(int k) {
        ArrayList<String> res = new ArrayList<>();
        hacerCombinaciones(k, "", res);
        return res;
    }

    public void hacerCombinaciones(int k, String stringActual, ArrayList<String> res) {
        if (stringActual.length() == k) {
            res.add(stringActual);
        }  else {
            for (String caracter: caracteres) {
                hacerCombinaciones(k, stringActual + caracter, res);
            }
        }

    }

}
