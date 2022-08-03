/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.details.manage;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sarth
 */
public class ConnectionProvider 
{
    static Connection con;//Creating a variable to store the connection
	public static Connection cp()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");//1.Load the Driver
			
			String user="root";
			String password="root";
			String url="jdbc:mysql://localhost:3306/servlet?autoReconnect=true&useSSL=false";//here studentmanagement is the database name
			
			ConnectionProvider.con=DriverManager.getConnection(url,user,password);//2.create the connection
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return con;
        }
}
