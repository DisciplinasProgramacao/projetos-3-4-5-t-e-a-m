package Aplicacao;


public class Carro extends Veiculo{
    private static final int CAPACIDADE_TANQUE = 50, PERCENTUAL_IPVA = 4, PERCENTUAL_SEGURO = 5, KM_ALINHAMENTO = 10000;
    private static final double ACRESCIMO_SEGURO = 300.00, VALOR_DO_ALINHAMENTO = 120.00, KM_POR_LITRO = 10;
    private static final String Super = null;
    private static final int KM_ALINHAMENTO_VISTORIA = 0;
    private static final double VALOR_VISTORIA = 0;

    public Carro(String placa,int capacidadeTanque , int CAPACIDADE_TANQUE, int PERCENTUAL_IPVA, int PERCENTUAL_SEGURO, double valorVenda, double ACRESCIMO_SEGURO, double KM_POR_LITRO) {
        super(placa, capacidadeTanque, percentualIpva, percentualSeguro, valorVenda, acrescimoSeguro,
        kmPorLitro);

    }
    @Override
	public double valorIpva() {
        return (getValorVenda() * PERCENTUAL_IPVA / 100);
    }
	@Override
    public double valorSeguro() {
        return (getValorVenda() * PERCENTUAL_SEGURO / 100 );
    }
	@Override
    public double autonomia() {
        return (KM_POR_LITRO * CAPACIDADE_TANQUE);
    }
	@Override
    public double outrosCustos(){
     
        double custoTotal = 0;
        int kmAndado = 0;
        if( kmAndado >= KM_ALINHAMENTO_VISTORIA) {
        	custoTotal = VALOR_DO_ALINHAMENTO + VALOR_VISTORIA;
        }
        	
        return custoTotal;

    }
}