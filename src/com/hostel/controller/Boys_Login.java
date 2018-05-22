package com.hostel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hostel.dao.BoyStudDAO;
import com.hostel.dao.GirlStudDAO;

@WebServlet("/Boys_Login")
public class Boys_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Boys_Login() {
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
        
      //CREATE OBJECT OF DAO CLASS
      	BoyStudDAO cdaoobj = new BoyStudDAO();
      		
      //CALL DAO METHOD
       String first_name = cdaoobj.boyLogin(uni_roll, password);
        
       if(first_name != null)
       {
    	   HttpSession session = request.getSession(true);
    	   session.setAttribute("first_name", first_name);
    	   session.setAttribute("uni_roll", uni_roll);
    	   
           response.sendRedirect("Notice_boy.jsp");
        }
       else 
        {
        	request.setAttribute("errormsg", "INVALID USERID OR PASSWORD");
        	RequestDispatcher rd = request.getRequestDispatcher("/Boys_Login.jsp");
        	rd.forward(request, response);
        }
	}

}
