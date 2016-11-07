package ejercicio3;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import com.sun.org.glassfish.gmbal.ManagedObject;

import java.util.Comparator;

/**
 * Created by julianpascual on 10/21/16.
 */
public class Persona implements Comparable<Persona>{


    private String DNI;
    private String nombre;
    private String apellido;
    private Direccion direccion;


    public void setDNI(String pDNI){this.DNI=pDNI;}
    public String getDNI(){return this.DNI;}
    public void setNombre(String pNombre){this.nombre=pNombre;}
    public String getNombre(){return this.nombre;}
    public void setApellido(String pApellido){this.apellido=pApellido;}
    public String getApellido(){return this.apellido;}
    public void setDireccion(Direccion pDireccion){this.direccion=pDireccion;}
    public Direccion getDireccion(){return this.direccion;}



    public Persona(String pDNI)
    {
 setDNI(pDNI);
    }
    @Override
    public String toString(){
        String respuesta;
        respuesta=this.DNI + " " + this.nombre + " " + this.apellido;
        return respuesta;
    }
    @Override
    public int hashCode(){
        int result=17;
        result=37*result+this.getDNI().hashCode();
        return result;
    }
    @Override
    public boolean equals(Object pObj)
    {
        if (pObj.hashCode()==this.hashCode())
        {
            return true;
        }
        else {return false;}
    }

    @Override
    public int compareTo(Persona o) {
        return o.getDNI().compareTo(this.getDNI());
    }
}
