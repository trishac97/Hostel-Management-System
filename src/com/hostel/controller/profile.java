package com.hostel.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hostel.dao.GirlStudDAO;
import com.hostel.model.GirlsHostelDetails;

@WebServlet("/profile")
public class profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public profile() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
doPost(request,response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

        String g_email = request.getParameter("g_email");
        String password = request.getParameter("password");
        String last_name=request.getParameter("last_name");
        String year=request.getParameter("year");
        String mobile=request.getParameter("mobile");
        String address=request.getParameter("address");
        String hostel_name=request.getParameter("hostel_name");

		HttpSession session = request.getSession(true);
	       String uni_roll=(String)session.getAttribute("uni_roll");
	       String first_name=(String)session.getAttribute("first_name");
        GirlsHostelDetails girlobj=new GirlsHostelDetails();
        girlobj.setFirst_name(first_name);
        girlobj.setLast_name(last_name);
        girlobj.setG_email(g_email);
        girlobj.setYear(year);
        girlobj.setPassword(password);
        girlobj.setMobile(mobile);
        girlobj.setAddress(address);
        girlobj.setUni_roll(uni_roll);
        girlobj.setHostel_name(hostel_name);

        //CREATE OBJECT OF DAO CLASS
      	GirlStudDAO cdaoobj = new GirlStudDAO();
        boolean replyfromdao = cdaoobj.girlUpdate(girlobj);
        String nextviewpage="";
	    String reply="Information successfully stored for"+" "+g_email;
	    if(replyfromdao)
	    {
	    	request.setAttribute("servermsg", reply);
	    	nextviewpage ="profile.jsp";
	    }
	    else
	    {
	    	request.setAttribute("servermsg", "Oops! Something went wrong.");
	    	nextviewpage ="profile.jsp";
	    }
	          
	    RequestDispatcher rd = request.getRequestDispatcher(nextviewpage);
     	rd.forward(request, response);

      	}

}
