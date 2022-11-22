import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CaminhaoTest {

	Veiculo c;

	@BeforeEach
	void setUp() {
		c = new Caminhao("ABC1234", 50000.00, 0);
	}

	@Test
	void testValorIpva() {
		assertEquals(500.0, c.valorIpva(), "valor IPVA ");

	}

	@Test
	void testValorSeguro() {
		assertEquals(3000.00, c.valorSeguro(), "valor Seguro ");
	}

	// @Test
	// void testAutonomia() {
	// 	assertEquals(2500, c.autonomia(), "autonomia do caminhao ");

	// }

	// @Test
	// void testOutrosCustos() {
	// 	c = new Caminhao("1234", 5000.0, 20000);
	// 	assertEquals(1000, c.outrosCustos(), "outros custos: Manutencao ");
	// 	c = new Caminhao("1234", 5000.0, 30000);
	// 	assertEquals(1000, c.outrosCustos(), "outros custos: Vistoria ");
	// 	c = new Caminhao("1234", 5000.0, 40000);
	// 	assertEquals(2000, c.outrosCustos(), "outros custos: Manutencao e Vistoria ");
	// }
}
