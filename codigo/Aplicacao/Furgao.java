public class Furgao extends Veiculo {

	// ATRIBUTOS
	private static final int PERCENTUAL_IPVA = 3;
	private static final int PERCENTUAL_SEGURO = 3;
	//private static final double KM_POR_LITRO = 10;
	private static final int KM_ALINHAMENTO = 10000;
	private static final double VALOR_POR_ALINHAMENTO = 120.00;
	private static final int KM_VISTORIA = 10000;
	private static final double VALOR_POR_VISTORIA = 500.00;

	private double valorVenda;
	private int kmAtual;
	private static int quantCombustivelAtual;
	private int kmAlinhamento;
	private double valorAlinhamento;
	private int kmVistoria;
	private double valorVistoria;
	private static int capacidadeTanque = 7000;
	private static Combustivel[] combustiveis = {Combustivel.GASOLINA, Combustivel.ALCOOL};

	public Furgao(String placa, double valorVenda, int kmAtual) {
		//super(placa, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, KM_POR_LITRO, kmAtual, quantCombustivelAtual);
		super(placa, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, kmAtual, capacidadeTanque, quantCombustivelAtual, combustiveis);
		this.kmAlinhamento = KM_ALINHAMENTO;
		this.valorAlinhamento = VALOR_POR_ALINHAMENTO;
		this.kmVistoria = KM_VISTORIA;
		this.valorVistoria = VALOR_POR_VISTORIA;
	}

	@Override
	public double valorIpva() {
		return (valorVenda * PERCENTUAL_IPVA / 100);
	}

	@Override
	public double valorSeguro() {
		return (valorVenda * PERCENTUAL_SEGURO / 100);
	}

	// @Override
	// public double autonomia() {
	// 	return (KM_POR_LITRO * CAPACIDADE_TANQUE);
	// }

	@Override
	public double outrosCustos() {
		int kmAnterior = 0;

		if (((kmAtual - kmAnterior) % KM_ALINHAMENTO) == 0) {
			valorAlinhamento = (((kmAtual - kmAnterior) / KM_ALINHAMENTO) * VALOR_POR_ALINHAMENTO);

		} else {
			valorAlinhamento = 0.0;
		}
		if (((kmAtual - kmAnterior) % KM_VISTORIA) == 0) {
			valorVistoria = (((kmAtual - kmAnterior) / KM_VISTORIA) * VALOR_POR_VISTORIA);
		} else {
			valorVistoria = 0.0;
		}
		return (valorAlinhamento + valorVistoria);
	}
}