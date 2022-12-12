
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

public abstract class Veiculo implements Serializable, Custeavel, Sujeito {

	private LinkedList<Rota> rotas = new LinkedList<Rota>();
	private LinkedList<Custo> custos = new LinkedList<Custo>();

	private String placa;
	private double valorVenda;
	private int percentualIpva;
	private int percentualSeguro;
	private double acrescimoSeguro;
	private int kmAtual;
	public Tanque tanque;
	public LocalDate date = java.time.LocalDate.now();

	/**
	 * Construtor do Veículo
	 * 
	 * @param placa                 placa do veículo
	 * @param valorVenda            valor de venda do veículo
	 * @param percentualIpva        precentual utilizado para cálculo do IPVA
	 *                              (incide sobre valor do veículo)
	 * @param percentualSeguro      precentual utilizado para cálculo do Seguro
	 *                              (incide sobre valor do veículo)
	 * @param acrescimoSeguro       valor que deve ser acrescido para o cálculo do
	 *                              seguro
	 * @param kmAtual               quilometragem atual do veículo
	 * @param capacidadeTanque      quantidade de combustível que cabe no tanque
	 * @param quantCombustivelAtual quantidade de combustível atual no tanque
	 * @param combustiveis          tipos de combustíveis que podem ser utilizados
	 * @param atual                 combustível atual utilizado
	 */
	public Veiculo(String placa, double valorVenda, int percentualIpva, int percentualSeguro,
			double acrescimoSeguro, int kmAtual, int capacidadeTanque,
			float quantCombustivelAtual, Combustivel[] combustiveis, Combustivel atual) {
		this.placa = placa;
		this.valorVenda = valorVenda;
		this.percentualIpva = percentualIpva;
		this.percentualSeguro = percentualSeguro;
		this.acrescimoSeguro = acrescimoSeguro;
		this.kmAtual = kmAtual;
		
		//verificar o atual com os possíveis
		this.tanque = new Tanque(atual, capacidadeTanque);  

	//	(capacidadeTanque, quantCombustivelAtual, combustiveis);
		this.addCusto(valorIpva(), "IPVA 2022");
		this.addCusto(valorSeguro(), "Seguro");
	}

	@Override
	public void assinar(Object obj){
		observers.addLast(obj);
	}

	@Override
	public void desistir(){
		
	}

	@Override
	public void notificar(){
		observers.forEach(observer -> ((Frota) observer).atualizar());
	}

	/**
	 * 
	 * @return Retorna a placa do veículo.
	 */
	public String getPlaca() {
		return this.placa;
	}

	/**
	 * Cálculo do valor do IPVA
	 * 
	 * @return Valor do IPVA.
	 */
	public double valorIpva() {
		return (valorVenda * percentualIpva / 100);
	}

	/**
	 * Cálculo do valor do Seguro
	 * 
	 * @return Valor do Seguro.
	 */
	public double valorSeguro() {
		return (valorVenda * percentualSeguro / 100 + acrescimoSeguro);
	}

	
	/**
	 * Cálculo do custo fixo (IPVA + Seguro)
	 * 
	 * @return Valor do IPVA acrescido do valor do seguro.
	 */
	@Override
	public double custoFixo() { // add todos os custos fixos
		return (valorIpva() + valorSeguro());
	}

	/**
	 * Calcula o valor gasto com combustível pelo veículo. Os gastos com combustível são incluídos em uma lista a cada abastecimento
	 * e o código abaixo percorre a lista somando os custos com combustível incluídos na lista.
	 * 
	 * 
	 * @return Valor gasto com combustível
	 */
	@Override
	public double custoCombustivel() {
		double custoCombustivel = 0.00;
		for (int i = 0; i < custos.size(); i++) {
			if (custos.get(i).getDescricao().equals("Combustivel")) {
				custoCombustivel += custos.get(i).getValor();
			}
		}
		return custoCombustivel;
	}

	/**
	 * Soma todos os custos incluídos na lista.
	 * 
	 * @return A soma de todos os custos.
	 */
	
	@Override
	public double custoTotal() {
		double somaCustos = 0;
		for (int i = 0; i < custos.size(); i++) {
			somaCustos += custos.get(i).getValor();
		}
		return somaCustos;
	}

	/**
	 * Imprime os custos do veículo
	 */
	public void listaCustosVeiculo() {
		for (int i = 0; i < custos.size(); i++) {
			System.out.println(custos.get(i).getDescricao() + " - " + custos.get(i).getValor());
		}
	}

	/**
	 * Acrescenta novo custo (descriçao e valor) ao final da lista de custos.
	 * 
	 * @param valor Valor do custo que vai ser acrescentado.
	 * @param descricao Tipo de custo que vai ser acrescentado.
	 */
	public void addCusto(double valor, String descricao) {
		Custo custo = new Custo(valor, descricao);
		custos.addLast(custo);
		notificar();
	}

	/**
	 * Acrescenta uma nova rota ao veículo.
	 * Primeiro verifica se o tanque tem autonomia para realizar a rota.
	 * Caso tenha autonomia, verifica se o combustível que tem no tanque é suficiente. Caso não seja efetua o abastecimento.
	 * Acrescenta o custo do abastecimento.
	 * 
	 * @param nova
	 */
	public void addRota(Rota nova) {
		if ((nova.getDistanciaTotal() <= tanque.autonomiaMaxima())) {
						
			if ((tanque.autonomia()) < (nova.getDistanciaTotal())) {
				addCusto(tanque.abastecer(), "abastecimento");
			}
			kmAtual += nova.getDistanciaTotal();
			tanque.consumir(nova.getDistanciaTotal());
			rotas.addLast(nova); 
			custoVariavel(); 
			
		} else {
			System.out.println("A distância excede a autonomia máxima do veículo");
		}
	}

	/**
	 * Calcula a média da distância das rotas (soma das distâncias das rotas dividida pelo número de rotas percorridas).
	 * 
	 * @return Média da distância das rotas.
	 */
	public double kmMediaDasRotas() {
		int rotasPercorridas = rotas.size();
		double somaDasDistancias = 0;
		for (int i = 0; i < rotas.size(); i++) {
			somaDasDistancias += rotas.get(i).getDistanciaTotal();
		}
		return somaDasDistancias / rotasPercorridas;
	}

	/**
	 * Imprime as rotas cadastradas para um veículo (data e distância).
	 */
	public void imprimeRotas() {
		for (int i = 0; i < rotas.size(); i++) {
			System.out.println("Data: " + rotas.get(i).getDate() + " Distancia total: "
					+ rotas.get(i).getDistanciaTotal());
		}
	}

	/**
	 * Quantidade de rotas cadatradas.
	 * 
	* @return Quantidade de rotas cadastradas.
	 */
	public int getNumRotas() {
		int numRotas = rotas.size();
		return numRotas;
	}

	/**
	 * Lista com as rotas cadastradas.
	 * 
	 * @return Lista com as rotas cadastradas.
	 */
	public LinkedList<Rota> getRotas() {
		return rotas;
	}


}
