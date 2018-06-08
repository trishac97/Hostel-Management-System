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


@WebServlet("/room_supplied")
public class room_supplied extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public room_supplied() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ref_no = request.getParameter("ref_no");
	      
	      //CREATE OBJECT OF DAO CLASS
 	    AdminDAO cdaoobj = new AdminDAO();
 	    
	      		
	      //CALL DAO METHOD
 	   boolean replyfromdao = cdaoobj.serviceAvailed(ref_no);
	    String nextviewpage="";
	    String msg="The service has been provided against reference number: " +ref_no;
	    if( replyfromdao)
	    {
	    	request.setAttribute("servermsg3", msg);
	    	nextviewpage ="Admin_roomservice.jsp";
	    }
	    else
	    {
	    	request.setAttribute("servermsg3", "Oops! Something went wrong");
	    	nextviewpage ="Admin_roomservice.jsp";
	    }
	          
	    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
 	rd.forward(request, response);


	}

}
