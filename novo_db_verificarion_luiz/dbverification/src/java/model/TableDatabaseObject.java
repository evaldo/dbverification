/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author luiz.rodrigues
 */
public class TableDatabaseObject extends AbstractDatabaseObject{
    
    public TableDatabaseObject(String objectName) {
        super(objectName);
        databaseObjectInstanceType = "TABELA";
    }
}
