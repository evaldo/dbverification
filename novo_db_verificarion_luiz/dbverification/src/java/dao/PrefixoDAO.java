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
public class PrefixoDAO extends AbstractDAO{
    
    public Boolean IsAllowedPrefixForObject(String prefix, String databaseObjectType){
        String sql = "SELECT COUNT(1) AS TOTAL FROM T_SPDC_PRFX WHERE UPPER(DS_TIPO_DADO_PRFX) = ? and UPPER(SG_PRFX) = ?";
        try {
            int total = 0;
            PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            preparedStatement.setString(1, databaseObjectType);
            preparedStatement.setString(2, prefix.concat("_"));
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                total = resultSet.getInt("TOTAL");
            }
            return total > 0;
        } catch (SQLException ex) {
            Logger.getLogger(PrefixoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
