package backend;

public class CelulaVazia extends Celula{
	
	public CelulaVazia(int posicao) {
		super(posicao);
		setMinada(false);
		setTipo(1);
	}
	
	public CelulaVazia(int posicao, boolean aberta) {
		super(posicao);
		setMinada(false);
		setTipo(1);
		setDescoberta(aberta);
	}
	

	
	
	
}
