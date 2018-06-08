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
import com.hostel.dao.GirlStudDAO;
import com.hostel.model.BreakfastDetails;
import com.hostel.model.ComplaintGirlsDetails;
import com.hostel.model.LaundryDetails;


@WebServlet("/fetch_laundry_girls")
public class fetch_laundry_girls extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public fetch_laundry_girls() {
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
 	    List<LaundryDetails> breaklist = cdaoobj.fetchAllLaundry();
	    String nextviewpage="";
	    
	    if(breaklist.size() > 0)
	    {
	    	request.setAttribute("servermsg", breaklist);
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
