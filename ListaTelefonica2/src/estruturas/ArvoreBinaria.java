package estruturas;

import java.util.Random;

public class ArvoreBinaria<T extends Comparable<T>> {

    private NodoBinario<T> root;

    public ArvoreBinaria() {
        this.root = null;
    }

    public boolean isEmpty() {
        return (this.root != null) ? false : true;
    }

    public void insert(T dado) {
        if (this.root == null) {
            this.root = new NodoBinario<T>(dado);
        } else {
            insert(dado, this.root);
        }
    }

    private void insert(T dado, NodoBinario<T> current) {
        if (dado.compareTo(current.getDado()) < 0) {
            if (current.getEsquerda() == null) {
                current.setEsquerda(new NodoBinario<T>(dado));
            } else {
                insert(dado, current.getEsquerda());
            }
        } else if (dado.compareTo(current.getDado()) > 0) {
            if (current.getDireita() == null) {
                current.setDireita(new NodoBinario<T>(dado));
            } else {
                insert(dado, current.getDireita());
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
    public void infixTraversal() {
        if (!isEmpty()) {
            infixTraversal(root);
        } else {
            System.out.println("Arvore vazia.");
        }
    }

    /**
     * Metodo recursivo que percorre os elementos da arvore, de forma ordenados
     * (infix) Primeiro avalia o conteudo dos nodos a esquerda, apos avalia o
     * conteudo do nodo e depois os ﬁlhos a direita.
     *
     * @param BinaryNode
     */
    private void infixTraversal(NodoBinario<T> node) {
        if (node != null) {
            infixTraversal(node.getEsquerda());
            System.out.println(node.getDado());
            infixTraversal(node.getDireita());
        }
    }

    /**
     * Metodo que testa se a arvore esta vazia, entao chama o prefixTraversal
     * recursivo, mantendo encapsulada a arvore, protegendo assim seus
     * elementos.
     */
    public void prefixTraversal() {
        if (!isEmpty()) {
            prefixTraversal(root);
        } else {
            System.out.println("Arvore vazia.");
        }
    }

    /**
     * Metodo recursivo que percorre os elementos da arvore (prefix), tambem
     * chamado pre-order Primeiro avalia o conteúdo do nodo, apos, avalia os
     * ﬁlhos a esquerda e por fim os ﬁlhos a direita.
     *
     * @param NodoBinario
     */
    private void prefixTraversal(NodoBinario<T> node) {
        if (node != null) {
            System.out.println(node.getDado());
            prefixTraversal(node.getEsquerda());
            prefixTraversal(node.getDireita());
        }
    }

    /**
     * Testa se a arvore esta vazia, chama o postfixTraversal
     * recursivo, mantendo encapsulada a arvore
     */
    public void postfixTraversal() {
        if (!isEmpty()) {
            postfixTraversal(root);
        } else {
            System.out.println("Arvore vazia.");
        }
    }

    /**
     * Metodo recursivo que percorre os elementos da arvore (postfix), tambem
     * chamado post-order Primeiro avalia o conteúdo dos nodos a esquerda,
     * apos os nodos a direita, e entao o conteudo do proprio nodo
     * Ordem de execucao: left, right e node
     *
     * @param NodoBinario
     */
    private void postfixTraversal(NodoBinario<T> nodo) {
        if (nodo != null) {
            postfixTraversal(nodo.getEsquerda());
            postfixTraversal(nodo.getDireita());
            System.out.println(nodo.getDado());
        }
    }

    public static void main(String[] args) {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<Integer>();
        Random r = new Random();

        for (int i = 0; i < 5; i++) {
            arvore.insert(r.nextInt(101));
        }

        System.out.println("Root: " + arvore.root.getDado());

        System.out.println("Impressao em ordem: ");
        arvore.infixTraversal();

        System.out.println("Impressao pre-order: ");
        arvore.prefixTraversal();

        System.out.println("Impressao post-order: ");
        arvore.postfixTraversal();
    }
}
