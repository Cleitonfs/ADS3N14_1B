package estruturas;

import static java.lang.System.out;

public class ListaEncadeada<T> {

	protected Nodo<T> head;
	protected Nodo<T> tail;
	
        public Nodo<T> getHead(){
            return this.head;
        }
        
        public Nodo<T> getTail(){
            return this.tail;
        }
        
	public void insert(Nodo<T> novo)
	{
		novo.setNext(head);
		head = novo;
		if (tail == null)
			tail = novo;
	}
	
	public void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		novo.setNext(anterior.getNext());
		anterior.setNext(novo);
		if (anterior == tail)
			tail = novo;
	}
	
	public void append(Nodo<T> novo)
	{
		if (tail != null)
			tail.setNext(novo);
		else
			head = novo;
		tail = novo;
	}
	
	public void print() {
		Nodo<T> elem = head;
		do {
                    out.println(elem.getData());
                    elem = elem.getNext();
		} while (elem != null);		
	}
	
        public static void main(String[] args) {
            String teste = "34;nome;51;33190400";
            System.out.println(
                teste.substring(0,teste.indexOf(";",3))
            );
            
        }
        
}
