/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import java.util.List;
import model.AbstractDatabaseObject;
import model.DatabaseObject;

/**
 *
 * @author luiz.rodrigues
 */
public interface Handler {
    public List<AbstractDatabaseObject> process();
}
