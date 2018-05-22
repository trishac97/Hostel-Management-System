package com.hostel.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import com.hostel.model.ComplaintDetails;
import com.hostel.model.DinnerDetails;
import com.hostel.model.HomeDetails;
import com.hostel.model.LunchDetails;
import com.hostel.model.MealBookingDetails;


@WebServlet("/Home_in_out")
public class Home_in_out extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Home_in_out() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      //CREATE OBJECT OF DAO CLASS
		GirlStudDAO cdaoobj=new GirlStudDAO(); 	 
		HomeDetails homeobj=new HomeDetails();
		HttpSession session = request.getSession(true);
	       String uni_roll=(String)session.getAttribute("uni_roll");
	       String start_date=(String)request.getParameter("start_date");
	       String end_date=(String)request.getParameter("end_date");
	       String emergency_contact=(String)request.getParameter("emergency_contact");
	       String reason=(String)request.getParameter("reason");
	       String hostel_name=(String)request.getParameter("hostel_name");


	       homeobj.setUni_roll(uni_roll);
	       homeobj.setStart_date(start_date);
	       homeobj.setEnd_date(end_date);
	       homeobj.setEmergency_contact(emergency_contact);
	       homeobj.setReason(reason);
	       homeobj.setHostel_name(hostel_name);


	       boolean replyfromdao = cdaoobj.homeinout(homeobj);
	        String nextviewpage="";
		    String reply="Home in/out is being recorded";
		    if(replyfromdao)
		    {
		    	request.setAttribute("errormsg", reply);
		    	nextviewpage ="Home-In-out.jsp";
		    }
		    else
		    {
		    	request.setAttribute("errormsg", "Oops! Something went wrong.");
		    	nextviewpage ="Home-In-out.jsp";
		    }
		          
		    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
	     	rd.forward(request, response);

	      	}

	}

