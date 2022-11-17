import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
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

	public void mediaConsumoRotas() {
		Veiculo aux;
		double sum = 0;
		int auxsum = 0;
		for(int i=0; i<veiculos.size(); i++){
			aux = veiculos.get(i);
			for(int j=0; j<aux.getRotas().size(); j++){
				sum += aux.getRotas().get(j).getDistanciaTotal();
				auxsum++;
			}
		}
		System.out.println("Media de todas as rotas: " + sum/auxsum);
	}


	public void imprimeTresMaiores() {
		
		LinkedList<Veiculo> tresMaiores;
		Veiculo maior = veiculos.get(0);
		Veiculo medio = veiculos.get(0);
		Veiculo menor = veiculos.get(0);
		
		for(Veiculo veiculo : veiculos) {
			if(veiculo.getNumRotas() > maior.getNumRotas()) {
				
				menor = medio;
				medio = maior;
				maior = veiculo;
				
			}else if(veiculo.getNumRotas() > medio.getNumRotas()) {
				
				menor = medio;
				medio = veiculo;				
				
			}else if(veiculo.getNumRotas() > menor.getNumRotas()) {
				menor = veiculo;
				
			}
		}
		
		System.out.println(" 1: " + maior.getPlaca());
		System.out.println(" 2: " + medio.getPlaca());
		System.out.println(" 3: " + menor.getPlaca());
		
	}

	
	
	
	
	
	
	
//public Veiculo filtrarFrotaPorData(LocalDate date) throws Exception {
//		
//		for(Veiculo veiculo : veiculos) {
//			if(date.equals(veiculo.getClass())) {
//				return veiculo;
//			}
//		}
//		throw new Exception("Data não encontrada");
//	}

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
