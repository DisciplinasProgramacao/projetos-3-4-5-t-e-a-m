import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		System.out.println("7. Acrescentar um custo eventual aos custos de um veículo");
		System.out.println("8. Testar classe enumerada");
		System.out.println("9. Respostas estratégicas");
		System.out.println("10. Finalizar a menu");
		System.out.println("Digite a opcao desejada:");
	}

	public static void main(String[] args) throws Exception {
		String entrada, placa;
		int kmAtual;
		double valorVenda;
		Boolean isAtivo = true;
		String caminhoArquivo = "C:/Offline/dados.dat";

		Frota frota = new Frota();
		Veiculo veic;

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
							kmAtual = 0;

							System.out.println("Qual tipo de veículo será incluído: ");
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
							System.out.println("Plc: " + novo.getPlaca());
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
							veic = frota.localizaVeiculo(placa);

							System.out.println("Digite a distância da rota");
							String distancia = ler.nextLine();
							Double distdoub = Double.parseDouble(distancia);

							System.out.println("Escolha o combustível que será usado");
							for (int i = 0; i < veic.tanque.getCombustiveis().size(); i++)
								System.out.println(i + " - " + veic.tanque.getCombustiveis().get(i));
							String escolha = ler.nextLine();
							int escol = Integer.parseInt(escolha);
							Combustivel combust = (Combustivel) veic.tanque.getCombustiveis().get(escol);

							veic.addRota(distdoub, combust);
							System.out.println("Combustivel restante: " + veic.tanque.getQuantAtual());
							veic.imprimeRotas();

						} catch (Exception erro) {
							System.out.println(erro.getMessage());
						}
						break;

					case 5:
						try {

							System.out.println("Digite a placa do veículo:");

							placa = ler.nextLine();
							veic = frota.localizaVeiculo(placa);
							// System.out.println("Placa: " + veic.getPlaca() + " - Valor IPVA: " + veic.valorIpva()
							// 		+ " - Valor Seguro:  " + veic.valorSeguro() + " - Custo Eventual" veic.valorCustoEventual() +
							// 		+ " - Outros Custos: " /* + veic.custoTotal() */);

							frota.imprimirRelatorio();


							System.out.println("Rotas do veiculo: ");
							veic.imprimeRotas();

						} catch (Exception erro) {
							System.out.println(erro.getMessage());
						}
						break;

					case 6:
						try {
							frota.imprimirRelatorioCompleto();
						} catch (Exception erro) {
							System.out.println(erro.getMessage());
						}
						break;

					case 7:
						System.out.println("Digite a placa do veículo: ");
						frota.imprimirRelatorio();
						placa = ler.nextLine();
						try {
							veic = frota.localizaVeiculo(placa);

							System.out.println("Informe o valor do custo");
							String valorCustoEventual = ler.nextLine();
							Double distdoub = Double.parseDouble(valorCustoEventual);

							veic.addCusto(distdoub, "custo eventual");
							System.out.println("O custo eventual foi adicionado");
							frota.imprimirRelatorioCompleto();

						} catch (Exception erro) {
							System.out.println(erro.getMessage());
						}
						break;

					case 8:
						for (Combustivel c : Combustivel.values()) {
							System.out.println(c.getDescricao());
						}
						break;

					case 9:
						System.out.println("Escolha qual resposta estratégica: ");
						System.out.println("1. A quilometragem média de todas as rotas da empresa");
						System.out.println("2. Os 3 veículos que mais fizeram rotas");
						System.out.println("3. Lista de veículos ordenada decrescentemente por custos gerados");
						System.out.println("4. Filtro para busca de rotas por data.");

						entrada = ler.nextLine();

						Object jLabelDia;
						switch (Integer.parseInt(entrada)) {
							case 1:
								frota.mediaConsumoRotas();
								break;

							case 2:
								frota.imprimeTresMaiores();
								break;

							case 3:
								frota.listaDecrescenteCusto();
								break;

							case 4:
								frota.imprimirRotas();

								DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
								System.out.println("Digite uma data para filtrar as rotas - fomato aaaa-mm-dd: ");
								entrada = ler.nextLine();
								LocalDate date = LocalDate.parse(entrada, formatter);
								System.out.println(date);

								frota.filtrarFrotaPorData(date);
								break;

							default:
								System.out.println("modelo inválido");
								break;
						}
						break;

					case 10:
						isAtivo = false;
						System.out.println("Finalizado!");
						break;

					default:
						System.out.println("Comando inválido");
						break;

				}
			}
		}
	}
}