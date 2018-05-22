package com.hostel.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hostel.dao.BoyStudDAO;
import com.hostel.model.BoysHostelDetails;



@WebServlet("/Reg_boy")
public class Reg_boy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Reg_boy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//CREATE POJO CLASS OBJECT
        BoysHostelDetails docobj = new BoysHostelDetails();
		
        //RECEIVED FROM HTML PAGE & STORE VALUES WITHIN OBJECT
		docobj.setG_email(request.getParameter("g_email"));
		docobj.setPassword(request.getParameter("password"));
		docobj.setFirst_name(request.getParameter("first_name"));
		docobj.setLast_name(request.getParameter("last_name"));
		docobj.setYear(request.getParameter("year"));
		docobj.setStream(request.getParameter("stream"));
		docobj.setUni_roll(request.getParameter("uni_roll"));
		docobj.setAddress(request.getParameter("address"));
		docobj.setMobile(request.getParameter("phone"));
		docobj.setHostel_name(request.getParameter("hostel_name"));
		docobj.setFlag(request.getParameter("false"));
		docobj.setParent_mob(request.getParameter("parent_phone"));

		
		
	
		//CREATE OBJECT OF DAO CLASS
		BoyStudDAO cdaoobj = new BoyStudDAO();
		
		//CALL DAO METHOD
		boolean replyfromdao = cdaoobj.boyRegistration(docobj);
		
		String msg="";
		String nextpage="";
		if(replyfromdao)
		{
			msg ="Please wait for the Administrator to authenticate you email address!";
			nextpage="Boys_Login.jsp";
		}
		else
	    {
			msg ="Oops! Something went wrong!";
			nextpage="Boys_Login.jsp";
	    }
		
		request.setAttribute("errormsg", msg);
		RequestDispatcher rd = request.getRequestDispatcher(nextpage);
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}

