import java.util.Random;

public class Tabuleiro extends Celula {
    
    private int valor;
    private boolean mapa[][] = new boolean[10][10];

    Random aleatorio = new Random();
    
    
    
    //preenche o mapa
    public void setValor(){
        for (int i = 0; i < 10; i++) {
            for(int j = 0; j<10; j++) {
                 if(aleatorio.nextInt(100) %6==0) {
                        mapa[i][j] = true;
                    }
                    else {
                        mapa[i][j] = false;
                        temBomba();
                    }
            }
            
        }
    
        
    }
    
    
    
    //testar se há bombas por perto
    public int temBomba() {
        
        int contador = 0;
        
        for (int i = 1; i < 9; i++) {
            for(int j = 1; j<9; j++) {
            
                
                if(mapa[i-1][j-1] == true){
                    contador++;
                }
                if(mapa[i+1][j+1]==true) {
                    contador++;
                }
                if(mapa[i][j-1] == true) {
                    contador++;
                }
                if(mapa[i][j+1]==true) {
                    contador++;
                }
                if(mapa[i-1][j+1]==true) {
                    contador++;
                }
                if(mapa[i+1][j-1]==true) {
                    contador++;
                }
                if(mapa[i+1][j]==true) {
                    contador++;
                }
                if(mapa[i-1][j]==true) {
                    contador++;
                }    
                
                
            }
            
        }
        
        return contador;
            
    }

    

}
