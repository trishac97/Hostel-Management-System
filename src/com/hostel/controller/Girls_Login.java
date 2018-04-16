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

@WebServlet("/Girls_Login")
public class Girls_Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Girls_Login() {
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
      	GirlStudDAO cdaoobj = new GirlStudDAO();
      		
      //CALL DAO METHOD
       String first_name = cdaoobj.girlLogin(uni_roll, password);
        
       if(first_name != null)
       {
    	   HttpSession session = request.getSession(true);
    	   session.setAttribute("first_name", first_name);
    	   session.setAttribute("uni_roll", uni_roll);
    	   
           response.sendRedirect("Notice.jsp");
        }
       else 
        {
        	request.setAttribute("errormsg", "INVALID USERID OR PASSWORD");
        	RequestDispatcher rd = request.getRequestDispatcher("/Girls_Login.jsp");
        	rd.forward(request, response);
        }
	}

}
