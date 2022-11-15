
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

public abstract class Veiculo implements Serializable {


	private LinkedList<Rota> rotas = new LinkedList<Rota>();
	private LinkedList<Custo> custos = new LinkedList<Custo>();

	private String placa;
	private double valorVenda;
	private int percentualIpva;
	private int percentualSeguro;
	//private double kmPorLitro;
	private int kmAtual;
	//private int quantCombustivelAtual;
	private Tanque tanque;

	public Veiculo(String placa, double valorVenda,	int percentualIpva, int percentualSeguro, int kmAtual, int capacidadeTanque, float quantCombustivelAtual, Combustivel[] combustiveis) {
		this.placa = placa;
		this.valorVenda = valorVenda;
		this.percentualIpva = percentualIpva;
		this.percentualSeguro = percentualSeguro;
		//this.kmPorLitro = kmPorLitro;
		this.kmAtual = kmAtual;
		//this.quantCombustivelAtual = quantCombustivelAtual;
		//tanque = new Tanque(capacidadeTanque, quantCombustivelAtual, combustiveis);
		tanque = new Tanque(capacidadeTanque, quantCombustivelAtual, combustiveis);
	}

	public String getPlaca(){
		return this.placa;
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
		// somaDasDistancias+=distanciaTotal;
		// rotasPercorridas++;
		}
	}

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

}