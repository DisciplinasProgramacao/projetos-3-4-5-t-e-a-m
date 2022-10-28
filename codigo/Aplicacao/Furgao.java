public class Furgao extends Veiculo {

	// ATRIBUTOS
	private static final int CAPACIDADE_TANQUE = 80;
	private static final int PERCENTUAL_IPVA = 3;
	private static final int PERCENTUAL_SEGURO = 3;
	private static final double KM_POR_LITRO = 10;
	private static final int KM_ALINHAMENTO = 10000;
	private static final double VALOR_POR_ALINHAMENTO = 120.00;
	private static final int KM_VISTORIA = 10000;
	private static final double VALOR_POR_VISTORIA = 500.00;

	private double valorVenda;
	private int kmAlinhamento;
	private double valorPorAlinhamento;
	private int kmVistoria;
	private double valorPorVistoria;
	private int kmAtual;

	public Furgao(String placa, double valorVenda, int kmAtual) {
		super(placa, CAPACIDADE_TANQUE, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO,
				KM_POR_LITRO, kmAtual);
		this.kmAlinhamento = KM_ALINHAMENTO;
		this.valorPorAlinhamento = VALOR_POR_ALINHAMENTO;
		this.kmVistoria = KM_VISTORIA;
		this.valorPorVistoria = VALOR_POR_VISTORIA;
		this.valorVenda = valorVenda;
		this.kmAtual = kmAtual;
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
	public double autonomia() {
		return (KM_POR_LITRO * CAPACIDADE_TANQUE);
	}

	@Override
    public double outrosCustos() {
        int kmAnterior = 0;
        double valorAlinhamento;
        double valorVistoria;

        if (((kmAtual - kmAnterior) % kmAlinhamento) == 0) {
			valorAlinhamento = (((kmAtual - kmAnterior) / kmAlinhamento) * valorPorAlinhamento);
			
		} else {
			valorAlinhamento = 0.0;
		}
		if (((kmAtual - kmAnterior) % kmVistoria) == 0) {
			valorVistoria = (((kmAtual - kmAnterior) / kmVistoria) * valorPorVistoria);
		} else {
			valorVistoria = 0.0;
		}
		return (valorAlinhamento + valorVistoria);
        }
}