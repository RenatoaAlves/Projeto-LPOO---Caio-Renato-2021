package backend;

public class CelulaAlerta extends Celula {
	
	
	private int numBombasVizinhas;
	
	public CelulaAlerta(int posicao) {
		super(posicao);
		setAlerta(true);
		setTipo(2);
	}
	
	public CelulaAlerta(int posicao, int numBombasVizinhas) {
		super(posicao);
		this.numBombasVizinhas = numBombasVizinhas;
	}
	

	public int getNumBombasVizinhas() {
		return numBombasVizinhas;
	}
	

}
