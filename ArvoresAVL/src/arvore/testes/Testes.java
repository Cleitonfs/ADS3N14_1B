/**
 * Classe que contém métodos que criam menus, para a iteração com o usuário.
 * Criada ao som de Kashmir - Led Zepellin
 */
package arvore.testes;

/**
 *
 * @author lpoliveira
 */
import arvore.estrutura.ArvoreAVL;
import arvore.estrutura.ArvoreBSP;
import arvore.views.ImprimirArvore;
import arvore.uteis.Uteis;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lpoliveira
 */
public class Testes {

    private static void testeArvoreAVL() {

        String opcao = "";
        ArvoreAVL<Integer> a = new ArvoreAVL<>();
        List<Integer> lista = null;

        while (!opcao.equals("sair")) {

            System.out.println("Digite a opção: (inserir|imprimir|sair)");
            Scanner entradaUsuario = new Scanner(System.in);
            opcao = entradaUsuario.nextLine();

            switch (opcao) {
                case "inserir":
                    lista = getSequenciaNumeros();
                    if (lista.size() > 0) {
                        for (Integer item : lista) {
                            a.insert(item);
                            System.out.println("Adicionou item " + item.toString());
                        }
                    } else {
                        System.out.println("Não foi possível adicionar a lista na arvore.");
                    }
                    break;
                case "imprimir":
                    ImprimirArvore.imprimirArvore(a);
                    break;
            }

        }

    }

    private static void testeArvoreBSP() {

        String opcao = "";
        ArvoreBSP<Integer> a = new ArvoreBSP<>();
        List<Integer> lista = null;

        while (!opcao.equals("sair")) {

            System.out.println("Digite a opção: (inserir|imprimir|sair)");
            Scanner entradaUsuario = new Scanner(System.in);
            opcao = entradaUsuario.nextLine();

            switch (opcao) {
                case "inserir":
                    lista = getSequenciaNumeros();
                    if (lista.size() > 0) {
                        for (Integer item : lista) {
                            a.insert(item);
                            System.out.println("Adicionou item " + item.toString());
                        }
                    } else {
                        System.out.println("Não foi possível adicionar a lista na arvore.");
                    }
                    break;
                case "imprimir":
                    ImprimirArvore.imprimirArvore(a);
                    break;
            }

        }

    }

    private static void testeArvoreRB() {
        String opcao = "";
        ArvoreBSP<Integer> a = new ArvoreBSP<>();
        List<Integer> lista = null;
        
        while (!opcao.equals("sair")) {

            System.out.println("Digite a opção: (inserir|imprimir|sair)");
            Scanner entradaUsuario = new Scanner(System.in);
            opcao = entradaUsuario.nextLine();

            switch (opcao) {
                case "inserir":
                    lista = getSequenciaNumeros();
                    if (lista.size() > 0) {
                        for (Integer item : lista) {
                            a.insert(item);
                            System.out.println("Adicionou item " + item.toString());
                        }
                    } else {
                        System.out.println("Não foi possível adicionar a lista na arvore.");
                    }
                    break;
                case "imprimir":
                    ImprimirArvore.imprimirArvore(a);
                    break;
            }
        }
    }

    private static List<Integer> getSequenciaNumeros() {
        System.out.println("Digite uma lista de numeros. Separe por virgula: ex: (1,2,3)");
        Scanner entradaUsuario = new Scanner(System.in);
        String numeros = entradaUsuario.nextLine();
        return Uteis.explode(numeros);
    }

    public static void main(String[] args) {

        String opcao = "";

        while (!opcao.equals("sair")) {
            System.out.println("Digite a opção desejada: (avl|rb|bsp|sair)");
            Scanner entradaUsuario = new Scanner(System.in);
            opcao = entradaUsuario.nextLine();

            switch (opcao) {
                case "avl":
                    System.out.println("Escolha Arvore AVL");
                    testeArvoreAVL();
                    break;
                case "rb":
                    System.out.println("Escolha Arvore RB");
                    testeArvoreRB();
                    break;
                case "bsp":
                    System.out.println("Escolha Arvore BSP");
                    testeArvoreBSP();
                    break;
            }

        }

        System.out.println("Obrigado!");

    }

    private static Integer getNumeroApaga(List<Integer> lista) {
        System.out.println("Digite o numero que deseja apagar: (" + imprimeLista(lista) + ")");
        Scanner entradaUsuario = new Scanner(System.in);
        Integer opcao = null;
        try {
            opcao = Integer.valueOf(entradaUsuario.nextLine());
            if (lista.indexOf(opcao) < 0) {
                opcao = null;
            }
        } catch (Exception e) {
            System.out.println("Número inválido.");
        }
        return opcao;
    }

    private static String imprimeLista(List<Integer> lista) {
        String strLista = "";
        for (Integer item : lista) {
            strLista += "," + item.toString();
        }
        return strLista;
    }

}
