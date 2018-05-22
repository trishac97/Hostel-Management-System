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

import com.hostel.model.BoysHostelDetails;
import com.hostel.model.BreakfastDetails;
import com.hostel.model.ComplaintDetails;
import com.hostel.model.GirlsHostelDetails;
import com.hostel.model.HealthCareChartDetails;
import com.hostel.model.LaundryChartDetails;
import com.hostel.model.MealBookingDetails;
public class BoyStudDAO 
{
	public String boyLogin(String uni_roll,String password) 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		String first_name = null,last_name="";
		try
		{
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	         
	         pst = connectionobject.prepareStatement("select * from stud_boy where uni_roll= ? and password =?");
		     
		     pst.setString(1, uni_roll);
		     pst.setString(2, password);
		    	     
		     rs = pst.executeQuery();
		    
		     if(rs.next())
		     {
		    	 if(rs.getString(11).equals("true")) {
		    	 first_name = rs.getString(4);
		    	 last_name=rs.getString(5);
		     }
	    }}catch(SQLException e){System.out.print(e.toString());}
	     finally 	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
		   ConnectionByStaticMethod.closeMySQLResulsetConnection(rs);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
	    return first_name;
	}

	public boolean complaint(ComplaintDetails comobj) {
		Connection connectionobject=null;
		PreparedStatement pst=null;
		boolean f=false;
		int j;
		try {
			connectionobject=ConnectionByStaticMethod.getMySQLConnection();
			pst=connectionobject.prepareStatement("insert into complaint_box_boys values(?,?,?)");
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
	
	public List<BoysHostelDetails> fetchAllDetails(String uni_roll) 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<BoysHostelDetails> boylist= new ArrayList<BoysHostelDetails>();
		try
		{
			
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // Connection connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	 	         
	         
	            pst = connectionobject.prepareStatement("select * from stud_boy where uni_roll=?");
	            pst.setString(1, uni_roll);
	         
		     
	         rs = pst.executeQuery();
		     
		     while(rs.next())
		     {
		    	 //CREATE CUSTOMER DETAIL OBJECT
		    	BoysHostelDetails boyobj = new BoysHostelDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	boyobj.setG_email(rs.getString(1));
		    	boyobj.setPassword(rs.getString(2));
		    	boyobj.setUni_roll(rs.getString(3));
		    	boyobj.setFirst_name(rs.getString(4));
		    	boyobj.setLast_name(rs.getString(5));
		    	boyobj.setYear(rs.getString(6));
		    	boyobj.setStream(rs.getString(7));
		    	boyobj.setAddress(rs.getString(8));
		    	boyobj.setMobile(rs.getString(9));
		    	boyobj.setHostel_name(rs.getString(10));
		    	boyobj.setFlag(rs.getString(11));
		    	boyobj.setParent_mob(rs.getString(12));
				//ADDED TO THE ARRAYLIST
				boylist.add(boyobj);
				
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
		finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
		   ConnectionByStaticMethod.closeMySQLResulsetConnection(rs);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return boylist;
	}
	public List<LaundryChartDetails> fetchAllLaundryChart() 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<LaundryChartDetails> laulist= new ArrayList<LaundryChartDetails>();
		try
		{
			
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // Connection connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	 	         
	         
	            pst = connectionobject.prepareStatement("select * from laundry_chart");
	         
		     
	         rs = pst.executeQuery();
		     
		     while(rs.next())
		     {
		    	 //CREATE CUSTOMER DETAIL OBJECT
		    	LaundryChartDetails lauobj = new LaundryChartDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	lauobj.setWeight(rs.getString(1));
		    	lauobj.setPrice(rs.getString(2));
		    	
				//ADDED TO THE ARRAYLIST
				laulist.add(lauobj);
				
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
		finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
		   ConnectionByStaticMethod.closeMySQLResulsetConnection(rs);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return laulist;
	}
	public List<HealthCareChartDetails> fetchAllHealthChart() 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<HealthCareChartDetails> laulist= new ArrayList<HealthCareChartDetails>();
		try
		{
			
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // Connection connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	 	         
	         
	            pst = connectionobject.prepareStatement("select * from med_chart");
	         
		     
	         rs = pst.executeQuery();
		     
		     while(rs.next())
		     {
		    	 //CREATE CUSTOMER DETAIL OBJECT
		    	HealthCareChartDetails lauobj = new HealthCareChartDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	lauobj.setMedicine_name(rs.getString(1));
		    	lauobj.setMedicine_price(rs.getString(2));
		    	
				//ADDED TO THE ARRAYLIST
				laulist.add(lauobj);
				
		     }
	    }catch(SQLException e){System.out.print(e.toString());}
		finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
		   ConnectionByStaticMethod.closeMySQLResulsetConnection(rs);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return laulist;
	}
	public boolean boyRegistration(BoysHostelDetails docobj) 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		boolean f = false;
		try
		{
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        //connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	 
	         //JDBC STEP 3
	         //CREATE QUERY
	         pst = connectionobject.prepareStatement("insert into stud_boy values(?,?,?,?,?,?,?,?,?,?,?,?)");
		     
		     pst.setString(1, docobj.getG_email());
		     pst.setString(2, docobj.getPassword());
		     pst.setString(3, docobj.getUni_roll());
		     pst.setString(4, docobj.getFirst_name());
		     pst.setString(5, docobj.getLast_name());
		     pst.setString(6, docobj.getYear());
		     pst.setString(7, docobj.getStream());
		     pst.setString(8, docobj.getAddress());
		     pst.setString(9, docobj.getMobile());
		     pst.setString(10, docobj.getHostel_name());
		     pst.setString(11, "false");
		     pst.setString(12, docobj.getParent_mob());
		    
		     //JDBC STEP 4
		     //EXECUTE QUERY
		     int i = pst.executeUpdate();		     
		     if(i > 0 )
		    	 f = true;
           
	    }catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
	
	public boolean mealBooking(MealBookingDetails mealobj) {
		Connection connectionobject=null;
		PreparedStatement pst=null;
		boolean f=false;
		int j;
		System.out.println("U entered"+mealobj.getItem_code());
		try {
			connectionobject=ConnectionByStaticMethod.getMySQLConnection();
			pst=connectionobject.prepareStatement("insert into meal_booking values(?,?,?,?,?)");
			pst.setString(1, mealobj.getUni_roll());
			pst.setString(2, mealobj.getItem_code());
			pst.setString(3, mealobj.getPrice());
			pst.setString(4, mealobj.getPurchase_date());
			pst.setString(5, mealobj.getMealRef());


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
	
	public boolean boyUpdate(BoysHostelDetails boyobj) {
		Connection connectionobject=null;
		PreparedStatement pst=null;
		 
		boolean f=false;
		try {
			connectionobject=ConnectionByStaticMethod.getMySQLConnection();
			pst=connectionobject.prepareStatement("update stud_boy set last_name=?,g_email=?,year=?,password=?,mobile=?,address=?,hostel=? where uni_roll=?");
			pst.setString(1, boyobj.getLast_name());
			pst.setString(2, boyobj.getG_email());
			pst.setString(3, boyobj.getYear());
			pst.setString(4, boyobj.getPassword());
			pst.setString(5, boyobj.getMobile());
			pst.setString(6, boyobj.getAddress());
			pst.setString(7, boyobj.getHostel_name());

			pst.setString(8, boyobj.getUni_roll());

System.out.println("U entered:"+boyobj.getUni_roll()+" "+boyobj.getG_email());
			
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
	public String checkPrice(String weight) {
		Connection connectionobject=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		String price=null;
		 
		try {
			connectionobject=ConnectionByStaticMethod.getMySQLConnection();
			pst=connectionobject.prepareStatement("select price from laundry_chart where weight=?");
			pst.setString(1, weight);
						
			 rs=pst.executeQuery();
			 while(rs.next()) {
				 price=rs.getString(1);
			 }
			
		}
		catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return price;
	}
}
