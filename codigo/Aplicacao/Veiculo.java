
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
	private double kmPorLitro;
	private int kmAtual;
	private int quantCombustivelAtual;

	public Veiculo(String placa, double valorVenda,	int percentualIpva, int percentualSeguro, double kmPorLitro, int kmAtual, int quantCombustivelAtual) {
		this.placa = placa;
		this.valorVenda = valorVenda;
		this.percentualIpva = percentualIpva;
		this.percentualSeguro = percentualSeguro;
		this.kmPorLitro = kmPorLitro;
		this.kmAtual = kmAtual;
		this.quantCombustivelAtual = quantCombustivelAtual;
	}

	public String getPlaca(){
		return this.placa;
	}

	public abstract double valorIpva();

	public abstract double valorSeguro();

	public double autonomia(){

		return 0.00;
	}

	public abstract double outrosCustos();

	public void addRota(double distanciaTotal, LocalDate data) {
		if((distanciaTotal < autonomia())){
		Rota rota = new Rota(distanciaTotal, data);
		//somar km no kmatual do veiculo
		listaDeRotas.addLast(rota);
		if ((quantCombustivelAtual * kmPorLitro) < (distanciaTotal)){
		abastecer();
		}
		kmAtual+=distanciaTotal;
		// somaDasDistancias+=distanciaTotal;
		// rotasPercorridas++;
		}
	}

	public void abastecer(){
		quantCombustivelAtual += (capacidadeTanque-quantCombustivelAtual);
		//gastoCombustivel += (capacidadeTanque-quantCombustivelAtual)*valorCombustivel;

	}

	public double kmMediaDasRotas(){
		return somaDasDistancias/rotasPercorridas;
	}

	public void imprimeRotas() {
		for (int i = 0; i < listaDeRotas.size(); i++) {
			System.out.println("Data: " + listaDeRotas.get(i).getDate() + "Distancia total: "
					+ listaDeRotas.get(i).getDistanciaTotal());
		}
	}

}