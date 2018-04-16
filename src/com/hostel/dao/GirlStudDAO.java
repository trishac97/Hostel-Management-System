package com.hostel.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import com.hostel.dao.ConnectionByStaticMethod;
import com.hostel.model.BreakfastDetails;
import com.hostel.model.ComplaintDetails;
import com.hostel.model.DinnerDetails;
import com.hostel.model.GirlsHostelDetails;
import com.hostel.model.HealthCareDetails;
import com.hostel.model.HomeDetails;
import com.hostel.model.LaundryDetails;
import com.hostel.model.LunchDetails;
import com.hostel.model.MealBookingDetails;
import com.hostel.model.RoomServiceDetails;

public class GirlStudDAO 
{
	public String girlLogin(String uni_roll,String password) 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		String first_name = null,last_name="";
		try
		{
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	         
	         pst = connectionobject.prepareStatement("select * from stud_girl where uni_roll= ? and password =?");
		     
		     pst.setString(1, uni_roll);
		     pst.setString(2, password);
		    	     
		     rs = pst.executeQuery();
		     
		     if(rs.next())
		     {
		    	 first_name = rs.getString(3);
		    	 last_name=rs.getString(4);
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
	     finally 	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
		   ConnectionByStaticMethod.closeMySQLResulsetConnection(rs);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
	    return first_name;
	}
	public boolean girlUpdate(GirlsHostelDetails girlobj) {
		Connection connectionobject=null;
		PreparedStatement pst=null;
		 
		boolean f=false;
		try {
			connectionobject=ConnectionByStaticMethod.getMySQLConnection();
			pst=connectionobject.prepareStatement("update stud_girl set last_name=?,g_email=?,year=?,password=?,mobile=?,address=?,hostel_name=? where uni_roll=?");
			pst.setString(1, girlobj.getLast_name());
			pst.setString(2, girlobj.getG_email());
			pst.setString(3, girlobj.getYear());
			pst.setString(4, girlobj.getPassword());
			pst.setString(5, girlobj.getMobile());
			pst.setString(6, girlobj.getAddress());
			pst.setString(7, girlobj.getHostel_name());

			pst.setString(8, girlobj.getUni_roll());


			
			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
		catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
	public List<BreakfastDetails> fetchAllBreakfast() 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<BreakfastDetails> breaklist= new ArrayList<BreakfastDetails>();
		try
		{
			
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // Connection connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	 	         
	         
	            pst = connectionobject.prepareStatement("select * from breakfast");
	         
		     
	         rs = pst.executeQuery();
		     
		     while(rs.next())
		     {
		    	 //CREATE CUSTOMER DETAIL OBJECT
		    	 BreakfastDetails breakobj = new BreakfastDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	breakobj.setItem_1(rs.getString(1));
		    	breakobj.setItem_2(rs.getString(2));
		    	breakobj.setItem_3(rs.getString(3));
		    	breakobj.setItem_4(rs.getString(4));
		    	breakobj.setItem_5(rs.getString(5));
		    	breakobj.setItem_6(rs.getString(6));
		    	breakobj.setItem_code(rs.getString(7));
		    	breakobj.setPrice(rs.getString(8));

				
				//ADDED TO THE ARRAYLIST
				breaklist.add(breakobj);
				
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
		finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
		   ConnectionByStaticMethod.closeMySQLResulsetConnection(rs);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return breaklist;
	}
	
	public List<LunchDetails> fetchAllLunch() 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<LunchDetails> lunchlist= new ArrayList<LunchDetails>();
		try
		{
			
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // Connection connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	 	         
	         
	            pst = connectionobject.prepareStatement("select * from lunch");
	         
		     
	         rs = pst.executeQuery();
		     
		     while(rs.next())
		     {
		    	 //CREATE CUSTOMER DETAIL OBJECT
		    	 LunchDetails lunchobj = new LunchDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	lunchobj.setItem_1(rs.getString(1));
		    	lunchobj.setItem_2(rs.getString(2));
		    	lunchobj.setItem_3(rs.getString(3));
		    	lunchobj.setItem_4(rs.getString(4));
		    	lunchobj.setItem_5(rs.getString(5));
		    	lunchobj.setItem_6(rs.getString(6));
		    	lunchobj.setItem_code(rs.getString(7));
		    	lunchobj.setPrice(rs.getString(8));

				
				//ADDED TO THE ARRAYLIST
				lunchlist.add(lunchobj);
				
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
		finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
		   ConnectionByStaticMethod.closeMySQLResulsetConnection(rs);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return lunchlist;
	}
	public List<DinnerDetails> fetchAllDinner() 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<DinnerDetails> dinnerlist= new ArrayList<DinnerDetails>();
		try
		{
			
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // Connection connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	 	         
	         
	            pst = connectionobject.prepareStatement("select * from dinner");
	         
		     
	         rs = pst.executeQuery();
		     
		     while(rs.next())
		     {
		    	 //CREATE CUSTOMER DETAIL OBJECT
		    	 DinnerDetails dinnerobj = new DinnerDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	dinnerobj.setItem_1(rs.getString(1));
		    	dinnerobj.setItem_2(rs.getString(2));
		    	dinnerobj.setItem_3(rs.getString(3));
		    	dinnerobj.setItem_4(rs.getString(4));
		    	dinnerobj.setItem_5(rs.getString(5));
		    	dinnerobj.setItem_6(rs.getString(6));
		    	dinnerobj.setItem_code(rs.getString(7));
		    	dinnerobj.setPrice(rs.getString(8));

				
				//ADDED TO THE ARRAYLIST
				dinnerlist.add(dinnerobj);
				
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
		finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
		   ConnectionByStaticMethod.closeMySQLResulsetConnection(rs);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return dinnerlist;
	}
	
	public boolean mealBooking(MealBookingDetails mealobj) {
		Connection connectionobject=null;
		PreparedStatement pst=null;
		boolean f=false;
		int j;
		System.out.println("U entered"+mealobj.getItem_code());
		try {
			connectionobject=ConnectionByStaticMethod.getMySQLConnection();
			pst=connectionobject.prepareStatement("insert into meal_booking values(?,?,?,?)");
			pst.setString(1, mealobj.getUni_roll());
			pst.setString(2, mealobj.getItem_code());
			pst.setString(3, mealobj.getPrice());
			pst.setString(4, mealobj.getPurchase_date());


			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
			
			
		
		catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);

		   ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
	
	public boolean complaint(ComplaintDetails comobj) {
		Connection connectionobject=null;
		PreparedStatement pst=null;
		boolean f=false;
		int j;
		try {
			connectionobject=ConnectionByStaticMethod.getMySQLConnection();
			pst=connectionobject.prepareStatement("insert into complaint_box values(?,?,?)");
			pst.setString(1, comobj.getUni_roll());
			pst.setString(2, comobj.getComplaint());
			pst.setString(3, comobj.getDate());


			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
			
			
		
		catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);

		   ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
	public boolean laundry(LaundryDetails lauobj) {
		Connection connectionobject=null;
		PreparedStatement pst=null;
		boolean f=false;
		int j;
		try {
			connectionobject=ConnectionByStaticMethod.getMySQLConnection();
			pst=connectionobject.prepareStatement("insert into laundry values(?,?,?,?,?)");
			pst.setString(1, lauobj.getUni_roll());
			pst.setString(2, lauobj.getWeight());
			pst.setString(3, lauobj.getPrice());
			pst.setString(4, lauobj.getQuantity());
			pst.setString(5, lauobj.getDate());

			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
			
			
		
		catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);

		   ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
	
	public boolean homeinout(HomeDetails homeobj) {
		Connection connectionobject=null;
		PreparedStatement pst=null;
		boolean f=false;
		int j;
		try {
			connectionobject=ConnectionByStaticMethod.getMySQLConnection();
			pst=connectionobject.prepareStatement("insert into home_in_out values(?,?,?,?,?)");
			pst.setString(1, homeobj.getUni_roll());
			pst.setString(2, homeobj.getStart_date());
			pst.setString(3, homeobj.getEnd_date());
			pst.setString(4, homeobj.getEmergency_contact());
			pst.setString(5, homeobj.getReason());

			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
			
			
		
		catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);

		   ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
	public boolean room_service(RoomServiceDetails roomobj) {
		Connection connectionobject=null;
		PreparedStatement pst=null;
		boolean f=false;
		int j;
		try {
			connectionobject=ConnectionByStaticMethod.getMySQLConnection();
			pst=connectionobject.prepareStatement("insert into room_service values(?,?,?,?,?)");
			pst.setString(1, roomobj.getUni_roll());
			pst.setString(2, roomobj.getRoom_no());
			pst.setString(3, roomobj.getService());
			pst.setString(4, roomobj.getAvailability_time());
			pst.setString(5, roomobj.getHostel());

			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
			
			
		
		catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);

		   ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
	public boolean health_care(HealthCareDetails serobj) {
		Connection connectionobject=null;
		PreparedStatement pst=null;
		boolean f=false;
		int j;
		try {
			connectionobject=ConnectionByStaticMethod.getMySQLConnection();
			pst=connectionobject.prepareStatement("insert into health_care values(?,?,?,?,?,?)");
			int tot_price=0;
			String price=(String)serobj.getPrice();
			String quantity=(String)serobj.getQuantity();
			int p=Integer.parseInt(price);
			int q=Integer.parseInt(quantity);
			tot_price=p*q;
			String total_price=Integer.toString(tot_price);
			pst.setString(1, serobj.getUni_roll());
			pst.setString(2, serobj.getRoom_no());
			pst.setString(3, serobj.getHostel());
			pst.setString(4, serobj.getMed_name());
			pst.setString(5, total_price);
			pst.setString(6, serobj.getQuantity());

			int i=pst.executeUpdate();
			if(i>0)
				f=true;
		}
			
			
		
		catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);

		   ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
}
