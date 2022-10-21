import Aplicacao.Veiculo;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VanTest {

    Van v;

    @BeforeEach
    void setUp() throws Exception {
    v = new Van();
    }


    @Test
    void testValorIpva(){
    assertEquals(2500.00, v.valorIpva());

    }

    @Test
    void testValorSeguro(){
    assertEquals(2000.00, v.valorSeguro());
    }
    
    @Test
    void testAutonomia(){
    assertEquals();

    }
    @Test
    void testOutrosCustos(){
    assertEquals();

    }

}
