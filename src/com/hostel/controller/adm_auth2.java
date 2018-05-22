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


@WebServlet("/adm_auth2")
public class adm_auth2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public adm_auth2() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request,response);
	}

	


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uni_roll = request.getParameter("uni_roll");
	      
	      //CREATE OBJECT OF DAO CLASS
 	    AdminDAO cdaoobj = new AdminDAO();
 	    
	      		
	      //CALL DAO METHOD
 	   boolean replyfromdao = cdaoobj.studentEnable2(uni_roll);
	    String nextviewpage="";
	    String msg="Student enabled for University Roll Number:" +uni_roll;
	    if( replyfromdao)
	    {
	    	request.setAttribute("servermsg3", msg);
	    	nextviewpage ="Admin_boys_auth.jsp";
	    }
	    else
	    {
	    	request.setAttribute("servermsg3", "Oops! Something went wrong");
	    	nextviewpage ="Admin_boys_auth.jsp";
	    }
	          
	    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
 	rd.forward(request, response);


	}

}
