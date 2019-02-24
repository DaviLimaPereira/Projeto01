/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author davil
 */
@WebServlet(name = "JurosCompostoServlet", urlPatterns = {"/juroscomposto.html"})
public class JurosCompostoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*Formatação de moeda*/
        Locale localeBR = new Locale("pt","BR");
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet - Juros Composto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>SERVLETS</h1>");
            out.println("<h2>Juros Composto</h2>");
            out.println("<hr/>");
            out.println("<form>");
            out.println("Digite o valor do Capital Inicial: <input type='text' name='c'>");
            out.println("Digite o vaor do juros por mês: <input type='text' name='j'>");
            out.println("Digite a quantidade de meses: <input type='text' name='n'>");
            out.println("<input type='submit' name='calc' value='ok'/>");
            out.println("</form>");
            out.println("<hr/>");
            
            if(request.getParameter("calc")!=null){
                try{
                    double c = Double.parseDouble(request.getParameter("c"));
                    double j = Double.parseDouble(request.getParameter("j"));
                    int n = Integer.parseInt(request.getParameter("n"));
                    /*M = P . (1 +  i)^n*/
                    double m = c*Math.pow((1+(j/100)),n);
                    out.println("<h3>Capital: "+dinheiro.format(c)+"</h3>");
                    out.println("<h3>Taxa de juros: "+j+"%</h3>");
                    out.println("<h3>Periodo: "+n+" meses</h3>");                    
                    out.println("<h3>O valor do montante no final do periodo: "+dinheiro.format(m)+"</h3>");
                    
                }catch(Exception ex){
                    out.println("<h1 style='color:red;'>Erro ao converter os campos</h1>");
                }
            }
            out.println("<hr/>");
            out.println("<h3><a href='index.html'>Voltar</a></h3>");
            out.println("</body>");
            out.println("</html>");
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
