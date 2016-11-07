package ejercicio6;

/**
 * Created by julianpascual on 11/1/16.
 */
public class Presentador extends Asistente {

    Presentador(String nombre, String apellido, String institucion, Congreso congreso) {
        super(nombre, apellido, institucion, congreso);
        this.setDescuento();
    }

    @Override
    public double setDescuento() {
        descuento = this.getCongreso().getPrecioBase()*0.75;
        return descuento;
    }
}
