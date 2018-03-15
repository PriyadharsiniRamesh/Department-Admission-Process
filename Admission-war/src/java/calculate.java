/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import ejb.logicEJBRemote;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.*;

/**
 *
 * @author Abdul
 */
@WebServlet(urlPatterns = {"/calculate"})
public class calculate extends HttpServlet {
    @EJB
    private logicEJBRemote logicEJB;

    public void test(String a1[])
    {
        for(int i=1;i<5;i++)
        {
            System.out.println(a1[i]);
        }
    }
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
        HttpSession session = request.getSession(false);
        int score = 0;
        String name = (String)session.getAttribute("name");
        out.println("<center><h3>Name: "+name+"</h3><br>");
        String a1[]=new String[5];
        for(int k=1;k<a1.length;k++) {
            a1[k]=request.getParameter("radio"+k);
        }
        score = logicEJB.calculateScore(name, a1);
        out.println("<center><b>Score: "+score+"</b></center><br>");
        out.println("<br><a href=\"/Admission-war/sort\">Logout</a><br><br>");
        out.println("<br><a href=\"/Admission-war/login\">Login</a><br><br>");
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet calculate</title>");            
            out.println("</head>");
            out.println("<body>");
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
