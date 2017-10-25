/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.util.ArrayList;
import java.util.List;
import model.DatabaseObject;

/**
 *
 * @author luiz.rodrigues
 */
public class AbstractHandler {
    protected String textBlock;
    protected List<DatabaseObject> dbObjects = new ArrayList<DatabaseObject>();

    public AbstractHandler(String textBlock) {
        this.textBlock = textBlock;
    }
    
}
