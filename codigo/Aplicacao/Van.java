public class Van extends Veiculo {

	// ATRIBUTOS
	private static final int PERCENTUAL_IPVA = 3;
	private static final int PERCENTUAL_SEGURO = 3;
	private static final double ACRESCIMO_SEGURO = 0.00;
	private static final int KM_ALINHAMENTO = 10000;
	private static final double VALOR_POR_ALINHAMENTO = 120.00;
	private static final int KM_VISTORIA = 10000;
	private static final double VALOR_POR_VISTORIA = 500.00;
	private static final int CAPACIDADE_TANQUE = 60;

	private double valorVenda;
	private int kmAtual;
	private static int quantCombustivelAtual;
	private int kmAlinhamento;
	private double valorAlinhamento;
	private double kmAnterior;
	private int kmVistoria;
	private double valorVistoria;
	private static Combustivel[] combustiveis = {Combustivel.DIESEL};

	public Van(String placa, double valorVenda, int kmAtual) {
		super(placa, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, ACRESCIMO_SEGURO, kmAtual, 
		CAPACIDADE_TANQUE, quantCombustivelAtual, combustiveis);
		this.kmAlinhamento = KM_ALINHAMENTO;
		this.valorAlinhamento = VALOR_POR_ALINHAMENTO;
		this.kmVistoria = KM_VISTORIA;
		this.valorVistoria = VALOR_POR_VISTORIA;
	}

	@Override
	public void custoVariavel() {

		if (((kmAtual - kmAnterior) / KM_ALINHAMENTO) >= 1) {
			valorAlinhamento = (((kmAtual - kmAnterior) / KM_ALINHAMENTO) * VALOR_POR_ALINHAMENTO);
			valorVistoria = (((kmAtual - kmAnterior) / KM_VISTORIA) * VALOR_POR_VISTORIA);
			kmAnterior += kmAtual;
			this.addCusto(valorAlinhamento, "Alinhamento");
			this.addCusto(valorVistoria, "Vistoria");
		} else {
			valorAlinhamento = 0.0;
			valorVistoria = 0.0;
		}
		//add alinhamenot e vistoria lista custos
	}

}
