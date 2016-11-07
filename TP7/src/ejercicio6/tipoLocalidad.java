package ejercicio6;


/**
 * Created by julianpascual on 10/21/16.
 */
public enum tipoLocalidad {
    adelante(5),
    medio(15),
    atras(30);

    double precio;

    public double getMonto(){
        return precio;
    }

    public double precioEnDolares(){
        double value = precio / 15;
        return value;
    }

    public double precioEnEuros(){
        double value = precio / 18;
        return value;
    }

    tipoLocalidad(double pPrecio){
        precio = pPrecio;
    }

}
