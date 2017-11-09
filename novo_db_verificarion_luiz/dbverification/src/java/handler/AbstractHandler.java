/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.util.ArrayList;
import java.util.List;
import model.AbstractDatabaseObject;
import model.DatabaseObject;
import util.ReservedWords;

/**
 *
 * @author luiz.rodrigues
 */
public class AbstractHandler {
   
    
    protected String textBlock;
    protected List<DatabaseObject> dbObjects = new ArrayList<>();
    
    public AbstractHandler(String textBlock) {
        this.textBlock = textBlock;
    }
    
    protected List<AbstractDatabaseObject> findInvalidObjects(){
        //TODO: Throw handler not processed exception
        List<AbstractDatabaseObject> invalidObjects = new ArrayList<>();
        for(DatabaseObject dbObject : dbObjects){
            if (!dbObject.isValid()){
                invalidObjects.add((AbstractDatabaseObject)dbObject);
            }
        }
        return invalidObjects;
    }
    
    protected Integer getNextReservedWordEndPosition(String str, Integer startIndex){
        Integer currentNextReservedWordPosition = -1;
        String stringToSearchIn = str.substring(startIndex);
        for (String reservedWord : ReservedWords.reservedWords){
           Integer index = stringToSearchIn.indexOf(reservedWord.concat(" "));
           if (index > -1){
               index += reservedWord.length();
               if (currentNextReservedWordPosition == -1 || index < currentNextReservedWordPosition){
                   currentNextReservedWordPosition = index;
               }
           }
        }
        return currentNextReservedWordPosition+startIndex;
    }
    
    protected Integer getNextReservedWordStartPosition(String str, Integer startIndex){
        Integer currentNextReservedWordPosition = -1;
        String stringToSearchIn = str.substring(startIndex);
        for (String reservedWord : ReservedWords.reservedWords){
           Integer index = stringToSearchIn.indexOf(reservedWord.concat(" "));
           if (index > -1){
               if (currentNextReservedWordPosition == -1 || index < currentNextReservedWordPosition){
                   currentNextReservedWordPosition = index;
               }
           }
        }
        return currentNextReservedWordPosition+startIndex;
    }
    
    protected String removeUnededChars(String str){
        return str.replaceAll("`", "").replaceAll("'", "").replaceAll("", "").replaceAll("	", "");
    }
    
}
