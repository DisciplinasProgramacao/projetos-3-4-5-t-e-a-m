//package Main;

//import javax.lang.model.util.ElementScanner14;

public class Caminhao extends Veiculo {

    // ATRIBUTOS
    private static final int CAPACIDADE_TANQUE = 250;
    private static final int PERCENTUAL_IPVA = 1;
    private static final int PERCENTUAL_SEGURO = 2;
    private static final double ACRESCIMO_SEGURO = 2000.00;
    private static final double KM_POR_LITRO = 10;
    private static final int KM_MANUTENCAO = 10000;
    private static final double VALOR_POR_MANUTENCAO = 500.00;
    private static final int KM_VISTORIA = 30000;
    private static final double VALOR_POR_VISTORIA = 1000.00;

    private double valorVenda;
    private double acrescimoSeguro;
    private int kmManutencao;
    private double valorPorManutencao;
    private int kmVistoria;
    private double valorPorVistoria;
    private int kmAtual;

    public Caminhao(String placa, double valorVenda, int kmAtual) {
        super(placa, CAPACIDADE_TANQUE, valorVenda, PERCENTUAL_IPVA, PERCENTUAL_SEGURO,
                KM_POR_LITRO, kmAtual);
        this.acrescimoSeguro = ACRESCIMO_SEGURO;
        this.kmManutencao = KM_MANUTENCAO;
        this.valorPorManutencao = VALOR_POR_MANUTENCAO;
        this.kmVistoria = KM_VISTORIA;
        this.valorPorVistoria = VALOR_POR_VISTORIA;
    }

    @Override
    public double valorIpva() {
        return (valorVenda * PERCENTUAL_IPVA / 100);
    }

    @Override
    public double valorSeguro() {
        return (valorVenda * PERCENTUAL_SEGURO / 100 + acrescimoSeguro);
    }

    @Override
    public double autonomia() {
        return (KM_POR_LITRO * CAPACIDADE_TANQUE);
    }

    @Override
    public double outrosCustos() {
        int kmAnterior = 0;
        double valorManutencao;
        double valorVistoria;

        if ((kmAtual - kmAnterior) % kmManutencao > 1) {
            valorManutencao = ((kmAtual - kmAnterior) % kmManutencao) * valorPorManutencao;
        } else{
            valorManutencao = 0.00;
        }
        if ((kmAtual - kmAnterior) % kmVistoria > 1) {
            valorVistoria = ((kmAtual - kmAnterior) % kmVistoria) * valorPorVistoria;
        } else {
           valorVistoria = 0.00;
        }
            return (valorManutencao + valorVistoria);
        }
}
