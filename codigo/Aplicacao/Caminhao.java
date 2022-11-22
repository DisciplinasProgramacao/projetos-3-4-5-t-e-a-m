public class Caminhao extends Veiculo {

	// ATRIBUTOS
	private static final int PERCENTUAL_IPVA = 1;
	private static final int PERCENTUAL_SEGURO = 2;
	private static final double ACRESCIMO_SEGURO = 2000.0;
	private static final int KM_MANUTENCAO = 20000;
	private static final double VALOR_POR_MANUTENCAO = 1000.0;
	private static final int KM_VISTORIA = 30000;
	private static final double VALOR_POR_VISTORIA = 1000.0;
	private static final int CAPACIDADE_TANQUE = 250;

	private double valorVenda;
	private int kmAtual;
	private static int quantCombustivelAtual;
	private double kmAnteriorManutencao;
	private double kmAnteriorVistoria;
	private int kmManutencao;
	private double valorManutencao;
	private int kmVistoria;
	private double valorVistoria;
	private static Combustivel[] combustiveis = {Combustivel.DIESEL};

	public Caminhao(String placa, double valorVenda, int kmAtual) {
		super(placa, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, kmAtual, CAPACIDADE_TANQUE, 
		quantCombustivelAtual, custoCombustivel, custoVariavel,	combustiveis);
		this.kmManutencao = KM_MANUTENCAO;
		this.valorManutencao = VALOR_POR_MANUTENCAO;
		this.kmVistoria = KM_VISTORIA;
		this.valorVistoria = VALOR_POR_VISTORIA;
		this.tanque = new Tanque(CAPACIDADE_TANQUE, quantCombustivelAtual, combustiveis);

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
	public void custoVariavel() {

		if ((kmAtual - kmAnteriorManutencao) / KM_MANUTENCAO >= 1) {
			valorManutencao = ((kmAtual - kmAnteriorManutencao) / KM_MANUTENCAO * VALOR_POR_MANUTENCAO);
			kmAnteriorManutencao += kmAtual;
			this.addCusto(valorManutencao, "Manutenção");
		} else {
			valorManutencao = 0.0;
		}

		if (((kmAtual - kmAnteriorVistoria) / KM_VISTORIA) >= 1) {
			valorVistoria = (((kmAtual - kmAnteriorVistoria) / KM_VISTORIA) * VALOR_POR_VISTORIA);
			kmAnteriorVistoria += kmAtual;
			this.addCusto(valorVistoria, "Vistoria");
		} else {
			valorVistoria = 0.0;
		}
	}
}