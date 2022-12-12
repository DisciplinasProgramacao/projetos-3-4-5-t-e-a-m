public class Furgao extends Veiculo {

	// ATRIBUTOS
	private static final int PERCENTUAL_IPVA = 3;
	private static final int PERCENTUAL_SEGURO = 3;
	private static final int ACRESCIMO_SEGURO = 0;
	private static final int KM_ALINHAMENTO = 10000;
	private static final double VALOR_POR_ALINHAMENTO = 120.00;
	private static final int KM_VISTORIA = 10000;
	private static final double VALOR_POR_VISTORIA = 500.00;
	private static final int CAPACIDADE_TANQUE = 80;

	private int kmAtual;
	private int kmAnterior;
	private int kmAlinhamento;
	private double valorPorAlinhamento;
	private int kmVistoria;
	private double valorPorVistoria;
	private static int quantCombustivelAtual;
	public static Combustivel[] combustiveis = { Combustivel.GASOLINA };

	
	/**
	 * Construtor do Furgão
	 * 
	 * @param placa Placa do Furgão.
	 * @param valorVenda Valor de venda do Furgão.
	 * @param kmAtual Quilometragem atual do Furgão.
	 * @param atual Tipo de combustível que está no tanque do Furgão.
	 */
	public Furgao(String placa, double valorVenda, int kmAtual, Combustivel atual) {
		super(placa, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, ACRESCIMO_SEGURO, kmAtual,
				CAPACIDADE_TANQUE, quantCombustivelAtual, combustiveis, atual);
		this.kmAlinhamento = KM_ALINHAMENTO;
		this.valorPorAlinhamento = VALOR_POR_ALINHAMENTO;
		this.kmVistoria = KM_VISTORIA;
		this.valorPorVistoria = VALOR_POR_VISTORIA;
		this.tanque = new Tanque(atual, CAPACIDADE_TANQUE);
	}

	/**
	 * 
	 * Adiciona na lista os custos com alinhamento e vistoria
	 * 
	 */
	@Override
	public void custoVariavel() {
		double valorAlinhamento;
		int numAlinhamento = ((kmAtual - kmAnterior) / kmAlinhamento);
		if (numAlinhamento >= 1) {
			valorAlinhamento = (numAlinhamento * valorPorAlinhamento);
			this.addCusto(valorAlinhamento, "Alinhamento");
		}

		double valorVistoria;
		int numVistoria = ((kmAtual - kmAnterior) / kmVistoria);
		if (numVistoria >= 1) {
			valorVistoria = (numVistoria * valorPorVistoria);
			this.addCusto(valorVistoria, "Vistoria");
		}
		if ((numAlinhamento >= 1) || (numVistoria >= 1)) {
			kmAnterior = kmAtual;
		}
	}
	
}