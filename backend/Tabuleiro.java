package backend;
import java.util.Random;
import java.util.ArrayList;

public class Tabuleiro implements AcoesTabuleiro{



	private ArrayList<Celula> mapa = new ArrayList<>();
	private ArrayList<Integer> posicaoBombas = new ArrayList<>();
	private int numBombas = 7;
	//private int bandeiras = numBombas;
	private int tamMapa = 99;
	private int tamLinha = 10;
	

		
	Random aleatorio = new Random();
	
	
	//preencher o mapa
	public void criarCampo() {
		
		//gerar numeros aleatorios sem repeticao
		while(posicaoBombas.size()<numBombas) {
			int index = aleatorio.nextInt();
			if(!posicaoBombas.contains(index)) {
				posicaoBombas.add(index);
			}

		}
		for(int i = 0; i<tamMapa;i++) {
			if(posicaoBombas.contains(i)) {
				mapa.add(new Bomba());
			}
			else if(i%tamLinha == 0){
				if(posicaoBombas.contains(i-tamLinha+1)||
					posicaoBombas.contains(i-tamLinha)||
					posicaoBombas.contains(i+tamLinha)||
					posicaoBombas.contains(i+tamLinha+1)||
					posicaoBombas.contains(i+1)){
					
					mapa.add(new CelulaAlerta(contarMinas(i)));
				}
			}
			else if(i%tamLinha==9){
				if(posicaoBombas.contains(i-tamLinha-1) ||
					posicaoBombas.contains(i-tamLinha)||
					posicaoBombas.contains(i+tamLinha)||
					posicaoBombas.contains(i+tamLinha-1)||
					posicaoBombas.contains(i-1)) {
					
					mapa.add(new CelulaAlerta(contarMinas(i)));
				}
			}
			else {
				if(posicaoBombas.contains(i-tamLinha-1) ||
					posicaoBombas.contains(i-tamLinha+1)||
					posicaoBombas.contains(i-tamLinha)||
					posicaoBombas.contains(i+tamLinha)||
					posicaoBombas.contains(i+tamLinha-1)||
					posicaoBombas.contains(i+tamLinha+1)||
					posicaoBombas.contains(i+1)||
					posicaoBombas.contains(i-1)) {
					
					mapa.add(new CelulaAlerta(contarMinas(i)));
				}
				else {
					mapa.add(new CelulaVazia());
				}
			}
		}
		
}
	public void colocarBandeira(int posicao) {
		mapa.get(posicao).setBandeira(true);
	}
	
	public int contarMinas(int i) {
		int contador = 0;
		if(i%tamLinha == 0){
			if(posicaoBombas.contains(i-tamLinha+1)) contador++;
			if(posicaoBombas.contains(i-tamLinha)) contador++;
			if(posicaoBombas.contains(i+tamLinha)) contador++;
			if(posicaoBombas.contains(i+tamLinha+1)) contador++;
			if(posicaoBombas.contains(i+1)) contador++;
			}
		
		else if(i%tamLinha==9){
			if(posicaoBombas.contains(i-tamLinha-1)) contador++;
			if(posicaoBombas.contains(i-tamLinha)) contador++;
			if(posicaoBombas.contains(i+tamLinha)) contador++;
			if(posicaoBombas.contains(i+tamLinha-1)) contador++;
			if(posicaoBombas.contains(i-1)) contador++;
		
		}
		else {
			if(posicaoBombas.contains(i-tamLinha-1)) contador++;
			if(posicaoBombas.contains(i-tamLinha+1)) contador++;
			if(posicaoBombas.contains(i-tamLinha)) contador++;
			if(posicaoBombas.contains(i+tamLinha)) contador++;
			if(posicaoBombas.contains(i+tamLinha-1)) contador++;
			if(posicaoBombas.contains(i+tamLinha+1)) contador++;
			if(posicaoBombas.contains(i+1)) contador++;
			if(posicaoBombas.contains(i-1)) contador++;
			}
		return contador;
	}


		

	

	

}
