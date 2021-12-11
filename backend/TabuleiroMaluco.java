import java.util.Random;
import java.util.ArrayList;

public class TabuleiroMaluco implements AcoesTabuleiro{



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
				mapa.add(new CelulaMaluca(true));
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
					mapa.add(new CelulaMaluca());
				}
			}
		}
		
		
}
	
	public void colocarBandeira(int posicao) {
		mapa.get(posicao).setBandeira(true);
	}
	
	//ativar celulas malucas de acordo com o nivel de maluquice setado
	public void setProbabilidade(int index) {
		int num = aleatorio.nextInt(10);
		if((mapa.get(index).getMinada() == false)&&(mapa.get(index).getBandeira()) == true && mapa.get(index).getNivelMaluquice() == 1
				&& num == 8) {
			mapa.get(index).setMinada(true);
			posicaoBombas.add(index);
		}
		if((mapa.get(index).getMinada() == false)&&(mapa.get(index).getBandeira()) == true && mapa.get(index).getNivelMaluquice() == 2
				&& num == 8 || num == 3 || num == 0) {
			mapa.get(index).setMinada(true);
			posicaoBombas.add(index);
		}
		if((mapa.get(index).getMinada() == false)&&(mapa.get(index).getBandeira()) == true && mapa.get(index).getNivelMaluquice() == 3
				&& num == 8 || num == 3 || num == 0 || num == 5) {
			mapa.get(index).setMinada(true);
			posicaoBombas.add(index);
		}
		if((mapa.get(index).getMinada() == true)&&(mapa.get(index).getBandeira()) == true && mapa.get(index).getNivelMaluquice() == 1
				&& num == 8) {
			mapa.get(index).setMinada(false);
			posicaoBombas.remove(Integer.valueOf(index));
		}
		if((mapa.get(index).getMinada() == true)&&(mapa.get(index).getBandeira()) == true && mapa.get(index).getNivelMaluquice() == 2
				&& num == 8 || num == 3 || num == 0) {
			mapa.get(index).setMinada(false);
			posicaoBombas.remove(Integer.valueOf(index));
		}
		if((mapa.get(index).getMinada() == true)&&(mapa.get(index).getBandeira()) == true && mapa.get(index).getNivelMaluquice() == 3
				&& num == 8 || num == 3 || num == 0 || num == 5) {
			mapa.get(index).setMinada(false);
			posicaoBombas.remove(Integer.valueOf(index));
		}
		
		
		recarregarMapa();

	}
	
	
	//recarregar o mapa apos ativar a celula maluca
	public void recarregarMapa() {
		for(int i = 0; i<tamMapa;i++) {
			if(mapa.get(i).getMinada()==true) {
				
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
			}
		}
		
		
}
	//contar o numero de minas adjacentes para adicionar o valor � celula alerta
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
