/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.AgendamentoDAO;
import gerais.Resposta;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Agendamento;

/**
 *
 * @author pfsta
 */
public class AgendamentoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    
    private void consulta(HttpServletRequest request, PrintWriter out){
        String nome = request.getParameter("nome");
        
        //avaliando se os parametros foram passados na requisicao
        if(nome == null ){
            out.println(new Resposta(403, "para o login é necessário informar o nome do aluno"));
        }else{
          Vector<Agendamento> agendamentos = AgendamentoDAO.consultaAluno(nome);
            
            if(agendamentos ==null){
                out.println(new Resposta(404, "sem consultas cadastradas"));
            }else{
                out.println(new Resposta(200, agendamentos));
            }
        }
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
           
            String servico = request.getParameter("servico");
            
            if(servico == null){
                //aqui temos que enviar uma mensagem dizendo que o servico nao foi especificado
                out.println("serviço não especificado");
            }else{
                switch(servico){
                    case "consulta":{
                        consulta(request, out);
                    }break;
                    default:{
                        out.println("serviço não disponível para o usuário");
                    }
                }
            }
        }catch(Exception e){
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
