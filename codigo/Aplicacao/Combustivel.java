public enum Combustivel {

	GASOLINA("GASOLINA", 12.00, 4.80),
	ALCOOL("ALCOOL", 8.00, 3.65),
	DIESEL("DIESEL", 3.5, 6.65);

	private String descricao;
	private double consumo;
	private double preco;

	/**
	 * Construtor do combustível
	 * 
	 * @param descricao Tipo de combustível
	 * @param consumo Consumo por Km
	 * @param preco Preço por litro
	 */
	private Combustivel(String descricao, double consumo, double preco) {
		this.descricao = descricao;
		this.consumo = consumo;
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getConsumo() {
		return consumo;
	}

	public double getPreco() {
		return preco;
	}

	/**
	 * 
	 * 
	 * @param distancia
	 * @return Valor do combustível para a distância informada.
	 */
	public double valorAbastecimento(int distancia) {
		return (getPreco() * distancia / getConsumo());

	}

}
