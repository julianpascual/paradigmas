package ejemploMemento;

/**
 * Created by julianpascual on 11/7/16.
 */
public class Demo {

    public static void main(String[] args) {

        // caretaker
        Caretaker caretaker = new Caretaker();

        //originator
        Contacto contacto = new Contacto("Julian", "Pascual", "0112565634");
        System.out.println(contacto);

        //modifico el telefono y guardo el estado
        contacto.setTelefono("0111521620839");
        caretaker.saveState(contacto);

        System.out.println("Estado guardado.");
        System.out.println(contacto);

        //modifco el los demas datos pero al final quiero volver a mi estado anterior
        contacto.setNombre("Pablo");
        contacto.setApellido("Marmol");

        System.out.println("Contacto actualizado.");

        System.out.println(contacto);

        System.out.println("Volviendo al estado anterior...");
        caretaker.restoreState(contacto);

        System.out.println(contacto);
    }
}
