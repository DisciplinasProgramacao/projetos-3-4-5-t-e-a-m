package Aplicacao;

public class Veiculos {

    private int placa;
    private int capacidadeTanque, percentualIpva, percentualSeguro,
    private float valorVenda, acrescimoSeguro, kmPorLitro;

    public Veiculos(int placa, float valorVenda, int percentualIpva, int percentualSeguro, float acrescimoSeguro, float kmPorLitro) {
        this.placa = placa;
        this.valorVenda = valorVenda;
        this.percentualIpva = percentualIpva;
        this.percentualSeguro = percentualSeguro;
        this.acrescimoSeguro = acrescimoSeguro;
        this.kmPorLitro = kmPorLitro;
    }

    public float valorIpva(float valorVenda, int percentualIpva) {
        return (valorVenda * percentualIpva / 100);
    }

    public float valorSeguro(float valorVenda, int percentualSeguro, float acrescimoSeguro) {
        return (valorVenda * percentualSeguro / 100 + acrescimoSeguro);
    }

    public float autonomia(float kmPorLitro, int capacidadeTanque) {
        return (kmPorLitro * capacidadeTanque);
    }

    // public outrosCustos(){

    // }

}
