package estruturas;

public class NodoBinario<T> {

    private NodoBinario<T> esquerda;
    private NodoBinario<T> direita;
    private T dado;

    public NodoBinario(T dado) {
        this.dado = dado;
        this.esquerda = null;
        this.direita = null;
    }

    public NodoBinario<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NodoBinario<T> left) {
        this.esquerda = left;
    }

    public NodoBinario<T> getDireita() {
        return direita;
    }

    public void setDireita(NodoBinario<T> right) {
        this.direita = right;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }
}
