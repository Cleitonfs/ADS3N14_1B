package modelo;

import controles.Arquivo;
import estruturas.ListaEncadeada;
import estruturas.ListaOrdenada;
import estruturas.Nodo;
import java.io.FileNotFoundException;

/**
 *
 * @author Lucas
 */
public class ListaContatos {

    private ListaEncadeada lista;
    private ListaOrdenada listaOrdenada;
    private int sequencia;

    public ListaContatos() {

        Arquivo a;
        sequencia = 0;
        this.lista = new ListaEncadeada();
        this.listaOrdenada = new ListaOrdenada();

        try {
            a = new Arquivo();
            String linha = "";
            while ((linha = a.leLinhaArquivo()) != null) {
                Contato contato = new Contato(linha);
                Nodo<Contato> nodo = new Nodo<Contato>(contato);
                sequencia = contato.getId() > sequencia ? contato.getId() : sequencia;
                this.lista.append(nodo);
                this.listaOrdenada.append(nodo);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao tentar criar a lista. ");
            ex.printStackTrace();
        }

    }

    public int getSequencia() {
        return sequencia;
    }

    public void exibeListaDesordenada() {
        Nodo<Contato> nodo = this.lista.getHead();
        while (nodo != null) {
            System.out.println("Nome: " + nodo.getData().getNome());
            nodo = nodo.getNext();
        }
    }
    
    public void exibeListaOrdenada() {
        Nodo<Contato> nodo = this.listaOrdenada.getHead();
        while (nodo != null) {
            System.out.println("Nome: " + nodo.getData().getNome());
            nodo = nodo.getNext();
        }
    }
}
