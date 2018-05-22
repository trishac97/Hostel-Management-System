<%@page import="com.hostel.model.ComplaintBoysDetails"%>
<%@page import="com.hostel.model.ComplaintGirlsDetails"%>
<%@page import="com.hostel.model.DinnerDetails"%>
<%@page import="com.hostel.model.LunchDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.hostel.model.BreakfastDetails"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<title>JIS Hostel</title>
<head>
<style>
table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    padding: 8px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

tr:hover {background-color:#f5f5f5;}
tr:nth-child(even){background-color: #f2f2f2}

</style>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Tell the browser to be responsive to screen width -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
    <!-- Bootstrap Core CSS -->
    <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet">
    <!-- You can change the theme colors from here -->
    <link href="css/colors/blue.css" id="theme" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
</head>

<body class="fix-header card-no-border">
    <!-- ============================================================== -->
    <!-- Preloader - style you can find in spinners.css -->
    <!-- ============================================================== -->
    <div class="preloader">
        <svg class="circular" viewBox="25 25 50 50">
            <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="2" stroke-miterlimit="10" /> </svg>
    </div>
    <!-- ============================================================== -->
    <!-- Main wrapper - style you can find in pages.scss -->
    <!-- ============================================================== -->
    <div id="main-wrapper">
        <!-- ============================================================== -->
        <!-- Topbar header - style you can find in pages.scss -->
        <!-- ============================================================== -->
        <header class="topbar">
            <nav class="navbar top-navbar navbar-toggleable-sm navbar-light">
              
<!-- ============================================================== -->
                <!-- Logo -->
                <!-- ============================================================== -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="index.html">
                        <!-- Logo icon -->
                        <b>
                            <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                            <!-- Dark Logo icon -->
                            <span><img src="assets/images/logo-icon.png" alt="homepage" class="dark-logo" />
                            </span>
                        </b>
                        <!--End Logo icon -->
                        <span>
                         <!-- dark Logo text -->
                         <img src="assets/images/logo-text.png" alt="homepage" class="dark-logo" />
                    </span>
                        </a>
                </div>
                <!-- ============================================================== -->
                <!-- End Logo -->
                <!-- ============================================================== -->
                <div class="navbar-collapse">
                    <!-- ============================================================== -->
                    <!-- toggle and nav items -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav mr-auto mt-md-0 ">
                        <!-- This is  -->
                        <li class="nav-item"> <a class="nav-link nav-toggler hidden-md-up text-muted waves-effect waves-dark" href="javascript:void(0)"><i class="ti-menu"></i></a> </li>
                        <li class="nav-item hidden-sm-down">
                            <form class="app-search p-l-20">
                                <h2><font color="#F8F8F8">Food Service</font></h2>
                            </form>
                        </li>
                    </ul>
                    <!-- ============================================================== -->
                    <!-- User profile and search -->
                    <!-- ============================================================== -->
                    <ul class="navbar-nav my-lg-0">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="assets/images/users/1.jpg" alt="user" class="profile-pic m-r-5" />Administrator</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
        
        <!-- ============================================================== -->
        <!-- End Topbar header -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <aside class="left-sidebar">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="sidebarnav">
                         <li>
                            <a href="Admin_notice.jsp" class="waves-effect"><i class="fa fa-bell m-r-10" aria-hidden="true"></i>Notice Display</a>
                        </li>
						<li>
                            <a href="Admin_complaint.jsp" class="waves-effect"><i class="fa fa-exclamation-circle m-r-10" aria-hidden="true"></i>Complaints</a>
                        </li>
                        <li>
                            <a href="List_girl" class="waves-effect"><i class="fa fa-list m-r-10" aria-hidden="true"></i>List of Girls</a>
                        </li>
						<li>
                            <a href="List_boy" class="waves-effect"><i class="fa fa-list m-r-10" aria-hidden="true"></i>List of Boys</a>
                        </li>
                        <li>
                            <a href="Admin_food.jsp" class="waves-effect"><i class="fa fa-cutlery m-r-10" aria-hidden="true"></i>Food Items</a>
                        </li>
                        <li>
                            <a href="Laundry-service.html" class="waves-effect"><i class="fa fa-archive m-r-10" aria-hidden="true"></i>Laundry Service</a>
                        </li>
                        <li>
                            <a href="Home-In-out.html" class="waves-effect"><i class="fa fa-home m-r-10" aria-hidden="true"></i>Home In/Out Service</a>
                        </li>
                        <li>
                            <a href="Room-Service.html" class="waves-effect"><i class="fa fa-trash m-r-10" aria-hidden="true"></i>Room Service</a>
                        </li>
                        <li>
                            <a href="AdminMedical.html" class="waves-effect"><i class="fa fa-heartbeat m-r-10" aria-hidden="true"></i>Medical</a>
                        </li>
						<li>
                            <a href="AdminMain.html" class="waves-effect"><i class="fa fa-calculator m-r-10" aria-hidden="true"></i>Fees Calculation(Girls)</a>
                        </li>
						<li>
                            <a href="AdminMain.html" class="waves-effect"><i class="fa fa-calculator m-r-10" aria-hidden="true"></i>Fees Calculation(Boys)</a>
                        </li>
                    </ul>
                    <div class="text-center m-t-30">
                        <a href="main.html" class="btn btn-danger">Logout</a>
                    </div>
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
        </aside>
        <!-- ============================================================== -->
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ============================================================== -->
        <!-- ============================================================== -->
        <!-- Page wrapper  -->
        <!-- ============================================================== -->
        <div class="page-wrapper">
          
          <!-- ============================================================== -->
            <!-- Container fluid  -->
            <!-- ============================================================== -->
<div class="container-fluid">
                <!-- ============================================================== -->
                <!-- Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
              <div class="row page-titles">
                    <div class="col-md-6 col-8 align-self-center">
                      
                      <ol class="breadcrumb">
                        <li class="breadcrumb-item"></li>
                      </ol>
                  </div>
                    <div class="col-md-6 col-4 align-self-center"> </div>
  </div>
<!-- ============================================================== -->
                <!-- End Bread crumb and right sidebar toggle -->
                <!-- ============================================================== -->
                <!-- ============================================================== -->
                <!-- Start Page Content -->
                <!-- ============================================================== -->
  				<a href="breakfastII" class="btn pull-center hidden-sm-down btn-success" style="margin-right: 15px;margin-left: 15px">Modify breakfast chart</a>
  				<a href="lunchII" class="btn pull-center hidden-sm-down btn-success" style="margin-right: 15px;margin-left: 15px">Modify lunch chart</a>
  				<a href="dinnerII" class="btn pull-center hidden-sm-down btn-success" style="margin-right: 15px;margin-left: 15px">Modify dinner chart</a>

             	<a href="add_break_food.jsp" class="btn pull-center hidden-sm-down btn-success" style="margin-right: 15px;">Add new food item(Breakfast)</a>
             	<a href="add_lunch_food.jsp" class="btn pull-center hidden-sm-down btn-success" style="margin-right: 5px;">Add new food item(Dinner)</a>
             	<a href="add_dinner_food.jsp" class="btn pull-center hidden-sm-down btn-success" style="margin-right: 5px;">Add new food item(Lunch)</a>

              	<div style="color: blue;padding-left: 500px;background-color: rgba(0,0,255,0.1)"><b>
                                
    				<%
    			
        if(request.getAttribute("errormsg")!=null)
        	out.print(request.getAttribute("errormsg"));%>
        	</div>
				
<div><br><br><br>
<div>

<%! List<BreakfastDetails> breaklist=null; %>  
  <%
     breaklist=(List<BreakfastDetails>)request.getAttribute("servermsg");
  if(breaklist != null)
  {
  %>
  <h1>Breakfast Chart</h1><br>
 <table id="alter">  
   <tr>
      <th>Item1</th>
      <th>Item2</th>
      <th>Item3</th>
            <th>Item4</th>
            <th>Item5</th>
            <th>Item6</th>
            <th>Item Code</th>
            <th>Price</th>
      
     
   </tr>  
 <%
 
   for(BreakfastDetails breakobj : breaklist)
   {
 %>
   <tr>
     <td><%= breakobj.getItem_1() %></td>
     <td><%= breakobj.getItem_2() %></td>
     <td><%= breakobj.getItem_3() %></td>
    <td><%= breakobj.getItem_4() %></td>
     <td><%= breakobj.getItem_5() %></td>
     <td><%= breakobj.getItem_6() %></td>
    <td><%= breakobj.getItem_code() %></td>
     <td><%= breakobj.getPrice() %></td>
                       <td><a  href="delete_break?item_code=<%=breakobj.getItem_code()%>"><button type="button" class="btn btn-danger btn-sm"> Delete Combo </button></a></button></td>      
    
             
   </tr>  
   
   <%
   }
   %>
</table>   
<%
  }
%>
 
</div>

<div>

<%! List<LunchDetails> lunchlist=null; %>  
  <%
     lunchlist=(List<LunchDetails>)request.getAttribute("servermsg1");
  if(lunchlist != null)
  {
  %>
  <h1>Lunch Chart</h1><br>
 <table id="alter">  
   <tr>
      <th>Item1</th>
      <th>Item2</th>
      <th>Item3</th>
            <th>Item4</th>
            <th>Item5</th>
            <th>Item6</th>
            <th>Item Code</th>
            <th>Price</th>
      
     
   </tr>  
 <%
 
   for(LunchDetails lunchobj : lunchlist)
   {
 %>
   <tr>
     <td><%= lunchobj.getItem_1() %></td>
     <td><%= lunchobj.getItem_2() %></td>
     <td><%= lunchobj.getItem_3() %></td>
    <td><%= lunchobj.getItem_4() %></td>
     <td><%= lunchobj.getItem_5() %></td>
     <td><%= lunchobj.getItem_6() %></td>
    <td><%= lunchobj.getItem_code() %></td>
     <td><%= lunchobj.getPrice() %></td>
                           <td><a  href="delete_lunch?item_code=<%=lunchobj.getItem_code()%>"><button type="button" class="btn btn-danger btn-sm"> Delete Combo </button></a></button></td>      
    
             
   </tr>  
   
   <%
   }
   %>
</table>   
<%
  }
%>
 
</div>
<div>

<%! List<DinnerDetails> dinnerlist=null; %>  
  <%
     dinnerlist=(List<DinnerDetails>)request.getAttribute("servermsg2");
  if(dinnerlist != null)
  {
  %>
  <h1>Dinner Chart</h1><br>
 <table id="alter">  
   <tr>
      <th>Item1</th>
      <th>Item2</th>
      <th>Item3</th>
            <th>Item4</th>
            <th>Item5</th>
            <th>Item6</th>
            <th>Item Code</th>
            <th>Price</th>
      
     
   </tr>  
 <%
 
   for(DinnerDetails dinnerobj : dinnerlist)
   {
 %>
   <tr>
     <td><%= dinnerobj.getItem_1() %></td>
     <td><%= dinnerobj.getItem_2() %></td>
     <td><%= dinnerobj.getItem_3() %></td>
    <td><%= dinnerobj.getItem_4() %></td>
     <td><%= dinnerobj.getItem_5() %></td>
     <td><%= dinnerobj.getItem_6() %></td>
    <td><%= dinnerobj.getItem_code() %></td>
     <td><%= dinnerobj.getPrice() %></td>
                           <td><a  href="delete_dinner?item_code=<%=dinnerobj.getItem_code()%>"><button type="button" class="btn btn-danger btn-sm"> Delete Combo </button></a></button></td>      
    
             
   </tr>  
   
   <%
   }
   %>
</table>   
<%
  }
%>
 
</div>

<br><br><br>

                <!-- ============================================================== -->
                <!-- End PAge Content -->
                <!-- ============================================================== -->
            </div>


<!-- ============================================================== -->
            <!-- End Container fluid  -->
            <!-- ============================================================== -->
            <!-- ============================================================== -->
            <!-- footer -->
            <!-- ============================================================== -->
            
            <!-- ============================================================== -->
            <!-- End footer -->
            <!-- ============================================================== -->
  </div>
        
        
  <!-- ============================================================== -->
  <!-- End Page wrapper  -->
  <!-- ============================================================== -->
  </div>
    <!-- ============================================================== -->
    <!-- End Wrapper -->
    <!-- ============================================================== -->
    <!-- ============================================================== -->
    <!-- All Jquery -->
    <!-- ============================================================== -->
    <script src="assets/plugins/jquery/jquery.min.js"></script>
    <!-- Bootstrap tether Core JavaScript -->
    <script src="assets/plugins/bootstrap/js/tether.min.js"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js"></script>
    <!-- slimscrollbar scrollbar JavaScript -->
    <script src="js/jquery.slimscroll.js"></script>
    <!--Wave Effects -->
    <script src="js/waves.js"></script>
    <!--Menu sidebar -->
    <script src="js/sidebarmenu.js"></script>
    <!--stickey kit -->
    <script src="assets/plugins/sticky-kit-master/dist/sticky-kit.min.js"></script>
    <!--Custom JavaScript -->
    <script src="js/custom.min.js"></script>
    <!-- ============================================================== -->
    <!-- Style switcher -->
    <!-- ============================================================== -->
    <script src="assets/plugins/styleswitcher/jQuery.style.switcher.js"></script>
</body>

</html>
