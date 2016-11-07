package ejercicio6;

/**
 * Created by julianpascual on 10/21/16.
 */
public class Ticket {
    private tipoLocalidad localidad;

    public void setLocalidad(tipoLocalidad pLocalidad)
    {
        this.localidad=pLocalidad;
    }

    @Override
    public String toString()
    {
        return this.localidad + ": " + this.localidad.getMonto() +  " pesos";
    }

}
