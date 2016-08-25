package ejercicio6;

/**
 * Created by julianpascual on 8/25/16.
 */
public class OrdenarReales {

    public float[] ordenarNumeros(float x, float y, float z) {
        float mayor,medio,menor;
        float[] resultado = new float[3];

        if(x>y&&x>z)
            mayor=x;
        else
        if(y>x&&y>z)
            mayor=y;
        else
            mayor=z;

        if(x<y&&x<z)
            menor=x;
        else
        if(y<x&&y<z)
            menor=y;
        else
            menor=z;
        medio=(x+y+z)-(mayor+menor);

        resultado[0] = mayor;
        resultado[1] = medio;
        resultado[2] = menor;

        return resultado;
    }
}
