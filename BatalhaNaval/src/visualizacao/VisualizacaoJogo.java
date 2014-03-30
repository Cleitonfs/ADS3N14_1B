package visualizacao;

import controle.Tabuleiro;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Erro;
import modelo.Jogo;
import uteis.Funcoes;

/**
 *
 * @author Lucas Pacheco Oliveira
 */
public class VisualizacaoJogo {
    
    private Jogo jogo;

    public VisualizacaoJogo() {
        this.jogo = new Jogo();
    }
    
    public int retornaNumAlfabeto(String letra) {
        ArrayList<String> letras = Funcoes.listaAlfabeto();
        return letras.indexOf(letra);
    }
    
    public void escreveTabueiro(Tabuleiro tabuleiro) {
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
                    strLinha.append(".");
                }
                strLinha.append("  ");
            }
            System.out.println(strLinha.toString());
            strLinha = new StringBuilder();
        }
        
    }

    private String solicitaPosicaoUsuario() {
        Scanner entradaUsuario = new Scanner(System.in);
        String coordenada = "";        
        System.out.println("Digite a posição para a próxima jogada: ");
        coordenada = entradaUsuario.nextLine();
        entradaUsuario.close();
        
        if(coordenada.equals("sair")) {
            System.out.println("Você desistiu com : "+jogo.getPontuacao()+" pontos.");
            System.exit(0);
        }
        
        return coordenada;
    }
    
    public static void main(String[] args) {
        Tabuleiro tabuleiro = new Tabuleiro();
        tabuleiro.inicia();
        
        VisualizacaoJogo jogo = new VisualizacaoJogo();
        jogo.escreveTabueiro(tabuleiro);
        String coordenadaUsuario = jogo.solicitaPosicaoUsuario();
        
        Erro jogada = tabuleiro.joga(coordenadaUsuario);
        if(jogada!=null){
            System.out.println("Erro: \n"+jogada.getMensagem());
        }
        
    }
    
}
