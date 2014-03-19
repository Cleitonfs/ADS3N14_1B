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
    
    

    public Arquivo() {
        this.file = new File("d:\\temp\\contatos.txt" );
        if(!this.file.exists()){
            try {
                this.file.createNewFile();
            } catch (IOException ex) {
                System.out.println("Erro ao tentar abrir o arquivo.");
            }
        }
    }
    
    public void escreveLinhaArquivo(String linha) throws IOException {
        FileWriter fr = new FileWriter(this.file,true);
        BufferedWriter bw = new BufferedWriter(fr);
        bw.append(linha);
        bw.close();
    }
    
   
    public String leLinhaArquivo () throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(this.file);
        BufferedReader br = new BufferedReader(fr);
        String linha = br.readLine();
        br.close();
        return linha;
    }
    
    public String[] leTodoArquivo() throws FileNotFoundException, IOException {
        
        
        FileReader fr = new FileReader(this.file);
        BufferedReader br = new BufferedReader(fr);
        int i=0;
        String linha = null;
        while(true){
            linha = br.readLine();
            if(linha==null)  break;
            i++;
        }
        br.close();
        fr.close();
        
        
        /// ai q ve a bambiarra !!
        // pelomenos funciona
        String linhas[] = new String[i];
        fr = new FileReader(this.file);
        br = new BufferedReader(fr);
        i=0;
        while(true){
            linhas[i] = br.readLine();
            if(linha==null)  break;
            i++;
        }
        br.close();
        fr.close();
        
        

        
        return linhas;
    }
    
    
    public void fechaArquivo() {
        
    }

}
