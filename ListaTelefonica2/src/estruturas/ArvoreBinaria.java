package estruturas;

import java.util.ArrayList;
import java.util.Random;
import modelo.Contato;

public class ArvoreBinaria<T extends Comparable<T>> {

    private NodoBinario<T> root;
    private boolean localizado = false;
    private int comparacoes = 0;

    public NodoBinario<T> getRoot() {
        return root;
    }

    public void setRoot(NodoBinario<T> root) {
        this.root = root;
    }

    public int getComparacoes() {
        return comparacoes;
    }

    public void setComparacoes(int comparacoes) {
        this.comparacoes = comparacoes;
    }

    public ArvoreBinaria() {
        this.root = null;
    }

    public boolean isVazio() {
        return (this.root != null) ? false : true;
    }

    public void adicionar(T dado) {
        if (this.root == null) {
            this.root = new NodoBinario<T>(dado);
        } else {
            adicionar(dado, this.root);
        }
    }

    private void adicionar(T dado, NodoBinario<T> current) {
        if (dado.compareTo(current.getDado()) < 0) {
            if (current.getEsquerda() == null) {
                current.setEsquerda(new NodoBinario<T>(dado));
            } else {
                adicionar(dado, current.getEsquerda());
            }
        } else if (dado.compareTo(current.getDado()) > 0) {
            if (current.getDireita() == null) {
                current.setDireita(new NodoBinario<T>(dado));
            } else {
                adicionar(dado, current.getDireita());
            }
        } else {
            System.out.println("Elemento existente");
        }
    }

    /**
     * Metodo que testa se a arvore esta vazia, entao chama o infixTraversal
     * recursivo, mantendo encapsulada a arvore, protegendo assim seus
     * elementos.
     */
    public ArrayList<T> infixTraversal() {
        ArrayList<T> retorno = new ArrayList<T>();
        if (!isVazio()) {
            infixTraversal(root, retorno);
        }
        return retorno;
    }

    /**
     * Metodo recursivo que percorre os elementos da arvore, de forma ordenados
     * (infix) Primeiro avalia o conteudo dos nodos a esquerda, apos avalia o
     * conteudo do nodo e depois os ﬁlhos a direita.
     *
     * @param BinaryNode
     */
    private void infixTraversal(NodoBinario<T> node, ArrayList<T> lista) {
        if (node != null) {
            infixTraversal(node.getEsquerda(), lista);
            lista.add(node.getDado());
            infixTraversal(node.getDireita(), lista);
        }
    }

    /**
     * Metodo que testa se a arvore esta vazia, entao chama o prefixTraversal
     * recursivo, mantendo encapsulada a arvore, protegendo assim seus
     * elementos.
     */
    public ArrayList<T> prefixTraversal() {
        ArrayList<T> retorno = new ArrayList<T>();
        if (!isVazio()) {
            prefixTraversal(root, retorno);
        }
        return retorno;
    }

    /**
     * Metodo recursivo que percorre os elementos da arvore (prefix), tambem
     * chamado pre-order Primeiro avalia o conteúdo do nodo, apos, avalia os
     * ﬁlhos a esquerda e por fim os ﬁlhos a direita.
     *
     * @param NodoBinario
     */
    private void prefixTraversal(NodoBinario<T> node, ArrayList<T> lista) {
        if (node != null) {
            lista.add(node.getDado());
            prefixTraversal(node.getEsquerda(), lista);
            prefixTraversal(node.getDireita(), lista);
        }
    }

    /**
     * Testa se a arvore esta vazia, chama o postfixTraversal recursivo,
     * mantendo encapsulada a arvore
     */
    public ArrayList<T> postfixTraversal() {
        ArrayList<T> retorno = new ArrayList<T>();
        if (!isVazio()) {
            postfixTraversal(root, retorno);
        }
        return retorno;
    }

    /**
     * Metodo recursivo que percorre os elementos da arvore (postfix), tambem
     * chamado post-order Primeiro avalia o conteúdo dos nodos a esquerda, apos
     * os nodos a direita, e entao o conteudo do proprio nodo Ordem de execucao:
     * left, right e node
     *
     * @param NodoBinario
     */
    private void postfixTraversal(NodoBinario<T> nodo, ArrayList<T> lista) {
        if (nodo != null) {
            postfixTraversal(nodo.getEsquerda(), lista);
            postfixTraversal(nodo.getDireita(), lista);
            lista.add(nodo.getDado());
        }
    }

