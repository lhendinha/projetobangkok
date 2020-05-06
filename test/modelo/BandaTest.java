package modelo;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BandaTest {
    private Banda banda;
    
    public BandaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        banda = new Banda();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetCodigo() {
        System.out.println("getCodigo");
        int expResult = 1;
        banda.setCodigo(1);
        int result = banda.getCodigo();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNome() {
        System.out.println("getNome");
        String expResult = "Pedro Sousa";
        banda.setNome("Pedro Sousa");
        String result = banda.getNome();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetGenero() {
        System.out.println("getGenero");
        String expResult = "Masculino";
        banda.setGenero("Masculino");
        String result = banda.getGenero();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAvaliacao() {
        System.out.println("getAvaliacao");
        String expResult = "Ruim";
        banda.setAvaliacao(15);
        String result = banda.getAvaliacao();
        assertEquals(expResult, result);
    }
}
