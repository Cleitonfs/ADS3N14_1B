/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    public Contato(String strLinha) {
        int pPos = 0;
        int nPos = strLinha.indexOf(";", pPos);
        this.id = Integer.valueOf(strLinha.substring(pPos, nPos));
        pPos = nPos+1;
        nPos = strLinha.indexOf(";", pPos+1);
        this.nome = strLinha.substring(pPos, nPos);
        pPos = nPos+1;
        nPos = strLinha.indexOf(";", pPos+1);
        this.ddd = Integer.valueOf(strLinha.substring(pPos, nPos));
        pPos = nPos+1;
        // ele não pode buscar por ;, é o ultimo campo, não há ; então pega oque sobrou da linha !
        //nPos = strLinha.indexOf(";", pPos+1);
        this.telefone = Integer.valueOf(strLinha.substring(pPos, strLinha.length()));
    }

    public Contato(String nome, int ddd, int telefone) {
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

    public boolean escreveContato(){
        
        Arquivo arquivo = new Arquivo();
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.id);
            sb.append(";");
            sb.append(this.nome);
            sb.append(";");
            sb.append(this.ddd);
            sb.append(";");
            sb.append(this.telefone);
            arquivo.escreveLinhaArquivo(sb.toString());
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Contato.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    @Override
    public int compareTo(Contato o) {
        return this.getNome().toString().compareTo(o.getNome().toString());
    }
    
    public String toString(){
        return "ID: "+id + " Nome: "+nome+ " DDD: "+ddd + " Telefone: "+telefone;
    }

}
