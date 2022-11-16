import java.util.*;

public class Tanque {

    private int capacidade;
    private float quantAtual;
    private EnumSet<Combustivel> combustiveis;

	public Tanque() {
      //this.combustiveis = {Combustivel.GASOLINA, Combustivel.DIESEL, Combustivel.ALCOOL};
      combustiveis = EnumSet.of(Combustivel.GASOLINA, Combustivel.DIESEL, Combustivel.ALCOOL);
      capacidade = 1000;
      quantAtual = 1000;
    }

    public Tanque(int capacidade, float quantAtual, Combustivel[] combs) {
      this.capacidade = capacidade;
      this.quantAtual = quantAtual;
      for(int i=0; i<combs.length; i++)
        combustiveis.add(combs[i]);
    }

  //   public double autonomiaMaxima() {
	// 	return (kmPorLitro * capacidade);
	// }
/*
    public double autonomiaMaxima(Combustivel combustivel){
      return (combustivel.getConsumo() * capacidade);
    }

    public double autonomia(Combustivel combustivel){
      return (combustivel.getConsumo() * quantAtual);
    }
	*/

    public float getQuantAtual() {
        return quantAtual;
    }
	 
    public int getCapacidade(){
    return this.capacidade;
  }

	public Combustivel getCombustivel(){
      return this.combustivel;
    }

    public void abastecer(){
      quantAtual += (capacidade-quantAtual);
    }
}
