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
import java.sql.*;

/**
 *
 * @author Abdul
 */
@WebServlet(urlPatterns = {"/update"})
public class update extends HttpServlet {
    @EJB
    private logicEJBRemote logicEJB;

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
            out.println("<title>Servlet update</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
            String name = request.getParameter("name");
            String address = request.getParameter("Address");
            String gender = request.getParameter("gender");
            String mobileNumber = request.getParameter("mnum");
            String community = request.getParameter("community");
            String nationality = request.getParameter("Nationality");
            String email = request.getParameter("email");
            String mathematics = request.getParameter("mat_p");
            String physics = request.getParameter("phy_p");
            String chemistry = request.getParameter("che_p");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if(logicEJB.validateUsername(username))
            {
            logicEJB.insert(name, address, gender, mobileNumber, community, nationality, email, mathematics, physics, chemistry, username, password);
            response.sendRedirect("/Admission-war/login");
            }
            else
            {
                out.println("Username already exits!<br>");
                out.println("<br><a href=\"/Admission-war/login\">Retry</a><br><br>");
            }
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
