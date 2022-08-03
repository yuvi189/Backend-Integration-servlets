/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registration.portal;

import com.details.manage.ConnectionProvider;
import com.details.manage.DetailsDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author sarth
 */
public class RegisterServlet extends HttpServlet
{
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter out=res.getWriter();
        String name=req.getParameter("user_name");
        String email=req.getParameter("user_email");
        String passwd=req.getParameter("user_password");
        String branch=req.getParameter("user_branch");
        String course=req.getParameter("user_course"); 
        
        
        if(name!=null && email!=null && passwd!=null && branch!=null && course!=null && passwd!="" && name!="" && email!="" && branch!="" && course!="")
        {
            try
            {
                Connection c = ConnectionProvider.cp();
                String q = "SELECT * from studentdetails";
                Statement stmt = c.createStatement();
                ResultSet y = stmt.executeQuery(q);
                boolean x=false;
                while(y.next())
                {
                    
                    String mail_id=y.getString("user_email");
                    if (mail_id.equals(email.toLowerCase())) 
                    {
                        x=true;
                        out.println("<h2>A user with that email-ID already exists</h2>");
                        RequestDispatcher rd = req.getRequestDispatcher("index.html");
                        rd.include(req, res);
                    }
                }
                if(x==false)
                {
                    RequestDispatcher rd = req.getRequestDispatcher("SuccessServlet");
                        rd.forward(req, res);
                        StudentDetails obj = new StudentDetails(name, email, passwd, branch, course);
                        boolean ans = DetailsDAO.insert_student_to_db(obj);
                        if (ans = true) {
                            System.out.println("Details added Succesfully");
                        } else {
                            System.out.println("Error");
                        }
                }
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        else 
        {
            out.println("<h2>Please fill all the details</h2>");
            
            //1. Include method
            RequestDispatcher rd=req.getRequestDispatcher("index.html");
            rd.include(req, res);
        }
    }
    
}
 