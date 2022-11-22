public class Furgao extends Veiculo {

	// ATRIBUTOS
	private static final int PERCENTUAL_IPVA = 3;
	private static final int PERCENTUAL_SEGURO = 3;
	private static final int KM_ALINHAMENTO = 10000;
	private static final double VALOR_POR_ALINHAMENTO = 120.00;
	private static final int KM_VISTORIA = 10000;
	private static final double VALOR_POR_VISTORIA = 500.00;
	private static final int CAPACIDADE_TANQUE = 80;


	private double valorVenda;
	private int kmAtual;
	private static int quantCombustivelAtual;
	private int kmAlinhamento;
	private int kmAnterior;
	private double valorAlinhamento;
	private int kmVistoria;
	private int kmAnteriorVistoria;
	private double valorVistoria;
	private static Combustivel[] combustiveis = {Combustivel.GASOLINA};

	public Furgao(String placa, double valorVenda, int kmAtual) {
		super(placa, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, kmAtual, CAPACIDADE_TANQUE, 
		quantCombustivelAtual, custoCombustivel, custoVariavel, combustiveis);
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

	@Override
	public void custoVariavel() {
		if ((kmAtual - kmAnterior) / KM_ALINHAMENTO >= 1) {
			valorAlinhamento = ((kmAtual - kmAnterior) / KM_ALINHAMENTO * VALOR_POR_ALINHAMENTO);
			kmAnterior += kmAtual;
			this.addCusto(valorAlinhamento,"Alinhamento");
		} else {
			valorAlinhamento = 0.0;
		}

		if (((kmAtual - kmAnteriorVistoria) / KM_VISTORIA) >= 1) {
			valorVistoria = (((kmAtual - kmAnteriorVistoria) / KM_VISTORIA) * VALOR_POR_VISTORIA);
			kmAnteriorVistoria += kmAtual;
			this.addCusto(valorVistoria, "Vistoria");
		} else {
			valorVistoria = 0.0;
		}
		//add alinhamento e vistoria custos
	}
}