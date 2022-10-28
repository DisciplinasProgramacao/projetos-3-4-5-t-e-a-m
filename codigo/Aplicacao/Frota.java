import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class Frota{
	LinkedList<Veiculo> veiculos;
	public Frota(){
		veiculos = new LinkedList<Veiculo>();
	}

	public void carregarVeiculo(String nomeArquivo) {

	ObjectInputStream ois = null;
	FileInputStream fis = null;
	try {
		//ArquivoTextoLeitura leitura = new ArquivoTextoLeitura(caminhoArquivo);
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
	
	public boolean addVeiculo(Veiculo veiculo) {
		this.veiculos.addLast(veiculo);
		return true;
	}

	
	public Veiculo localizaVeiculo(String placaProcurar) throws Exception {
		
		for(Veiculo veiculo : veiculos) {
			if(placaProcurar.equals(veiculo.getPlaca())) {
				return veiculo;
			}
		}
		throw new Exception("Placa não encontrada");
	}

	public void imprimirRelatorio() {
		for(int i=0; i<veiculos.size(); i++){
			System.out.println(i + " - Placa: " + veiculos.get(i).getPlaca() + " - Valor IPVA: " + veiculos.get(i).valorIpva()+ " - Valor Seguro:  " 
		+ veiculos.get(i).valorSeguro()+ " - Outros Custos: " + veiculos.get(i).outrosCustos() );
		}
	}

}
