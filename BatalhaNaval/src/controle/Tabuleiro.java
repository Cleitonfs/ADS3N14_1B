package controle;

import modelo.Navios;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.Random;
import modelo.Erro;
import uteis.Funcoes;
import visualizacao.VisualizacaoJogo;

/**
 *
 * @author Lucas Pacheco Oliveira
 */
public class Tabuleiro {

    private ArrayList<ArrayList<String>> linhas;

    public Tabuleiro() {
        this.linhas = new ArrayList<>();
        ArrayList<String> linha;
        for (int i = 0; i < 10; i++) {
            linha = new ArrayList();
            for (int j = 0; j < 10; j++) {
                linha.add(".");
            }
            this.linhas.add(linha);
        }
    }
    
    public ArrayList<ArrayList<String>> getTabuleiro ( ) {
        return this.linhas;
    }
    
    public void inicia() {
        Navios navio = new Navios();
        Random rnd = new Random();
        
        VisualizacaoJogo jogo = new VisualizacaoJogo();
        
        int linha = 0;
        int coluna = 0;
        int nPeca = 0;
        
        ArrayList<ArrayList<String>> listaPecas = new ArrayList<ArrayList<String>>(
            asList(
                navio.getPortaAvioes(),navio.getDestroyer(),navio.getDestroyer(),
                navio.getFragata(),navio.getFragata(),navio.getTorpedeiro(),navio.getTorpedeiro(),
                navio.getTorpedeiro(),navio.getSubmarino(),navio.getSubmarino(),navio.getSubmarino(),
                navio.getSubmarino(),navio.getSubmarino()
            )
        );
        
        for( ArrayList<String> obj : listaPecas ) {
            ArrayList<String> lPecas = Funcoes.listaAlfabeto();
            linha = rnd.nextInt(10);
            coluna = rnd.nextInt(10);
            while(!adiciona(obj, linha, coluna, lPecas.get(nPeca))) {
                linha = rnd.nextInt(9);
                coluna = rnd.nextInt(9);
            }
            nPeca++;
            //System.out.println("Adicionou objeto tamanho ("+obj.size()+") na linha: "+linha+" coluna: "+coluna);
        }
        
    }

    private boolean adiciona(List<String> peca, int linha, int coluna, String strPeca) {
        int j = 0;
        if(coluna+peca.size()>10){
            return false;
        } else {
            for(int i=coluna;i<coluna+peca.size();i++){
                if(!this.linhas.get(linha).get(i).equals(".")) {
                    return false;
                }
            }
            for(int i=coluna;i<coluna+peca.size();i++){
                this.linhas.get(linha).set(i, strPeca);
                j++;
            }
        }
        return true;
    }

    private ArrayList<Integer> getCoordenadas(String coordenada) {
        Integer pos1 = Funcoes.getPosicaoAlfabeto(coordenada.substring(0,1));
        Integer pos2 = Integer.valueOf(coordenada.substring(1, 1));
        ArrayList<Integer> retorno = new ArrayList<>( asList(pos1, pos2) );
        return retorno;
    }
    
    public void realizaJogada(ArrayList<Integer> coordenadas) {
        if(!this.linhas.get(coordenadas.get(0)).get(coordenadas.get(1)).equals("O")&&this.linhas.get(coordenadas.get(0)).get(coordenadas.get(1)).equals("-")) {
            
        }
    }
    
    public Erro joga(String coordenadaUsuario) {
        
        ArrayList<Integer> coordenadas = this.getCoordenadas(coordenadaUsuario);
        
        try {
            this.linhas.get(coordenadas.get(0));
        } catch ( IndexOutOfBoundsException ex ) {
            Erro e = new Erro();
            e.setMensagem("A coluna que você informou não existe. "+ex.getMessage());
            return e;
        }
        
        try {
            this.linhas.get(coordenadas.get(0)).get(coordenadas.get(1));
        } catch ( IndexOutOfBoundsException ex ) {
            Erro e = new Erro();
            e.setMensagem("A linha que você informou não existe. "+ex.getMessage());
            return e;            
        }
        
        realizaJogada(coordenadas);
        return null;
    }

}
