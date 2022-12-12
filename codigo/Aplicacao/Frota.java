import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Collections;
import java.util.LinkedList;

public class Frota {
	LinkedList<Rota> rotas;
	LinkedList<Veiculo> veiculos;

	/**
	 * Cria lista para inclusão dos veículos da frota
	 */
	public Frota() {
		veiculos = new LinkedList<Veiculo>();
	}

	/**
	 * Carrega veículos a partir de um arquivo.
	 * 
	 * @param nomeArquivo Nome do arquivo que será carregado.
	 */
	public void carregarVeiculo(String nomeArquivo) {

		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(nomeArquivo);
			ois = new ObjectInputStream(fis);
			Object obj = ois.readObject();
			veiculos = (LinkedList<Veiculo>) obj;
			fis.close();
			ois.close();

		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			erro.printStackTrace();
		} finally {
			this.imprimirRelatorio();
		}
	}

	/**
	 * Salva veículos em um arquivo
	 * 
	 * @param nomeArquivo Nome do arquivo em que os veículos serão salvos
	 */
	public void salvarVeiculo(String nomeArquivo) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		try {
			fout = new FileOutputStream(nomeArquivo);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(veiculos);
			fout.close();
			oos.close();
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
			erro.printStackTrace();
		}
	}

	/**
	 * Inclui veículo na frota (lista)
	 * 
	 * @param veiculo Veículo a ser incluído.
	 * @return Verdadeiro caso o veículo seja incluído.
	 */
	public boolean addVeiculo(Veiculo veiculo) {
		this.veiculos.addLast(veiculo);
		return true;
	}

	/**
	 * Localiza veículo incluído na frota (lista) a partir da indicação da placa do veículo procurado.
	 * 
	 * @param placa Do veículo a ser localizado.
	 * @return Veículo (caso for encontrado)
	 * @throws Exception Apresenta mensagem "Placa não encontrada" caso não seja localizado veículo na frota com a placa indicada.
	 */
	public Veiculo localizaVeiculo(String placa) throws Exception {
		for (Veiculo veiculo : veiculos) {
			if (placa.equals(veiculo.getPlaca())) {
				return veiculo;
			}
		}
		throw new Exception("Placa não encontrada");
	}

	/**
	 * Imprime relatório com placa do veículo, valor do IPVA, valor do Seguro e soma dos custos.
	 * 
	 */
	public void imprimirRelatorio() {
		for (int i = 0; i < veiculos.size(); i++) { //stream filtro pra pegar valores
			System.out.println(i + " - Placa: " + veiculos.get(i).getPlaca() + " - Valor IPVA: "
					+ veiculos.get(i).valorIpva() + " - Valor Seguro:  "
					+ veiculos.get(i).valorSeguro() + " - Soma dos Custos: " + veiculos.get(i).custoTotal());
		}
	}

	/**
	 * Imprime relatório com placa do veículo, valor do IPVA, valor do Seguro, soma dos custos e todos os custos.
	 * 
	 */
	public void imprimirRelatorioCompleto() {
		for (int i = 0; i < veiculos.size(); i++) { //stream filtro pra pegar valores
			System.out.println(i + " - Placa: " + veiculos.get(i).getPlaca() + " - Valor IPVA: "
					+ veiculos.get(i).valorIpva() + " - Valor Seguro:  "
					+ veiculos.get(i).valorSeguro() + " - Soma dos Custos: " + veiculos.get(i).custoTotal());
			System.out.println("Todos os custos: ");
			veiculos.get(i).listaCustosVeiculo();
		}
	}

	/**
	 * Calcula a média do consumo das rotas,
	 */
	public void mediaConsumoRotas() {
		Veiculo aux;
		double sum = 0;
		int auxsum = 0;
		for (int i = 0; i < veiculos.size(); i++) {
			aux = veiculos.get(i);
			for (int j = 0; j < aux.getRotas().size(); j++) {
				sum += aux.getRotas().get(j).getDistanciaTotal();
				auxsum++;
			}
		}
		System.out.println("Media de todas as rotas: " + sum / auxsum);
	}

	/**
	 * Informa os três vaeículos que fizeram mais rotas. 
	 * 
	 */
	public void imprimeTresMaiores() {

		LinkedList<Veiculo> tresMaiores;
		Veiculo maior = veiculos.get(0);
		Veiculo medio = veiculos.get(0);
		Veiculo menor = veiculos.get(0);

		for (Veiculo veiculo : veiculos) {
			if (veiculo.getNumRotas() > maior.getNumRotas()) {

				menor = medio;
				medio = maior;
				maior = veiculo;

			} else if (veiculo.getNumRotas() > medio.getNumRotas()) {

				menor = medio;
				medio = veiculo;

			} else if (veiculo.getNumRotas() > menor.getNumRotas()) {
				menor = veiculo;

			}
		}

		System.out.println(" 1: " + maior.getPlaca());
		System.out.println(" 2: " + medio.getPlaca());
		System.out.println(" 3: " + menor.getPlaca());

	}

	/**
	 * Organiza lista de custos em ordem decrescente de custos.
	 */
	public void listaDecrescenteCusto() {
		for (int i = 0; i < veiculos.size(); i++) {
			for (int j = 0; j < veiculos.size(); j++) {
				if (veiculos.get(i).custoTotal() > veiculos.get(j).custoTotal()) {
					Collections.swap(veiculos, i, j);
				}
			}
		}
		imprimirRelatorio();
	}

	/**
	 * Imprime as rotas cadastradas para um veículo (placa, data e distância).
	 */
	public void imprimirRotas() {
		Veiculo aux;
		for (int i = 0; i < veiculos.size(); i++) {
			aux = veiculos.get(i);
			for (int j = 0; j < aux.getRotas().size(); j++) {
				System.out.println(
						"Placa: " + aux.getPlaca() + "\nDistancia Total: " + aux.getRotas().get(j).getDistanciaTotal()
								+ "\nData: " + aux.getRotas().get(j).getDate());
			}
		}
	}

	/**
	 * Filtra as rotas cadastradas por data, considerando a data indicada, e imprime as filtradas
	 * 
	 * @param date 
	 */
	public void filtrarFrotaPorData(LocalDate date) {
		Veiculo aux;
		for (int i = 0; i < veiculos.size(); i++) {
			aux = veiculos.get(i);
			for (int j = 0; j < aux.getRotas().size(); j++) {
				if (date.equals(aux.getRotas().get(j).getDate())) {
					System.out.println("Placa: " + aux.getPlaca() + "\nDistancia Total: "
							+ aux.getRotas().get(j).getDistanciaTotal()
							+ "\nData: " + aux.getRotas().get(j).getDate());
				}
			}
		}

	}
}
