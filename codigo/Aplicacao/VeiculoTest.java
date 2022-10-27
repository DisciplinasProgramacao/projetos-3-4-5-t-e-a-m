
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VeiculoTest {

	Veiculo v = new Carro("ABC", 100, 100);

//    @BeforeEach
//    void setUp() throws Exception {
//    v = new Veiculo();
//    };



    @Test
    void testValorIpva(){
    assertEquals(2500.00, v.valorIpva());

    }

    @Test
    void testValorSeguro(){
    assertEquals(2000.00, v.valorSeguro());
    }


}
