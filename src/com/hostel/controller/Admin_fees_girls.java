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
import com.hostel.model.GirlsHostelDetails;
import com.hostel.model.RoomServiceDetails;


@WebServlet("/Admin_fees_girls")
public class Admin_fees_girls extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_fees_girls() {
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
 	    List<GirlsHostelDetails> breaklist = cdaoobj.fetchAllGirls();
	    String nextviewpage="";
	    
	    if(breaklist.size() > 0)
	    {
	    	request.setAttribute("servermsg", breaklist);
	    	nextviewpage ="Admin_fees_girls.jsp";
	    }
	    else
	    {
	    	request.setAttribute("servermsg", "No Complaints Found!");
	    	nextviewpage ="Admin_fees_girls.jsp";
	    }
	          
	    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
 	rd.forward(request, response);

	}

}
