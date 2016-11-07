package ejercicio6;

/**
 * Created by julianpascual on 10/21/16.
 */
public class Teatro {

    public void ImprimirLocalidades()
    {
        System.out.println("Localidades disponibles:");
        System.out.println(tipoLocalidad.adelante);
        System.out.println(tipoLocalidad.medio);
        System.out.println(tipoLocalidad.atras);
    }

    public void crearTicket(tipoLocalidad pTipo)
    {
        Ticket ticket=new Ticket();
        ticket.setLocalidad(pTipo);
        System.out.println(ticket.toString() + " - en Dolares: " + pTipo.precioEnDolares() + " - en Euros: " + pTipo.precioEnEuros());
    }
}
