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
@WebServlet(name = "JuroSimplesServlet", urlPatterns = {"/jurosimples.html"})
public class JuroSimplesServlet extends HttpServlet {

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
        /*Formatação de moeda*/
        Locale localeBR = new Locale("pt","BR");
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localeBR);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet - Juros Simples</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<table border='0' style='text-align:center' align='center' cellspacing='10' cellpadding='4'>");
            out.println("<tr>");
            out.println("<td colspan='3'><h1>SERVLETS</h1></td>");
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td width='250px'><a href='home.html'><font size='6'>Home</font></a></td>");
            out.println("<td width='250px'><a href='jurosimples.html'><font size='6'>Juros Simples</font></a></td>");
            out.println("<td width='250px'><a href='juroscomposto.html'><font size='6'>Juros Composto</font></a></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<hr/>");
            out.println("<form>");
            out.println("<table border='0' style='text-align:center' align='center' cellspacing='3'>");
            out.println("<tr>");
            out.println("<td width='32%'>Digite o valor do capital Inicial: <input type='text' name='c'></td>");
            out.println("<td width='32%'>Digite o valor do juros por mês: <input type='text' name='j'></td>");
            out.println("<td width='32%'>Digite a quantidade de meses: <input type='text' name='n'></td>");
            out.println("<td width='3%'><input type='submit' name='calc' value='OK'/></td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
            out.println("<hr/>");
            
            if(request.getParameter("calc")!=null){
                try{
                    double capital = Double.parseDouble(request.getParameter("c"));
                    double juros = Double.parseDouble(request.getParameter("j"));
                    int quantidadeMeses = Integer.parseInt(request.getParameter("n"));
                    /*M = P . ( 1 + ( i . n ) )*/
                    double montante = capital*(1+((juros/100)*quantidadeMeses));
                    out.println("<h3>Capital: "+dinheiro.format(capital)+"</h3>");
                    out.println("<h3>Taxa de juros: "+juros+"%</h3>");
                    out.println("<h3>Periodo: "+quantidadeMeses+" meses</h3>");                    
                    out.println("<h3>O valor do montante no final do periodo: "+dinheiro.format(montante)+"</h3>");
                    out.println("<hr/>");
                    
                }catch(Exception ex){
                    out.println("<h1 style='color:red;'>Erro ao converter os campos</h1>");
                    out.println("<hr/>");
                }
            }
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
