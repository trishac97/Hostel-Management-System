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

import com.hostel.dao.AdminDAO;
import com.hostel.dao.BoyStudDAO;
import com.hostel.dao.GirlStudDAO;
import com.hostel.model.BreakfastDetails;
import com.hostel.model.ComplaintDetails;
import com.hostel.model.DinnerDetails;
import com.hostel.model.LunchDetails;
import com.hostel.model.MealBookingDetails;
import com.hostel.model.NoticeBoardDetails;


@WebServlet("/Admin_notice")
public class Admin_notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_notice() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      //CREATE OBJECT OF DAO CLASS
		AdminDAO cdaoobj=new AdminDAO(); 	 
		NoticeBoardDetails comobj=new NoticeBoardDetails();
		HttpSession session = request.getSession(true);
	      
	       String topic=(String)request.getParameter("notice");
	      	       LocalDate localDate = LocalDate.now();//For reference
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String today = localDate.format(formatter);	       
	       comobj.setTopic(topic);
	       comobj.setDate(today);
	       boolean replyfromdao = cdaoobj.submitNotice(comobj);
	        String nextviewpage="";
		    String reply="The notice is live!";
		    if(replyfromdao)
		    {
		    	request.setAttribute("errormsg", reply);
		    	nextviewpage ="Admin_notice.jsp";
		    }
		    else
		    {
		    	request.setAttribute("errormsg", "Oops! Something went wrong.");
		    	nextviewpage ="Admin_notice.jsp";
		    }
		          
		    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
	     	rd.forward(request, response);

	      	}

	}

