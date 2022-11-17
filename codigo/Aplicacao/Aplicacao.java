
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
		System.out.println("7. Finalizar a menu");
		System.out.println("8. Testar classe enumerada");
		System.out.println("9. Respostas estratégicas");
		System.out.println("Digite a opcao desejada:");
	}

	public static void main(String[] args) throws Exception {
		String entrada, placa;
		int kmAtual;
		double valorVenda;
		Boolean isAtivo = true;
		// ADICIONAR CAMINHO PARA O ARQUIVO LOCAL .DAT
		/// projeto3-t-e-a-m/projetos-3-4-5-t-e-a-m/codigo/Aplicacao/dados.dat
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
							System.out.println("Qual a quilometragem do veículo?: ");
							entrada = ler.nextLine();
							kmAtual = Integer.parseInt(entrada);
							
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
						//Veiculo veic;
						try {
							veic = frota.localizaVeiculo(placa);
							System.out.println("Digite a distância da rota");
							String distancia = ler.nextLine();
							Double distdoub = Double.parseDouble(distancia);
							
							//verificar se está dentro da autonomia(ou não, isso já é tratado em outro lugar)
							//veic.addRota(1000, null);
							//veic.imprimeRotas();
	
							System.out.println("Escolha o combustível que será usado");
							for(int i=0; i<veic.tanque.getCombustiveis().size(); i++)
								System.out.println(i + " - " + veic.tanque.getCombustiveis().get(i));

							String escolha = ler.nextLine();
							int escol = Integer.parseInt(escolha);
							Combustivel combust = (Combustivel)veic.tanque.getCombustiveis().get(escol);

							veic.addRota(distdoub, combust);
							System.out.println("Combustivel restante: " + veic.tanque.getQuantAtual());
							veic.imprimeRotas();

						//System.out.println("Escolha o combustível que será usado");
						
						// try {
						// 	Veiculo veic = frota.localizaVeiculo(placa);
						// 	//terceiro null eh de combustivel
						// 	veic.addRota(1000, null, null);
						// 	veic.imprimeRotas();

						} catch (Exception erro) {
							System.out.println(erro.getMessage());
						}

						break;

					case 5:

						try {

							System.out.println("Digite a placa do veículo:");

							placa = ler.nextLine();
							veic = frota.localizaVeiculo(placa);
							System.out.println("Placa: " + veic.getPlaca() + " - Valor IPVA: " + veic.valorIpva()
									+ " - Valor Seguro:  " + veic.valorSeguro() + " - Outros Custos: " /*+ veic.custoTotal()*/);

							System.out.println("Rotas do veiculo: ");
							veic.imprimeRotas();

							
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
							
							break;

						case 3:
							
							break;

						case 4:
						
						
						//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						// Veiculo veic = new Veiculo(null,null, null, null, null);
						// //veic.imprimeRotas();
						// System.out.println("Digite uma data para filtrar as rotas");
						// entrada = ler.nextLine();
					    
						// LocalDate date = LocalDate.parse(entrada,formatter);
						
						//  System.out.println(date);
						
						// veic.filtrarRotasPorData(date);
							
							break;

						default:
							System.out.println("modelo inválido");
							break;
					}
						
						break;
					
					default:

						System.out.println("Comando inválido");
						break;


				}

			}
		}
	}


}