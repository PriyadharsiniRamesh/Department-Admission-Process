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

/**
 *
 * @author Abdul
 */
@WebServlet(urlPatterns = {"/signUp"})
public class signUp extends HttpServlet {
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signUp</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><b>SIGN UP</b></center><br><br><br>");
            out.println("<form method=\"post\" action=\"/Admission-war/update\">");
            out.println("Username:<input type=\"text\" name = \"username\"><br><br>");
            out.println("Password:<input type=\"password\" name = \"password\"><br><br>");
            out.println("<input type=\"hidden\" name = \"name\" value=\""+name+"\">");
            out.println("<input type=\"hidden\" name = \"Address\" value=\""+address+"\">");
            out.println("<input type=\"hidden\" name = \"gender\" value=\""+gender+"\">");
            out.println("<input type=\"hidden\" name = \"mnum\" value=\""+mobileNumber+"\">");
            out.println("<input type=\"hidden\" name = \"community\" value=\""+community+"\">");
            out.println("<input type=\"hidden\" name = \"Nationality\" value=\""+nationality+"\">");
            out.println("<input type=\"hidden\" name = \"email\" value=\""+email+"\">");
            out.println("<input type=\"hidden\" name = \"mat_p\" value=\""+mathematics+"\">");
            out.println("<input type=\"hidden\" name = \"phy_p\" value=\""+physics+"\">");
            out.println("<input type=\"hidden\" name = \"che_p\" value=\""+chemistry+"\">");
            out.println("<input type=\"submit\" value=\"submit\">");
            out.println("</form>");
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
