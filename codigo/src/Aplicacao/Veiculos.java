package Aplicacao;

public class Veiculos {

    private String placa;
    private final int capacidadeTanque, percentualIpva, percentualSeguro,
    private final float valorVenda, acrescimoSeguro, kmPorLitro;

    public Veiculo (int placa, float valorVenda, int percentualIpva, int percentualSeguro, float acrescimoSeguro, float kmPorLitro){
        this.placa = placa;
        this.valorVenda = valorVenda;
        this.percentualIpva = percentualIpva;
        this.percentualSeguro = percentualSeguro;
        this.acrescimoSeguro = acrescimoSeguro;
        this.kmPorLitro = kmPorLitro;
    }

    public float valorIpva(float valorVenda, int percentualIpva){
        return (valorVenda * percentualIpva/100); 
    }

    public float valorSeguro (float valorVenda, int percentualSeguro, float acrescimoSeguro){
        return (valorVenda * percentualSeguro/100 + acrescimoSeguro);
    }

    public float autonomia (float kmPorLitro, int capacidadeTanque){
        return (kmPorLitro * capacidadeTanque);
    }

    public outrosCustos(){
        
    }

}
