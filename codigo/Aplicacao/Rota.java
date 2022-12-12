import java.io.Serializable;
import java.time.LocalDate;

public class Rota implements Serializable {

	private double distanciaTotal;
	private LocalDate date;

	/**
	 * Construtor da rota.
	 * 
	 * @param distancia Distância da rota.
	 */
	public Rota(double distancia) {
		this.distanciaTotal = distancia;
		this.date = java.time.LocalDate.now();
	}

	/**
	 * Indica a data da realização da rota.
	 * 
	 * @return Data da realização da rota.
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Modifica a data cadastrada para a realização da rota.
	 * 
	 * @param date 
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Indica a distãncia da rota.
	 * 
	 * @return Distância da rota.
	 */
	public double getDistanciaTotal() {
		return distanciaTotal;
	}

	/**
	 * Modifica a distância da rota.
	 * 
	 * @param distanciaTotal
	 */
	public void setDistanciaTotal(int distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	}
}
