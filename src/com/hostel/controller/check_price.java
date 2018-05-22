package com.hostel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hostel.dao.BoyStudDAO;
import com.hostel.dao.GirlStudDAO;
import com.hostel.model.BoysHostelDetails;
import com.hostel.model.GirlsHostelDetails;

@WebServlet("/check_price")
public class check_price extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public check_price() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
doPost(request,response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

        String weight = request.getParameter("weight");
        System.out.println("U enetered weight"+weight);
    
        //CREATE OBJECT OF DAO CLASS
      	BoyStudDAO cdaoobj = new BoyStudDAO();
        String replyfromdao = cdaoobj.checkPrice(weight);
        String nextviewpage="";
	    if(replyfromdao!=null)
	    {
	    	request.setAttribute("servermsgcheck", replyfromdao);
	    	nextviewpage ="Laundry_service_boy.jsp";
	    }
	    else
	    {
	    	request.setAttribute("servermsg", "Oops! Something went wrong.");
	    	nextviewpage ="Laundry-service_boy.jsp";
	    }
	          
	    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
     	rd.forward(request, response);

      	}

}
