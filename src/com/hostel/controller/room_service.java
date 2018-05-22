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
import com.hostel.model.ComplaintDetails;
import com.hostel.model.DinnerDetails;
import com.hostel.model.LunchDetails;
import com.hostel.model.MealBookingDetails;
import com.hostel.model.RoomServiceDetails;


@WebServlet("/room_service")
public class room_service extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public room_service() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      //CREATE OBJECT OF DAO CLASS
		GirlStudDAO cdaoobj=new GirlStudDAO(); 	 
		RoomServiceDetails roomobj=new RoomServiceDetails();
		HttpSession session = request.getSession(true);
		 Random r=new Random();
	        int rand_int1 =r.nextInt(90000);
	        String rand=Integer.toString(rand_int1);
	       String uni_roll=(String)session.getAttribute("uni_roll");
	       String room_no=(String)request.getParameter("room_no");
	       String hostel=(String)request.getParameter("hostel");
	       String service=(String)request.getParameter("service");
	       String availability_time=(String)request.getParameter("availability_time");



	       roomobj.setUni_roll(uni_roll);
	       roomobj.setRoom_no(room_no);
	       roomobj.setHostel(hostel);
	       roomobj.setService(service);
	       roomobj.setRef_no(rand);

	       roomobj.setAvailability_time(availability_time);


	       boolean replyfromdao = cdaoobj.room_service(roomobj);
	        String nextviewpage="";
		    String reply="Room service is being recorded against Reference number:" +rand+". You will be served as soon as possible";
		    if(replyfromdao)
		    {
		    	request.setAttribute("errormsg", reply);
		    	nextviewpage ="Room-Service.jsp";
		    }
		    else
		    {
		    	request.setAttribute("errormsg", "Oops! Something went wrong.");
		    	nextviewpage ="Room-Service.jsp";
		    }
		          
		    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
	     	rd.forward(request, response);

	      	}

	}

