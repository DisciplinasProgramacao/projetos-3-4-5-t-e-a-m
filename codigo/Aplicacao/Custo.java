import java.io.Serializable;

public class Custo implements Serializable{

    private double valor;
    private String descricao;

    /**
     * Construtor do custo
     * 
     * @param valor Valor do custo
     * @param descricao Descrição (tipo) do custo
     */
    public Custo(double valor, String descricao) {
        this.valor = valor;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

}
