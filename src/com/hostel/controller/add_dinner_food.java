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

import com.hostel.dao.AdminDAO;
import com.hostel.dao.BoyStudDAO;
import com.hostel.dao.GirlStudDAO;
import com.hostel.model.BoysHostelDetails;
import com.hostel.model.BreakfastDetails;
import com.hostel.model.DinnerDetails;
import com.hostel.model.GirlsHostelDetails;
import com.hostel.model.HealthCareChartDetails;
import com.hostel.model.LaundryChartDetails;
import com.hostel.model.LunchDetails;


@WebServlet("/add_dinner_food")
public class add_dinner_food extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public add_dinner_food() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      //CREATE OBJECT OF DAO CLASS
		AdminDAO cdaoobj=new AdminDAO(); 
		DinnerDetails breakobj=new DinnerDetails();
			String item_1=request.getParameter("item_1");	
			String item_2=request.getParameter("item_2");
			String item_3=request.getParameter("item_3");	
			String item_4=request.getParameter("item_4");	
			String item_5=request.getParameter("item_5");	
			String item_6=request.getParameter("item_6");	
			String item_code=request.getParameter("item_code");
			String price=request.getParameter("price");
breakobj.setItem_1(item_1);
breakobj.setItem_2(item_2);
breakobj.setItem_3(item_3);
breakobj.setItem_4(item_4);
breakobj.setItem_5(item_5);
breakobj.setItem_6(item_6);
breakobj.setItem_code(item_code);
breakobj.setPrice(price);
System.out.println("U entered"+item_code+""+price);
//CALL DAO METHOD
boolean replyfromdao=cdaoobj.addDinner(breakobj);
	    String nextviewpage="";
	    
	    if(replyfromdao)
	    {
	    	request.setAttribute("errormsg","New Dinner Added");
	    	nextviewpage ="Admin_food.jsp";
	    }
	    else
	    {
	    	request.setAttribute("errormsg", "Oops! Something went wrong");
	    	nextviewpage ="Admin_food.jsp";
	    }
	          
	    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
 	rd.forward(request, response);

	}

}
