package ejercicio7;

/**
 * Created by julianpascual on 10/21/16.
 */
public class ProductoAlimenticio implements ProductoDeVenta
    {
        private String nombre;
        private double precio;

        /**Getters y Setters*/
        public void setPrecio(double pPrecio){this.precio=pPrecio;}
        public void setNombre(String pNombre){this.nombre=pNombre;}
        public String getNombre(){return this.nombre;}
        @Override
        public double getPrecioVenta() {
            return precio;
        }
        @Override
        public boolean equals(Object pObj) {
            if (pObj.hashCode() == this.hashCode()) {
                return true;
            } else
            {return false;}
        }
        @Override
        public int hashCode(){
            int result=17;
            result=37*result+this.getNombre().hashCode();
            return result;
        }

        @Override
        public void promoDescuento70SegundaUnidad() {
            setPrecio(getPrecioVenta()*0.30);
        }
    }
