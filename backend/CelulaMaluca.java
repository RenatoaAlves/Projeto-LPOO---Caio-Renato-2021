package backend;

import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;


public class CelulaMaluca extends Celula {
    
    private int numBombasVizinhas;
    private TabuleiroMaluco tabuleiroMaluco;
    
    
    
    public CelulaMaluca(int posicao, int tipo) {
        super(posicao);
        this.tabuleiroMaluco = new TabuleiroMaluco();
        setTipo(tipo);

    }
    
    
    public void clique() {
        tabuleiroMaluco.clicar(this);
    }
    
    public void cliqueDireito() {
        tabuleiroMaluco.colocarBandeira(this);
    }
    
    
    public void setNumBombasVizinhas(int num) {
        this.numBombasVizinhas = num;
    }
    
    public int getNumBombasVizinhas() {
        return numBombasVizinhas;
    }
    
    
}
