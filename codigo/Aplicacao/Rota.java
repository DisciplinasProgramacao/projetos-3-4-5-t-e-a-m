import java.io.Serializable;
import java.time.LocalDate;

public class Rota implements Serializable {

	private double distanciaTotal;
	private LocalDate date;
	private Combustivel combustivel;

	public Rota(double distancia, LocalDate data) {
		this.distanciaTotal = distancia;
		this.date = data;
	}

	public Rota(double distancia, LocalDate data, Combustivel combustivel) {
		this.distanciaTotal = distancia;
		this.date = data;
		this.combustivel = combustivel;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getDistanciaTotal() {
		return distanciaTotal;
	}

	public void setDistanciaTotal(int distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	}
}
