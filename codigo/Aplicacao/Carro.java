import java.util.Scanner;

public class Carro extends Veiculo {

	// ATRIBUTOS
	private static final int PERCENTUAL_IPVA = 4;
	private static final int PERCENTUAL_SEGURO = 5;
	private static final double ACRESCIMO_SEGURO = 300.0;
	private static final int KM_ALINHAMENTO = 10000;
	private static final double VALOR_POR_ALINHAMENTO = 80.00;
	private static final int CAPACIDADE_TANQUE = 50;

	private double valorVenda;
	private static int kmAtual;
	private static int quantCombustivelAtual;
	private int kmAlinhamento;
	private double valorAlinhamento;
	private static Combustivel[] combustiveis = {Combustivel.GASOLINA, Combustivel.ALCOOL};

	public Carro(String placa, double valorVenda, int kmAtual) {
		super(placa, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, kmAtual, CAPACIDADE_TANQUE, quantCombustivelAtual, custoCombustivel, custoVariavel                                                                                                                                                                                                                                                             );
		this.kmAlinhamento = KM_ALINHAMENTO;
		this.valorAlinhamento = VALOR_POR_ALINHAMENTO;
	}

	@Override
	public double valorIpva() {
		return (valorVenda * PERCENTUAL_IPVA / 100);
	}

	@Override
	public double valorSeguro() {
		return (valorVenda * PERCENTUAL_SEGURO / 100 + ACRESCIMO_SEGURO);
	}

	@Override
	public double outrosCustos() {
		int kmAnterior = 0;

				if ((kmAtual - kmAnterior) % KM_ALINHAMENTO == 0) {
			return ((kmAtual - kmAnterior) / KM_ALINHAMENTO * VALOR_POR_ALINHAMENTO);
		} else {
			return 0.00;
		}
	}

}