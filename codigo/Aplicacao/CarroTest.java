import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarroTest {

    Carro c;

    @BeforeEach
    public void setUp() {
    c = new Carro("ABC123", 5000.0, 10000);
    }

    @Test
	void testValorIpva() {
		assertEquals(200.0, c.valorIpva(), "valor IPVA ");

	}

	@Test
	void testValorSeguro() {
		assertEquals(550.0, c.valorSeguro(), "valor Seguro ");
	}

	@Test
	void testAutonomia() {
		assertEquals(500, c.autonomia(), "autonomia do carro ");

	}

	@Test
	void testOutrosCustos() {
		assertEquals(80, c.outrosCustos(), "outros custos: Alinhamento ");
		c = new Carro("ABC123", 5000.0, 20000);
		assertEquals(160, c.outrosCustos(), "outros custos: Alinhamento ");
	}
    
}
