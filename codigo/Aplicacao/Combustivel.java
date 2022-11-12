
public enum Combustivel {

	GASOLINA("GASOLINA",4.8d,12d),
    ALCOOL("ALCOOL",3.65d,8d),
    DIESEL("DIESEL",6.65d,3.5d);


	private String descricao;
	private double consumo;
	private double preco;


	private Combustivel(String descricao, double consumo, double preco) {
		this.descricao = descricao;
		this.consumo = consumo;
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public volume abastecido(){
		
	}



}
