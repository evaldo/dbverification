/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author luiz.rodrigues
 */
public class CommentDatabaseObject extends AbstractDatabaseObject{
    
    public CommentDatabaseObject(String objectName) {
        super(objectName);
        databaseObjectInstanceType = "COMMENT";
    }
    
    @Override
    public Boolean isValid() {
        return !objectName.isEmpty();
    }
    
}
