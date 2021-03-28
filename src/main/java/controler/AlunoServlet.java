/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.AlunoDAO;
import gerais.Resposta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;

/**
 *
 * @author pfsta
 */
public class AlunoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
     private void login(HttpServletRequest request, PrintWriter out){
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        
        //avaliando se os parametros foram passados na requisicao
        if(email == null || senha == null){
            out.println(new Resposta(403, "para o login é necessário informar email e senha"));
        }else{
           Aluno temp = AlunoDAO.loginUser(email, senha);
            
            if(temp ==null){
                out.println(new Resposta(404, "usuario não cadastrado, ou senha incorreta "));
            }else{
                out.println(new Resposta(200, temp));
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
                    case "login":{
                        login(request, out);
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
