import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarroTest {

  //  Veiculo c;

   // @BeforeEach 
   // public void setUp() {
   // c = new Carro("ABC123", 50000.0, 10000);
   // }

    @Test
	void testValorIpva() {
		Carro c = new Carro("ABC123", 50000.0, 10000);
		assertEquals(2000.00, c.valorIpva(), "valor IPVA ");
	}

	@Test
	void testValorSeguro() {
		Veiculo c = new Carro("ABC123", 50000.0, 10000);
		assertEquals(2800.0, c.valorSeguro(), "valor Seguro ");
	}

	@Test
	void testAutonomia() {
		assertEquals(500, c.autonomia(), "autonomia do carro ");
	}

	@Test
	void testCustoVariavel() {
		Carro c = new Carro("ABC123", 50000.0, 20000);
		assertEquals(80, c.custoVariavel(), "outros custos: Alinhamento ");
		// c = new Carro("ABC123", 5000.0, 20000);
		// assertEquals(160, c.custoVariavel(), "outros custos: Alinhamento ");
	}
    
}
