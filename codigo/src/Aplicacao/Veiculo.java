package Aplicacao;

import java.util.List;

public class Veiculo {

	private List<Rota> rota;
	private String placa;
	private int capacidadeTanque;
	private double valorVenda;
	private int percentualIpva;
	private int percentualSeguro;
	private double acrescimoSeguro;
	private double kmPorLitro;
	private int kmAlinhamentoManutencao;
	private double valorAlinhamentoManutencao;
	private int kmAnterior;
	private int kmAtual;

	// public String getPlaca() {
	// return placa;
	// }

	// public void setPlaca(String placa) {
	// this.placa = placa;
	// }

	// public int getCapacidadeTanque() {
	// return capacidadeTanque;
	// }

	// public void setCapacidadeTanque(int capacidadeTanque) {
	// this.capacidadeTanque = capacidadeTanque;
	// }

	// public int getPercentualIpva() {
	// return percentualIpva;
	// }

	// public void setPercentualIpva(int percentualIpva) {
	// this.percentualIpva = percentualIpva;
	// }

	// public int getPercentualSeguro() {
	// return percentualSeguro;
	// }

	// public void setPercentualSeguro(int percentualSeguro) {
	// this.percentualSeguro = percentualSeguro;
	// }

	// public double getValorVenda() {
	// return valorVenda;
	// }

	// public void setValorVenda(double valorVenda) {
	// this.valorVenda = valorVenda;
	// }

	// public double getAcrescimoSeguro() {
	// return acrescimoSeguro;
	// }

	// public void setAcrescimoSeguro(double acrescimoSeguro) {
	// this.acrescimoSeguro = acrescimoSeguro;
	// }

	// public double getKmPorLitro() {
	// return kmPorLitro;
	// }

	// public void setKmPorLitro(double kmPorLitro) {
	// this.kmPorLitro = kmPorLitro;
	// }

	public Veiculo(String placa, int capacidadeTanque, double valorVenda, 
	 int percentualIpva,int percentualSeguro, double acrescimoSeguro, 
	 double kmPorLitro, int kmAlinhamentoManutencao, 
	 double valorAlinhamentoManutencao, int kmAtual) {
        this.placa = placa;
        this.capacidadeTanque = capacidadeTanque;
		this.valorVenda = valorVenda;
		this.percentualIpva = percentualIpva;
        this.percentualSeguro = percentualSeguro;
        this.acrescimoSeguro = acrescimoSeguro;
        this.kmPorLitro = kmPorLitro;
		this.kmAlinhamentoManutencao = kmAlinhamentoManutencao;
		this.valorAlinhamentoManutencao = valorAlinhamentoManutencao;
		this.kmAtual;
    }

	public double valorIpva() {
		return (valorVenda * percentualIpva / 100);
	}

	public double valorSeguro() {
		return (valorVenda * percentualSeguro / 100 + acrescimoSeguro);
	}

	public double autonomia() {
		return (kmPorLitro * capacidadeTanque);
	}

	public double outrosCustos() {
		if ((kmAtual - kmAnterior) % kmAlinhamentoManutencao > 1)
			return ((kmAtual - kmAnterior) % kmAlinhamentoManutencao) * valorAlinhamentoManutencao;
		else
			return 0.00;
	}

	public void addRota() {

	}

}