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

    private ListaOrdenada listaOrdenada;
    Nodo<Contato> registroAtual;
    private int sequencia;

    public ListaContatos() {

        Arquivo a;
        sequencia = 0;
        this.listaOrdenada = new ListaOrdenada();

        try {
            a = new Arquivo();
            String linha = "";
            while ((linha = a.leLinhaArquivo()) != null) {
                Contato contato = new Contato(linha);
                Nodo<Contato> nodo = new Nodo<Contato>(contato);
                sequencia = contato.getId() > sequencia ? contato.getId() : sequencia;
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

    public boolean filtroContato(String primeiraLetra) {
        Nodo<Contato> nodo = this.listaOrdenada.getHead();
        while (nodo != null) {
            if(nodo.getData().getNome().startsWith(primeiraLetra)){
                this.registroAtual = nodo;
                break;
            }
            nodo = nodo.getNext();
        }
        
        if(this.registroAtual==null) {
            System.out.println("Nenhum registro encontrado para a letra ["+primeiraLetra+"].");
            return false;
        } else {
            escreveRegistroUsuario(this.registroAtual);
            return true;
        }

    }
    
    public void listaProximo() {
        if(this.registroAtual==null){
            this.registroAtual = this.listaOrdenada.getHead();
        } else {
            this.registroAtual = this.registroAtual.getNext();
            if(this.registroAtual == null) {
                this.registroAtual = this.listaOrdenada.getHead();
            }
        }
        escreveRegistroUsuario(this.registroAtual);
    }

    public void listaAnterior() {
        Nodo<Contato> nodo = this.listaOrdenada.getHead();
        while (nodo != null) {
            escreveRegistroUsuario(nodo);
            nodo = nodo.getNext();
        }
    }
    
    public void exibeListaOrdenada() {
        Nodo<Contato> nodo = this.listaOrdenada.getHead();
        while (nodo != null) {
            escreveRegistroUsuario(nodo);
            nodo = nodo.getNext();
        }
    }
    
    public void escreveRegistroUsuario(Nodo<Contato> nodo){
        System.out.println(new StringBuilder().append("[ Id: ").append(nodo.getData().getId()).append(" ] Nome: ").append(nodo.getData().getNome()).append(" - Telefone: (").append(nodo.getData().getDdd()).append(")").append(nodo.getData().getTelefone()).toString());
    }
    
}
