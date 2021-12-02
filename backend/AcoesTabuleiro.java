package backend;

public interface AcoesTabuleiro {

	void criarCampo();
	
	void colocarBandeira(int posicao);
	
	int contarMinas(int i);
}
