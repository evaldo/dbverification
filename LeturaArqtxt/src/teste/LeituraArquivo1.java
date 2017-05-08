/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Filipe
 */
public class LeituraArquivo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);

        System.out.printf("Informe o nome de arquivo texto:\n");
        String nome = ler.nextLine();

        System.out.printf("\nConteúdo do arquivo texto:\n");
        try {
            FileReader arq = new FileReader(nome);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha
            linha.trim();
            while(linha!=null){
            if (linha.contains("CREATE TABLE")) {

                String str = "";
                char[] array = new char[linha.length()];
                linha.getChars(12, linha.lastIndexOf("("), array, 0);
                System.out.printf("Nome da tabela: ");
                String temp = String.copyValueOf(array);
                System.out.print(temp.trim() + "\n");

            //d:\tabela.sql
            System.out.println("Atributos:");
            do {
                linha = lerArq.readLine();
                linha.trim();
                if (linha.contains("PRIMARY")) {
                    break;
                }
                char[] arrayatt = new char[linha.length()];
                linha.getChars(0, linha.lastIndexOf(" "), arrayatt, 0);
                String tempatt = String.copyValueOf(arrayatt);

                System.out.println(tempatt.trim());

            } while (!linha.contains("PRIMARY"));

            System.out.println("Pk:");
            // linha = lerArq.readLine();
            linha.trim();
            char[] arraypk = new char[linha.length()];
            linha.getChars(linha.indexOf("(") + 1, linha.lastIndexOf(")"), arraypk, 0);
            String tempk = String.copyValueOf(arraypk);

            System.out.println(tempk.trim());
            }
           else {
              linha = lerArq.readLine();
           }
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        System.out.println();
    }
}
