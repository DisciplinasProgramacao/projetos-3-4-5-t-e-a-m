public class Caminhao extends Veiculo {

	// ATRIBUTOS
	private static final int PERCENTUAL_IPVA = 1;
	private static final int PERCENTUAL_SEGURO = 2;
	private static final double ACRESCIMO_SEGURO = 2000.00;
	private static final int KM_MANUTENCAO = 20000;
	private static final double VALOR_POR_MANUTENCAO = 1000.0;
	private static final int KM_VISTORIA = 30000;
	private static final double VALOR_POR_VISTORIA = 1000.0;
	private static final int CAPACIDADE_TANQUE = 250;

	private int kmAtual;
	private static int quantCombustivelAtual;
	private int kmAnterior;
	private int kmManutencao;
	private double valorPorManutencao;
	private int kmVistoria;
	private double valorPorVistoria;
	private static Combustivel[] combustiveis = {Combustivel.DIESEL};

	public Caminhao(String placa, double valorVenda, int kmAtual) {
		super(placa, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, ACRESCIMO_SEGURO, kmAtual, CAPACIDADE_TANQUE, 
		quantCombustivelAtual, combustiveis);
		this.kmManutencao = KM_MANUTENCAO;
		this.valorPorManutencao = VALOR_POR_MANUTENCAO;
		this.kmVistoria = KM_VISTORIA;
		this.valorPorVistoria = VALOR_POR_VISTORIA;
		this.tanque = new Tanque(CAPACIDADE_TANQUE, quantCombustivelAtual, combustiveis);

	}

	@Override
	public void custoVariavel() {
		double valorAlinhamento;
		int numManutencao = ((kmAtual - kmAnterior) / kmManutencao);
		if (numManutencao >= 1) {
			valorAlinhamento = (numManutencao * valorPorManutencao);
			this.addCusto(valorAlinhamento,"Alinhamento");
		} else {
			valorAlinhamento = 0.0;
		}


		double valorVistoria;
		int numVistoria = ((kmAtual - kmAnterior) / kmVistoria);
		if (numVistoria >= 1) {
			valorVistoria = (numVistoria * valorPorVistoria);
			this.addCusto(valorVistoria, "Vistoria");
		} else {
			valorVistoria = 0.0;

			if((numManutencao>=1) || (numVistoria >= 1)){
			kmAnterior += kmAtual;
			}
		}
	}
}