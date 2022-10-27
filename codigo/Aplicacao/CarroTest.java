import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;

public class CarroTest {

    Carro c;

    @BeforeEach
    public void setUp() throws Exception {
    c = new Carro("ABC123", 5000.00, 0);
    }

    @Test
    public void testValorIpva(){
    assertEquals(2500.00, c.valorIpva());

    }

    @Test
    public void testValorSeguro(){
    assertEquals(2000.00, c.valorSeguro());
    }
    
}
