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
    
    public void acertou() {
        pontuacao++;
    }
    
    public void errou(){
        pontuacao--;
    }
    
}
