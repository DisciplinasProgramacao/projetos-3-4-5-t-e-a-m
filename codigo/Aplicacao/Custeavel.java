
public interface Custeavel {

    /**
     * 
     * @return Soma de todos os custos do veículo
     */
    public double custoTotal();

    /**
     * 
     * @return Custo do veículo com combustível.
     */
    public double custoCombustivel();

    /**
     * Custo do veículo com alinhamento, manutenção e vistoria.
     */
    public void custoVariavel();

   
    /**
     * Custo do veículo com IPVA e seguro.
     *  
     */
    public double custoFixo();
}
