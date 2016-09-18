package ejercicio6;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static helpers.Helpers.escribirArchivo;

/**
 * Created by Julian on 14/9/16.
 */
public class MatrizTranspuesta {

    public void transponerMatriz(String pathMatriz, String pathSalida) {

        ArrayList<ArrayList<Integer>> matrizTranspuesta = new ArrayList<>();
        ArrayList<ArrayList<Integer>> matriz = obtenerMatrizDeArchivo(pathMatriz);

        if (!matriz.isEmpty()) {
            int noOfElementsInList = matriz.get(0).size();
            for (int i = 0; i < noOfElementsInList; i++) {
                ArrayList<Integer> col = new ArrayList<>();
                for (ArrayList<Integer> row : matriz) {
                    col.add(row.get(i));
                }
                matrizTranspuesta.add(col);
            }
        }

        String texto = matrizATexto(matrizTranspuesta);
        escribirArchivo(pathSalida, "matrizTranspuesta.txt", texto);
    }

    public ArrayList<ArrayList<Integer>> obtenerMatrizDeArchivo(String path) {

        ArrayList<ArrayList<Integer>> matriz = null;
        try {
            matriz = new ArrayList<>();
            Scanner input = new Scanner(new File(path));
            while(input.hasNextLine())
            {
                Scanner colReader = new Scanner(input.nextLine());
                ArrayList col = new ArrayList();
                while(colReader.hasNextInt())
                {
                    col.add(colReader.nextInt());
                }
                matriz.add(col);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return matriz;
        }
    }

    public String matrizATexto(ArrayList<ArrayList<Integer>> matriz) {
        StringBuilder texto = new StringBuilder();

        if (!matriz.isEmpty()) {
            for (int i = 0; i < matriz.size(); i++)
            {
                ArrayList<Integer> list = matriz.get(i);
                for (Integer num : list)
                {
                    texto.append(num + " ");
                }
                if (i != matriz.size() - 1) {
                    texto.append("\n ");
                }
            }
        }
        return texto.toString();
    }

}
