package estruturas;

import modelo.Contato;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

    private Nodo<T> procuraNodo(T data) {
        Nodo<T> nodo = head;
        Nodo<T> anterior = null;

        while (nodo != null) {
            int cmp = nodo.getData().compareTo(data);
            if (cmp == 0) {
                return nodo;
            }
            if (cmp > 0) {
                return anterior;
            }
            anterior = nodo;
            nodo = nodo.getNext();
        }

        return nodo;
    }

    @Override
    public void insert(Nodo<T> novo) {
        Nodo<T> anterior = procuraNodo(novo.getData());

        if (anterior != null) {
            novo.setNext(anterior.getNext());
            anterior.setNext(novo);
            if (anterior == tail) {
                tail = novo;
            }
        } else {
            if (tail != null) {
                tail.setNext(novo);
            } else {
                head = novo;
            }
            tail = novo;
        }
    }

    @Override
    public void insert(Nodo<T> novo, Nodo<T> anterior) {
        insert(novo);
    }

    @Override
    public void append(Nodo<T> novo) {
        insert(novo);
    }

    /*
    public static void main(String[] args) {
        Contato reg = new Contato();
        reg.setNome("teste");
        reg.setTelefone("(51)9723-0660");

        // criar lista
        ListaOrdenada<Contato> lista = new ListaOrdenada<>();
        Nodo<Contato> novo = new Nodo<Contato>(reg);

        lista.insert(novo);
        lista.insert(new Nodo<Contato>(reg), novo);
        lista.append(new Nodo<Contato>(reg));
        lista.insert(new Nodo<Contato>(reg), novo);
        lista.print();
    }
    */

}
