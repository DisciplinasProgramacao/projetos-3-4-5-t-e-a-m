
package Testes;
import org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VeiculosTest {

    @BeforeEach
    void setUp() throws Exception {
    veiculo v = new Veículo();
    }

    /**
     * 
     */
    @test
    void testValorIpva(50000.00, 4){
    assertEquals(200.00, v.valorIpva());

    }

}
