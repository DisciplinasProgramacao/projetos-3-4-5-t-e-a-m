package Aplicacao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Veiculo {

	private List<Rota> listaDeRotas = new ArrayList<Rota>();
	private String placa;
	private int capacidadeTanque;
	private double valorVenda;
	private int percentualIpva;
	private int percentualSeguro;
	// private double acrescimoSeguro;
	private double kmPorLitro;
	// private int kmAlinhamentoManutencao;
	// private double valorPorAlinhamentoManutencao;
	// private int kmVistoria;
	// private double valorPorVistoria;
	// private int kmAnterior;
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
			int percentualIpva, int percentualSeguro, double kmPorLitro, int kmAtual) {
		this.placa = placa;
		this.capacidadeTanque = capacidadeTanque;
		this.valorVenda = valorVenda;
		this.percentualIpva = percentualIpva;
		this.percentualSeguro = percentualSeguro;
		// this.acrescimoSeguro = acrescimoSeguro;
		this.kmPorLitro = kmPorLitro;
		// this.kmAlinhamentoManutencao = kmAlinhamentoManutencao;
		// this.valorPorAlinhamentoManutencao = valorPorAlinhamentoManutencao;
		// this.kmVistoria;
		// this.valorPorVistoria;
		this.kmAtual = kmAtual;
	}

	public double valorIpva() {
		return (valorVenda * percentualIpva / 100);
	}

	public abstract double valorSeguro();
	// {
	// return (valorVenda * percentualSeguro / 100 + acrescimoSeguro);
	// }

	public double autonomia() {
		return (kmPorLitro * capacidadeTanque);
	}

	public abstract double outrosCustos();
	// {
	// double resultadoAlinhamentoManutenção = 0, resultadoVistoria = 0;
	// if ((kmAtual - kmAnterior) % kmAlinhamentoManutencao > 1) {
	// resultadoAlinhamentoManutenção = ((kmAtual - kmAnterior) %
	// kmAlinhamentoManutencao)
	// * valorPorAlinhamentoManutencao;
	// } else {
	// resultadoAlinhamentoManutenção = 0.00;
	// }
	// if ((kmAtual - kmAnterior) % kmVistoria > 1) {
	// resultadoVistoria = ((kmAtual - kmAnterior) % kmVistoria) * valorPorVistoria;
	// } else {
	// resultadoVistoria = 0.00;
	// }
	// return 0.00;
	// }

	public void addRota(double distanciaTotal, LocalDate data) {
		Rota rota = new Rota(distanciaTotal, data);
		listaDeRotas.add(rota);
	}

}