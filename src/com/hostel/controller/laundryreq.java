package com.hostel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hostel.dao.AdminDAO;

import com.hostel.model.LaundryDetails;


@WebServlet("/laundryreq")
public class laundryreq extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public laundryreq() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      //CREATE OBJECT OF DAO CLASS
		AdminDAO cdaoobj=new AdminDAO(); 	    
	      		
	      //CALL DAO METHOD
 	    List<LaundryDetails> laulist = cdaoobj.fetchLaundryRequest();
	    String nextviewpage="";
	    
	    if(laulist.size() > 0)
	    {
	    	request.setAttribute("servermsg", laulist);
	    	nextviewpage ="Admin_laundry.jsp";
	    }
	    else
	    {
	    	request.setAttribute("servermsg", "No Complaints Found!");
	    	nextviewpage ="Admin_laundry.jsp";
	    }
	          
	    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
 	rd.forward(request, response);

	}

}