    /**
     * Metodo que efetua a busca em argura, retorna o nodo, se encontrado
     *
     * @param dado
     * @return
     */
    public T buscaLargura(T dado) {
        this.comparacoes = 0;
        if (!isVazio()) {
            ArrayList<NodoBinario<T>> fila = new ArrayList<>();
            NodoBinario<T> elemento = null;
            fila.add(this.root);

            while (!fila.isEmpty()) {
                elemento = fila.remove(0);
                this.comparacoes++;

                if (elemento.getDado().compareTo(dado) == 0) {
                    return elemento.getDado();
                }

                if (elemento.getEsquerda() != null) {
                    fila.add(elemento.getEsquerda());
                }

                if (elemento.getDireita() != null) {
                    fila.add(elemento.getDireita());
                }
            }
            return null;
        } else {
            return null;
        }
    }

    /**
     * Metodo que realiza busca em profundidade, retorna um element T quando
     * encontra o elemento na arvore
     *
     * @param dado
     * @return
     */
    public T buscaProfundidade(T dado) {
        comparacoes = 0;
        if (!isVazio()) {
            ArrayList<NodoBinario<T>> pilha = new ArrayList<>();
            NodoBinario<T> elemento = null;

            pilha.add(this.root);

            while (!pilha.isEmpty()) {

                elemento = pilha.remove(pilha.size() - 1);

                comparacoes++;

                if (elemento.getDado().compareTo(dado) == 0) {
                    return elemento.getDado();
                }

                if (elemento.getEsquerda() != null) {
                    pilha.add(elemento.getEsquerda());
                }

                if (elemento.getDireita() != null) {
                    pilha.add(elemento.getDireita());
                }
            }

            return null;

        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();
        ArrayList<Integer> lista = new ArrayList<Integer>();

        Random r = new Random();
        int dado = 0;

        System.out.println("Ordem criação");
        /*
         for (int i = 0; i < 10; i++) {
         dado = r.nextInt(101);
         arvore.insert(dado);
         }
         */

        arvore.adicionar(5);
        arvore.adicionar(7);
        arvore.adicionar(2);
        arvore.adicionar(4);
        arvore.adicionar(3);
        arvore.adicionar(0);
        arvore.adicionar(9);
        arvore.adicionar(6);
        arvore.adicionar(1);
        arvore.adicionar(8);

        System.out.println("Root: " + arvore.root.getDado());

        System.out.println("Impressao em ordem: ");
        lista = arvore.infixTraversal();
        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i));
            }
        } else {
            System.out.println("Lista Vazia");
        }

        System.out.println("Impressao pre-order: ");
        lista = arvore.prefixTraversal();
        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i));
            }
        } else {
            System.out.println("Lista Vazia");
        }

        System.out.println("Impressao post-order: ");
        lista = arvore.postfixTraversal();
        if (lista.size() > 0) {
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i));
            }
        } else {
            System.out.println("Lista Vazia");
        }

    }

    private int buscaNodosLargura(NodoBinario<T> root) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * recebe um elemento e executa a exclusao, mantendo a arvore encapsulada
     *
     * @param dado
     * @return boolean
     */
    public boolean remove(T dado) {
        this.localizado = false;
        if (!isVazio()) {
            if (remove(root, dado) != null) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public NodoBinario<T> remove(NodoBinario<T> auxiliar, T dado) {

        if ((dado) == null) {
            return null;
        }

        NodoBinario<T> parent;
        NodoBinario<T> parent2;

        if (auxiliar.getDado().compareTo(dado) == 0) {
            if (auxiliar.getEsquerda() == auxiliar.getDireita()) {
                return null;
            } else if (auxiliar.getEsquerda() == null) {
                return auxiliar.getDireita();
            } else if (auxiliar.getDireita() == null) {
                return auxiliar.getEsquerda();
            } else {
                parent2 = auxiliar.getDireita();
                parent = auxiliar.getDireita();
                while (parent.getEsquerda() != null) {
                    parent = parent.getEsquerda();
                }
                parent.setEsquerda(auxiliar.getEsquerda());
                return parent2;
            }
        } else if (auxiliar.getDado().compareTo(dado) < 0) {
            auxiliar.setDireita(remove(auxiliar.getDireita(), dado));
        } else {
            auxiliar.setEsquerda(remove(auxiliar.getEsquerda(), dado));
        }

        return auxiliar;
    }

}
