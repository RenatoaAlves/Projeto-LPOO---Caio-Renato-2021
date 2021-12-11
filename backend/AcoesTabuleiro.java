package backend;

public interface AcoesTabuleiro {

	void criarCampo();
	
	int bandeirasRestantes();
	
	int contarMinas(int i);

	void colocarBandeira(Celula celula);
	
	void clicar(Celula celula);
	
	void adicionarCelulas();
}
