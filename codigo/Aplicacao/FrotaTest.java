import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FrotaTest {

	Frota frota;
	Caminhao c;

	@BeforeEach
	void setUp() throws Exception {
		frota = new Frota();
	}

	@Test
	void carregarVeiculo(String nomeArquivo) {
	}

	@Test
	void salvarVeiculo(String nomeArquivo) {
	}

	@Test
	void testAddVeiculo() {
		c = new Caminhao("ABC1234", 5000.00, 0, Carro.combustiveis[0]);
		frota.addVeiculo(c);
		assertEquals(frota.veiculos.get(0).getPlaca(), "ABC1234");
	}

	@Test
	void testAddRota() {
		c = new Caminhao("ABC1234", 5000.00, 0, Carro.combustiveis[0]);
		Rota rota = new Rota(123);
		c.addRota(rota);
		assertEquals(c.getRotas().get(0).getDistanciaTotal(), 123);
	}

	@Test
	void testLocalizaVeiculo() {
		c = new Caminhao("ABC1234", 5000.00, 0, Carro.combustiveis[0]);
		frota.addVeiculo(c);
		Veiculo veic = null;
		try {
			veic = frota.localizaVeiculo("ABC1234");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals(veic, c);
	}

}
