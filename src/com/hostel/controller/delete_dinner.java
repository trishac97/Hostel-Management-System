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
import com.hostel.dao.GirlStudDAO;
import com.hostel.model.BreakfastDetails;
import com.hostel.model.ComplaintGirlsDetails;
import com.hostel.model.GirlsHostelDetails;


@WebServlet("/delete_dinner")
public class delete_dinner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public delete_dinner() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String item_code = request.getParameter("item_code");
	      
	      //CREATE OBJECT OF DAO CLASS
 	    AdminDAO cdaoobj = new AdminDAO();
 	    
	      		
	      //CALL DAO METHOD
 	   boolean replyfromdao = cdaoobj.deleteFood3(item_code);
	    String nextviewpage="";
	    String msg="Food Combo with Item Code:" +item_code+" has been deleted.";
	    if( replyfromdao)
	    {
	    	request.setAttribute("errormsg", msg);
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
