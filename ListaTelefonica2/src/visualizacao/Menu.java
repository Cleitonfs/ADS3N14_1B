package visualizacao;

import estruturas.ArvoreBinaria;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Agenda;
import modelo.Contato;

/**
 * @version 1.3
 * @author Lucas
 */
public class Menu {

    int sequencia = 0;
    ArvoreBinaria<Contato> listaContatos = new ArvoreBinaria<Contato>();
    Agenda agenda = new Agenda();
    /**
     * Metodo que exibe o menu principal ao usuario. Retorna a opcao adquirida atraves de Java.Util.Scanner
     * @return numero da opcao selecionado pelo usuario
     */
    private String exibeMenu() {
        String opcao = "";
        Scanner menu = new Scanner(System.in);
        try {
            System.out.println("Digite a opcao desejada: ");
            System.out.println(
                    new StringBuilder("Adicionar").
                            append(" | Infix").
                            append(" | Prefix").
                            append(" | Posfix").
                            append(" | Largura").
                            append(" | Profundidade").
                            append(" | Excluir").
                            append(" | Ajuda").
                            append(" | Sair.").toString()
            );
            opcao = menu.next();
        } catch (Exception e) {
            opcao = "";
        }
        return opcao;

    }

    /**
     * Cria um usuario no sistema atraves da solicicao de dados utilizando a classe Java.Util.Scanner para interface com o usuario.
     * @return true, false
     */
    public boolean novoContato() {
        
        int id = agenda.getUltimoCodigo()+1;
        boolean valido = true;
        Integer ddd = 0;
        Integer telefone = 0;
                
        System.out.println("Adicionar contato: ");
        Scanner entradaUsuario = new Scanner(System.in);
        System.out.println("Nome: ");
        String nome = entradaUsuario.next();
        try {
            System.out.println("DDD: ");
            ddd = entradaUsuario.nextInt();
        } catch ( Exception e ) {
            System.out.println("DDD invalido");
            ddd = 0;
            valido = false;
        }
        
        try {
            System.out.println("Telefone: ");
            telefone = entradaUsuario.nextInt();
        } catch ( Exception e ) {
            System.out.println("Numero de telefone invalido");
            telefone = 0;
            valido = false;
        }
        
        if(valido){
            Contato contato = new Contato(id, nome, ddd, telefone);
            listaContatos.adicionar(contato);
            agenda.setUltimoCodigo(id);
        }
        
        return valido;
    }
    
    private void carregaArquivoAgenda() {
        listaContatos = agenda.carregaAgendaArquivo();
    }

    private void salvaArquivo(){
        agenda.salvarArquivo(listaContatos);
    }
    
    private void escreveListaInfix() {
        escreveLista( listaContatos.infixTraversal() );
    }
    
    private void escreveListaPostfix() {
        escreveLista( listaContatos.postfixTraversal() );
    }        
    
    private void escreveListaPrefix() {
         escreveLista( listaContatos.prefixTraversal() );
    }
    
    private void buscaLargura() {
        System.out.println("Buscar: ");
        Scanner entradaUsuario = new Scanner(System.in);
        String nome = entradaUsuario.nextLine();
        Contato comparar = new Contato();
        comparar.setNome(nome);
        Contato busca = listaContatos.buscaLargura(comparar);
        if(busca!=null) {
            System.out.println("Resultado: ("+listaContatos.getComparacoes()+" comparacoes)");
            agenda.escreveContato(busca);
        }
    }
    
    private void buscaProfundidade() {
        System.out.println("Buscar: ");
        Scanner entradaUsuario = new Scanner(System.in);
        String nome = entradaUsuario.nextLine();
        Contato comparar = new Contato();
        comparar.setNome(nome);
        Contato busca = listaContatos.buscaProfundidade(comparar);
        if(busca!=null) {
            System.out.println("Resultado: ("+listaContatos.getComparacoes()+" comparacoes)");
            agenda.escreveContato(busca);
        }        
    }
    
    public void escreveLista(ArrayList<Contato> lista) {
        for(int i=0;i<lista.size();i++) {
            agenda.escreveContato(lista.get(i));
        }        
    }
    
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.carregaArquivoAgenda();
        String opcao = "";

        while (opcao != "sair") {
            opcao = menu.exibeMenu();
            switch (opcao) {
                case "adicionar":
                    menu.novoContato();
                    opcao = "";
                    break;
                case "infix":
                    System.out.println("Infix");
                    menu.escreveListaInfix();
                    opcao = "";
                    break;
                case "prefix":
                    System.out.println("Prefix");
                    menu.escreveListaPrefix();
                    opcao = "";
                    break;
                case "posfix":
                    System.out.println("Posfix");
                    menu.escreveListaPostfix();
                    opcao = "";
                    break;
                case "largura":
                    System.out.println("Busca Largura");
                    menu.buscaLargura();
                    opcao = "";
                    break;
                case "profundidade":
                    System.out.println("Busca Profundidade");
                    menu.buscaProfundidade();
                    opcao = "";
                    break;
                case "excluir":
                    System.out.println("Excluir");
                    menu.removeContato();
                    opcao = "";
                    break;
                case "sair":
                    System.out.println("Salvando alteracoes.");
                    menu.salvaArquivo();
                    System.out.println("Tchau!");
                    System.exit(0);
                default:
                    System.out.println("Opcao invalida!");
                    opcao = "";
            }
        }

    }

    /**
     * Metodo que solicita Id do contato que deseja remover. Exibe mensagens com o status da solicitacao.
     */
    public void removeContato() {
        System.out.println("Nome:");
        String nome = "";
        Scanner entradaUsuario = new Scanner(System.in);
        nome = entradaUsuario.nextLine();
        Contato contato = new Contato();
        contato.setNome(nome);
        if(listaContatos.remove(contato)){
            System.out.println("Contato "+nome+" removido.");
        } else {
            System.out.println("Não foi possivel remover o contato.");
        }
        
    }
    
    /**
     * Solicita os dados do usuario para aplicar o filtro na lista de contatos.
     */
    public void procuraLista() {
        
    }

    /**
     * Metodo que exibe menu listar contato proximo/anterior. Retorna ao menu principal se o usuario informar 99.
     */
    public static void exibeProcuraAnteriorProximo() {
        String opcao = "";
        while (opcao.equals("")) {
            try {
                Scanner entradaUsuario = new Scanner(System.in);
                System.out.println("Opcoes: Anterior | Proximo | Sair.");
                opcao = entradaUsuario.next();
                if (opcao.equals("anterior") || opcao.equals("proximo") ) {
                    opcao = "sair";
                    exibeProcuraAnteriorProximo();
                }
                opcao = "";
            } catch (Exception e) {
                System.out.println("Opcao Invalida!");
                opcao = "";
            }

        }
    }

}
