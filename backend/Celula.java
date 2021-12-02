package backend;

//import javax.swing.*;

public abstract class Celula{
    

	private boolean minada;
    private boolean bandeira;
    private boolean descoberta;
    private boolean alerta;
    
    public Celula() {
    	
    }
    
    public Celula(boolean minada, boolean bandeira, boolean descoberta, boolean alerta) {
		this.minada = minada;
		this.bandeira = bandeira;
		this.descoberta = descoberta;
		this.alerta = alerta;
	}
    
    
    //define o estado da celula
    public void setMinada(boolean minada) {
        if(minada == true) {
            this.minada = true;
        }
        else {
            this.minada = false;
        }
    }
    
    
    //retorna estado da celula
    public boolean getMinada() {
        return minada;
    }
    
    
    
    //define a existencia da bandeira
    public void setBandeira(boolean bandeira) {
    	this.bandeira = bandeira;
    }
    
    //retorna a existencia da bandeira
    public boolean getBandeira() {
    	return bandeira;
    }
    
    
    
    //status de abertura da celula
    public void setDescoberta(boolean descoberta) {
    	this.descoberta = descoberta;
    }
    
    //retorna o status
    public boolean getDescoberta() {
    	return descoberta;
    }
    
    //ativa o alerta da celula alerta
    public void setAlerta(boolean alerta) {
    	this.alerta = alerta;
    }
    
    //descobre o status alerta da celula
    public boolean getAlerta() {
    	return alerta;
    }

	public int getNivelMaluquice() {
		return 0;
	}

 

    
    
    
    
}