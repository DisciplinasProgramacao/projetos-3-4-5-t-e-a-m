import java.util.*;

public class Tanque {

  private int capacidade;
  private float quantAtual;
  private Combustivel combustivelAtual;

  public Tanque(Combustivel qual, int capacidade) {
    combustivelAtual = qual;// = new ArrayList<>(Arrays.asList(Combustivel.GASOLINA, Combustivel.DIESEL, Combustivel.ALCOOL));
    this.capacidade = capacidade;
    quantAtual = capacidade;
    
  }

  public Tanque(int capacidade, float quantAtual, Combustivel combs) {
    this.capacidade = capacidade;
    this.quantAtual = quantAtual;
    this.combustivelAtual = combs;
  }

  public double autonomiaMaxima() {
    return (this.combustivelAtual.getConsumo() * capacidade);
  }

  public double autonomia() {
    return (combustivelAtual.getConsumo() * quantAtual);
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

  public double abastecer() {
      double litrosParaEncher = this.capacidade - this.quantAtual;
      this.quantAtual = this.capacidade;
      return combustivelAtual.getPreco()*litrosParaEncher;

    }

  public double consumir(double distancia) {
    double consumo = distancia / combustivelAtual.getConsumo();
    quantAtual -= consumo;
    return consumo;
  }
}
