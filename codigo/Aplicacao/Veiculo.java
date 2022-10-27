

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Veiculo {

	private List<Rota> listaDeRotas = new ArrayList<Rota>();
	private String placa;
	private int capacidadeTanque;
	private double valorVenda;
	private int percentualIpva;
	private int percentualSeguro;
	private double kmPorLitro;
	private int kmAtual;

	 public String getPlaca() {
	 return placa;
	 }


	public Veiculo(String placa, int capacidadeTanque, double valorVenda,
			int percentualIpva, int percentualSeguro, double kmPorLitro, int kmAtual) {
		this.placa=placa;
		this.capacidadeTanque = capacidadeTanque;
		this.valorVenda=valorVenda;  
		this.percentualIpva = percentualIpva;
		this.percentualSeguro = percentualSeguro;
		this.kmPorLitro = kmPorLitro;
		this.kmAtual=kmAtual;
	}

	public abstract double valorIpva();
	
	public abstract double valorSeguro();

	public abstract double autonomia();
	
	public abstract double outrosCustos();

	public void addRota(double distanciaTotal, LocalDate data) {
		Rota rota = new Rota(distanciaTotal, data);
		listaDeRotas.add(rota);
	}

	

}