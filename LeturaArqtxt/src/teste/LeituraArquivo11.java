/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import dao.AcessoTextoDAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Filipe
 */
public class LeituraArquivo11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.printf("Informe o nome de arquivo texto:\n");
        String nomeArqui = ler.nextLine();

        System.out.printf("Informe o nome de arquivo texto:\n");
        String trecho = ler.nextLine();

        System.out.printf("\nConteúdo do arquivo texto:\n");
        try {
            FileReader arq = new FileReader(nomeArqui);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha
            linha.trim();
            //lerArq.readLine();
            while (linha != null) {
                //trecho.trim();
                linha = lerArq.readLine();
                if (linha == null) {
                    arq.close();
                } else if (linha.contains(trecho.trim())) {

                    AcessoTextoDAO acDAO = new AcessoTextoDAO();
                    String flag = acDAO.selecionarTexto(trecho).getFlagFim();
                    int num_inicio = linha.lastIndexOf(trecho) + trecho.length();
                    int num_fim = linha.indexOf(flag.trim());

//int num_inicio = acDAO.selecionarTexto(trecho).getNumFim();//deverá ser modificado taidolvez remov
int tamanhoLinha;
                    if (linha.contains("--")) {
                        tamanhoLinha = linha.trim().lastIndexOf("--");
                    }
                    else{
                        
                    tamanhoLinha = linha.length();
                    }

                    char[] array = new char[tamanhoLinha];
if(array.length > 0 ){
                    linha.getChars(num_inicio, num_fim, array, 0);
                    System.out.printf("Nome da tabela: ");
                    String temp = String.copyValueOf(array);
                    System.out.print(temp.trim() + "\n");
}
                }

            }
            // arq.close();
            //d:\tabela.sql CREATE TABLE COMMENT --COMMENT
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        System.out.println();

    }
}
