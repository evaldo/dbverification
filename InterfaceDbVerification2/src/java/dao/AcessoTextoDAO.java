package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.AcessoTexto;



public class AcessoTextoDAO {

    Connection conexao;

    public AcessoTextoDAO() {
    }

    public List<String> listarEstruturas() throws ClassNotFoundException {
        ArrayList listaEst = new ArrayList();
        Class.forName("org.apache.derby.jdbc.ClientDriver"); 
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/anotacaoSemantica", "teste", "teste");//acesso ao banco.
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT DS_PRMT_ACSSO_TXTO FROM T_SPDC_PRMT_ACSSO_TXTO");// filipe    

            while (resultado.next()) {//enquanto há resultado
                listaEst.add(resultado.getString("DS_PRMT_ACSSO_TXTO"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AcessoTextoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(listaEst);
        return listaEst;
    }

    public AcessoTexto selecionarTexto(String trecho) {

        AcessoTexto acess = new AcessoTexto();
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/anotacaoSemantica", "teste", "teste");//acesso ao banco.
            Statement operacao = conexao.createStatement();
            String  r = "SELECT * FROM T_SPDC_PRMT_ACSSO_TXTO WHERE DS_PRMT_ACSSO_TXTO = '" + trecho.trim() + "'";
            ResultSet resultado = operacao.executeQuery("SELECT * FROM T_SPDC_PRMT_ACSSO_TXTO WHERE DS_PRMT_ACSSO_TXTO  = '" + trecho.trim() + "'");// filipe    
            
            while (resultado.next()) {//enquanto há resultado
                acess.setIdparam(resultado.getLong("ID_PRMT_ACSSO_TXTO"));
                acess.setDesParam(resultado.getString("DS_PRMT_ACSSO_TXTO"));
                acess.setNumInicio(resultado.getInt("NU_INIC_ACSSO_TXTO"));
                acess.setNumFim(resultado.getInt("NU_FIM_ACSSO_TXTO"));
               
                acess.setFlagInicio(resultado.getString("FL_INIC_ACSSO_TXTO"));
                acess.setFlagFim(resultado.getString("FL_FIM_ACSSO_TXTO"));
                acess.setTipo(resultado.getString("IC_TIPO_ACSSO_TXTO"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AcessoTextoDAO.class.getName()).log(Level.SEVERE, null, ex);//se der erro
        }

        return acess;//instancia setada pela query.

    }
}
