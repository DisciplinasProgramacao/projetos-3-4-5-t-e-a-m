package Main;
import java.util.List;

public class Frota {
	List<Veiculo> veiculo;

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
		Veiculo[] veic = new Veiculo[veiculo.size()];
        veiculo.allElements(veic);
        ArquivoTextoEscrita arq = new ArquivoTextoEscrita(nomeArquivo);

        for(int i=0; i<veiculo.size(); i++){
            for(int j=0; j<veiculo.size(); j++){
                // if(ver[i].arestaApontandoPara(j) != null){
                    System.out.println(i + ";" + j);
                    arq.escrever(i + ";" + j);
                //}
            }
        }
        arq.fecharArquivo();
    }
	

	public void addVeiculo() {

	}

	public void addRota(int rota) {

	}

	public Veiculo localizaVeiculo(int placa) {
		return null;

	}

	public void imprime() {

	}

}

