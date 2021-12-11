package backend;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;


public class Celula extends JButton{

	private int tipo;
	private boolean minada;
	private boolean bandeira;
	private boolean descoberta;
	private boolean alerta;
	private int posicao;
	private boolean explosao;
	private Tabuleiro tabuleiro;
    
    
    public Celula(int posicao) {
    	setTipo(0);
    	this.posicao = posicao;
    	this.tabuleiro = new Tabuleiro();
    	
    	addMouseListener(new MouseListener(){
    		
			public void mouseClicked(MouseEvent e) {
				if(SwingUtilities.isLeftMouseButton(e)) {
					clique();
				}
				else {
					cliqueDireito();
				}
				
				
			}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
    		
    	});

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
	
	public int getPosicao() {
		return posicao;
	}
	
	public void clique() {
		tabuleiro.clicar(this);
	}
	
	public void cliqueDireito() {
		tabuleiro.colocarBandeira(this);
	}
	
	public void setExplosao() {
		this.explosao = true;
	}
	
	public boolean getExplosao() {
		return explosao;
	}


	public int getNumBombasVizinhas() {
		return 0;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public int getTipo() {
		return tipo;
	}



	
	
 

    
    
    
    
}
