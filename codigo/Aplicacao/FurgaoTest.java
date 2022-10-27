import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FurgaoTest {

	Furgao f;

	@BeforeEach
	void setUp() {
		f = new Furgao("1234", 5000.0, 10000);
	}

	@Test
	void testValorIpva() {
		assertEquals(150.0, f.valorIpva(), "valor IPVA ");

	}

	@Test
	void testValorSeguro() {
		assertEquals(150.00, f.valorSeguro(), "valor Seguro ");
	}

	@Test
	void testAutonomia() {
		assertEquals(800, f.autonomia(), "autonomia do furgao ");
	}

	@Test
	void testOutrosCustos() {
		assertEquals(620, f.outrosCustos(), "outros custos: Alinhamento e Vistoria ");
	}

}
