/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;
import java.sql.*;

/**
 *
 * @author Abdul
 */
@Stateless
public class logicEJB implements logicEJBRemote {
    private boolean flag=false;

    @Override
    public void insert(String name, String address, String gender, String mNumber, String community, String nationality, String email, String maths, String physics, String chemistry, String username, String password) 
    {
try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Admission");
            Statement stmt = con.createStatement();
            String qry = "insert into APPLICANT values('"+name+"','"+address+"','"+gender+"','"+community+"','"+nationality+"','"+email+"','"+maths+"','"+physics+"','"+chemistry+"',"+null+",'"+username+"','"+password+"','"+mNumber+"')";
            stmt.executeUpdate(qry);
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @Override
    public Boolean validate(String name, String password) {
        Boolean flag = false;
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Admission");
            Statement stmt = con.createStatement();
            String qry = "select * from Applicant";
            ResultSet rs = stmt.executeQuery(qry);
            while(rs.next())
            {
             String nameDB =  rs.getString("uname");
             String passwordDB = rs.getString("password");
             if(name.equals(nameDB) && password.equals(passwordDB))
             {
                 flag = true;
             }
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return flag;
    }

    /**
     *
     * @param uname
     * @param a1
     * @return
     */
    @Override
    public int calculateScore(String uname, String a1[]) {
        String ans[] = new String[5];
        int i = 1;
        int score = 0;
        try {
            System.out.println("test!");
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Admission");
            Statement stmt = con.createStatement();
            String qry = "select * from QUIZ_QN";
            ResultSet rs = stmt.executeQuery(qry);
            while(rs.next())
            {
                ans[i]=rs.getString(5);
                if(ans[i].equals(a1[i]))
                {
                    score = score+4;
                }
                else
                {
                    score = score-1;
                }
                i++;
            }
            qry = "update Applicant set score = "+score+" where uname = '"+uname+"'";
            stmt.executeUpdate(qry);
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return score;
    }

    @Override
    public boolean validateUsername(String uname) {
        boolean flag = true;
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Admission");
            Statement stmt = con.createStatement();
            String qry = "select * from Applicant";
            ResultSet rs = stmt.executeQuery(qry);
            while(rs.next())
            {
             String nameDB =  rs.getString("uname");
             if(uname.equals(nameDB))
             {
                 flag = false;
             }
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return flag;
    }
    
}
