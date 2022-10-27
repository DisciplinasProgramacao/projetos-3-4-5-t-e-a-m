//package Main;
import java.util.LinkedList;
import java.util.List;

public class Frota {
	//List<Veiculo> veiculo;
//	private Veiculo[]veiculos;
//	private Rota[]rotas;
	LinkedList<Veiculo> veiculos;
	public Frota(){
//		veiculos = new Veiculo[5];
//		rotas = new Rota[5];
		veiculos = new LinkedList<Veiculo>();
	}

	public void carregarVeiculo(String nomeArquivo) {

		ArquivoTextoLeitura arq = new ArquivoTextoLeitura(nomeArquivo);
		String linha = arq.ler();
		while (linha != null) {

			String[] arquivo = linha.split(";");
			// int id1 = Integer.parseInt(arquivo[0]);
			// int id2 = Integer.parseInt(arquivo[1]);

			linha = arq.ler();
		}

		arq.fecharArquivo();
	}

	public void salvarVeiculo(String nomeArquivo) {
//		Veiculo[] veic = new Veiculo[veic.length];
//        veic.allElements(veic);
        ArquivoTextoEscrita arq = new ArquivoTextoEscrita(nomeArquivo);

//        for(int i=0; i<veic.length; i++){
//            for(int j=0; j<veic.length; j++){
//                // if(ver[i].arestaApontandoPara(j) != null){
//                    System.out.println(i + ";" + j);
//                    arq.escrever(i + ";" + j);
//                //}
//            }
//        }
        arq.fecharArquivo();
    }
	
//MUDANÇA
	public boolean addVeiculo(Veiculo veiculo) {
//		int cont = 0;
//		 if(cont < this.veiculos.length) {
//	            this.veiculos[cont++] = veiculo;
//	            return true;
//	        }
//	        
//	        return false;
		this.veiculos.addLast(veiculo);
		return true;
	}

	public boolean addRota(Rota rota) {
//		int cont = 0;
//		 if(cont < this.rotas.length) {
//	            this.rotas[cont++] = rota;
//	            return true;
//	        }
//	        
	        return false;
		
	}
	
//Colocar recebendo por parâmetro String placaProcurar, vindo de aplicacao ?
	public Veiculo localizaVeiculo(String placa) {
		
		//Abre arquivo
		//le todas as placas do arquivo
		//se a placa do arquivo for igual a que deseja, retona dados do veiculo
		
		return null;

	}

	public void imprimir() {
		for(int i=0; i<veiculos.size(); i++){
			System.out.println(i + ". " + veiculos.get(i).getPlaca());
		}

	}

}

