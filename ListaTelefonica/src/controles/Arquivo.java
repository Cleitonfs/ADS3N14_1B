/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Contato;

/**
 *
 * @author Lucas
 */
public class Arquivo {

    private File file;
    private FileReader fr;
    private BufferedReader br;

    public Arquivo() throws FileNotFoundException {

        this.file = new File("contatos.txt");
        this.fr = new FileReader(this.file);
        this.br = new BufferedReader(this.fr);

        if (!this.file.exists()) {
            try {
                this.file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Erro ao tentar abrir o arquivo.");
            }
        }
    }

    public void escreveLinhaArquivo(String linha) throws IOException {
        FileWriter fr = new FileWriter(this.file, true);
        BufferedWriter bw = new BufferedWriter(fr);
        bw.newLine();
        bw.append(linha);
        bw.close();
    }

    public String leLinhaArquivo() {
        String linha = null;
        try {
            linha = this.br.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return linha;
    }

    public String[] leTodoArquivo() throws FileNotFoundException, IOException {

        FileReader fr = new FileReader(this.file);
        BufferedReader br = new BufferedReader(fr);
        int i = 0;
        String linha = "";
        while ((linha = br.readLine()) != null) {
            i++;
        }
        br.close();
        fr.close();

        if (i > 0) {
            linha = "";
            String linhas[] = new String[i];
            fr = new FileReader(this.file);
            br = new BufferedReader(fr);
            i = 0;
            while ((linha = br.readLine()) != null) {
                linhas[i] = linha;
                i++;
            }
            br.close();
            fr.close();
            return linhas;
        }

        return null;

    }

    public void fechaArquivo() {
        if (this.br != null) {
            try {
                this.br.close();
            } catch (IOException ex) {
                System.out.println("Erro ao tentar fechar o arquivo.");
            }
        }
    }
}
