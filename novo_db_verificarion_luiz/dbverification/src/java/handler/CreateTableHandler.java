/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.util.List;
import model.ColumnDatabaseObject;
import model.TableDatabaseObject;

/**
 *
 * @author luiz.rodrigues
 */
public class CreateTableHandler extends AbstractHandler implements HandlerInterface{

    public CreateTableHandler(String textBlock) {
        super(textBlock);
    }

    @Override
    public void process() {
        findTableName();
        findAttributes();
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
    
    private String removeUnededChars(String str){
        return str.replaceAll("`", "").replaceAll("'", "").replaceAll("", "");
    }
    
    
}
