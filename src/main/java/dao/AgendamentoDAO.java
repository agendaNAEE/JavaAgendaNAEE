/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import gerais.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import model.Agendamento;

/**
 *
 * @author pfsta
 */
public class AgendamentoDAO {
    
    public static Vector<Agendamento> consultaAluno(String nome){
        Vector<Agendamento> resultado = new Vector<>();
        
        String sql = "SELECT * FROM agendamentos WHERE aluno_agendamento=?";
        Agendamento temp = null;
        
        try(Connection con = FabricaConexao.criaConexao()){
 
            
            PreparedStatement trans = con.prepareStatement(sql);
            
            
            trans.setString(1, nome);
            
            ResultSet tuplas = trans.executeQuery();
            
            while(tuplas.next()){
                temp = new Agendamento(tuplas.getString("servidor_agendamento"),
                        tuplas.getString("data_horario"));
                resultado.add(temp);
            }
            
        }catch(SQLException ex){
            System.err.println("Erro de execução na consulta do usuário");
        }
        return resultado;
    }
    
}
