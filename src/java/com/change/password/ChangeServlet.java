/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.change.password;

import com.details.manage.DetailsDAO;
import com.registration.portal.StudentDetails;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sarth
 */
public class ChangeServlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String mail=request.getParameter("user_email");
        String new_pass=request.getParameter("user_password_new");
        String new_pass_conf=request.getParameter("user_password_new_confirm");
        String old_pass=request.getParameter("user_password_old");
        int b=DetailsDAO.email_check(mail);
        if(b==1)
        {
            int l=DetailsDAO.old_pass_check(mail,old_pass);
            if(l==1)
            {
                if (new_pass.equals(new_pass_conf)) 
                {
                    if(old_pass.equals(new_pass))
                    {
                        out.println("<h1>Your old password cannot be your new password</h1>");
                    }
                    else
                    {
                        try 
                        {
                            DetailsDAO.change_pass(new_pass, mail);
                            out.println("<h1>Your Password has been changed succesfully</h1>");
                        } 
                        catch (SQLException ex) 
                        {
                            Logger.getLogger(ChangeServlet.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                else 
                {
                    out.println("<h1>New Passwords do not match</h1>");
                }
            }
            else
            {
                out.println("<h1>Old Password Is Incorrect</h1>");
            }
        }
        else
        {
            out.println("<h1>User with that email does not exist</h1>");
            RequestDispatcher rd=request.getRequestDispatcher("Change.html");
            rd.include(request, response);
        }
    }

 

}
