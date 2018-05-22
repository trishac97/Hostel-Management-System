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
import com.hostel.model.ComplaintBoysDetails;
import com.hostel.model.ComplaintGirlsDetails;


@WebServlet("/com_boys")
public class com_boys extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public com_boys() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	      //CREATE OBJECT OF DAO CLASS
		AdminDAO cdaoobj=new AdminDAO(); 	    
	      		
	      //CALL DAO METHOD
 	    List<ComplaintBoysDetails> breakslist = cdaoobj.fetchAllComplaints();
	    String nextviewpage="";
	    
	    if(breakslist.size() > 0)
	    {
	    	request.setAttribute("servermsgs", breakslist);
	    	nextviewpage ="Admin_complaint.jsp";
	    }
	    else
	    {
	    	request.setAttribute("servermsgs", "No Complaints Found!");
	    	nextviewpage ="Admin_complaint.jsp";
	    }
	          
	    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
 	rd.forward(request, response);

	}

}
