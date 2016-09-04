package ejercicio5;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import helpers.Helpers;

/**
 * Created by julianpascual on 9/3/16.
 */
public class Ejercicio5 {
    private Helpers helper = new Helpers();

    public void generarArchivoResultados(int[] numeros) {

        ArrayList<Integer> arrayPares = new ArrayList<Integer>();
        ArrayList<Integer> arrayImpares = new ArrayList<Integer>();
        ArrayList<Integer> arrayPrimos = new ArrayList<Integer>();
        ArrayList<Integer> arrayDiv3000 = new ArrayList<Integer>();
        int promedioPares, promedioImpares;

        for (int i = 0; i < numeros.length; i++) {

            if (helper.esPrimo(numeros[i])) {
                arrayPrimos.add(numeros[i]);
            }
            if (esDivisor3000(numeros[i])) {
                arrayDiv3000.add(numeros[i]);
            }
            if (numeros[i] % 2 == 0) {
                arrayPares.add(numeros[i]);
            } else {
                arrayImpares.add(numeros[i]);
            }
        }

        promedioImpares = promedioNumeros(arrayImpares);
        promedioPares = promedioNumeros(arrayPares);

        escribirArchivo("primos", convertirArray(arrayPrimos));
        escribirArchivo("divisores de 300", convertirArray(arrayDiv3000));
        escribirArchivo("promedios", "Promedio de pares: " + promedioPares + "\nPromedio de impares: " + promedioImpares);
    }

    public int promedioNumeros(ArrayList<Integer> numeros) {

        int prom;
        int sumNumeros = 0;

        for (int i = 0; i < numeros.size(); i++) {
            sumNumeros = sumNumeros + numeros.get(i);
        }
        prom = sumNumeros / numeros.size();
        return prom;
    }

    public boolean esDivisor3000(int num){
        if (num % 3000 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void escribirArchivo(String fileName, String texto) {
        try {
            File statText = new File("resources/" + fileName + ".txt");
            FileOutputStream is = new FileOutputStream(statText);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            Writer w = new BufferedWriter(osw);
            w.write(texto);
            w.close();
        } catch (IOException e) {
            System.err.println("No se pudo crear el archivo.");
        }

    }

    public String convertirArray(ArrayList<Integer> numeros) {
        String texto = "";

        for (int i = 0; i < numeros.size(); i++) {
            texto = texto + numeros.get(i) + "\n";
        }
        return texto;
    }
}
