//package Main;

import java.util.Scanner;

public class Aplicacao {
  
    public static void menu() {
		System.out.println("\n\tMenu:");
		System.out.println("1. Carregar um conjunto de veículos de um arquivo");
		System.out.println("2. Salvar um conjunto de veículos de um arquivo");
		System.out.println("3. Incluir um novo veículo ");
		System.out.println("4. Incluir rotas para um veículo");
		System.out.println("5. Localizar um veículo da frota");
		System.out.println("6. Imprimir um relatório do veículo com seus gastos até o momento");
		System.out.println("7. Finalizar a menu");
		System.out.println("Digite a opcao desejada:");
	}

    public static void main(String[] args) throws Exception {
        //ListaEncadeada minhaLista;
		//Compromisso novo, removido;
		String data, tarefa, num, strRepeticoes;
		Integer i = 0, repeticoes;
		Boolean isAtivo = true;

		Frota frota = new Frota();

		//minhaLista = new ListaEncadeada();

		try (Scanner ler = new Scanner(System.in)) {
			while (isAtivo) {
				menu();

				num = ler.nextLine();

				switch (Integer.parseInt(num)) {
//Carregar um conjunto de veículos de um arquivo
				case 1:
				String caminhoArquivo = "leitura.txt";
				try {
					ArquivoTextoLeitura leitura = new ArquivoTextoLeitura(caminhoArquivo);
				} catch (Exception erro) {
					System.out.println(erro.getMessage());
				}
				break;
					
					// while (!linhaTeclado.equals("FIM")) {
					// 	numeroDeSeriesTeclado++;
			
					// 	for (i = 0; i < numeroDeSeriesEntrada - 2; i++) {
					// 		if (minhaSerie[i].getNome().equals(linhaTeclado)) {
					// 			novaSerie = new Serie();
					// 			novaSerie = minhaSerie[i];
					// 			//novaLetra = novaSerie.getNome().charAt(0);
					// 			//novoCaractere.setValor(novaLetra);
					// 			try {
					// 				minhaArvoreSerie.inserir(novaSerie);
									
			
					// 			} catch (Exception erro) {
					// 				System.out.println(erro.getMessage());
					// 			}
					// 		}
					// 	} // fim for
					// 	linhaTeclado = entradaTeclado.nextLine();
					// } // fim while
					
					//break;

				case 2:
					try {
//						frota.salvarVeiculo("nome do arquivo");
					} catch (Exception erro) {
						System.out.println(erro.getMessage());
					}
					break;

				case 3:
					try {
						System.out.println("que tipo de veículo será incluído: ");
						System.out.println("1. Carro");
						System.out.println("2. Caminhão");
						System.out.println("3. Van");
						System.out.println("4. Furgão");

						num = ler.nextLine();

						switch (Integer.parseInt(num)) {
							case 1:
							Carro carro = new Carro("ABC", 5000.0, 10000);
							frota.addVeiculo(carro);
							frota.imprimir();
							break;

							case 2:
							Caminhao caminhao = new Caminhao("DEF", 5000.0, 20000);
							frota.addVeiculo(caminhao);
							frota.imprimir();
							break;

							case 3:
							Van van = new Van("GHI", 5000.0, 10000);
							frota.addVeiculo(van);
							frota.imprimir();
							break;

							case 4:
							Furgao furgao = new Furgao("JKL", 5000.0, 20000);
							frota.addVeiculo(furgao);
							frota.imprimir();
							break;

							default:
							System.out.println("modelo inválido");
							break;
						}

					} catch (Exception erro) {
						System.out.println(erro.getMessage());
					}
					break;
				case 4:
						
						try {
							// ?????
//							frota.localizaVeiculo("ABC");
//							frota.addRota(null);
							
						} catch (Exception erro) {
							System.out.println(erro.getMessage());
						}
						
					

					break;
					
				case 5:
					
					try {
//						NAO FUNCIONANDO
//						frota.localizaVeiculo("ABC");
						
					} catch (Exception erro) {
						System.out.println(erro.getMessage());
					}
					
					break;
				case 6:
					
					try {
						//frota.imprimir();
					} catch (Exception erro) {
						System.out.println(erro.getMessage());
					}
					
					break;
					
				case 7:
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

