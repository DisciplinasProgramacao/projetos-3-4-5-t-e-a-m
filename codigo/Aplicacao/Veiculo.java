
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

public abstract class Veiculo implements Serializable, Custo {


	private LinkedList<Rota> rotas = new LinkedList<Rota>();

	private String placa;
	private double valorVenda;
	private int percentualIpva;
	private int percentualSeguro;
	private int kmAtual;
	public double custoCombustivel;
	public double custoVariavel;

	public Tanque tanque;
	public LocalDate date = java.time.LocalDate.now();

	public Veiculo(String placa, double valorVenda,	int percentualIpva, int percentualSeguro, int kmAtual, int capacidadeTanque, 
	float quantCombustivelAtual, double custoCombustivel, double custoVariavel, Combustivel[] combustiveis) {
		this.placa = placa;
		this.valorVenda = valorVenda;
		this.percentualIpva = percentualIpva;
		this.percentualSeguro = percentualSeguro;
		this.kmAtual = kmAtual;
		this.custoCombustivel = custoCombustivel;
		this.custoVariavel = custoVariavel;
		this.tanque = new Tanque(capacidadeTanque, quantCombustivelAtual, combustiveis);
	}

	public String getPlaca(){
		return this.placa;
	}
	
	@Override
	public double custoTotal() {
		return (custoCombustivel() + custoVariavel() + custoFixo());
	}

	@Override
    public double custoCombustivel(){
		return (custoCombustivel);
	}

	@Override
    public double custoVariavel(){
		return (custoVariavel);
	}
	
	@Override
    public double custoFixo(){
		return (valorIpva()+valorSeguro()+outrosCustos());
	}

	public abstract double valorIpva();

	public abstract double valorSeguro();

	public double autonomiaMaxima(){
		return (tanque.getCombustivel().getConsumo() * tanque.getCapacidade());
	  }

	  public double autonomiaAtual(){
		return (tanque.getCombustivel().getConsumo() * tanque.getQuantAtual());
	  }

	public abstract double outrosCustos();

	public void addRota(double distanciaTotal, Combustivel combustivel) {
		if((distanciaTotal <= tanque.autonomiaMaxima(combustivel))){
			Rota rota = new Rota(distanciaTotal, date, combustivel);
			//somar km no kmatual do veiculo
			rotas.addLast(rota);
			kmAtual+=distanciaTotal;
			if ((tanque.getQuantAtual() * combustivel.getConsumo()) < (distanciaTotal)){
				System.out.println("Tanque abastecido! Quantidade anterior insuficiente");
				System.out.println("quantidade anterior: " + tanque.getQuantAtual() + " => quantidade atual: " + tanque.getCapacidade());
				tanque.abastecer();
				addCustoCombustivel();

			}
			System.out.println("Combustível consumido: " + tanque.consumir(combustivel, distanciaTotal));
		} else {
			System.out.println("Rota além da autonomia máxima do veículo");
		}
	}

	// public void abastecer(){
	// 	quantCombustivelAtual += (capacidadeTanque-quantCombustivelAtual);
	// 	//gastoCombustivel += (capacidadeTanque-quantCombustivelAtual)*valorCombustivel;

	// }

	private void addCustoCombustivel() {
		double volumeAbastecido = (tanque.getCapacidade()-tanque.getQuantAtual());
		custoCombustivel += (volumeAbastecido*custoCombustivel)
	}

	public double kmMediaDasRotas(){
		int rotasPercorridas = rotas.size();
		double somaDasDistancias = 0;
		for (int i = 0; i < rotas.size(); i++){
			somaDasDistancias += rotas.get(i).getDistanciaTotal();
		}
		return somaDasDistancias/rotasPercorridas;
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

	public int getNumRotas(){
		int numRotas = rotas.size();
		return numRotas;
	}

	public LinkedList<Rota> getRotas(){
		return rotas;
	}
	
//	public void filtrarRotasPorData(LocalDate date) {
//		for (int i = 0; i < rotas.size(); i++) {
//			System.out.println("Data: " + rotas.get(i).getDate());
//		}
//	}

}
