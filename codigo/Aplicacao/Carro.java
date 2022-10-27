//package Main;

public class Carro extends Veiculo {

	// ATRIBUTOS
	private static final int CAPACIDADE_TANQUE = 50;
	private static final int PERCENTUAL_IPVA = 4;;
	private static final int PERCENTUAL_SEGURO = 5;
	private static final double ACRESCIMO_SEGURO = 300.0;
	private static final double KM_POR_LITRO = 10.0;
	private static final int KM_ALINHAMENTO = 10000;
	private static final double VALOR_POR_ALINHAMENTO = 80.00;

	private double valorVenda;
	private double acrescimoSeguro;
	private int kmAlinhamento;
	private double valorPorAlinhamento;
	private int kmAtual;

	private int novoKmAtual;
	private double novoValorVenda;
	
	public int getNovoKmAtual() {
		return novoKmAtual;
	}

	public void setNovoKmAtual(int novoKmAtual) {
		this.novoKmAtual = novoKmAtual;
	}

	public int getKmAlinhamento() {
		return kmAlinhamento;
	}

	public void setKmAlinhamento(int kmAlinhamento) {
		this.kmAlinhamento = kmAlinhamento;
	}

	public double getValorPorAlinhamento() {
		return valorPorAlinhamento;
	}

	public void setValorPorAlinhamento(double valorPorAlinhamento) {
		this.valorPorAlinhamento = valorPorAlinhamento;
	}
	public Carro(String placa, double valorVenda, int kmAtual) {
		super(placa, CAPACIDADE_TANQUE, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, KM_POR_LITRO, kmAtual);
		this.acrescimoSeguro = ACRESCIMO_SEGURO;
		this.kmAlinhamento = KM_ALINHAMENTO;
		this.valorPorAlinhamento = VALOR_POR_ALINHAMENTO;
		novoKmAtual=kmAtual;
		novoValorVenda = valorVenda;
	}


	@Override
	public double valorIpva() {
		return (novoValorVenda * PERCENTUAL_IPVA / 100);
	}

	@Override
	public double valorSeguro() {
		return (novoValorVenda * PERCENTUAL_SEGURO / 100 + acrescimoSeguro);
	}

	@Override
	public double autonomia() {
		return (KM_POR_LITRO * CAPACIDADE_TANQUE);
	}

	@Override
	public double outrosCustos() {
		int kmAnterior = 0;
		if ((novoKmAtual - kmAnterior) % this.getKmAlinhamento() == 0) {
			return ((novoKmAtual - kmAnterior) / this.getKmAlinhamento()) * this.getValorPorAlinhamento();
		} else {
			return 0.00;
		}
	}

	
}