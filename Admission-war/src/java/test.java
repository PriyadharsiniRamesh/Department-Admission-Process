/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/test"})
public class test extends HttpServlet {

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
            String ans[]=new String[10];
        String ans1[]=new String[10];
        HttpSession session = request.getSession(false);
        String name=(String)session.getAttribute("name");
        out.println("<center><h3>Name: "+name+"</h3><br>");
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/Admission");
            Statement stmt = con.createStatement();
            String qry = "select * from quiz_qn";
            ResultSet rs = stmt.executeQuery(qry);
            int j=0,i=1;
               
            while (rs.next()) {
                out.println("<form  method=\"post\" action=\"/Admission-war/calculate\">"+i+":"+rs.getString(1)+"<br>");
                out.println("<br><input type=\"radio\" name=\"radio"+i+"\" value="+rs.getString(2)+">"+rs.getString(2)+"<br><input type=\"radio\" name=\"radio"+i+"\" value="+rs.getString(3)+">"+rs.getString(3)+"<br><input type=\"radio\" name=\"radio"+i+"\" value="+rs.getString(4)+">"+rs.getString(4)+"<br><br><br>");
                {
                    ans[i]=rs.getString(5);
                    i++;
                }
                
            }                                
                out.print("<input type=\"submit\" value=\"Submit\" /></form>");
                con.close();
            }
         catch(Exception e) {
            System.out.println(e);
        }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet test</title>");            
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
