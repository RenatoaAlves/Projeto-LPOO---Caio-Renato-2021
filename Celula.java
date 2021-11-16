 /*
 * Essa é a parte 9 e 10 
 * do projeto
 * 
 */
public class Celula {
    
    private boolean minada;
    
    //define o estado da celula
    public void temMina(boolean minada) {
        if(minada == true) {
            this.minada = true;
        }
        else {
            this.minada = false;
        }
    }
    
    
    //retorna estado da celula
    public boolean estadoCelula() {
        return minada;
    }
    
    
    
    
}
