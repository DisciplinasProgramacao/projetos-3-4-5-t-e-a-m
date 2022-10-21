
public class Van extends Veiculo {
	private static final int CAPACIDADE_TANQUE = 60, PERCENTUAL_IPVA = 3, PERCENTUAL_SEGURO = 3, KM_ALINHAMENTO_VISTORIA = 10000;
	private static final double VALOR_DO_ALINHAMENTO = 120.00, VALOR_VISTORIA = 500.00, KM_POR_LITRO = 10;
    int kmAndado = 0;

	public Van(String placa, double valorVenda, double acrescimoSeguro, double kmPorLitro) {
		super(placa, CAPACIDADE_TANQUE, PERCENTUAL_IPVA, PERCENTUAL_SEGURO, valorVenda, acrescimoSeguro, kmPorLitro);
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
        if( kmAndado >= KM_ALINHAMENTO_VISTORIA) {
        	custoTotal = VALOR_DO_ALINHAMENTO + VALOR_VISTORIA;
            kmAndado = 0;
        }
        
        	
        return custoTotal;

    }

}
