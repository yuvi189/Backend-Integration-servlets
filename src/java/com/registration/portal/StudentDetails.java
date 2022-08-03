/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.registration.portal;

/**
 *
 * @author sarth
 */
public class StudentDetails 
{
    String name;
    String email;
    String passwd;
    String branch;
    String course;

    public StudentDetails(String name, String email, String passwd, String branch, String course) 
    {
        this.name = name;
        this.email = email;
        this.passwd = passwd;
        this.branch = branch;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "StudentDetails{" + "name=" + name + ", email=" + email + ", passwd=" + passwd + ", branch=" + branch + ", course=" + course + '}';
    }

    public StudentDetails() 
    {
        
    }
    
    
}
