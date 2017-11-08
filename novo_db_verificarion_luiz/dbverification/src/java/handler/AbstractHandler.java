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
    
}
