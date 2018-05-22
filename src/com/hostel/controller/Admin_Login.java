package com.hostel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hostel.dao.GirlStudDAO;

@WebServlet("/Admin_Login")
public class Admin_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        
		doPost(request, response);

	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String uni_roll = request.getParameter("uni_roll");
        String password = request.getParameter("password");
        
     
        
       if(uni_roll.equals("admin")&&password.equals("admin"))
       {
    	
    	   
           response.sendRedirect("Admin_notice.jsp");
        }
       else 
        {
        	request.setAttribute("errormsg", "INVALID USERID OR PASSWORD");
        	RequestDispatcher rd = request.getRequestDispatcher("/Admin_Login.jsp");
        	rd.forward(request, response);
        }
	}

}
