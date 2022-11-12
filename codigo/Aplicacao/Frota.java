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


	// public ArrayList<Rota> localizarRotasPorData(LocalDate data){
    //     ArrayList<Rota> aux1 = new ArrayList<Rota>();
    //     for(Veiculo veiculo:veiculos){
    //         veiculo.getRota().stream()
    //         .filter(rote -> rote.getData().equals(data))
    //         .forEach(rote -> aux1.add(rote));
    //     }
    //     return aux1;
    // }
    // public List<Veiculo> ordenarCustosDecrescentes() {
    //     List<Veiculo> list = new ArrayList<Veiculo>(veiculos);

    //     list.sort((veiculo1, veiculo2) -> veiculo2.compareTo(veiculo1));
        
    //     return list;
    // }
    
    // public List<Veiculo> veiculosComMaisRotas() {
    // 	List<Veiculo> list = new ArrayList<Veiculo>(veiculos);
    	
    // 	list.sort((veiculo1, veiculo2) -> veiculo2.compararRotas(veiculo1));
    	
    // 	return list.subList(0, 3);
    // }

}
