package visualizacao;

import java.util.Scanner;
import modelo.Contato;
import modelo.ListaContatos;

/**
 * @version 1.3
 * @author Lucas
 */
public class Menu {

    private static ListaContatos listaContatos;
    
    /**
     * Metodo que exibe o menu principal ao usuario. Retorna a opcao adquirida atraves de Java.Util.Scanner
     * @return numero da opcao selecionado pelo usuario
     */
    private static int exibeMenu() {
        int opcao = 0;
        Scanner menu = new Scanner(System.in);
        try {
            System.out.println("Digite a op��o desejada: ");
            System.out.println(new StringBuilder("2 - Listar contatos").append(" | 3 - Adicionar contato").append(" | 4 - Procurar contatos").append(" | 5 - Procura Bin�ria").append(" | 6 - Excluir contato").append(" | 99 - Sair.").toString());
            opcao = menu.nextInt();
        } catch (Exception e) {
            opcao = 1;
        }
        return opcao;

    }

    /**
     * Cria um usuario no sistema atraves da solicicao de dados utilizando a classe Java.Util.Scanner para interface com o usuario.
     * @return true, false
     */
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
                    System.out.println("Op��o adicionar contato");
                    novoContato();
                    opcao = 0;
                    break;
                case 4:
                    System.out.println("Op��o procurar na lista");
                    procuraLista();
                    opcao = 0;
                    break;
                case 5:
                    System.out.println("Busca bin�ria");
                    buscaBinaria();
                    opcao = 0;
                    break;
                case 6:
                    System.out.println("Exluir contato");
                    removeContato();
                    opcao = 0;
                    break;
                case 99:
                    System.out.println("Tchau!");
                    System.exit(0);
                default:
                    System.out.println("Op��o inv�lida!");
                    opcao = 0;
            }
        }

    }

    /**
     * Metodo que solicita Id do contato que deseja remover. Exibe mensagens com o status da solicitacao.
     */
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
                } else {
                    System.out.println("Contato ["+id+"] inexistente.");
                }
                opcao = "sair";
            } catch (Exception e) {
                System.out.println("Digite um valor v�lido.");
            }
        }
    }

    /**
     * Metodo que solicita ao usuario uma letra para que a consulta seja realizada.
     * Se o usuario digita o numero 99 volta ao menu anterior
     */
    public static void buscaBinaria() {
        Scanner ent = new Scanner(System.in);
        String opcao = ent.nextLine();
        if(opcao!="sair") {
            if(listaContatos.buscaBinaria(opcao)>0){
                exibeProcuraAnteriorProximo();
            }
        }
    }
    
    /**
     * Solicita os dados do usuario para aplicar o filtro na lista de contatos.
     */
    public static void procuraLista() {

        
        System.out.println("Digite a primeira letra a exibir ou digite 99 para sair: ");
        String opcao = "";
        while (opcao != "99") {
            Scanner entradaUsuario = new Scanner(System.in);
            opcao = entradaUsuario.nextLine();
            if (opcao == "99") {
                break;
            } else {
                if (!opcao.equals("")) {
                    if (listaContatos.filtroContato(opcao)) {
                        exibeProcuraAnteriorProximo();
                    }
                    opcao = "99";
                } else {
                    System.out.println("� necess�rio informar pelo menos uma letra para iniciar a pesquisa.");
                }
            }
        }
    }

    /**
     * Metodo que exibe menu listar contato proximo/anterior. Retorna ao menu principal se o usuario informar 99.
     */
    public static void exibeProcuraAnteriorProximo() {
        Integer opcao = 0;
        while (opcao == 0) {
            try {
                Scanner entradaUsuario = new Scanner(System.in);
                System.out.println("Op��es: (1) Registro anterior | (2) Pr�ximo registro. | (99) Sair.");
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
                System.out.println("Op��o Inv�lida!");
                opcao = 0;
            }

        }
    }

    /**
     * Metodo que lista os contatos contidos na ListaOrdenada.
     */
    public static void listar() {
        System.out.println("Inicio da lista: ");
        listaContatos.exibeListaOrdenada();
        System.out.println("Fim da lista.");
    }
}
