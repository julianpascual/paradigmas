package ejercicio5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by julianpascual on 11/7/16.
 */
public class Gen {
    int id;
    int cantidadNucleotidos;
    List<String> listaNucleotidos = new ArrayList<String>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidadNucleotidos() {
        return cantidadNucleotidos;
    }

    public void setCantidadNucleotidos(int cantidadNucleotidos) {
        this.cantidadNucleotidos = cantidadNucleotidos;
    }

    public List<String> getListaNucleotidos() {
        return listaNucleotidos;
    }

    public void setListaNucleotidos(List<String> listaNucleotidos) {
        this.listaNucleotidos = listaNucleotidos;
    }

    public Gen(int id, int cantidadNucleotidos) {
        this.id = id;
        this.cantidadNucleotidos = cantidadNucleotidos;
    }

    public void agregarNucleotido(String valor){
        this.getListaNucleotidos().add(valor);

    }
}
