//package Main;

//import javax.lang.model.util.ElementScanner14;

public class Caminhao extends Veiculo {

	// ATRIBUTOS
	private static final int CAPACIDADE_TANQUE = 250;
	private static final int PERCENTUAL_IPVA = 1;
	private static final int PERCENTUAL_SEGURO = 2;
	private static final double ACRESCIMO_SEGURO = 2000.0;
	private static final double KM_POR_LITRO = 10;
	private static final int KM_MANUTENCAO = 20000;
	private static final double VALOR_POR_MANUTENCAO = 1000.0;
	private static final int KM_VISTORIA = 30000;
	private static final double VALOR_POR_VISTORIA = 1000.0;

	private double valorVenda;
	private double acrescimoSeguro;
	private int kmManutencao;
	private double valorPorManutencao;
	private int kmVistoria;
	private double valorPorVistoria;
	private int kmAtual;

	private double novoValorVenda;
	private int novoKmAtual;

	public int getKmManutencao() {
		return kmManutencao;
	}

	public double getValorPorManutencao() {
		return valorPorManutencao;
	}

	public void setValorPorManutencao(double valorPorManutencao) {
		this.valorPorManutencao = valorPorManutencao;
	}

	public void setKmManutencao(int kmManutencao) {
		this.kmManutencao = kmManutencao;
	}

	public int getNovoKmAtual() {
		return novoKmAtual;
	}

	public void setNovoKmAtual(int novoKmAtual) {
		this.novoKmAtual = novoKmAtual;
	}

	public double getNovoValorVenda() {
		return novoValorVenda;
	}

	public void setNovoValorVenda(double novoValorVenda) {
		this.novoValorVenda = novoValorVenda;
	}

	public int getKmVistoria() {
		return kmVistoria;
	}

	public void setKmVistoria(int kmVistoria) {
		this.kmVistoria = kmVistoria;
	}

	public double getValorPorVistoria() {
		return valorPorVistoria;
	}

	public void setValorPorVistoria(double valorPorVistoria) {
		this.valorPorVistoria = valorPorVistoria;
	}

	public double getAcrescimoSeguro() {
		return acrescimoSeguro;
	}

	public void setAcrescimoSeguro(double acrescimoSeguro) {
		this.acrescimoSeguro = acrescimoSeguro;
	}

	public Caminhao(String placa, double valorVenda, int kmAtual) {
		super(placa, CAPACIDADE_TANQUE, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, KM_POR_LITRO, kmAtual);
		this.acrescimoSeguro = ACRESCIMO_SEGURO;
		this.kmManutencao = KM_MANUTENCAO;
		this.valorPorManutencao = VALOR_POR_MANUTENCAO;
		this.kmVistoria = KM_VISTORIA;
		this.valorPorVistoria = VALOR_POR_VISTORIA;

		novoValorVenda = valorVenda;
		novoKmAtual = kmAtual;
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
		double valorManutencao;
		double valorVistoria;

		if ((novoKmAtual - kmAnterior) % this.getKmManutencao() == 0) {
			valorManutencao = ((novoKmAtual - kmAnterior) / this.getKmManutencao()) * this.getValorPorManutencao();
		} else {
			valorManutencao = 0.0;
		}
		if (((novoKmAtual - kmAnterior) % this.getKmVistoria()) == 0) {
			valorVistoria = (((novoKmAtual - kmAnterior) / this.getKmVistoria()) * this.getValorPorVistoria());
		} else {
			valorVistoria = 0.0;
		}
		return (valorManutencao + valorVistoria);
	}
}
