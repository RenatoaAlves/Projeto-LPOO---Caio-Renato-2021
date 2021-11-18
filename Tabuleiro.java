import java.util.Random;

public class Tabuleiro extends Celula {
	
	private int valor;
	private boolean mapa[][] = new boolean[10][10];

	Random aleatorio = new Random();
	
	public void setValor(){
		for (int i = 0; i < 10; i++) {
			for(int j = 0; j<10; j++) {
				 if(aleatorio.nextInt(100) %6==0) {
		            	mapa[i][j] = true;
		            }
		            else {
		            	mapa[i][j] = false;
		            }
			}
			
        }
		

		
	}
	

	
	

}
