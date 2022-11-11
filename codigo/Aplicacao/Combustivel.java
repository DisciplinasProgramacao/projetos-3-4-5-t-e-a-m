
public enum Combustivel {
	GASOLINA("gasolina", 12f, 4.8f),
	ETANOL("etanol", 8f, 3.65f),
	DISEL("disel", 3.5f, 6.65f);

	private final String descricao;
	private final float consumo;
	private final float precoPorAbastecimento;

	private Combustivel(String descricao, float consumo, float precoPorAbastecimento) {
		this.descricao = descricao;
		this.consumo = consumo;
		this.precoPorAbastecimento = precoPorAbastecimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public float getConsumo(){
		return consumo;
	}

	public float getPrecoPorAbastecimento(){
		return precoPorAbastecimento;
	}

}
