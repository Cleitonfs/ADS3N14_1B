/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visualizacao;

import modelo.DadosOrdenacao;
import ordenacao.Ordenacao;

/**
 *
 * @author Lucas Pacheco Oliveira
 */
public class principal {
    
    public static void main(String[] args) {
        int[] vetor = {38,16,27,39,12,26,10,9,50,23};
        Ordenacao ordenacao = new Ordenacao();
        DadosOrdenacao dadosOrdenacao = null;
        dadosOrdenacao = new DadosOrdenacao();
        dadosOrdenacao = ordenacao.mergeSort(vetor, vetor.length, dadosOrdenacao);
        
        System.out.println("Merge sort: ");
        System.out.println("Trocas: "+dadosOrdenacao.getTrocas());
        System.out.println("Comparações: "+dadosOrdenacao.getComparacoes());
        
        dadosOrdenacao = new DadosOrdenacao();
        dadosOrdenacao = ordenacao.bubbleSort(vetor);
        System.out.println("Bubble sort: ");
        System.out.println("Trocas: "+dadosOrdenacao.getTrocas());
        System.out.println("Comparações: "+dadosOrdenacao.getComparacoes());
        
    }
    
}
