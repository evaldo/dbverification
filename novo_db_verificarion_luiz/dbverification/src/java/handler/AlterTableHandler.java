/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import com.sun.corba.se.impl.util.PackagePrefixChecker;
import java.util.List;
import model.AbstractDatabaseObject;
import model.ColumnDatabaseObject;
import model.CommentDatabaseObject;
import model.ForeignKeyDatabaseObject;
import model.PrimaryKeyDatabaseObject;
import model.TableDatabaseObject;
import util.ReservedWords;

/**
 *
 * @author luiz.rodrigues
 */
public class AlterTableHandler extends AbstractHandler implements Handler{

    public AlterTableHandler(String textBlock) {
        super(textBlock);
    }

    @Override
    public List<AbstractDatabaseObject> process() {
        findAttributes();
        return findInvalidObjects();
    }
    
    private void findAttributes(){
        int startIndex = textBlock.indexOf("ALTER TABLE")+11; //index of ALTER TABLE string plus "ALTER TABLE" string lenght
        String str = textBlock.substring(startIndex);
        str = str.substring(getNextReservedWordEndPosition(str, 0));
        String[] attributes = str.split("ADD");
        for(String attribute : attributes){
            if (attribute.lastIndexOf("CONSTRAINT")>-1){
                //is a constraint
                instanceConstraint(attribute);
            }else{
                //is a column
            }
        }
    }
    
    private void instanceConstraint(String str){
        Integer startIndex = str.indexOf("CONSTRAINT")+10; //plus "CONSTRAINT" word lenght
        Integer endIndex = getNextReservedWordStartPosition(str, startIndex);
        
        String constrant = removeUnededChars(str.substring(startIndex, endIndex)).trim();
        if (str.lastIndexOf("PRIMARY KEY")>-1){
                //is a PRIMARY key constraint
                instanceConstraintPK(constrant);
        }
        if (str.lastIndexOf("FOREIGN KEY")>-1){
                //is a FOREIGN key constraint
                instanceConstraintFK(constrant);
        }
    }
    private void instanceConstraintPK(String constrant){
        dbObjects.add(new PrimaryKeyDatabaseObject(constrant));
    }
    private void instanceConstraintFK(String constrant){
        dbObjects.add(new ForeignKeyDatabaseObject(constrant));
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
