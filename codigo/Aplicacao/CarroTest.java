import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarroTest {

	Veiculo c;

	@BeforeEach
	public void setUp() {
		c = new Carro("ABC123", 5000.00, 0, Carro.combustiveis[0]);
	}

	@Test
	void testGetPlaca() {
		assertEquals("ABC123", c.getPlaca(), "Placa");
	}

	@Test
	void testValorIpva() {
		assertEquals(2000.00, c.valorIpva(), "Valor IPVA");
	}

	@Test
	void testValorSeguro() {
		assertEquals(2800.00, c.valorSeguro(), "Valor Seguro");
	}

	@Test
	void custoFixo(){
		assertEquals(4800.00, c.custoFixo(), "Valor do Custo Fixo");
	}

}