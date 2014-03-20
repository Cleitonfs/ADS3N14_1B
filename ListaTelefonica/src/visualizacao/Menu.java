package visualizacao;

import java.util.Scanner;
import modelo.Contato;
import modelo.ListaContatos;

/**
 *
 * @author Lucas
 */
public class Menu {

    private static int exibeMenu() {
        int opcao = 0;
        Scanner menu = new Scanner(System.in);

        try {
            System.out.println("Digite a opção desejada: ");
            System.out.println("\t2 - Listar contatos");
            System.out.println("\t3 - Adicionar contato");
            System.out.println("\t4 - Procurar contatos");
            System.out.println("\t5 - Excluir contato");
            System.out.println("\t99 - Sair");
            opcao = menu.nextInt();
        } catch (Exception e) {
            opcao = 1;
        }

        return opcao;

    }

    public static boolean novoContato() {

        try {
            Scanner iUsuario = new Scanner(System.in);
            System.out.println("Digite o nome do contato: ");
            String nome = iUsuario.nextLine();
            System.out.println("Digite o DDD: ");
            int ddd = iUsuario.nextInt();
            System.out.println("Digite o telefone: ");
            int telefone = iUsuario.nextInt();
            Contato contato = new Contato(nome, ddd, telefone);
            contato.escreveContato();
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {

        int opcao = 0;
        ListaContatos listaContatos = new ListaContatos();


        while (opcao == 0) {
            opcao = exibeMenu();

            switch (opcao) {
                case 2:
                    System.out.println("Listar agenda");
                    //listar();
                    listaContatos.exibeListaOrdenada();
                    opcao = 0;
                    break;
                case 3:
                    System.out.println("Adicionar contato");
                    novoContato();
                    opcao = 0;
                    break;
                case 4:
                    System.out.println("Procurar na lista");
                    opcao = 0;
                    break;
                case 5:
                    System.out.println("Exluir contato");
                    opcao = 0;
                    break;
                case 99:
                    System.out.println("Saindo do sistema.");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
                    opcao = 0;
            }
        }

    }

    public static void listar() {
        Scanner menu = new Scanner(System.in);
        int opcao = 0;
        ListaContatos listaContatos = new ListaContatos();

        System.out.println("(1) Listar ordenado\n(2) Listar ordem do arquivo\n(99) Voltar ao menu anterior\n");
        while (opcao == 0) {
            try {
                opcao = menu.nextInt();
                switch (opcao) {
                    case 1:
                        listaContatos.exibeListaOrdenada();
                        break;
                    case 2:
                        listaContatos.exibeListaDesordenada();
                        break;
                    case 99:
                        break;
                    default:
                        opcao = 0;
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Digite uma opção válida!");
            }
        }

    }
}
