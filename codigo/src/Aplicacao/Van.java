
public class Van extends Veiculo {
	private static final int CAPACIDADE_TANQUE = 60, PERCENTUAL_IPVA = 3, PERCENTUAL_SEGURO = 3, KM_ALINHAMENTO_VISTORIA = 10000;
	private static final double VALOR_DO_ALINHAMENTO = 120.00, VALOR_VISTORIA = 500.00, KM_POR_LITRO = 10;
    int kmAndado = 0;

	Van(String placa, int capacidadeTanque, int percentualIpva, int percentualSeguro, double valorVenda,
			double acrescimoSeguro, double kmPorLitro, int CAPACIDADE_TANQUE, int PERCENTUAL_IPVA,
			int PERCENTUAL_SEGURO, int KM_ALINHAMENTO, int KM_VISTORIA, double VALOR_DO_ALINHAMENTO,
			double VALOR_VISTORIA, double KM_POR_LITRO) {
		super(placa, capacidadeTanque, capacidadeTanque, capacidadeTanque, acrescimoSeguro, acrescimoSeguro,
				acrescimoSeguro);
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
