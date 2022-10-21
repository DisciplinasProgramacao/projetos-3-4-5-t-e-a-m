//package Aplicacao;

import java.util.List;

public class Veiculo {

    private List<Rota> rota;
    private String placa;
    private int capacidadeTanque, percentualIpva, percentualSeguro;
    private double valorVenda, acrescimoSeguro, kmPorLitro;

    public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(int capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public int getPercentualIpva() {
		return percentualIpva;
	}

	public void setPercentualIpva(int percentualIpva) {
		this.percentualIpva = percentualIpva;
	}

	public int getPercentualSeguro() {
		return percentualSeguro;
	}

	public void setPercentualSeguro(int percentualSeguro) {
		this.percentualSeguro = percentualSeguro;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public double getAcrescimoSeguro() {
		return acrescimoSeguro;
	}

	public void setAcrescimoSeguro(double acrescimoSeguro) {
		this.acrescimoSeguro = acrescimoSeguro;
	}

	public double getKmPorLitro() {
		return kmPorLitro;
	}

	public void setKmPorLitro(double kmPorLitro) {
		this.kmPorLitro = kmPorLitro;
	}

	public Veiculo(String placa, int capacidadeTanque, int percentualIpva, int percentualSeguro, double valorVenda, double acrescimoSeguro, double kmPorLitro) {
        this.placa = placa;
        this.capacidadeTanque = capacidadeTanque;
        this.percentualIpva = percentualIpva;
        this.percentualSeguro = percentualSeguro;
        this.valorVenda = valorVenda;
        this.acrescimoSeguro = acrescimoSeguro;
        this.kmPorLitro = kmPorLitro;
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

    public double outrosCustos(){
        
        return 0.00;

    }

}