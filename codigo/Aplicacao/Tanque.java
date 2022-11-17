import java.util.*;

public class Tanque {

    private int capacidade;
    private float quantAtual;
    private ArrayList<Combustivel> combustiveis;

	public Tanque() {
      //this.combustiveis = {Combustivel.GASOLINA, Combustivel.DIESEL, Combustivel.ALCOOL};
      combustiveis = new ArrayList<>(Arrays.asList(Combustivel.GASOLINA, Combustivel.DIESEL, Combustivel.ALCOOL));
      capacidade = 1000;
      quantAtual = 1000;
    }

    public Tanque(int capacidade, float quantAtual, Combustivel[] combs) {
      this.capacidade = capacidade;
      this.quantAtual = quantAtual;
      //problema aqui
      // for(int i=0; i<combs.length; i++){
      //   System.out.println("teste");
      //   combustiveis.add(combs[i]);
      //   System.out.println("aaa");
      // }
      combustiveis = new ArrayList<>(Arrays.asList(combs));
      //combustiveis = new ArrayList<>(Arrays.asList(Combustivel.GASOLINA, Combustivel.DIESEL, Combustivel.ALCOOL));

      //combustiveis = Arrays.asList(combs);
      //new ArrayList<List>(combs);
    }

  //   public double autonomiaMaxima() {
	// 	return (kmPorLitro * capacidade);
	// }

    public double autonomiaMaxima(Combustivel combustivel){
      return (combustivel.getConsumo() * capacidade);
    }

    public double autonomia(Combustivel combustivel){
      return (combustivel.getConsumo() * quantAtual);
    }

    public float getQuantAtual() {
        return quantAtual;
    }
	 
    public int getCapacidade(){
    return this.capacidade;
  }

	// public Combustivel getCombustivel(){
  //     return this.combustivel;
  //   }

    public ArrayList getCombustiveis() {
      return combustiveis;
    }

    public void abastecer(){
      quantAtual += (this.capacidade - this.quantAtual);
    }

    public double consumir(Combustivel combust, double distancia){
      double consumo = distancia / combust.getConsumo();
      quantAtual -= consumo;
      return consumo;
    }
}
