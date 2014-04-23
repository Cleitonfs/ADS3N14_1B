/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package visualizacao;

import modelo.DadosOrdenacao;
import ordenacao.Gerador;
import ordenacao.Ordenacao;

/**
 *
 * @author Lucas Pacheco Oliveira
 */
public class principal {
    
    public static void main(String[] args) {
        int[] vetorOrdenar = Gerador.gerar(1000);
        Ordenacao ordenacao = new Ordenacao();
        DadosOrdenacao dadosOrdenacao = null;
        dadosOrdenacao = new DadosOrdenacao();
        dadosOrdenacao = ordenacao.mergeSort(vetorOrdenar, vetorOrdenar.length, dadosOrdenacao);
        
        System.out.println("Merge sort: ");
        System.out.println("Trocas: "+dadosOrdenacao.getTrocas());
        System.out.println("Comparações: "+dadosOrdenacao.getComparacoes());
        
        for(int i=0;i<vetorOrdenar.length;i++){
            System.out.print(vetorOrdenar[i]+" ,");
        }        
        dadosOrdenacao = new DadosOrdenacao();
        dadosOrdenacao = ordenacao.bubbleSort(vetorOrdenar);
        System.out.println("Bubble sort: ");
        System.out.println("Trocas: "+dadosOrdenacao.getTrocas());
        System.out.println("Comparações: "+dadosOrdenacao.getComparacoes());
        
        
        
    }
    
}
