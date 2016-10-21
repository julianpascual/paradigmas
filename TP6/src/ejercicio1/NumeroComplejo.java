package ejercicio1;

/**
 * Created by julianpascual on 10/21/16.
 */
public class NumeroComplejo {

    private double real;
    private double imag;

    public NumeroComplejo() {
        setReal(0.0);
        setImag(0.0);
    }
    public NumeroComplejo(double real, double imag){
        this.setReal(real);
        this.setImag(imag);
    }

    //suma de dos números complejos
    public NumeroComplejo suma(NumeroComplejo nroC){
        double x= this.getReal() + nroC.getReal();
        double y= this.getImag() + nroC.getImag();
        return new NumeroComplejo(x, y);
    }

    public NumeroComplejo resta(NumeroComplejo nroC){
        double x= this.getReal() - nroC.getReal();
        double y= this.getImag() - nroC.getImag();
        return new NumeroComplejo(x, y);
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }
}
