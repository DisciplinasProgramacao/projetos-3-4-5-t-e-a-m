public enum Combustivel {

	GASOLINA("GASOLINA", 4.80, 12.00),
	ALCOOL("ALCOOL",3.65,8.00),
	DIESEL("DIESEL",6.65,3.50);

	private String descricao;
	private double consumo;
	private double preco;

	private Combustivel(String descricao, double consumo, double preco) {
		this.descricao = descricao;
		this.consumo = consumo;
		this.preco = preco;
	}

	public double valorAbastecimento(int distancia) {
		
		// como vai saber qual combustível é? Obs. o veículo vai sempre usar o mesmo combustível


			return (preco * distancia);

	}
}
