/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlet;

import com.session.NewSessionBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
public class NewServlet extends HttpServlet {
    
    @EJB
    private NewSessionBean newSessionBean;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        try {            
            out.println("<html>");
            out.println("<body>");
            out.println("<h1><center>Sewa Kamera Alfonso</center></h1>");
            out.println("<br/>");
            String kam = request.getParameter("kam");
            
            if ((kam != null) && (kam.length() > 0)) {
                double d = Double.parseDouble(kam);
                if (request.getParameter("biaya") != null){
                    String cefa = newSessionBean.businessMethod(d);
                    out.println("<p><center>Biaya Sewa Total: Rp."+cefa+"</center></p>");
                }     
            } else {
                out.println("<center>");
                out.println("<p>Waktu pinjam (hari):</p>");
                out.println("<form method=\"get\">");
                out.println("<p><input type=\"text\" name=\"kam\" size=\"20\"></p>");
                out.println("<br/>");
                out.println("<input type=\"submit\" name=\"biaya\" value=\"Bayar\">");
                out.println("</center>");
                out.println("</form>");
            }
        
        } finally {
            out.println("</center>");
            out.println("</body>");
            out.println("</html>");
            out.close();
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
