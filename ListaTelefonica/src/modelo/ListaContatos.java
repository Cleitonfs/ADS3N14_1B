/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import controles.Arquivo;
import estruturas.ListaEncadeada;
import estruturas.Nodo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class ListaContatos {
    
    private ListaEncadeada lista;
    
    public ListaContatos () {
        
        Arquivo a = new Arquivo();
        this.lista = new ListaEncadeada();
        
        String[] linhas;
        try {
            linhas = a.leTodoArquivo();
            
            for (int i=0 ; i<linhas.length ; i++) {
             Contato contato = new Contato(linhas[i]);
             Nodo<Contato> nodo = new Nodo<Contato>(contato);
             this.lista.append(nodo);
        }
        } catch (IOException ex) {
            Logger.getLogger(ListaContatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void exibe(){
        this.lista.print();
    }
    
}
