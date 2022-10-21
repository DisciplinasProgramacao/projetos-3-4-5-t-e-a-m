package Aplicacao;

import java.time.LocalDate;

public class Rota {
    
    private LocalDate date;
    private int distanciaTotal;

    private Rota(){
        this.date = date;
        this.distanciaTotal = distanciaTotal;
    }
    public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getDistanciaTotal() {
		return distanciaTotal;
	}

	public void setDistanciaTotal(int distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	}
}
