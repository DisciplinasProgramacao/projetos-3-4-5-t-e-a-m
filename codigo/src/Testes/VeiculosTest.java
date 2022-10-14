

import org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VeiculosTest {

    @BeforeEach
    void setUp() throws Exception {
    Veiculo v = new Veiculo(ABC0505, 50000.00, int percentualIpva, int percentualSeguro, float acrescimoSeguro, float kmPorLitro);
    }

    /**
     * 
     */
    @test
    void testValorIpva(50000.00, 4){
    assertEquals(200.00, v.valorIpva());

    }

}
