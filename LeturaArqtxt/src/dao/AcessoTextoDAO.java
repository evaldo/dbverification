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

    public AcessoTexto selecionarTexto(String trecho) {
        Connection conexao;
         AcessoTexto acess = new AcessoTexto();
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/anotacaoSemantica", "teste", "teste");//acesso ao banco.
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("SELECT * FROM T_SPDC_PRMT_ACSSO_TXTO WHERE DS_PRMT_ACSSO_TXTO LIKE '" + trecho.trim()+"'");// filipe    

 while (resultado.next()) {//enquanto há resultado
            acess.setIdparam(resultado.getLong("ID_PRMT_ACSSO_TXTO"));
            acess.setDesParam(resultado.getString("DS_PRMT_ACSSO_TXTO"));
            acess.setNumInicio(resultado.getInt("NU_INIC_ACSSO_TXTO"));
            acess.setNumFim(resultado.getInt("NU_FIM_ACSSO_TXTO"));
            acess.setTamanho(resultado.getInt("NU_TMHO_TXTO"));
            acess.setFlagFim(resultado.getString("FL_FIM_ACSSO_TXTO"));
            acess.setTipo(resultado.getString("IC_TIPO_ACSSO_TXTO"));
 }
        } catch (SQLException ex) {
            Logger.getLogger(AcessoTextoDAO.class.getName()).log(Level.SEVERE, null, ex);//se der erro
        }

        return acess;//instancia setada pela query.

    }
}
