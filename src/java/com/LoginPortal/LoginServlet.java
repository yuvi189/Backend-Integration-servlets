/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.LoginPortal;

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
public class LoginServlet extends HttpServlet 
{


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String pass=request.getParameter("user_password");
        String mail=request.getParameter("user_email");
        
        StudentDetails student=DetailsDAO.Display_from_DB(pass, mail);
        if(student.getName()==null)
        {
            out.println("<h1>Incorrect Login Details</h1>");
            RequestDispatcher rd=request.getRequestDispatcher("Login.html");
            rd.include(request, response);
        }
        else
        {
            out.println("<h1>Welcome back "+student.getName()+"</h1>");
            out.println("<h2>Your registered email id is :- "+student.getEmail()+"</h2>");
            out.println("<h2>Your Corresponding Password is :- "+student.getPasswd()+"</h2>");
            out.println("<h2>Your Branch is :- "+student.getBranch()+"</h2>");
            out.println("<h2>You have opted for the course :- "+student.getCourse()+"</h2>");
        }
        
    }


}
