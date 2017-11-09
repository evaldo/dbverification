/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.util.List;
import model.AbstractDatabaseObject;
import model.ColumnDatabaseObject;
import model.CommentDatabaseObject;
import model.DatabaseObject;
import model.TableDatabaseObject;

/**
 *
 * @author luiz.rodrigues
 */
public class CreateTableHandler extends AbstractHandler implements Handler{

    public CreateTableHandler(String textBlock) {
        super(textBlock);
    }

    @Override
    public List<AbstractDatabaseObject> process() {
        findTableName();
        findAttributes();
        findComments();
        return findInvalidObjects();
    }
    
    private void findTableName(){
        String tableName;
        int endIndex = textBlock.indexOf("(");
        tableName = textBlock.substring(0,endIndex);
        tableName = tableName.trim();
        
        int startIndex = tableName.lastIndexOf(".");
        if (startIndex == -1){
            startIndex = tableName.lastIndexOf(" ");
        }
        
        tableName = tableName.substring(startIndex+1, tableName.length()-1);
        tableName = removeUnededChars(tableName);
        
        TableDatabaseObject tableDatabaseObject = new TableDatabaseObject(tableName);
        dbObjects.add(tableDatabaseObject);
    }
    
    private void findAttributes(){
        int startIndex = textBlock.indexOf("(");
        int endIndex = textBlock.indexOf(")");
        String[] attributes = textBlock.substring(startIndex,endIndex).split(",");
        for(String attribute : attributes){
            String s;
            attribute = attribute.replace("(", "");
            attribute = attribute.trim();
            s=removeUnededChars(attribute.split(" ")[0]);
            dbObjects.add(new ColumnDatabaseObject(s));
        }
    }
    
    private void findComments(){
        int lastIndexedIndex = 0;
        while (lastIndexedIndex != -1) {
            int startIndex = textBlock.indexOf("COMMENT", lastIndexedIndex);
            int endIndex = textBlock.indexOf(",", startIndex);
            
            if (startIndex == -1){
                break;
            }
            if (endIndex == -1){
                //TODO lançar exceção pois se entrar neste if é porque achou um comando sem ponto e vírgula
                break;
            }
            String s =removeUnededChars(textBlock.substring(startIndex, endIndex));
            dbObjects.add(new CommentDatabaseObject(s));
            lastIndexedIndex = endIndex;
        }
    }
    
}
