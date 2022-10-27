//package Main;

//import javax.lang.model.util.ElementScanner14;

public class Furgao extends Veiculo {

    // ATRIBUTOS
    private static final int CAPACIDADE_TANQUE = 80;
    private static final int PERCENTUAL_IPVA = 3;
    private static final int PERCENTUAL_SEGURO = 3;
    private static final double KM_POR_LITRO = 10;
    private static final int KM_ALINHAMENTO = 10000;
    private static final double VALOR_POR_ALINHAMENTO = 120.00;
    private static final int KM_VISTORIA = 10000;
    private static final double VALOR_POR_VISTORIA = 500.00;

    private double valorVenda;
    private int kmAlinhamento;
    private double valorPorAlinhamento;
    private int kmVistoria;
    private double valorPorVistoria;
    private int kmAtual;
    
    private double novoValorVenda;
	private int novoKmAtual;
	

	public int getNovoKmAtual() {
		return novoKmAtual;
	}

	public void setNovoKmAtual(int novoKmAtual) {
		this.novoKmAtual = novoKmAtual;
	}

	public double getNovoValorVenda() {
		return novoValorVenda;
	}

	public void setNovoValorVenda(double novoValorVenda) {
		this.novoValorVenda = novoValorVenda;
	}
	
	
	public int getKmAlinhamento() {
		return kmAlinhamento;
	}

	public void setKmAlinhamento(int kmAlinhamento) {
		this.kmAlinhamento = kmAlinhamento;
	}

	public double getValorPorAlinhamento() {
		return valorPorAlinhamento;
	}

	public void setValorPorAlinhamento(double valorPorAlinhamento) {
		this.valorPorAlinhamento = valorPorAlinhamento;
	}

	public int getKmVistoria() {
		return kmVistoria;
	}

	public void setKmVistoria(int kmVistoria) {
		this.kmVistoria = kmVistoria;
	}

	public double getValorPorVistoria() {
		return valorPorVistoria;
	}

	public void setValorPorVistoria(double valorPorVistoria) {
		this.valorPorVistoria = valorPorVistoria;
	}

    public Furgao (String placa, double valorVenda, int kmAtual) {
        super(placa, CAPACIDADE_TANQUE, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO,
                KM_POR_LITRO, kmAtual);
        this.kmAlinhamento = KM_ALINHAMENTO;
        this.valorPorAlinhamento = VALOR_POR_ALINHAMENTO;
        this.kmVistoria = KM_VISTORIA;
        this.valorPorVistoria = VALOR_POR_VISTORIA;
        novoValorVenda = valorVenda;
		novoKmAtual = kmAtual;
    }

    @Override
    public double valorIpva() {
        return (novoValorVenda * PERCENTUAL_IPVA / 100);
    }

    @Override
    public double valorSeguro() {
        return (novoValorVenda * PERCENTUAL_SEGURO / 100);
    }

    @Override
    public double autonomia() {
        return (KM_POR_LITRO * CAPACIDADE_TANQUE);
    }

    @Override
    public double outrosCustos() {
        int kmAnterior = 0;
        double valorAlinhamento;
        double valorVistoria;

        if (((novoKmAtual - kmAnterior) % this.getKmAlinhamento()) == 0) {
			valorAlinhamento = (((novoKmAtual - kmAnterior) / this.getKmAlinhamento()) * this.getValorPorAlinhamento());
			
		} else {
			valorAlinhamento = 0.0;
		}
		if (((novoKmAtual - kmAnterior) % this.getKmVistoria()) == 0) {
			valorVistoria = (((novoKmAtual - kmAnterior) / this.getKmVistoria()) * this.getValorPorVistoria());
		} else {
			valorVistoria = 0.0;
		}
		return (valorAlinhamento + valorVistoria);
        }
}
