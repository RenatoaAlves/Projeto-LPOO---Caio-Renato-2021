package backend;

public class AlertaMaluca extends CelulaMaluca {
	

	public AlertaMaluca(int posicao, int tipo, int contarMinas) {
		super(posicao, tipo);
		setNumBombasVizinhas(contarMinas);
		setTipo(2);
	}


}
