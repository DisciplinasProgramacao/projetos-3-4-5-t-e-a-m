
import java.util.Scanner;

public class Aplicacao {

	public static void menu() {

		System.out.println("\n\tMenu:");
		System.out.println("1. Carregar um conjunto de veículos de um arquivo");
		System.out.println("2. Salvar um conjunto de veículos de um arquivo");
		System.out.println("3. Incluir um novo veículo ");
		System.out.println("4. Incluir rotas para um veículo");
		System.out.println("5. Localizar um veículo da frota");
		System.out.println("6. imprimirRelatorio um relatório do veículo com seus gastos até o momento");
		System.out.println("7. Finalizar a menu");
		System.out.println("8. Testar classe enumerada");
		System.out.println("Digite a opcao desejada:");
	}

	public static void main(String[] args) throws Exception {
		String data, tarefa, entrada, strRepeticoes, placa;
		int kmAtual;
		double valorVenda;
		Boolean isAtivo = true;
		// ADICIONAR CAMINHO PARA O ARQUIVO LOCAL .DAT
		/// projeto3-t-e-a-m/projetos-3-4-5-t-e-a-m/codigo/Aplicacao/dados.dat
		String caminhoArquivo = "C:/Offline/dados.dat";

		Frota frota = new Frota();

		try (Scanner ler = new Scanner(System.in)) {
			while (isAtivo) {
				menu();

				entrada = ler.nextLine();

				switch (Integer.parseInt(entrada)) {
					case 1:
						frota.carregarVeiculo(caminhoArquivo);
						break;

					case 2:
						frota.salvarVeiculo(caminhoArquivo);
						break;

					case 3:
						try {
							Veiculo novo = null;

							System.out.println("Qual a placa do veículo?: ");
							placa = ler.nextLine();
							System.out.println("Qual o valor de venda do veículo?: ");
							entrada = ler.nextLine();
							valorVenda = Double.parseDouble(entrada);
							System.out.println("Qual a quilometragem do veículo?: ");
							entrada = ler.nextLine();
							kmAtual = Integer.parseInt(entrada);
							
							System.out.println("que tipo de veículo será incluído: ");
							System.out.println("1. Carro");
							System.out.println("2. Caminhão");
							System.out.println("3. Van");
							System.out.println("4. Furgão");

							entrada = ler.nextLine();

							switch (Integer.parseInt(entrada)) {
								case 1:
									novo = new Carro(placa, valorVenda, kmAtual);
									break;

								case 2:
									novo = new Caminhao(placa, valorVenda, kmAtual);
									break;

								case 3:
									novo = new Van(placa, valorVenda, kmAtual);
									break;

								case 4:
									novo = new Furgao(placa, valorVenda, kmAtual);
									break;

								default:
									System.out.println("modelo inválido");
									break;
							}
							frota.addVeiculo(novo);
							frota.imprimirRelatorio();
									

						} catch (Exception erro) {
							System.out.println(erro.getMessage());

						}
						break;
					case 4:
						System.out.println("Digite a placa do veículo: ");
						frota.imprimirRelatorio();
						placa = ler.nextLine();

						try {
							Veiculo veic = frota.localizaVeiculo(placa);
							veic.addRota(1000, null);
							veic.imprimeRotas();
						} catch (Exception erro) {
							System.out.println(erro.getMessage());
						}
						break;

					case 5:

						try {

							System.out.println("Digite a placa do veículo:");

							placa = ler.nextLine();
							Veiculo veic = frota.localizaVeiculo(placa);
							System.out.println("Placa: " + veic.getPlaca() + " - Valor IPVA: " + veic.valorIpva()
									+ " - Valor Seguro:  "
									+ veic.valorSeguro() + " - Outros Custos: " + veic.outrosCustos());

						} catch (Exception erro) {
							System.out.println(erro.getMessage());
						}

						break;
					case 6:

						try {
							frota.imprimirRelatorio();
						} catch (Exception erro) {
							System.out.println(erro.getMessage());
						}

						break;

					case 7:
						isAtivo = false;
						System.out.println("Finalizado!");
						break;
					case 8:
						
						for (Combustivel c : Combustivel.values()) {
						      System.out.println(c.getDescricao());
						  }
						
//					Carro carro = new Carro("",0,0);
//					carro.manutencaoNaoProgramada();
						break;
					default:
						System.out.println("Comando inválido");
						break;


				}

			}
		}
	}


}