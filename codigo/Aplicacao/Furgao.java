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
	private static int quantCombustivelAtual;
	private int kmAlinhamento;
	private int kmAnterior;
	private double valorPorAlinhamento;
	private int kmVistoria;
	private double valorPorVistoria;
	private static Combustivel[] combustiveis = {Combustivel.GASOLINA};

	public Furgao(String placa, double valorVenda, int kmAtual) {
		super(placa, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, ACRESCIMO_SEGURO, kmAtual, CAPACIDADE_TANQUE, 
		quantCombustivelAtual, combustiveis);
		this.kmAlinhamento = KM_ALINHAMENTO;
		this.valorPorAlinhamento = VALOR_POR_ALINHAMENTO;
		this.kmVistoria = KM_VISTORIA;
		this.valorPorVistoria = VALOR_POR_VISTORIA;
	}

	@Override
	public void custoVariavel() {
		double valorAlinhamento;
		int numAlinhamento = ((kmAtual - kmAnterior) / kmAlinhamento);
		if (numAlinhamento >= 1) {
			valorAlinhamento = (numAlinhamento * valorPorAlinhamento);
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

			if((numAlinhamento>=1) || (numVistoria >= 1)){
			kmAnterior += kmAtual;
			}
		}
		//add alinhamento e vistoria custos
	}
}