import java.util.Scanner;

public class Carro extends Veiculo {

	// ATRIBUTOS
	private static final int PERCENTUAL_IPVA = 4;;
	private static final int PERCENTUAL_SEGURO = 5;
	private static final double ACRESCIMO_SEGURO = 300.0;
	private static final double KM_POR_LITRO = 10.0;
	private static final int KM_ALINHAMENTO = 10000;
	private static final double VALOR_POR_ALINHAMENTO = 80.00;

	private double valorVenda;
	private static int kmAtual;
	private static int quantCombustivelAtual;
	private int kmAlinhamento;
	private double valorAlinhamento;

	public Carro(String placa, double valorVenda) {
		super(placa, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, KM_POR_LITRO, kmAtual, quantCombustivelAtual);
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

	// @Override
	// public double autonomia() {
	// 	return (KM_POR_LITRO * CAPACIDADE_TANQUE);
	// }

	@Override
	public double outrosCustos() {
		int kmAnterior = 0;

				if ((kmAtual - kmAnterior) % KM_ALINHAMENTO == 0) {
			return ((kmAtual - kmAnterior) / KM_ALINHAMENTO * VALOR_POR_ALINHAMENTO);
		} else {
			return 0.00;
		}
	}

	// @Override
	// public double manutencaoNaoProgramada() {
	// String entrada;
	// double custoNovoGasto=0.0;
	//
	// Scanner ler = new Scanner(System.in);
	//
	// System.out.println("Qual o nome do gasto ? ");
	// entrada= ler.nextLine();
	//
	// System.out.println("Qual o valor de venda do veículo?: ");
	// entrada = ler.nextLine();
	// custoNovoGasto = Double.parseDouble(entrada);
	//
	// return custoNovoGasto;
	// }

}