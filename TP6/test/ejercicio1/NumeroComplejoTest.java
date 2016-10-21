package ejercicio1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 10/21/16.
 */
public class NumeroComplejoTest {
    private NumeroComplejo num1;
    private NumeroComplejo num2;

    @Before
    public void setUp() throws Exception {
        num1 = new NumeroComplejo(2,8);
        num2 = new NumeroComplejo(3,1);
    }

    @Test
    public void suma() throws Exception {
        NumeroComplejo rslt = num1.suma(num2);
        assertEquals(5, rslt.getReal(), 0.1);
        assertEquals(9, rslt.getImag(), 0.1);
    }

    @Test
    public void resta() throws Exception {
        NumeroComplejo rslt = num2.resta(num1);
        assertEquals(1, rslt.getReal(), 0.1);
        assertEquals(-7, rslt.getImag(), 0.1);
    }

}