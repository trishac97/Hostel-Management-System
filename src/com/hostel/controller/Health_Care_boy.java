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
import com.hostel.model.HealthCareChartDetails;
import com.hostel.model.LaundryChartDetails;
import com.hostel.model.LunchDetails;


@WebServlet("/Health_Care_boy")
public class Health_Care_boy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Health_Care_boy() {
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
 List<HealthCareChartDetails>laulist = cdaoobj.fetchAllHealthChart();

	    String nextviewpage="";
	    
	    if(laulist.size() > 0)
	    {
	    	request.setAttribute("servermsg2",laulist);
	    	nextviewpage ="Health-Care_boy.jsp";
	    }
	    else
	    {
	    	request.setAttribute("servermsg2", "Oops! Something went wrong");
	    	nextviewpage ="Health-Care_boy.jsp";
	    }
	          
	    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
 	rd.forward(request, response);

	}

}
