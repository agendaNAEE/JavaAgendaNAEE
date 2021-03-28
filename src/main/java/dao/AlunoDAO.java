package dao;
import gerais.FabricaConexao;
import model.Aluno;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.apache.shiro.crypto.hash.Md5Hash;

public class AlunoDAO {
   
    public static Aluno loginUser(String email, String senha){
        
        String sql = "SELECT * FROM alunos WHERE email_aluno=? AND senha_aluno=?";
        Aluno temp = null;
        
        try(Connection con = FabricaConexao.criaConexao()){
 
            
            PreparedStatement trans = con.prepareStatement(sql);
            
            //criptografia
            Md5Hash senhaHash = new Md5Hash(senha);
            senha= senhaHash.toString();
            
            trans.setString(1, email);
            trans.setString(2, senha);
            
            ResultSet tuplas = trans.executeQuery();
            
            while(tuplas.next()){
                temp = new Aluno(tuplas.getInt("id_aluno"),tuplas.getString("nome_aluno"), tuplas.getLong("ra"), tuplas.getString("email_aluno"), tuplas.getString("curso"),  tuplas.getString("periodo_ano"), tuplas.getString("senha_aluno"));
            }
            
        }catch(SQLException ex){
            System.err.println("Erro de execução na consulta do usuário");
        }
        return temp;
    }
}
