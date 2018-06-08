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
import com.hostel.model.LaundryDetails;
import com.hostel.model.LunchDetails;
import com.hostel.model.MealBookingDetails;


@WebServlet("/Laundry_service2")
public class Laundry_service2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Laundry_service2() {
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
		BoyStudDAO cdaoobj=new BoyStudDAO(); 	 
		LaundryDetails lauobj=new LaundryDetails();

           HttpSession session = request.getSession(true);
	       String uni_roll=(String)session.getAttribute("uni_roll");
	       String weight=(String)request.getParameter("weight");
	       String quantity=(String)request.getParameter("quantity");

	       String price=(String)request.getParameter("price");
	       LocalDate localDate = LocalDate.now();//For reference
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String today = localDate.format(formatter);	       
	       lauobj.setUni_roll(uni_roll);
	       lauobj.setWeight(weight);
	       lauobj.setPrice(price);
	       lauobj.setDate(today);
	       lauobj.setQuantity(quantity);
	       lauobj.setRef_no(rand);
	       boolean replyfromdao = cdaoobj.laundry_boys(lauobj);
	        String nextviewpage="";
		    String reply="Laundry details is being recorded for Reference number: "+rand;
		    if(replyfromdao)
		    {
		    	request.setAttribute("errormsg", reply);
		    	nextviewpage ="Laundry-service.jsp";
		    }
		    else
		    {
		    	request.setAttribute("errormsg", "Oops! Something went wrong.");
		    	nextviewpage ="Laundry-service.jsp";
		    }
		          
		    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
	     	rd.forward(request, response);

	      	}

	}

