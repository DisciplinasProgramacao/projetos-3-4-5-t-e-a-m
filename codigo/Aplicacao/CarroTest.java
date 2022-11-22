import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarroTest {

	Veiculo c;

	@BeforeEach
	public void setUp() {
		c = new Carro("ABC123", 50000.00, 0);
	}

	@Test
	void testValorIpva() {
		assertEquals(2000.00, c.valorIpva(), "valor IPVA ");
	}

	@Test
	void testValorSeguro() {
		assertEquals(2800.00, c.valorSeguro(), "valor Seguro ");
	}
}