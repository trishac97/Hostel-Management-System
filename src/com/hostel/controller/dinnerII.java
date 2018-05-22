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

import com.hostel.dao.GirlStudDAO;
import com.hostel.model.BreakfastDetails;
import com.hostel.model.DinnerDetails;
import com.hostel.model.LunchDetails;


@WebServlet("/dinnerII")
public class dinnerII extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public dinnerII() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      //CREATE OBJECT OF DAO CLASS
GirlStudDAO cdaoobj=new GirlStudDAO(); 	    
	      		
	      //CALL DAO METHOD
 	    List<DinnerDetails> dinnerlist = cdaoobj.fetchAllDinner();
	    String nextviewpage="";
	    
	    if(dinnerlist.size() > 0)
	    {
	    	request.setAttribute("servermsg2", dinnerlist);
	    	nextviewpage ="Admin_food.jsp";
	    }
	    else
	    {
	    	request.setAttribute("servermsg", "No Food Record Found!");
	    	nextviewpage ="Admin_food.jsp";
	    }
	          
	    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
 	rd.forward(request, response);

	}

}
