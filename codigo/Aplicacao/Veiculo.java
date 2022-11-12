
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

public abstract class Veiculo implements Serializable {


	private LinkedList<Rota> listaDeRotas = new LinkedList<Rota>();
	private String placa;
	private double valorVenda;
	private int percentualIpva;
	private int percentualSeguro;
	private double kmPorLitro;
	private int kmAtual;
	private int nivelCombustivelAtual;

	public Veiculo(String placa, double valorVenda,	int percentualIpva, int percentualSeguro, double kmPorLitro, int kmAtual, int nivelCombustivelAtual) {
		this.placa = placa;
		this.valorVenda = valorVenda;
		this.percentualIpva = percentualIpva;
		this.percentualSeguro = percentualSeguro;
		this.kmPorLitro = kmPorLitro;
		this.kmAtual = kmAtual;
		this.nivelCombustivelAtual = nivelCombustivelAtual;
	}

	public String getPlaca(){
		return this.placa;
	}

	public abstract double valorIpva();

	public abstract double valorSeguro();

	public abstract double autonomia();

	public abstract double outrosCustos();

	public void addRota(double distanciaTotal, LocalDate data) {
		if((distanciaTotal < autonomia())){
		Rota rota = new Rota(distanciaTotal, data);
		//somar km no kmatual do veiculo
		listaDeRotas.addLast(rota);
		if ((nivelCombustivelAtual * kmPorLitro) < (distanciaTotal)){
		abastecer();
		}
		kmAtual+=distanciaTotal;
		somaDasDistancias+=distanciaTotal;
		rotasPercorridas++;
		}
	}

	public void abastecer(){
		nivelCombustivelAtual += (capacidadeTanque-nivelCombustivelAtual);
		//gastoCombustivel += (capacidadeTanque-nivelCombustivelAtual)*valorCombustivel;

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