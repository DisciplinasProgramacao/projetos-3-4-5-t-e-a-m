
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

public abstract class Veiculo implements Serializable, Custeavel {

	private LinkedList<Rota> rotas = new LinkedList<Rota>();
	private LinkedList<Custo> custos = new LinkedList<Custo>();

	private String placa;
	private double valorVenda;
	private int percentualIpva;
	private int percentualSeguro;
	private double acrescimoSeguro;
	private int kmAtual;
	public static double custoCombustivel; // ???
	private int manutencoes;
	//public static double custoCombustivelConsumido;
	public static double custoVariavel;

	public Tanque tanque;
	public LocalDate date = java.time.LocalDate.now();

	public Veiculo(String placa, double valorVenda, int percentualIpva, int percentualSeguro, double acrescimoSeguro, int kmAtual,
			int capacidadeTanque,
			float quantCombustivelAtual, double custoCombustivel, double custoVariavel, Combustivel[] combustiveis) {
		this.placa = placa;
		this.valorVenda = valorVenda;
		this.percentualIpva = percentualIpva;
		this.percentualSeguro = percentualSeguro;
		this.acrescimoSeguro = acrescimoSeguro;
		this.kmAtual = kmAtual;
		this.custoCombustivel = custoCombustivel;
		this.custoVariavel = custoVariavel;
		this.tanque = new Tanque(capacidadeTanque, quantCombustivelAtual, combustiveis);
		this.addCusto(valorIpva(), "IPVA");
		this.addCusto(valorSeguro(), "Seguro");
	}

	public String getPlaca() {
		return this.placa;
	}

	public void listaCustosVeiculo() {
		for (int i = 0; i < custos.size(); i++) {
			System.out.println(custos.get(i).getDescricao() + " - " + custos.get(i).getValor());
		}
	}

	@Override
	public double custoCombustivel() {// add todos so custos de combustivel
		return (custoCombustivel);
	}

	@Override
	public double custoTotal() {
		double somaCustos = 0;
		for (int i = 0; i < custos.size(); i++) {
			somaCustos += custos.get(i).getValor();
		}
		return somaCustos;
		// return (custoCombustivel() + custoFixo() + somaCustosVariaveis);
	}



	//@Override
	//public abstract void custoVariavel();  // manutenção alinhamento e vistoria (muda só pro caminhão)
		// o custo variável automaticamente adiciona os custos na lista
	

	
	// Custos fixos

	public double valorIpva() {
		return (valorVenda * percentualIpva / 100);// overridado
	}

	public double valorSeguro() {
		return (valorVenda * percentualSeguro / 100 + acrescimoSeguro);// overridado
	}
	
	
	@Override
	public double custoFixo() { // add todos os custos fixos
		return (valorIpva() + valorSeguro());
	}

	public void addCusto(double valor, String descricao) {
		Custo custo = new Custo(valor, descricao);
		custos.addLast(custo);
	}


	public void addRota(double distanciaTotal, Combustivel combustivel) {
		if ((distanciaTotal <= tanque.autonomiaMaxima(combustivel))) {
			Rota rota = new Rota(distanciaTotal, date, combustivel);
			// somar km no kmatual do veiculo
			rotas.addLast(rota);
			kmAtual += distanciaTotal;
			if ((tanque.getQuantAtual() * combustivel.getConsumo()) < (distanciaTotal)) {
				System.out.println("Tanque abastecido! Quantidade anterior insuficiente");
				System.out.println("quantidade anterior: " + tanque.getQuantAtual() + " => quantidade atual: "
						+ tanque.getCapacidade());
				addCusto((tanque.getCapacidade() - tanque.getQuantAtual()) * combustivel.getPreco(), "Combustivel");
				tanque.abastecer();
			}
			System.out.println("Combustível consumido: " + tanque.consumir(combustivel, distanciaTotal));
		} else {
			System.out.println("Rota além da autonomia máxima do veículo");
		}
	}

	public double kmMediaDasRotas() {
		int rotasPercorridas = rotas.size();
		double somaDasDistancias = 0;
		for (int i = 0; i < rotas.size(); i++) {
			somaDasDistancias += rotas.get(i).getDistanciaTotal();
		}
		return somaDasDistancias / rotasPercorridas;
	}

	public void imprimeRotas() {
		for (int i = 0; i < rotas.size(); i++) {
			System.out.println("Data: " + rotas.get(i).getDate() + " Distancia total: "
					+ rotas.get(i).getDistanciaTotal());
		}
	}

	public void imprimeRotasData() {
		for (int i = 0; i < rotas.size(); i++) {
			System.out.println("Data: " + rotas.get(i).getDate() + " Distancia total: "
					+ rotas.get(i).getDistanciaTotal());
		}
	}

	public int getNumRotas() {
		int numRotas = rotas.size();
		return numRotas;
	}

	public LinkedList<Rota> getRotas() {
		return rotas;
	}
}
