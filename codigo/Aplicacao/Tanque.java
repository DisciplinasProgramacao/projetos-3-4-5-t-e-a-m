import java.io.Serializable;

public class Tanque implements Serializable{

  private int capacidade;
  private float quantAtual;
  private Combustivel combustivelAtual;

  /**
   * Construtor do tanque
   * 
   * @param qual Indica o tipo de combustível
   * @param capacidade Indica a capacidade do tanque.
   */

  public Tanque(Combustivel qual, int capacidade) {
    combustivelAtual = qual;
    this.capacidade = capacidade;
    quantAtual = capacidade;
    
  }

  public Tanque(int capacidade, float quantAtual, Combustivel combs) {
    this.capacidade = capacidade;
    this.quantAtual = quantAtual;
    this.combustivelAtual = combs;
  }

  /**
   * Calcula a autonomia do veículo com o tanque completo.
   * 
   * @return Autonomia do veículo com tanque completo.
   */
  public double autonomiaMaxima() {
    return (this.combustivelAtual.getConsumo() * capacidade);
  }

  /**
   * Calcula a autonomia do veículo considerando a quantidade de combustível disponível no tanque.
   * 
   * @return Autonomia com o combustível disponível no tanque.
   */
  public double autonomia() {
    return (combustivelAtual.getConsumo() * quantAtual);
  }

  /**
   * Indica a quantidade de combustível no tanque.
   * 
   * @return Quantidade de combustível no tanque.
   */
  public float getQuantAtual() {
    return quantAtual;
  }

  /**
   * Indica a capacidade total do tanque.
   * 
   * @return Capacidade do tanque.
   */
  public int getCapacidade() {
    return this.capacidade;
  }

  /**
   * Indica o tipo de combustível que está sendo utilizado.
   * 
   * @return Tipo de combustível que está sendo utilizado.
   */
  public Combustivel getCombustivel() {
    return combustivelAtual;
  }

  /**
   * 
   * Calcula o custo de abastecimento para completar o tanque do veículo.
   * 
   * @return Custo para abastecer o veículo.
   */
  public double abastecer() {
      double litrosParaEncher = this.capacidade - this.quantAtual;
      this.quantAtual = this.capacidade;
      return combustivelAtual.getPreco()*litrosParaEncher;

    }

  /**
   * Calcula o consumo de combustível do veículo em uma distância indicada.
   * Reduz a quantidade de combustível atual do veículo considerando o 
   * consumo de combustível na distância indicada.
   * 
   * @param distancia 
   * @return Consumo de combustível na distância indicada.
   */
    public double consumir(double distancia) {
    double consumo = distancia / combustivelAtual.getConsumo();
    quantAtual -= consumo;
    return consumo;
  }
}
