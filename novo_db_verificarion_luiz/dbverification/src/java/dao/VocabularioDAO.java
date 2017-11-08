/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luiz.rodrigues
 */
public class VocabularioDAO extends AbstractDAO{
    
    public Boolean IsAllowedWord(String word){
        String sql = "SELECT COUNT(1) AS TOTAL FROM T_SPDC_VOCB_CNTLD WHERE SG_VOCB_CNTLD = ?";
        try {
            int total = 0;
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, word);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                total = resultSet.getInt("TOTAL");
            }
            return total > 0;
        } catch (SQLException ex) {
            Logger.getLogger(VocabularioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
