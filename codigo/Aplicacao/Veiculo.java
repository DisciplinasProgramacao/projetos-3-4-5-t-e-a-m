
import java.io.Serializable;
import java.time.LocalDate;
import java.util.LinkedList;

public abstract class Veiculo implements Serializable {


	private LinkedList<Rota> listaDeRotas = new LinkedList<Rota>();
	private String placa;
	private int capacidadeTanque;
	private double valorVenda;
	private int percentualIpva;
	private int percentualSeguro;
	private double kmPorLitro;
	private int kmAtual;

	public Veiculo(String placa, int capacidadeTanque, double valorVenda,
			int percentualIpva, int percentualSeguro, double kmPorLitro, int kmAtual) {
		this.placa = placa;
		this.capacidadeTanque = capacidadeTanque;
		this.valorVenda = valorVenda;
		this.percentualIpva = percentualIpva;
		this.percentualSeguro = percentualSeguro;
		this.kmPorLitro = kmPorLitro;
		this.kmAtual = kmAtual;
	}

	public String getPlaca(){
		return this.placa;
	}

	public abstract double valorIpva();

	public abstract double valorSeguro();

	public abstract double autonomia();

	public abstract double outrosCustos();

	public void addRota(double distanciaTotal, LocalDate data) {
		Rota rota = new Rota(distanciaTotal, data);
		//somar km no kmatual do veiculo
		listaDeRotas.addLast(rota);
	}

	public void imprimeRotas() {
		for (int i = 0; i < listaDeRotas.size(); i++) {
			System.out.println("Data: " + listaDeRotas.get(i).getDate() + "Distancia total: "
					+ listaDeRotas.get(i).getDistanciaTotal());
		}
	}

}