package modelo;

/**
 *
 * @author Lucas Pacheco Oliveira
 * Classe responsável por guardar o retorno dos dados do vetor.
 */
public class DadosOrdenacao {

    private int comparacoes = 0;
    private int trocas = 0;
    private int[] vetorOrdenado;

    public int getComparacoes() {
        return comparacoes;
    }

    public void setComparacoes(int comparacoes) {
        this.comparacoes = comparacoes;
    }

    public int getTrocas() {
        return trocas;
    }

    public void setTrocas(int trocas) {
        this.trocas = trocas;
    }

    public int[] getVetorOrdenado() {
        return vetorOrdenado;
    }

    public void setVetorOrdenado(int[] vetorOrdenado) {
        this.vetorOrdenado = vetorOrdenado;
    }

}
