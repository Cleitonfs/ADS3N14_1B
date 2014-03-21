package visualizacao;

import java.util.Scanner;
import modelo.Contato;
import modelo.ListaContatos;

/**
 *
 * @author Lucas
 */
public class Menu {

    private static ListaContatos listaContatos;

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
            Contato contato = new Contato(listaContatos.getNextId(), nome, ddd, telefone);
            contato.escreveContato();
            listaContatos = new ListaContatos();
            return true;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {

        int opcao = 0;
        listaContatos = new ListaContatos();

        while (opcao == 0) {
            opcao = exibeMenu();

            switch (opcao) {
                case 2:
                    listar();
                    opcao = 0;
                    break;
                case 3:
                    System.out.println("Opção adicionar contato");
                    novoContato();
                    opcao = 0;
                    break;
                case 4:
                    System.out.println("Opção procurar na lista");
                    procuraLista();
                    opcao = 0;
                    break;
                case 5:
                    System.out.println("Exluir contato");
                    removeContato();
                    opcao = 0;
                    break;
                case 99:
                    System.out.println("Tchau!");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
                    opcao = 0;
            }
        }

    }

    public static void removeContato() {
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.println("Digite o id do contato que deseja remover, ou 0 para sair: ");
        String opcao = entradaUsuario.nextLine();

        while (!opcao.equals("sair")) {
            try {
                int id = Integer.valueOf(opcao);
                if(listaContatos.removeContatoById(id)){
                    listaContatos = new ListaContatos();
                    System.out.println("Contato ["+id+"] removido!");
                }
                opcao = "sair";
            } catch (Exception e) {
                System.out.println("Digite um valor válido.");
            }
        }
    }

    public static void procuraLista() {

        Scanner entradaUsuario = new Scanner(System.in);
        System.out.println("Digite a primeira letra a exibir ou digite 99 para sair: ");
        String opcao = "";
        while (opcao != "99") {
            opcao = entradaUsuario.nextLine();
            if (opcao == "99") {
                break;
            } else {
                if (opcao != "") {
                    if (listaContatos.filtroContato(opcao)) {
                        exibeProcuraAnteriorProximo();
                    }
                    opcao = "99";
                } else {
                    System.out.println("É necessário informar pelo menos uma letra para iniciar a pesquisa.");
                }
            }
        }
    }

    public static void exibeProcuraAnteriorProximo() {
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.println("Opções: (1) Registro anterior | (2) Próximo registro. | (99) Sair.");
        Integer opcao = 0;
        while (opcao == 0) {
            try {
                opcao = entradaUsuario.nextInt();
                if (opcao == 1 || opcao == 2) {
                    if (opcao == 1) {
                        listaContatos.listaAnterior();
                    } else {
                        listaContatos.listaProximo();
                    }
                    opcao = 99;
                    exibeProcuraAnteriorProximo();
                }
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                opcao = 0;
            }

        }
    }

    public static void listar() {
        System.out.println("Inicio da lista: ");
        listaContatos.exibeListaOrdenada();
        System.out.println("Fim da lista.");
    }
}
