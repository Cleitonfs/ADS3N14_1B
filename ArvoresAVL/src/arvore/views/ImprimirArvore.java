/**
 * Classe que contém métodos de impressao da árvore
 * Criada ao som de Sad But True - Metallica
 */
package arvore.views;

import java.util.ArrayList;
import java.util.List;

import arvore.estrutura.Arvore;
import arvore.estrutura.Nodo;

/**
 *
 * @author lpoliveira
 */
public class ImprimirArvore
{
	private static int contador;
	private static List<Object> lista;

	public static void imprimirArvore(Arvore<?> arvore)
	{
		contador = 0;
		lista = new ArrayList<Object>();
		System.out.printf("Tipo de Arvore: %s%n%n", arvore.getClass().getSimpleName());
		if (arvore.getRaiz() == null) {
			System.out.println("Arvore vazia!");
			return;
		}
		++contador;
		Nodo<?> atual = arvore.getRaiz();
		lista.add(atual.getElemento());
		String separador = "  |__";
		String elemento = String.valueOf(atual.getElemento());
		String cor = (atual.isCorPreto() ? "B" : "R");
		int altura = atual.getAltura();
		int fb = (atual.getDireita() == null ? 0 : atual.getDireita().getAltura())
				- (atual.getEsquerda() == null ? 0 : atual.getEsquerda().getAltura());
		String strFB = (fb < 0 ? String.valueOf(fb) : "+" + String.valueOf(fb));
		System.out.printf("%s C=%s  A=%d  FB=%s%n", elemento, cor, altura, strFB);
		imprimirSubArvore(atual.getEsquerda(), separador);
		imprimirSubArvore(atual.getDireita(), separador);
		System.out.printf("%nTotal de elementos: %d%n", contador);
		System.out.println(lista.toString());
	}

	private static void imprimirSubArvore(Nodo<?> atual, String separador)
	{
		if (atual != null) {
			++contador;
			lista.add(atual.getElemento());
			String elemento = String.valueOf(atual.getElemento());
			String cor = (atual.isCorPreto() ? "B" : "R");
			int altura = atual.getAltura();
			int fb = (atual.getDireita() == null ? 0 : atual.getDireita().getAltura())
					- (atual.getEsquerda() == null ? 0 : atual.getEsquerda().getAltura());
			String strFB = (fb < 0 ? String.valueOf(fb) : "+" + String.valueOf(fb));
			String pos = "N";
			if (atual.getPai() != null)
				pos = (atual == atual.getPai().getEsquerda() ? "E" : "D");
			System.out.printf("%s%s(%s) C=%s  A=%d  FB=%s%n", separador, elemento, pos, cor, altura, strFB);
			imprimirSubArvore(atual.getEsquerda(), "      " + separador);
			imprimirSubArvore(atual.getDireita(), "      " + separador);
		}
	}
}