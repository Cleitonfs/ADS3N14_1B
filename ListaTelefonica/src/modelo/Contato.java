package modelo;

import controles.Arquivo;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas
 */
public class Contato implements Comparable<Contato> {

    private int id;
    private String nome;
    private int ddd;
    private int telefone;

    public Contato() {
    }

    public Contato(String strLinha) {
        int pPos = 0;
        int nPos = strLinha.indexOf(";", pPos);
        this.id = Integer.valueOf(strLinha.substring(pPos, nPos));
        pPos = nPos + 1;
        nPos = strLinha.indexOf(";", pPos + 1);
        this.nome = strLinha.substring(pPos, nPos);
        pPos = nPos + 1;
        nPos = strLinha.indexOf(";", pPos + 1);
        this.ddd = Integer.valueOf(strLinha.substring(pPos, nPos));
        pPos = nPos + 1;
        nPos = strLinha.indexOf(";", pPos + 1);
        this.telefone = Integer.valueOf(strLinha.substring(pPos, nPos));
    }

    public Contato(int id, String nome, int ddd, int telefone) {
        this.id = id;
        this.nome = nome;
        this.ddd = ddd;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDdd() {
        return ddd;
    }

    public void setDdd(int ddd) {
        this.ddd = ddd;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean escreveContato() {

        try {
            Arquivo arquivo = new Arquivo();
            StringBuilder sb = new StringBuilder();
            sb.append(this.id).append(";").append(this.nome).append(";").append(this.ddd).append(";").append(this.telefone).append(";");
            arquivo.escreveLinhaArquivo(sb.toString());
            return true;
        } catch (IOException ex) {
            System.out.println("Erro ao escrever no arquivo.");
            return false;
        }

    }

    @Override
    public int compareTo(Contato o) {
        return this.getNome().toString().compareTo(o.getNome().toString());
    }

}
