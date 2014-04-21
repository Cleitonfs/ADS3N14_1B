package ordenacao;

import modelo.DadosOrdenacao;

/**
 *
 * @author Lucas Pacheco Oliveira
 *
 * Classe responsável pelos métodos de ordenação.
 */
public class Ordenacao {

    /**
     *
     * @param vet
     * @return Retorna um objeto contendo os dados resultantes da execução e
     * ordenação dos dados.
     *
     * Método que recebe um vetor e aplica comparações e trocas afim de ordenar
     * os dados utilizando o algoritmo de ordenação "Merge Sort" Retorna um
     * objeto DadosOrdenação que contém dados como numero de comparações e
     * trocas efetuadas durante a execução do algoritmo.
     */
    private void merge(int vetor[], int vecSize, DadosOrdenacao dadosOrdenacao) {
        int meio;
        int i, j, k;
        int comparacoes = dadosOrdenacao.getComparacoes();
        int trocas = dadosOrdenacao.getTrocas();
        int[] tmp = new int[vetor.length];

        meio = vecSize / 2;

        i = 0;
        j = meio;
        k = 0;
        while (i < meio && j < vecSize) {
            comparacoes++;
            if (vetor[i] <= vetor[j]) {
                tmp[k] = vetor[i++];
                trocas++;
            } else {
                tmp[k] = vetor[j++];
                trocas++;
            }
            ++k;
        }

        if (i == meio) {
            while (j < vecSize) {
                tmp[k++] = vetor[j++];
                trocas++;
            }
        } else {
            while (i < meio) {
                tmp[k++] = vetor[i++];
                trocas++;
            }
        }

        for (i = 0; i < vecSize; ++i) {
            vetor[i] = tmp[i];
        }
        dadosOrdenacao.setComparacoes(comparacoes);
        dadosOrdenacao.setTrocas(trocas);
        dadosOrdenacao.setVetorOrdenado(vetor);
    }

    public DadosOrdenacao mergeSort(int vetor[], int vecSize, DadosOrdenacao dadosOrdenacao) {
        int meio;
        if (vecSize > 1) {
            meio = vecSize / 2;
            dadosOrdenacao = mergeSort(vetor, meio, dadosOrdenacao);
            dadosOrdenacao = mergeSort(vetor, vecSize - meio, dadosOrdenacao);
            merge(vetor, vecSize, dadosOrdenacao);
        }
        return dadosOrdenacao;
    }

    /**
     *
     * @param vetor
     * @return Retorna um objeto contendo os dados resultantes da execução e
     * ordenação dos dados.
     *
     * Método que recebe um vetor e aplica comparações e trocas afim de ordenar
     * os dados utilizando o algoritmo de ordenação "Bubble Sort" Retorna um
     * objeto DadosOrdenação que contém dados como numero de comparações e
     * trocas efetuadas durante a execução do algoritmo.
     */
    public DadosOrdenacao bubbleSort(int[] vetor) {
        DadosOrdenacao dadosOrdenacao = new DadosOrdenacao();
        int comparacoes = 0;
        int trocas = 0;
        int troca = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                comparacoes++;
                if (vetor[j] > vetor[j + 1]) {
                    troca = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = troca;
                    trocas++;
                }
            }
        }
        dadosOrdenacao.setTrocas(trocas);
        dadosOrdenacao.setComparacoes(comparacoes);
        dadosOrdenacao.setVetorOrdenado(vetor);
        return dadosOrdenacao;
    }

}
