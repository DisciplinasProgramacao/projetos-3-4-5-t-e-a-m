
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.*;

public class VanTest {

    Van v;

    @BeforeEach
    void setUp() {
    v = new Van("1234", 5000.0, 10000);
    }


    @Test
    void testValorIpva(){
    assertEquals(150.0, v.valorIpva(), "valor IPVA ");

    }

    @Test
    void testValorSeguro(){
    assertEquals(150.00, v.valorSeguro(),"valor Seguro ");
    }
    
    @Test
    void testAutonomia(){
    assertEquals(600, v.autonomia(),"autonomia da van ");

    }
    @Test
    void testGet(){
    assertEquals(10000,v.getKmAlinhamento());
    assertEquals(120,v.getValorPorAlinhamento());
    assertEquals(10000,v.getKmVistoria());
    assertEquals(500,v.getValorPorVistoria());
    }
    
    @Test
    void testOutrosCustos(){
    assertEquals(620,v.outrosCustos(),"outros custos ");
    v = new Van("1234", 5000.0, 20000);
    assertEquals(1240,v.outrosCustos(),"outros custos ");
    }

}

