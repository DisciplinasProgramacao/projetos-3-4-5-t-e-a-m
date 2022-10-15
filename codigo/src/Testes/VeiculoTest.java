import Aplicacao.Veiculo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VeiculoTest {

    Veiculo v;

    @BeforeEach
    void setUp() throws Exception {
    v = new Veiculo("ABC0505", 80, 5, 4, 50000.00, 100.00, 10);
    }


    @Test
    void testValorIpva(){
    assertEquals(2500.00, v.valorIpva());

    }

    @Test
    void testValorSeguro(){
    assertEquals(2000.00, v.valorSeguro());
    }


}
