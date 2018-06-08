package com.hostel.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hostel.dao.BoyStudDAO;
import com.hostel.dao.GirlStudDAO;
import com.hostel.model.BreakfastDetails;
import com.hostel.model.DinnerDetails;
import com.hostel.model.HealthCareDetails;
import com.hostel.model.LaundryDetails;
import com.hostel.model.LunchDetails;
import com.hostel.model.MealBookingDetails;
import com.hostel.model.RoomServiceDetails;


@WebServlet("/Health_care2")
public class Health_care2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Health_care2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      //CREATE OBJECT OF DAO CLASS
		BoyStudDAO cdaoobj=new BoyStudDAO(); 	 
		HealthCareDetails serobj=new HealthCareDetails();
		    Random r=new Random();
	        int rand_int1 =r.nextInt(90000);
	        String rand=Integer.toString(rand_int1);
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
	       serobj.setRef_no(rand);

	       boolean replyfromdao = cdaoobj.health_care_boy(serobj);
	        String nextviewpage="";
		    String reply="Medicine purchase details is being recorded with ref_no: "+rand;
		    if(replyfromdao)
		    {
		    	request.setAttribute("errormsg", reply);
		    	nextviewpage ="Health-Care_boy.jsp";
		    }
		    else
		    {
		    	request.setAttribute("errormsg", "Oops! Something went wrong.");
		    	nextviewpage ="Health-Care_boy.jsp";
		    }
		          
		    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
	     	rd.forward(request, response);

	      	}

	}

