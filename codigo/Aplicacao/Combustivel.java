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
	 * @param consumo
	 * @param preco
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

	public double valorAbastecimento(int distancia) {
		return (getPreco() * distancia / getConsumo());

	}

}
