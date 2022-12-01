import java.util.*;

public class Tanque {

  private int capacidade;
  private float quantAtual;
  private Combustivel combustivelAtual;

  public Tanque(Combustivel qual) {
    combustivelAtual = qual;// = new ArrayList<>(Arrays.asList(Combustivel.GASOLINA, Combustivel.DIESEL, Combustivel.ALCOOL));
    capacidade = 1000;
    quantAtual = 1000;
  }

  public Tanque(int capacidade, float quantAtual, Combustivel combs) {
    this.capacidade = capacidade;
    this.quantAtual = quantAtual;
    this.combustivelAtual = combs;
  }

  public double autonomiaMaxima() {
    return (this.combustivelAtual.getConsumo() * capacidade);
  }

  public double autonomia(Combustivel combustivel) {
    return (combustivel.getConsumo() * quantAtual);
  }

  public float getQuantAtual() {
    return quantAtual;
  }

  public int getCapacidade() {
    return this.capacidade;
  }

  public Combustivel getCombustivel() {
    return combustivelAtual;
  }

  public void abastecer() {
    quantAtual += (this.capacidade - this.quantAtual);
    double custo = 0; //calc custo
    //return custo;
  }

  public double consumir(Combustivel combust, double distancia) {
    double consumo = distancia / combust.getConsumo();
    quantAtual -= consumo;
    return consumo;
  }
}
