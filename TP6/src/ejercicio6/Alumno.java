package ejercicio6;

/**
 * Created by julianpascual on 11/1/16.
 */
public class Alumno extends Asistente {

    private int año;

    public Alumno(String nombre, String apellido, String institucion, Congreso congreso, int año) {
        super(nombre, apellido, institucion, congreso);
        this.año = año;
        this.setDescuento();
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public double setDescuento() {
        if (getAño()>=1 && getAño()<=3){
            descuento = this.getCongreso().getPrecioBase()*0.25;
        }
        return descuento;
    }
}
