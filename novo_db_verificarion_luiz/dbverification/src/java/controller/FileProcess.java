/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import handler.AbstractHandler;
import handler.CreateTableHandler;
import handler.HandlerInterface;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luiz.rodrigues
 */
public class FileProcess {
    private static final Charset CHARSET = Charset.forName("cp1252");
    private List<HandlerInterface> handlers = new ArrayList<HandlerInterface>();
    
    /**
     * Singleton Implementation
     */
    private static FileProcess fileProcess;
    private FileProcess(){};
    public static FileProcess getInstance(){
        if (fileProcess == null){
            fileProcess = new FileProcess();
        }
        return  fileProcess;
    }
    
    public void processFile(String path) throws IOException{
        String dbScript = readFile(path, CHARSET);
        findCreateTable(dbScript);
        for (HandlerInterface handler : handlers){
            handler.process();
        }
    }
    
    private void findCreateTable(String dbScript){
        int lastIndexedIndex = 0;
        while (lastIndexedIndex != -1){
            int lastDbCommantIndex = dbScript.indexOf("CREATE TABLE", lastIndexedIndex);
            int lastSemicolom = dbScript.indexOf(";", lastDbCommantIndex);
            
            if (lastDbCommantIndex == -1){
                break;
            }
            if (lastSemicolom == -1){
                //TODO lançar exceção pois se entrar neste if é porque achou um comando sem ponto e vírgula
                break;
            }
            
            CreateTableHandler createHandler = new CreateTableHandler(dbScript.substring(lastDbCommantIndex, lastSemicolom));
            handlers.add(createHandler);
            lastIndexedIndex = lastSemicolom;
        }
    }
    
    private static String readFile(String path, Charset encoding) throws IOException
    {
      byte[] encoded = Files.readAllBytes(Paths.get(path));
      return new String(encoded, encoding);
    }
}
