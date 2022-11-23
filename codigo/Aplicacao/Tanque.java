import java.util.*;

public class Tanque {

  private int capacidade;
  private float quantAtual;
  private ArrayList<Combustivel> combustiveis;

  public Tanque() {
    combustiveis = new ArrayList<>(Arrays.asList(Combustivel.GASOLINA, Combustivel.DIESEL, Combustivel.ALCOOL));
    capacidade = 1000;
    quantAtual = 1000;
  }

  public Tanque(int capacidade, float quantAtual, Combustivel[] combs) {
    this.capacidade = capacidade;
    this.quantAtual = quantAtual;
    this.combustiveis = new ArrayList<>(Arrays.asList(combs));
  }

  public double autonomiaMaxima(Combustivel combustivel) {
    return (combustivel.getConsumo() * capacidade);
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

  public ArrayList getCombustiveis() {
    return combustiveis;
  }

  public void abastecer() {
    quantAtual += (this.capacidade - this.quantAtual);
  }

  public double consumir(Combustivel combust, double distancia) {
    double consumo = distancia / combust.getConsumo();
    quantAtual -= consumo;
    return consumo;
  }
}
