public class Tanque {

    private int capacidade;
    private float quantAtual;
    



    public double autonomiaMaxima() {
		return (kmPorLitro * capacidade);
	}
}
