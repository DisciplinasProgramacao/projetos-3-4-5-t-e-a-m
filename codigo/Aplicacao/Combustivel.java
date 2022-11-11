
public enum Combustivel {
	TANQUE_CARRO("50"), TANQUE_VAN("60"), TANQUE_FURGAO("80"), TANQUE_CAMINHAO("250"), CONSUMO_GASOLINA("12"),
	CONSUMO_ETANOL("8"), CONSUMO_DIESEL("3.5"), PRECO_GASOLINA("4.80"), PRECO_ETANOL("3.65"), PRECO_DIESEL("6.65"),;

	private String descricao;

	Combustivel(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
