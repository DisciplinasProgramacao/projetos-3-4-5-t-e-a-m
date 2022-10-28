import java.io.Serializable;
import java.time.LocalDate;

public class Rota implements Serializable{
    
	private double distanciaTotal;
	private LocalDate date;

    public Rota(double distancia, LocalDate data){
		this.distanciaTotal = distancia;
		this.date = data;
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

