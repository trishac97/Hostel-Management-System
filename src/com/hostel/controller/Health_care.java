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
import com.hostel.model.DinnerDetails;
import com.hostel.model.HealthCareDetails;
import com.hostel.model.LaundryDetails;
import com.hostel.model.LunchDetails;
import com.hostel.model.MealBookingDetails;
import com.hostel.model.RoomServiceDetails;


@WebServlet("/Health_care")
public class Health_care extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Health_care() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      //CREATE OBJECT OF DAO CLASS
		GirlStudDAO cdaoobj=new GirlStudDAO(); 	 
		HealthCareDetails serobj=new HealthCareDetails();

           HttpSession session = request.getSession(true);
	       String uni_roll=(String)session.getAttribute("uni_roll");
	       String room_no=(String)request.getParameter("room_no");
	       String hostel=(String)request.getParameter("hostel");

	       String med_name=(String)request.getParameter("med_name");
	       String price=(String)request.getParameter("price");
	       String quantity=(String)request.getParameter("quantity");


	      
	       serobj.setUni_roll(uni_roll);
	       serobj.setRoom_no(room_no);
	       serobj.setHostel(hostel);
	       serobj.setMed_name(med_name);
	       serobj.setPrice(price);
	       serobj.setQuantity(quantity);
	       boolean replyfromdao = cdaoobj.health_care(serobj);
	        String nextviewpage="";
		    String reply="Medicine purchase details is being recorded";
		    if(replyfromdao)
		    {
		    	request.setAttribute("errormsg", reply);
		    	nextviewpage ="Health-Care.jsp";
		    }
		    else
		    {
		    	request.setAttribute("errormsg", "Oops! Something went wrong.");
		    	nextviewpage ="Health-Care.jsp";
		    }
		          
		    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
	     	rd.forward(request, response);

	      	}

	}

