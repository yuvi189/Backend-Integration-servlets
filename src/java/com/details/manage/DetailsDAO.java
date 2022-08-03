/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.details.manage;

import com.registration.portal.StudentDetails;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sarth
 */

public class DetailsDAO 
{
    public static boolean insert_student_to_db(StudentDetails st) 
	{
		boolean f=false;
		try
		{
			Connection c=ConnectionProvider.cp();
			String q="insert into studentdetails(user_name,user_email,user_password,user_branch,user_course) values(?,?,?,?,?)";
			
			PreparedStatement pstmt= c.prepareStatement(q);   
			pstmt.setString(1, st.getName());
			pstmt.setString(2, st.getEmail());
			pstmt.setString(3, st.getPasswd());
                        pstmt.setString(4, st.getBranch());
                        pstmt.setString(5, st.getCourse());
			pstmt.executeUpdate();
			f=true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
    	public static StudentDetails Display_from_DB(String pass,String mail)
	{
            StudentDetails obj=new StudentDetails();
                int count=0;
		try
		{
                    
			Connection c=ConnectionProvider.cp();
			String q="SELECT * from studentdetails"; 
			Statement stmt=c.createStatement();
			ResultSet y=stmt.executeQuery(q);
			while(y.next())
			{
                            String passwd=y.getString("user_password");
                            String emailid=y.getString("user_email");
                            if(passwd.equals(pass) && emailid.equals(mail))
                            {
                                String name=y.getString("user_name");
                                String branch=y.getString("user_branch");
                                String course=y.getString("user_course");
                                obj.setName(name);
                                obj.setEmail(emailid);
                                obj.setPasswd(passwd);
                                obj.setBranch(branch);
                                obj.setCourse(course);
                            }
			}
                }
		catch(Exception e)
		{
			e.printStackTrace();
		}
                return obj;
        }
        
        public static int email_check(String mail)
        {
            int count=0;
            try
		{
                    
			Connection c=ConnectionProvider.cp();
			String q="SELECT * from studentdetails"; 
			Statement stmt=c.createStatement();
			ResultSet y=stmt.executeQuery(q);
			while(y.next())
			{
                            String emailid=y.getString("user_email");
                            if(emailid.equals(mail))
                            {
                                count=1;
                            }
			}
                }
		catch(Exception e)
		{
			e.printStackTrace();
		}
            return count;
        }
        public static void change_pass(String new_pass,String mail) throws SQLException
        {
            try
            {
                Connection c = ConnectionProvider.cp();
                String q = "update studentdetails set user_password=? where user_email=?";
                PreparedStatement pstmt = c.prepareStatement(q);
                pstmt.setString(1, new_pass);
                pstmt.setString(2, mail);
                pstmt.executeUpdate();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }

    public static int old_pass_check(String mail,String old_pass)
    {
        int count=0;
            try
		{
                    
			Connection c=ConnectionProvider.cp();
			String q="SELECT * from studentdetails"; 
			Statement stmt=c.createStatement();
			ResultSet y=stmt.executeQuery(q);
			while(y.next())
			{
                            String old=y.getString("user_password");
                            String mailID=y.getString("user_email");
                            if(old.equals(old_pass) && mailID.equals(mail))
                            {
                                count=1;
                            }
			}
                }
		catch(Exception e)
		{
			e.printStackTrace();
		}
            return count;
    }
    
        
        
}
