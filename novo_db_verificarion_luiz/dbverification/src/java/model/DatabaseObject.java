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
public class DatabaseObject {
    protected String objectName;

    public DatabaseObject(String objectName) {
        this.objectName = objectName;
    }
    
    public void validate() {
        
    }
}
