public class Caminhao extends Veiculo {

	// ATRIBUTOS
	private static final int PERCENTUAL_IPVA = 1;
	private static final int PERCENTUAL_SEGURO = 2;
	private static final double ACRESCIMO_SEGURO = 2000.0;
	private static final int KM_MANUTENCAO = 20000;
	private static final double VALOR_POR_MANUTENCAO = 1000.0;
	private static final int KM_VISTORIA = 30000;
	private static final double VALOR_POR_VISTORIA = 1000.0;

	private double valorVenda;
	private int kmAtual;
	private static int quantCombustivelAtual;
	private int kmManutencao;
	private double valorManutencao;
	private int kmVistoria;
	private double valorVistoria;
	private static int capacidadeTanque = 15000;
	private static Combustivel[] combustiveis = {Combustivel.DIESEL};

	public Caminhao(String placa, double valorVenda, int kmAtual) {
		super(placa, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, kmAtual, capacidadeTanque, quantCombustivelAtual,
				combustivel);
		this.kmManutencao = KM_MANUTENCAO;
		this.valorManutencao = VALOR_POR_MANUTENCAO;
		this.kmVistoria = KM_VISTORIA;
		this.valorVistoria = VALOR_POR_VISTORIA;
		this.tanque = new Tanque(capacidadeTanque, quantCombustivelAtual, combustiveis);

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

		if ((kmAtual - kmAnterior) % kmManutencao == 0) {
			valorManutencao = ((kmAtual - kmAnterior) / KM_MANUTENCAO) * VALOR_POR_MANUTENCAO;
		} else {
			valorManutencao = 0.0;
		}
		if (((kmAtual - kmAnterior) % kmVistoria) == 0) {
			valorVistoria = (((kmAtual - kmAnterior) / KM_VISTORIA) * VALOR_POR_VISTORIA);
		} else {
			valorVistoria = 0.0;
		}
		return (valorManutencao + valorVistoria);
	}

	@Override
	public double custoTotal() {
		return (custoCombustivel() + custoVariavel() + custoFixo());
	}

	@Override
	public double custoFixo() {
		// TODO Auto-generated method stub
		return 0;

	}

	@Override
	public double custoCombustivel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double custoVariavel() {
		// TODO Auto-generated method stub
		return 0;
	}

}