package modelo;

/**
 *
 * @author Lucas Pacheco Oliveira
 */
public class Jogo {
    
    int pontuacao = 15; 

    public int getPontuacao() {
        return this.pontuacao;
    }
    
    
    public void acertouNavio() {
        pontuacao+=5;
    }
    
    public void acertou() {
        pontuacao+=3;
    }
    
    public void errou(){
        pontuacao--;
    }
    
}
