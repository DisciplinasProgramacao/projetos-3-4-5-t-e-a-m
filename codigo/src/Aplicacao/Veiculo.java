package Aplicacao;

public class Veiculo {

    private List<Rota>;
    private String placa;
    private int capacidadeTanque, percentualIpva, percentualSeguro;
    private double valorVenda, acrescimoSeguro, kmPorLitro;

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