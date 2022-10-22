package Aplicacao;

public class Carro extends Veiculo{

    //ATRIBUTOS
    private static final int CAPACIDADE_TANQUE = 50;
    private static final int PERCENTUAL_IPVA = 4;;
    private static final int PERCENTUAL_SEGURO = 5;
    private static final double ACRESCIMO_SEGURO = 300.00;
    private static final double KM_POR_LITRO = 10.00;
    private static final int KM_ALINHAMENTO = 10000;
    private static final double VALOR_ALINHAMENTO = 80.00;

    private int placa;
    private double valorVenda;
    private int kmAnterior;
    private int kmAtual;

    public Carro(String placa, double valorVenda, int kmAtual) {
        super(placa, CAPACIDADE_TANQUE, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, 
         ACRESCIMO_SEGURO, KM_POR_LITRO, KM_ALINHAMENTO, VALOR_ALINHAMENTO, kmAtual);
    }

    @Override
	public double valorIpva() {
        return (valorVenda * PERCENTUAL_IPVA / 100);
    }
	@Override
    public double valorSeguro() {
        return (valorVenda * PERCENTUAL_SEGURO / 100 );
    }
	@Override
    public double autonomia() {
        return (KM_POR_LITRO * CAPACIDADE_TANQUE);
    }
	@Override
    public double outrosCustos(){    
        if((kmAtual - kmAnterior) % KM_ALINHAMENTO > 1) {
        return ((kmAtual - kmAnterior) % KM_ALINHAMENTO) * VALOR_ALINHAMENTO;
        }
        else{
        return 0.00;
        }    
    }
}