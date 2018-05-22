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

import com.hostel.dao.GirlStudDAO;
import com.hostel.model.BreakfastDetails;
import com.hostel.model.DinnerDetails;
import com.hostel.model.LunchDetails;
import com.hostel.model.MealBookingDetails;


@WebServlet("/meal_booking")
public class meal_booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public meal_booking() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
		 Random r=new Random();
	        int rand_int1 =r.nextInt(90000);
	        String rand=Integer.toString(rand_int1);
	      //CREATE OBJECT OF DAO CLASS
		GirlStudDAO cdaoobj=new GirlStudDAO(); 	 
		BreakfastDetails breakobj=new BreakfastDetails();
		HttpSession session = request.getSession(true);
	       String uni_roll=(String)session.getAttribute("uni_roll");
	       String item_code=(String)request.getParameter("item_code");
	       String price=(String)request.getParameter("price");
	       System.out.println("U enter"+price+" "+uni_roll);
	       LocalDate localDate = LocalDate.now();//For reference
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String today = localDate.format(formatter);	       
	       MealBookingDetails mealobj=new MealBookingDetails();
	       mealobj.setItem_code(item_code);
	       mealobj.setPrice(price);
	       mealobj.setUni_roll(uni_roll);
	       mealobj.setPurchase_date(today);
	       mealobj.setMealRef(rand);
	       boolean replyfromdao = cdaoobj.mealBooking(mealobj);
	        String nextviewpage="";
		    String reply="The Meal is being booked with coupon id: "+rand;
		    if(replyfromdao)
		    {
		    	request.setAttribute("errormsg", reply);
		    	nextviewpage ="Food-service.jsp";
		    }
		    else
		    {
		    	request.setAttribute("errormsg", "Oops! Something went wrong.");
		    	nextviewpage ="Food-service.jsp";
		    }
		          
		    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
	     	rd.forward(request, response);

	      	}

	}

