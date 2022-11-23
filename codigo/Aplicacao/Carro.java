import java.util.Scanner;

public class Carro extends Veiculo {

	// ATRIBUTOS
	private static final int PERCENTUAL_IPVA = 4;
	private static final int PERCENTUAL_SEGURO = 5;
	private static final double ACRESCIMO_SEGURO = 300.00;
	private static final int KM_ALINHAMENTO = 10000;
	private static final double VALOR_POR_ALINHAMENTO = 80.00;
	private static final int CAPACIDADE_TANQUE = 50;

	private int kmAtual;
	private int kmAnterior;
	private int kmAlinhamento;
	private double valorPorAlinhamento;
	private static int quantCombustivelAtual;
	private static Combustivel[] combustiveis = { Combustivel.GASOLINA, Combustivel.ALCOOL };

	public Carro(String placa, double valorVenda, int kmAtual) {
		super(placa, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, ACRESCIMO_SEGURO, kmAtual,
				CAPACIDADE_TANQUE, quantCombustivelAtual, combustiveis);
		this.kmAlinhamento = KM_ALINHAMENTO;
		this.valorPorAlinhamento = VALOR_POR_ALINHAMENTO;
		this.tanque = new Tanque(CAPACIDADE_TANQUE, quantCombustivelAtual, combustiveis);
	}

	@Override
	public void custoVariavel() {
		double valorAlinhamento;
		int numAlinhamento = ((kmAtual - kmAnterior) / kmAlinhamento);
		if (numAlinhamento >= 1) {
			valorAlinhamento = (numAlinhamento * valorPorAlinhamento);
			kmAnterior = kmAtual;
			this.addCusto(valorAlinhamento, "Alinhamento");
		} else {
			valorAlinhamento = 0.0;
		}
	}

}