/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luiz.rodrigues
 */
public abstract class AbstractDAO {
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://104.131.170.80:3306/padrao_documento?useSSL=false", "remote", "qweasd3274");
        } catch (SQLException ex) {
            Logger.getLogger(VocabularioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static Statement getStatement(){
        try {
            return getConnection().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(AbstractDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
