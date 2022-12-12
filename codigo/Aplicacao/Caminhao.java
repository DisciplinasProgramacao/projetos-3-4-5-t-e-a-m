public class Caminhao extends Veiculo {

	// ATRIBUTOS
	private static final int PERCENTUAL_IPVA = 1;
	private static final int PERCENTUAL_SEGURO = 2;
	private static final double ACRESCIMO_SEGURO = 2000.00;
	private static final int KM_VISTORIA = 30000;
	private static final double VALOR_POR_VISTORIA = 1000.00;
	private static final int KM_MANUTENCAO = 20000;
	private static final double VALOR_POR_MANUTENCAO = 1000.00;
	private static final int CAPACIDADE_TANQUE = 250;

	private int kmAtual;
	private int kmAnterior;
	private int kmManutencao;
	private double valorPorManutencao;
	private int kmVistoria;
	private double valorPorVistoria;
	private static int quantCombustivelAtual;
	public static Combustivel[] combustiveis = { Combustivel.DIESEL };

	/**
	 * Construtor do caminhão.
	 * 
	 * @param placa      Placa do caminhão.
	 * @param valorVenda Valor de venda do caminhão.
	 * @param kmAtual    Quilometragem atual do caminhão.
	 * @param atual      Tipo de combustível utilizado no momento no caminhão.
	 */
	public Caminhao(String placa, double valorVenda, int kmAtual, Combustivel atual) {
		super(placa, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, ACRESCIMO_SEGURO, kmAtual,
				CAPACIDADE_TANQUE, quantCombustivelAtual, combustiveis, atual);
		this.kmManutencao = KM_MANUTENCAO;
		this.valorPorManutencao = VALOR_POR_MANUTENCAO;
		this.kmVistoria = KM_VISTORIA;
		this.valorPorVistoria = VALOR_POR_VISTORIA;
		this.tanque = new Tanque(atual, CAPACIDADE_TANQUE);
	}

	/**
	 * Calcula o custo com manutencao e vistoria
	 */
	@Override
	public void custoVariavel() {
		double valorManutencao;
		int numManutencao = ((kmAtual - kmAnterior) / kmManutencao);
		if (numManutencao >= 1) {
			valorManutencao = (numManutencao * valorPorManutencao);
			this.addCusto(valorManutencao, "Manutencao");
		}

		double valorVistoria;
		int numVistoria = ((kmAtual - kmAnterior) / kmVistoria);
		if (numVistoria >= 1) {
			valorVistoria = (numVistoria * valorPorVistoria);
			this.addCusto(valorVistoria, "Vistoria");
		}

		if ((numManutencao >= 1) || (numVistoria >= 1)) {
			kmAnterior = kmAtual;
		}
	}
}