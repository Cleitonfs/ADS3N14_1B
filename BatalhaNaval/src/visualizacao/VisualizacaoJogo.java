package visualizacao;

import controle.Tabuleiro;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Retorno;
import modelo.Jogo;
import uteis.Funcoes;

/**
 *
 * @author Lucas Pacheco Oliveira
 */
public class VisualizacaoJogo {
    
    private Jogo jogo;
    Tabuleiro tabuleiro;

    public VisualizacaoJogo() {
        this.jogo = new Jogo();
        this.tabuleiro = new Tabuleiro();
    }
    
    public int retornaNumAlfabeto(String letra) {
        ArrayList<String> letras = Funcoes.listaAlfabeto();
        return letras.indexOf(letra);
    }
    
    public void escreveTabueiro(Tabuleiro tabuleiro, boolean disistiu) {
        StringBuilder strLinha = new StringBuilder();
        ArrayList<ArrayList<String>> tab = tabuleiro.getTabuleiro();
        
        System.out.println("   A  B  C  D  E  F  G  H  I  J");
        for(int i=0;i<tab.size();i++){
            strLinha.append(i);
            strLinha.append("  ");
            for(int j=0;j<tab.get(i).size();j++){
                if(tab.get(i).get(j).equals("-")||tab.get(i).get(j).equals("O")) {
                    strLinha.append(tab.get(i).get(j));
                } else {
                    strLinha.append(tab.get(i).get(j));
                }
                strLinha.append("  ");
            }
            System.out.println(strLinha.toString());
            strLinha = new StringBuilder();
        }
        
    }

    private String solicitaPosicaoUsuario() {
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.println("Digite a posição para a próxima jogada: ");
        String coordenada = entradaUsuario.next();
        if(coordenada.equals("sair")) {
            System.out.println("Você desistiu com : "+jogo.getPontuacao()+" pontos.");
            System.exit(0);
        }
        return coordenada;
    }
    
    public static void main(String[] args) {
        
        VisualizacaoJogo vJogo = new VisualizacaoJogo();
        vJogo.tabuleiro.inicia();
        String coordenadaUsuario = "";
        
        while(vJogo.jogo.getPontuacao()>0&&!vJogo.tabuleiro.fim()) {
            vJogo.escreveTabueiro(vJogo.tabuleiro, false);
            coordenadaUsuario = vJogo.solicitaPosicaoUsuario();
            Retorno jogada = vJogo.tabuleiro.joga(coordenadaUsuario, vJogo.jogo);
            System.out.println(jogada.getTipo()+" - "+jogada.getMensagem()+" - pontuação: ["+vJogo.jogo.getPontuacao()+"].");
        }
        
        vJogo.escreveTabueiro(vJogo.tabuleiro, true);
        if(vJogo.jogo.getPontuacao()>0) {
            System.out.println("Você ganhou com "+vJogo.jogo.getPontuacao()+" pontos.");
        } else {
            System.out.println("Você perdeu. Looser");
        }
        
    }
    
}
