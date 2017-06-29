/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dao.AcessoTextoDAO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Filipe
 */
public class AcessoTexto {
    private Long Idparam;
    private String DesParam;
    private int NumInicio;
    private int NumFim;
    private int Tamanho;
    private String FlagFim;
    private String Tipo;

    public AcessoTexto() {
    }
    
    

    public void exibirConteudo(String nomeArqui, String trecho){
        try {
            FileReader arq = new FileReader(nomeArqui);//leitor de arquivos, recebe como parametro o caminho do arquivo.
            BufferedReader lerArq = new BufferedReader(arq);//leitor do arquivo em parates

            String linha = lerArq.readLine();// lê a primeira linha e salta
            linha = linha.trim();//elimina os espaços em branco dos extremos da string

            while (linha != null) {//enquanto na linha houver algum caractere faça:
                linha = lerArq.readLine();
                if (linha == null) {
                    arq.close();//para não travar o projeto
                } 
                else if (trecho.contains("CREATE TABLE") && linha.contains("CREATE TABLE")) {
                    AcessoTextoDAO acDAO = new AcessoTextoDAO();
                    String flag = acDAO.selecionarTexto(trecho).getFlagFim();
                    int num_inicio = linha.lastIndexOf(trecho) + trecho.length();//talvez deletar do banco
                    int num_fim = linha.indexOf(flag.trim());
                    char[] array = new char[linha.length()];//cria um array com o tamanho da linha
                    if (array.length > 0) {//se o array for maior que 0 faça
                        linha.getChars(num_inicio, num_fim, array, 0);//pega um determinado trecho de codigo
                        System.out.printf("Nome da tabela: ");
                        String temp = String.copyValueOf(array);//de array p/ string
                        System.out.print(temp.trim() + "\n");
                    }
                    while (!linha.contains(");") ) {
                        linha = lerArq.readLine();
                        linha = linha.trim();
                        if (!linha.contains(");") ) {
                            char[] arrayColunas = new char[linha.length()];
                            int lc = linha.indexOf(" ");
                            linha.getChars(0, linha.indexOf(" "), arrayColunas, 0);
                            System.out.printf("Nome da coluna: ");
                            String tempColuna = String.copyValueOf(arrayColunas);//de array p/ string
                            System.out.print(tempColuna.trim() + "\n");
                        }
                    }
                }
                else if (linha.contains(trecho.trim())) {//se esta linha tiver o trecho que quero faça:
                    linha = linha.trim();
                    AcessoTextoDAO acDAO = new AcessoTextoDAO();
                    String flag = acDAO.selecionarTexto(trecho).getFlagFim();
                    int num_inicio = linha.lastIndexOf(trecho) + trecho.length();//talvez deletar do banco
                    int num_fim = linha.lastIndexOf(flag.trim());
                    int tamanhoLinha;
                    if (linha.contains("--")) {//verificar comentários
                        tamanhoLinha = linha.trim().lastIndexOf("--");//vé o tamanho da linha caso o cometario não esta no inicio da linha
                    } else {
                        tamanhoLinha = linha.length();
                    }
                    char[] array = new char[tamanhoLinha];//cria um array com o tamanho da linha
                    if (array.length > 0) {//se o array for maior que 0 faça
                        linha.getChars(num_inicio, num_fim, array, 0);//pega um determinado trecho de codigo
                        System.out.printf("Nome da tabela: ");
                        String temp = String.copyValueOf(array);//de array p/ string
                        System.out.print(temp.trim() + "\n");
                    }
                }
            }
            //d:\tabela.sql CREATE TABLE COMMENT --COMMENT 
            //D:\ProjetosGit\dbverification\script_create_database.sql CREATE TABLE
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",e.getMessage());
        }
    
    }
    
    
    
    
    public Long getIdparam() {
        return Idparam;
    }

    public void setIdparam(Long Idparam) {
        this.Idparam = Idparam;
    }

    public String getDesParam() {
        return DesParam;
    }

    public void setDesParam(String DesParam) {
        this.DesParam = DesParam;
    }



    public String getFlagFim() {
        return FlagFim;
    }

    public void setFlagFim(String FlagFim) {
        this.FlagFim = FlagFim;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public int getNumInicio() {
        return NumInicio;
    }

    public void setNumInicio(int NumInicio) {
        this.NumInicio = NumInicio;
    }

    public int getNumFim() {
        return NumFim;
    }

    public void setNumFim(int NumFim) {
        this.NumFim = NumFim;
    }

    public int getTamanho() {
        return Tamanho;
    }

    public void setTamanho(int Tamanho) {
        this.Tamanho = Tamanho;
    }
    
    
    
}
