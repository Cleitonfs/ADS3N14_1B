package modelo;

import controles.Arquivo;
import estruturas.ListaEncadeada;
import estruturas.ListaOrdenada;
import estruturas.Nodo;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lucas
 * Classe responsavel pela manipulacao da lista de contatos, ordenada ou encadeada.
 */
public class ListaContatos {

    private ListaOrdenada<Contato> listaOrdenada;
    private Nodo<Contato> registroAtual;
    private int sequencia;

    /**
     * Metodo contrutor que inicia uma lista ordenada.
     */
    public ListaContatos() {

        Arquivo a;
        sequencia = 0;
        this.listaOrdenada = new ListaOrdenada<Contato>();

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

    public int getNextId() {
        return sequencia + 1;
    }

    /**
     * Filtra o contato, recebe como parametro um fragmento, e efetua um laco, verificando se o item
     * contem o fragmento informado pelo usuario
     * @param primeiraLetra
     * @return falso se nao encontar um registro.
     */
    public boolean filtroContato(String primeiraLetra) {
        Nodo<Contato> nodo = this.listaOrdenada.getHead();
        while (nodo != null) {
            if (nodo.getData().getNome().startsWith(primeiraLetra)) {
                this.registroAtual = nodo;
                break;
            }
            nodo = nodo.getNext();
        }

        if (this.registroAtual == null) {
            System.out.println("Nenhum registro encontrado para a letra [" + primeiraLetra + "].");
            return false;
        } else {
            escreveRegistroUsuario(this.registroAtual);
            return true;
        }

    }
    
    
    /**
     * Recebe um id do usuario, recria a lista em uma lista encadeana, na ordem natural que foi gravada
     * menos o id informado pelo usuario.
     * Se o id existe na lista, reescreve o arquivo com base nesta lista.
     * @param id
     * @return verdadeiro se o registro foi encontrado e removido.
     */
    public boolean removeContatoById(int id) {

        ListaEncadeada<Contato> lista = new ListaEncadeada<Contato>();
        Arquivo a;
        String linha = "";
        boolean apagar = false;

        try {
            a = new Arquivo();
            while ((linha = a.leLinhaArquivo()) != null) {
                Contato contato = new Contato(linha);
                Nodo<Contato> nodo = new Nodo<Contato>(contato);
                if (nodo.getData().getId() != id) {
                    lista.append(nodo);
                } else {
                    apagar = true;
                }
            }
            
            if(apagar) {
                a.limpaArquivo();
                Nodo<Contato> nodo = lista.getHead();            
                while(nodo!=null) {
                    a.escreveLinhaArquivo(new StringBuilder().append(nodo.getData().getId()).append(";").append(nodo.getData().getNome()).append(";").append(nodo.getData().getDdd()).append(";").append(nodo.getData().getTelefone()).append(";").toString());
                    nodo = nodo.getNext();
                }
                return true;
            } else {
                return false;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro ao tentar ler o arquivo.");
            return false;
        }
    }
    
    /**
     * Metodo que seta o registro atual para o proximo registro, se o registro atual e o ultimo
     * seta o primeiro registro, formando um loop
     */
    public void listaProximo() {
        if (this.registroAtual == null) {
            this.registroAtual = this.listaOrdenada.getHead();
        } else {
            this.registroAtual = this.registroAtual.getNext();
            if (this.registroAtual == null) {
                this.registroAtual = this.listaOrdenada.getHead();
            }
        }
        escreveRegistroUsuario(this.registroAtual);
    }

    /**
     * Metodo que seta o registro atual para o proximo registro, se o registro atual e o primeiro
     * seta o ultimo registro, realizando um loop
     */
    public void listaAnterior() {
        Nodo<Contato> nodo = this.listaOrdenada.getHead();
        Nodo<Contato> anterior = nodo;
        while (nodo != null) {
            nodo = nodo.getNext();
            if (this.registroAtual == anterior) {
                this.registroAtual = this.listaOrdenada.getTail();
                break;
            } else {
                if (this.registroAtual == nodo) {
                    this.registroAtual = anterior;
                    break;
                }
            }
            anterior = nodo;
        }
        escreveRegistroUsuario(this.registroAtual);
    }

    /**
     * Mostra na tela para o usuário uma lista ordenada.
     */
    public void exibeListaOrdenada() {
        Nodo<Contato> nodo = this.listaOrdenada.getHead();
        while (nodo != null) {
            escreveRegistroUsuario(nodo);
            nodo = nodo.getNext();
        }
    }

    /**
     * Realiza uma busca utilizando a metodologia de pesquisa binaria.
     * Os nodos são inseridos em um Array, este array e dividido ao meio
     * Se o valor anterior for maior que o fragmento pesquisado busca da metade ate o final da lista
     * senao busca da metade ate o inicio da lista.
     * @param fragmento
     * @return retorna o numero de comparacoes realizadas até encontrar o fragmento.
     */
    public int buscaBinaria (String fragmento) {
        Nodo<Contato> nodo = this.listaOrdenada.getHead();
        List<Contato> lista = new ArrayList<>();
        Contato encontrou = null;
        int comparacoes = 0;
        
        while (nodo != null) {
            lista.add(nodo.getData());
            nodo = nodo.getNext();
        }
        
        if(lista.size()>0){
            
            int metade = Math.round((float) lista.size()/2);
            
            if(lista.get(metade).getNome().substring(0, 1).compareToIgnoreCase(fragmento)==0){
                /* Entao o elemento e igual */
                comparacoes++;
                registroAtual = new Nodo<>(lista.get(metade));
                encontrou = lista.get(metade);
            } else if(lista.get(metade).getNome().substring(0, 1).compareToIgnoreCase(fragmento)>0) {
                /* Entao o elemento e maior */
                for(int i=metade;i>=0;i--) {
                    comparacoes++;
                    if(lista.get(i).getNome().substring(0, 1).compareToIgnoreCase(fragmento)==0) {
                        registroAtual = new Nodo<>(lista.get(i));
                        encontrou = lista.get(i);
                    }
                }
            } else {
                /* Entao o elemento e menor. */
                for(int i=metade;i<lista.size();i++) {
                    comparacoes++;
                    if(lista.get(i).getNome().substring(0, 1).compareToIgnoreCase(fragmento)==0) {
                        registroAtual = new Nodo<>(lista.get(i));
                        encontrou = lista.get(i);
                    }                    
                }
            }
            
            if(encontrou!=null) {
                System.out.println("Registro encontrado ("+String.valueOf(comparacoes)+" comparacoes): ");
                escreveRegistroUsuario(new Nodo<>(encontrou));
            } else {
                System.out.println("Nenhum registro encontrado.");
            }
            
        }
        return comparacoes;
        
    }
    
    /**
     * Metodo que escreve na tela o contato.
     * @param nodo 
     */
    public void escreveRegistroUsuario(Nodo<Contato> nodo) {
        System.out.println(new StringBuilder().append("[ Id: ").append(nodo.getData().getId()).append(" ] Nome: ").append(nodo.getData().getNome()).append(" - Telefone: (").append(nodo.getData().getDdd()).append(")").append(nodo.getData().getTelefone()).toString());
    }

}
