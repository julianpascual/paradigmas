package ejercicio5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by julianpascual on 11/7/16.
 */
public class IndividuoTest {
    private Individuo individuo;

    @Before
    public void setUp() throws Exception {
        this.individuo = new Individuo();
    }

    @Test
    public void darValorANucleotidos() throws Exception {
        assertEquals(25000, individuo.genesIguales(individuo).size());
    }

}