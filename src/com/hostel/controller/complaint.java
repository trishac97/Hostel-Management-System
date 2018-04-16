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
import com.hostel.model.LunchDetails;
import com.hostel.model.MealBookingDetails;


@WebServlet("/complaint")
public class complaint extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public complaint() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      //CREATE OBJECT OF DAO CLASS
		GirlStudDAO cdaoobj=new GirlStudDAO(); 	 
		ComplaintDetails comobj=new ComplaintDetails();
		HttpSession session = request.getSession(true);
	       String uni_roll=(String)session.getAttribute("uni_roll");
	       String complaint=(String)request.getParameter("complaint");
	      	       LocalDate localDate = LocalDate.now();//For reference
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String today = localDate.format(formatter);	       
	       comobj.setUni_roll(uni_roll);
	       comobj.setComplaint(complaint);
	       comobj.setDate(today);
	       boolean replyfromdao = cdaoobj.complaint(comobj);
	        String nextviewpage="";
		    String reply="Complaint is being recorded";
		    if(replyfromdao)
		    {
		    	request.setAttribute("errormsg", reply);
		    	nextviewpage ="Notice.jsp";
		    }
		    else
		    {
		    	request.setAttribute("errormsg", "Oops! Something went wrong.");
		    	nextviewpage ="Notice.jsp";
		    }
		          
		    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
	     	rd.forward(request, response);

	      	}

	}

