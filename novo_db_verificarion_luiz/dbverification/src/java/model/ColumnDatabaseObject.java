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
public class ColumnDatabaseObject extends AbstractDatabaseObject{
    
    public ColumnDatabaseObject(String objectName) {
        super(objectName);
        databaseObjectInstanceType = "COLUMN";
    }
    
    
    @Override
    protected boolean validatePrefix(String word) {
        return true; //ignoring prifix validation of superclass for this object
    }
    
}
