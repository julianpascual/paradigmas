package ejemploMemento;

/**
 * Created by julianpascual on 11/7/16.
 */
public class Caretaker {

    Object objMemento;

    public void saveState(Contacto contacto) {
        objMemento = contacto.saveMemento();
    }

    public void restoreState(Contacto contacto) {
        contacto.restore(objMemento);
    }
}
