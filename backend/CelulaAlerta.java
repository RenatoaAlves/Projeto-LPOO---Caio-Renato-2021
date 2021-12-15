package backend;

public class CelulaAlerta extends Celula {
	
	
	private int numBombasVizinhas;
	
	public CelulaAlerta(int posicao) {
		super(posicao);
		setAlerta(true);
	}
	
	public CelulaAlerta(int posicao, int numBombasVizinhas) {
		super(posicao);
		this.numBombasVizinhas = numBombasVizinhas;
		setTipo(2);
	}
	
	public CelulaAlerta(int posicao, int numBombasVizinhas, boolean aberta) {
		super(posicao);
		this.numBombasVizinhas = numBombasVizinhas;
		setTipo(2);
		setDescoberta(aberta);
	}
	
	
	

	public int getNumBombasVizinhas() {
		return numBombasVizinhas;
	}
	
	public void setNumBombasVizinhas(int numBombasVizinhas) {
		this.numBombasVizinhas = numBombasVizinhas;
	}
	

}
