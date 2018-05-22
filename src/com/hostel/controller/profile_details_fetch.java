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

import com.hostel.dao.GirlStudDAO;
import com.hostel.model.BreakfastDetails;
import com.hostel.model.DinnerDetails;
import com.hostel.model.GirlsHostelDetails;
import com.hostel.model.LunchDetails;


@WebServlet("/profile_details_fetch")
public class profile_details_fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public profile_details_fetch() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      //CREATE OBJECT OF DAO CLASS
GirlStudDAO cdaoobj=new GirlStudDAO(); 	    
HttpSession session = request.getSession(true);
String uni_roll=(String)session.getAttribute("uni_roll");	
	      //CALL DAO METHOD
 List<GirlsHostelDetails> girllist = cdaoobj.fetchAllDetails(uni_roll);

	    String nextviewpage="";
	    
	    if(girllist.size() > 0)
	    {
	    	request.setAttribute("servermsg2", girllist);
	    	nextviewpage ="profile.jsp";
	    }
	    else
	    {
	    	request.setAttribute("servermsg2", "Oops! Something went wrong");
	    	nextviewpage ="profile.jsp";
	    }
	          
	    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
 	rd.forward(request, response);

	}

}
