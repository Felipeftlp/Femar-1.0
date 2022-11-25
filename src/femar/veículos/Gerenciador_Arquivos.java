/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package femar.veículos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author felip
 */
public class Gerenciador_Arquivos {
    private ObjectOutputStream saida;
    private ObjectInputStream entrada;
    private String nomeDoArquivo;
    
    public Gerenciador_Arquivos(String nomeDoArquivo) {
        saida = null;
        entrada = null;      
        this.nomeDoArquivo = nomeDoArquivo;
    }
    
    public void escrever(Object obj) throws IOException{
        FileOutputStream arquivoSaida = new FileOutputStream(nomeDoArquivo);
        saida = new ObjectOutputStream(arquivoSaida);
        saida.writeObject(obj);
        saida.close();
    }

    public Object ler() throws IOException, ClassNotFoundException{
        FileInputStream arquivoEntrada = new FileInputStream(nomeDoArquivo);
        entrada = new ObjectInputStream(arquivoEntrada);
        Object obj = entrada.readObject();
        entrada.close();
        return obj;
    }
}
