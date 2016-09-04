package ejercicio3;

import org.hamcrest.core.AnyOf;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * Created by julianpascual on 9/3/16.
 */
public class Ejercicio3Test {
    private Ejercicio3 ej3;

    @Before
    public void setUp() throws Exception {
        ej3 = new Ejercicio3();
    }

//    @Test
//    public void main() throws Exception {
//        ej3.main(new String[] {});
//    }


    @Test
    public void testFuncionRandom() throws Exception{
        String valor = ej3.devolverValorRandomDesdeNumero();
        Assert.assertThat(valor, AnyOf.anyOf(StringContains.containsString("papel"),StringContains.containsString("piedra"),StringContains.containsString("tijera")));
    }

}