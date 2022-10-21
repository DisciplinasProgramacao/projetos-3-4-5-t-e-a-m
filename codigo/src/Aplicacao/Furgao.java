package Aplicacao;

public class Furgao extends Veiculo {

	
	//ATRIBUTOS
	private static final int CAPACIDADE_TANQUE = 80;
	private int PERCENTUAL_IPVA = 3;
	private int PERCENTUAL_SEGURO = 3;
	private double KM_POR_LITRO;
	private int KM_ALINHAMENTO = 10000;
	private double VALOR_ALINHAMENTO = 120.00;
	private double VALOR_VISTORIA = 500.00;
	private int KM_VISTORIA = 10000;
	
	
	//MÉTODOS
	
	Furgao(String placa, int capacidadeTanque, int percentualIpva, int percentualSeguro, double valorVenda, double acrescimoSeguro, double kmPorLitro, int kmAlinhamento, double valorVistoria, int kmVistoria){
		super(placa, capacidadeTanque, percentualIpva, percentualSeguro, valorVenda, acrescimoSeguro,
				kmPorLitro);
	}
	
	@Override
	public double valorIpva() {
		
		return (getValorVenda()*(100/PERCENTUAL_IPVA));
		
	}
	
	@Override
	public double valorSeguro() {

		return (getValorVenda()*(100/PERCENTUAL_SEGURO));
	}
	
	@Override
	public double autonomia() {
		
		return (KM_POR_LITRO * CAPACIDADE_TANQUE );
	}
	
	@Override
	public double outrosCustos() {
		
		double outrosCustos = 0;
		float kmAndado = 0;
		
		if(kmAndado/KM_ALINHAMENTO == 1) {
			outrosCustos = outrosCustos + VALOR_VISTORIA + VALOR_ALINHAMENTO;
		}
		
		
		return outrosCustos;
		
	}
}