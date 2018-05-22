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

import com.hostel.dao.BoyStudDAO;
import com.hostel.dao.GirlStudDAO;
import com.hostel.model.BoysHostelDetails;
import com.hostel.model.BreakfastDetails;
import com.hostel.model.DinnerDetails;
import com.hostel.model.GirlsHostelDetails;
import com.hostel.model.LunchDetails;


@WebServlet("/profile_boy_details_fetch")
public class profile_boy_details_fetch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public profile_boy_details_fetch() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      //CREATE OBJECT OF DAO CLASS
BoyStudDAO cdaoobj=new BoyStudDAO(); 	    
HttpSession session = request.getSession(true);
String uni_roll=(String)session.getAttribute("uni_roll");	
	      //CALL DAO METHOD
 List<BoysHostelDetails> boylist = cdaoobj.fetchAllDetails(uni_roll);

	    String nextviewpage="";
	    
	    if(boylist.size() > 0)
	    {
	    	request.setAttribute("servermsg2", boylist);
	    	nextviewpage ="profile_boy.jsp";
	    }
	    else
	    {
	    	request.setAttribute("servermsg2", "Oops! Something went wrong");
	    	nextviewpage ="profile_boy.jsp";
	    }
	          
	    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
 	rd.forward(request, response);

	}

}
