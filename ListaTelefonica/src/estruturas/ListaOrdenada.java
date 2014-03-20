package estruturas;

import modelo.Contato;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

    private Nodo<T> procuraNodo(T data) {
        Nodo<T> atual = head;
        Nodo<T> anterior = null;

        while (atual != null) {
            int cmp = atual.getData().compareTo(data);
            if (cmp < 0) {
                anterior = atual;
                atual = atual.getNext();
            } else if (cmp == 0) {
                return atual;
            } else {
                break;
            }
        }
        return anterior;

    }

    public Nodo<T> getHead() {
        return this.head;
    }

    @Override
    public void insert(Nodo<T> novo) {
        Nodo<T> anterior = procuraNodo(novo.getData());

        if (anterior == null) {
            novo.setNext(this.head);
            this.head = novo;
            if (this.tail == null) {
                this.tail = head;
            }
        } else {
            if (tail == anterior) {
                this.tail.setNext(novo);
                this.tail = novo;
            } else {
                novo.setNext(anterior.getNext());
                anterior.setNext(novo);
            }
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

    public static void main(String[] args) {
        Contato reg;
        
        ListaOrdenada<Contato> lista = new ListaOrdenada<>();;
        Nodo<Contato> novo;        
        reg  = new Contato();
        reg.setNome("xxx");
        reg.setDdd(51);
        reg.setTelefone(97230660);
        
        novo = new Nodo<Contato>(reg);
        lista.insert(novo);
        reg  = new Contato();
        reg.setNome("teste");
        reg.setDdd(51);
        reg.setTelefone(97230662);
        
        novo = new Nodo<Contato>(reg);        
        lista.insert(novo);
        
        lista.print();
    }
}
