/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecpg.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author davil
 */
@WebServlet(name = "HomeServlet", urlPatterns = {"/home.html"})
public class HomeServlet extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet - Home</title>");            
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
            out.println("<h3>Sobre o projeto<br></h3>");            
            out.println("<dd>Projeto utilizando Servelets proposto pelo Professor Ricardo Pupo Larguesa.<br>"
                    + "Acessando qualquer um dos links, é apresentado um formulário, que após inseir os dados a montante será gerada. </dd>");            
            out.println("<hr/>");
            out.println("<h3>Integrantes:</h3>");
            out.println("<dl>");
            out.println("<dt><b>Daianne Aguiar</b></dt>");
            out.println("<dd> Formada em Técnico de Edificações pela ETEC São Vicente em 2010. <br>"
                    + "Formada em Engenharia Civil pel Universidade Santa Cecilia em 2015. <br>"
                    + "Atualmente cursando Análise e Desenvolvimento de Sistemas pela Fatec Praia Grande.</dd><br>");
            out.println("<dt><b>Davi Lima Pereira</b></dt>");
            out.println("<dd>Formado Técnico em Informatica pela ETEC Praia Grande em 2011. <br>");
            out.println("Atualmente cursando Analíse e Desenvolvimento de Sistemas pela Fatec Praia Grande.</dd><br>");
            out.println("<dt><b>Vinicius Santana Reis</b></dt>");
            out.println("<dd>Formado Técnico em Informatica pela Etec Praia Grande em 2017. <br>");
            out.println("Atualmente cursando Analíse e Desenvolvimento de Sistemas pela Fatec Praia Grande. <br>");
            out.println("Analista Desenvolvedor Java Junior. <br></dd>");
            out.println("</dl>");
            out.println("<hr/>");
            out.println("</body>");
            out.println("<footer>");
            out.println("<dd> º Programação Orientada a Objeto - POO - ADS - Fatec Praia Grande</dd>");
            out.println("</footer>");            
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
