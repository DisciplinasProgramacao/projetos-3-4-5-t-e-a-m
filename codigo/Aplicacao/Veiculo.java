
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

public abstract class Veiculo implements Serializable, Custo {


	private LinkedList<Rota> rotas = new LinkedList<Rota>();
	private LinkedList<Custo> custos = new LinkedList<Custo>();

	private String placa;
	private double valorVenda;
	private int percentualIpva;
	private int percentualSeguro;
	private int kmAtual;
	private Tanque tanque;

	public Veiculo(String placa, double valorVenda,	int percentualIpva, int percentualSeguro, int kmAtual, int capacidadeTanque, float quantCombustivelAtual, Combustivel[] combustiveis) {
		this.placa = placa;
		this.valorVenda = valorVenda;
		this.percentualIpva = percentualIpva;
		this.percentualSeguro = percentualSeguro;
		this.kmAtual = kmAtual;
		this.tanque = new Tanque(capacidadeTanque, quantCombustivelAtual, combustiveis);
	}

	public String getPlaca(){
		return this.placa;
	}
	
	
	public double autonomiaMaxima(){
		return (tanque.getcombustivel().getConsumo() * tanque.getCapacidade());
	  }


	  public double autonomiaAtual(){
		return (tanque.getcombustivel().getConsumo() * tanque.getQuantAtual());
	  }

	public abstract double valorIpva();

	public abstract double valorSeguro();

	// public double autonomia(){

	// 	return 0.00;
	// }

	public abstract double outrosCustos();

	// public void addRota(double distanciaTotal, LocalDate data) {
	// 	if(distanciaTotal < autonomia()){
	// 		Rota rota = new Rota(distanciaTotal, data);
	// 		//somar km no kmatual do veiculo
	// 		rotas.addLast(rota);
	// 		kmAtual+=distanciaTotal;
	// 		if ((quantCombustivelAtual * kmPorLitro) < (distanciaTotal)){
	// 			abastecer();
	// 		}
	// 	// somaDasDistancias+=distanciaTotal;
	// 	// rotasPercorridas++;
	// 	}
	// }
	
	public void addRota(double distanciaTotal, LocalDate data, Combustivel combustivel) {
		if((distanciaTotal <= tanque.autonomiaMaxima(combustivel))){
			Rota rota = new Rota(distanciaTotal, data);
			//somar km no kmatual do veiculo
			rotas.addLast(rota);
			kmAtual+=distanciaTotal;
			if ((tanque.getQuantAtual() * combustivel.getConsumo()) < (distanciaTotal)){
				tanque.abastecer();
			}
		}
	}
	
	/*
		public void addRota(double distanciaTotal, LocalDate data, Combustivel combustivel) {
		if((distanciaTotal <= autonomiaMaxima())){
			Rota rota = new Rota(distanciaTotal, data);
			//somar km no kmatual do veiculo
			rotas.addLast(rota);
			kmAtual+=distanciaTotal;
			if ((tanque.getQuantAtual() * combustivel.getConsumo()) < (distanciaTotal)){
				tanque.abastecer();
				addCusto(distanciaTotal);
			}
		}
	}

	public void addCusto(double distanciaTotal) {
		// NÃO CONSEGUI CRIAR A LISTA
			Custo custo = new Custo(combustivel.valorAbastecimento());	
			custos.addLast(custo);

			
		}
	}
	*/

	// public void abastecer(){
	// 	quantCombustivelAtual += (capacidadeTanque-quantCombustivelAtual);
	// 	//gastoCombustivel += (capacidadeTanque-quantCombustivelAtual)*valorCombustivel;

	// }

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
			System.out.println("Data: " + rotas.get(i).getDate() + "Distancia total: "
					+ rotas.get(i).getDistanciaTotal());
		}
	}

	public int getRotas(){
		int numRotas = rotas.size();
		return numRotas;
	}
	
//	public void filtrarRotasPorData(LocalDate date) {
//		for (int i = 0; i < rotas.size(); i++) {
//			System.out.println("Data: " + rotas.get(i).getDate());
//		}
//	}

}
