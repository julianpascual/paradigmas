package ejercicio2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by julianpascual on 9/5/16.
 */
public class Prolog {
    private static HashMap<String, String> hijosPadre = new HashMap<>();
    private static HashMap<String, String> hijosMadre = new HashMap<>();

    public static void main(String[] args) {
        boolean seguimos = true;

        System.out.println("Ingrese el path del archivo a utilizar: ");
        Scanner sc = new Scanner(System.in);
        String path = sc.next();

        try {
            ArrayList<String> datos = leerArchivo(path);
            obtenerDiccionarioHijos(datos);

            System.out.println("Datos cargados, comencemos.");

            while (seguimos) {
                System.out.println("Ingrese comando a evaluar:");
                sc = new Scanner(System.in);
                String valor = sc.next();

                String respuesta = evaluar(valor);

                if (!respuesta.isEmpty()) {
                    System.out.println(respuesta);
                } else {
                    System.out.println("Comando incorrecto");
                }

                System.out.println("Queres seguir jugando? y/n");
                String continuar = sc.next();

                if (!continuar.toLowerCase().startsWith("y")) {
                    seguimos = false;
                }

            }
        } catch (Exception ex) {
            System.out.println("Ooops, Ocurrio un problema.");
        }
    }

    public static String evaluar(String valor) {
        String respuesta = "";
        Matcher m = Pattern.compile("\\((.*?)\\)").matcher(valor);
        while(m.find()) {
            String[] valores = m.group(1).split(",");
            if (valor.contains("Hermano")) {
                respuesta = hermanos(valores[0], valores[1]);
            } else if (valor.contains("Abuelo")) {
                respuesta = abuelo(valores[0], valores[1]);
            }
        }
        return respuesta;
    }

    public static String hermanos(String hijo1, String hijo2) {
        try {
            if (hijosPadre.get(hijo1).equals(hijosPadre.get(hijo2)) || hijosMadre.get(hijo1).equals(hijosMadre.get(hijo2))) {
                return "SI";
            } else {
                return "NO";
            }
        } catch (Exception ex) {
            return "NO";
        }
    }

    public static String abuelo(String abuelo, String nieto) {
        String respuesta = "NO";
        try {
            for (Map.Entry<String, String> entry : hijosPadre.entrySet()) {
                if (entry.getValue().equals(abuelo)) {
                    for (Map.Entry<String, String> entry2 : hijosPadre.entrySet()) {
                        if (entry2.getKey().equals(nieto) && entry2.getValue().equals(entry.getKey())) {
                            respuesta = "SI";
                            break;
                        }
                    }
                    if (respuesta.equals("SI")) {
                        break;
                    }
                }
            }
        } catch (Exception ex) {

        } finally {
            return respuesta;
        }

    }

    public static void obtenerDiccionarioHijos(ArrayList<String> origenDatos) {
        for (String dato: origenDatos) {
            Matcher m = Pattern.compile("\\((.*?)\\)").matcher(dato);
            while(m.find()) {
                String[] valores = m.group(1).split(",");
                if (dato.contains("madre")) {
                    hijosMadre.put(valores[1], valores[0]);
                } else if (dato.contains("padre")) {
                    hijosPadre.put(valores[1], valores[0]);
                }
            }
        }
    }

    public static ArrayList<String> leerArchivo(String pathArchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(pathArchivo));
            String line = bufferedReader.readLine();
            while (line != null) {
                lineas.add(line);
                line = bufferedReader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lineas;
    }
}
