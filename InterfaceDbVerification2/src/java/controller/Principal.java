/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AcessoTextoDAO;
import java.io.File;
import java.io.IOException;
import static java.util.Collections.list;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.AcessoTexto;

/**
 *
 * @author alunoces
 */
@WebServlet(name = "Principal", urlPatterns = {"/Principal"," /resultado"})
@MultipartConfig
public class Principal extends HttpServlet {
    private String pastaArquivos = null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config); //To change body of generated methods, choose Tools | Templates.
    pastaArquivos = getServletContext().getInitParameter("pastaArquivos");
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
        
         if(request.getRequestURI().contains("/Principal")){
           
             try{
             AcessoTextoDAO actdao= new AcessoTextoDAO();
              List l = actdao.listarEstruturas();
              System.out.println(l);
            request.setAttribute("est", l);
             }catch(Exception e ){
              
             }
           
            
             
        request.getRequestDispatcher("/WEB-INF/selecao.jsp").forward(request, response);
       }
        
        
        
        
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
       
        
        if(request.getRequestURI().contains("/resultado")) {
            String estrutura = request.getParameter("est");
            
            String pastaProgeto=getServletContext().getRealPath("");
            System.out.println(pastaProgeto);
        String salvarEm = pastaProgeto+File.separator+pastaArquivos;
        System.out.println("Salvando arquivo em: " +salvarEm);
        File pasta = new File(salvarEm);
        if(!pasta.exists()){
        pasta.mkdir();
        }
        Part arquivoSelecionado = request.getPart("arquivo");
        String nomeArquivo = arquivoSelecionado.getSubmittedFileName();
        
        //gravar o arquivo no disco
        String caminhoArquivo = salvarEm+File.separator+ nomeArquivo;
        arquivoSelecionado.write(caminhoArquivo);
        request.getRequestDispatcher("/WEB-INF/resultado.jsp").forward(request, response);
        
            AcessoTexto act = new AcessoTexto();
            act.exibirConteudo(estrutura,nomeArquivo);
       }
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
