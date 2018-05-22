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
import com.hostel.model.BoysHostelDetails;
import com.hostel.model.BreakfastDetails;
import com.hostel.model.ComplaintBoysDetails;
import com.hostel.model.ComplaintDetails;
import com.hostel.model.ComplaintGirlsDetails;
import com.hostel.model.DinnerDetails;
import com.hostel.model.GirlsHostelDetails;
import com.hostel.model.HealthCareDetails;
import com.hostel.model.HomeDetails;
import com.hostel.model.LaundryDetails;
import com.hostel.model.LunchDetails;
import com.hostel.model.MealBookingDetails;
import com.hostel.model.NoticeBoardDetails;
import com.hostel.model.RoomServiceDetails;

public class AdminDAO 
{
	public boolean submitNotice(NoticeBoardDetails comobj) {
		Connection connectionobject=null;
		PreparedStatement pst=null;
		boolean f=false;
		int j;
		try {
			connectionobject=ConnectionByStaticMethod.getMySQLConnection();
			pst=connectionobject.prepareStatement("insert into notice_board values(?,?)");
			pst.setString(1, comobj.getTopic());
			pst.setString(2, comobj.getDate());

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
	public List<ComplaintGirlsDetails> fetchAllComplaint() 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<ComplaintGirlsDetails> breaklist= new ArrayList<ComplaintGirlsDetails>();
		try
		{
			
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // Connection connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	 	         
	         
	            pst = connectionobject.prepareStatement("select * from complaint_box_girls");
	         
		     
	         rs = pst.executeQuery();
		     
		     while(rs.next())
		     {
		    	 //CREATE CUSTOMER DETAIL OBJECT
		    	ComplaintGirlsDetails breakobj = new ComplaintGirlsDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	breakobj.setUni_roll(rs.getString(1));
		    	breakobj.setComplaint(rs.getString(2));
		    	breakobj.setDate(rs.getString(3));
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
	public List<ComplaintBoysDetails> fetchAllComplaints() 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<ComplaintBoysDetails> breaklist= new ArrayList<ComplaintBoysDetails>();
		try
		{
			
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // Connection connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	 	         
	         
	            pst = connectionobject.prepareStatement("select * from complaint_box_boys");
	         
		     
	         rs = pst.executeQuery();
		     
		     while(rs.next())
		     {
		    	 //CREATE CUSTOMER DETAIL OBJECT
		    	ComplaintBoysDetails breakobj = new ComplaintBoysDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	breakobj.setUni_roll(rs.getString(1));
		    	breakobj.setComplaint(rs.getString(2));
		    	breakobj.setDate(rs.getString(3));
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
	public List<GirlsHostelDetails> fetchAllGirls() 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<GirlsHostelDetails> breaklist= new ArrayList<GirlsHostelDetails>();
		try
		{
			
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // Connection connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	 	         
	         
	            pst = connectionobject.prepareStatement("select * from stud_girl");
	         
		     
	         rs = pst.executeQuery();
		     
		     while(rs.next())
		     {
		    	 //CREATE CUSTOMER DETAIL OBJECT
		    	GirlsHostelDetails breakobj = new GirlsHostelDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	breakobj.setG_email(rs.getString(1));
		    	breakobj.setPassword(rs.getString(2));
		    	breakobj.setUni_roll(rs.getString(3));
		    	
		    	breakobj.setFirst_name(rs.getString(4));
		    	breakobj.setLast_name(rs.getString(5));
		    	breakobj.setYear(rs.getString(6));
		    	breakobj.setStream(rs.getString(7));
		    	breakobj.setAddress(rs.getString(8));
		    	breakobj.setMobile(rs.getString(9));
		    	breakobj.setHostel_name(rs.getString(10));
		    	breakobj.setFlag(rs.getString(11));
		    	breakobj.setParent_mob(rs.getString(12));


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
	public List<BoysHostelDetails> fetchAllBoys() 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<BoysHostelDetails> breaklist= new ArrayList<BoysHostelDetails>();
		try
		{
			
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // Connection connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	 	         
	         
	            pst = connectionobject.prepareStatement("select * from stud_boy");
	         
		     
	         rs = pst.executeQuery();
		     
		     while(rs.next())
		     {
		    	 //CREATE CUSTOMER DETAIL OBJECT
		    	BoysHostelDetails breakobj = new BoysHostelDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	breakobj.setG_email(rs.getString(1));
		    	breakobj.setPassword(rs.getString(2));
		    	breakobj.setUni_roll(rs.getString(3));
		    	
		    	breakobj.setFirst_name(rs.getString(4));
		    	breakobj.setLast_name(rs.getString(5));
		    	breakobj.setYear(rs.getString(6));
		    	breakobj.setStream(rs.getString(7));
		    	breakobj.setAddress(rs.getString(8));
		    	breakobj.setMobile(rs.getString(9));
		    	breakobj.setHostel_name(rs.getString(10));
		    	breakobj.setFlag(rs.getString(11));
		    	breakobj.setParent_mob(rs.getString(12));


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
	public List<HomeDetails> fetchAll() 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		List<HomeDetails> breaklist= new ArrayList<HomeDetails>();
		try
		{
			
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // Connection connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	 	         
	         
	            pst = connectionobject.prepareStatement("select * from home_in_out");
	         
		     
	         rs = pst.executeQuery();
		     
		     while(rs.next())
		     {
		    	 //CREATE CUSTOMER DETAIL OBJECT
		    	HomeDetails breakobj = new HomeDetails();
		    	 
		    	 //FETCH FROM RESULTSET & STORE VALUE WITIN OBJECT
		    	breakobj.setUni_roll(rs.getString(1));
		    	breakobj.setStart_date(rs.getString(2));
		    	breakobj.setEnd_date(rs.getString(3));
		    	
		    	breakobj.setEmergency_contact(rs.getString(4));
		    	breakobj.setReason(rs.getString(5));
		    	breakobj.setHostel_name(rs.getString(6));
		    	


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
	public boolean studentEnable(String uni_roll) 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		boolean f=false;

		try
		{
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	         
	         pst = connectionobject.prepareStatement("update stud_girl set flag='true' where uni_roll=?");
		     
		     pst.setString(1, uni_roll);
		    	     
		     int i=pst.executeUpdate();
				if(i>0)
					f=true;
		
		     
		    
		     
	    }catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
		   ConnectionByStaticMethod.closeMySQLResulsetConnection(rs);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
	public boolean studentEnable2(String uni_roll) 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		boolean f=false;

		try
		{
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	         
	         pst = connectionobject.prepareStatement("update stud_boy set flag='true' where uni_roll=?");
		     
		     pst.setString(1, uni_roll);
		    	     
		     int i=pst.executeUpdate();
				if(i>0)
					f=true;
		
		     
		    
		     
	    }catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
		   ConnectionByStaticMethod.closeMySQLResulsetConnection(rs);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
	public boolean deleteFood1(String item_code) 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		boolean f=false;

		try
		{
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	         
	         pst = connectionobject.prepareStatement("delete from breakfast where item_code=?");
		     
		     pst.setString(1, item_code);
		    	     
		     int i=pst.executeUpdate();
				if(i>0)
					f=true;
		
		     
		    
		     
	    }catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
		   ConnectionByStaticMethod.closeMySQLResulsetConnection(rs);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
	public boolean deleteFood2(String item_code) 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		boolean f=false;

		try
		{
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	         
	         pst = connectionobject.prepareStatement("delete from lunch where item_code=?");
		     
		     pst.setString(1, item_code);
		    	     
		     int i=pst.executeUpdate();
				if(i>0)
					f=true;
		
		     
		    
		     
	    }catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
		   ConnectionByStaticMethod.closeMySQLResulsetConnection(rs);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
	public boolean deleteFood3(String item_code) 
	{
		Connection connectionobject = null;
		PreparedStatement pst = null;
		ResultSet rs =null;
		boolean f=false;

		try
		{
	         connectionobject = ConnectionByStaticMethod.getMySQLConnection();
		     
	        // connectionobject = ConnectionFactoryBySingletonClass.getConnection();
	      	         
	         pst = connectionobject.prepareStatement("delete from dinner where item_code=?");
		     
		     pst.setString(1, item_code);
		    	     
		     int i=pst.executeUpdate();
				if(i>0)
					f=true;
		
		     
		    
		     
	    }catch(SQLException e){System.out.print(e.toString());}
	     finally 
	     {
		   ConnectionByStaticMethod.closeMySQLPreaparedStatementConnection(pst);
		   ConnectionByStaticMethod.closeMySQLResulsetConnection(rs);
	       ConnectionByStaticMethod.closeMySQLConnection(connectionobject);
		 }
		
	    return f;
	}
	public boolean addBreakfast(BreakfastDetails breakobj) 
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
	         pst = connectionobject.prepareStatement("insert into breakfast values(?,?,?,?,?,?,?,?)");
		     
		     pst.setString(1, breakobj.getItem_1());
		     pst.setString(2, breakobj.getItem_2());
		     pst.setString(3, breakobj.getItem_3());
		     pst.setString(4, breakobj.getItem_4());
		     pst.setString(5, breakobj.getItem_5());
		     pst.setString(6, breakobj.getItem_6());
		     pst.setString(7, breakobj.getItem_code());
		     pst.setString(8, breakobj.getPrice());
		    
		    
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
	public boolean addLunch(LunchDetails breakobj) 
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
	         pst = connectionobject.prepareStatement("insert into lunch values(?,?,?,?,?,?,?,?)");
		     
		     pst.setString(1, breakobj.getItem_1());
		     pst.setString(2, breakobj.getItem_2());
		     pst.setString(3, breakobj.getItem_3());
		     pst.setString(4, breakobj.getItem_4());
		     pst.setString(5, breakobj.getItem_5());
		     pst.setString(6, breakobj.getItem_6());
		     pst.setString(7, breakobj.getItem_code());
		     pst.setString(8, breakobj.getPrice());
		    
		    
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
	public boolean addDinner(DinnerDetails breakobj) 
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
	         pst = connectionobject.prepareStatement("insert into dinner values(?,?,?,?,?,?,?,?)");
		     
		     pst.setString(1, breakobj.getItem_1());
		     pst.setString(2, breakobj.getItem_2());
		     pst.setString(3, breakobj.getItem_3());
		     pst.setString(4, breakobj.getItem_4());
		     pst.setString(5, breakobj.getItem_5());
		     pst.setString(6, breakobj.getItem_6());
		     pst.setString(7, breakobj.getItem_code());
		     pst.setString(8, breakobj.getPrice());
		    
		    
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
}
