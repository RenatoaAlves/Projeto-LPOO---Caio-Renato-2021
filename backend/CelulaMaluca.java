package backend;
import java.util.Random;

public class CelulaMaluca extends Celula {
	
	private int nivelMaluquice = 0;
	
	Random aleatorio = new Random();
	
	public CelulaMaluca() {
		
	}
	
	//celula maluca com caracteristicas de bomba
	public CelulaMaluca(boolean minada) {
		this.setMinada(minada);
	}
	
	
	//definir a probabilidade maluca do celula
	public void setNivelMaluquice(int nivelMaluquice) {
		this.nivelMaluquice = nivelMaluquice;
	}
	
	//descobrir o nivel de maluquice da celula
	public int getNivelMaluquice() {
		return nivelMaluquice;
	}
	
	

	
	
	
}
