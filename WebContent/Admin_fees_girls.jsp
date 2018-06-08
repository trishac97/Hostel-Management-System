<%@page import="com.hostel.model.RoomServiceDetails"%>
<%@page import="com.hostel.model.GirlsHostelDetails"%>
<%@page import="com.hostel.model.HealthCareChartDetails"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<title>JIS Hostel</title>
<head>
<html>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}
th {
	background-color: #d1d8be;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
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
<%! String first_name="",uni_roll=""; %>
                    <% first_name=(String)session.getAttribute("first_name");
                    uni_roll=(String)session.getAttribute("uni_roll");
                    %>
                <!-- Logo -->
                <!-- ============================================================== -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="Notice.html">
                        <!-- Logo icon -->
                        <b>
                            <!--You can put here icon as well // <i class="wi wi-sunset"></i> //-->
                            <!-- Dark Logo icon -->
                            <img src="assets/images/logo-icon.png" alt="homepage" class="dark-logo" />
                            
                        </b>
                        <!--End Logo icon -->
                        <!-- Logo text -->
                        <span>
                         <!-- dark Logo text -->
                         <img src="assets/images/logo-text.png" alt="homepage" class="dark-logo" />
                    </span> </a>
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
                        <li class="nav-item"><a class="nav-link nav-toggler hidden-md-up text-muted waves-effect waves-dark" href="javascript:void(0)"><i class="ti-menu"></i></a> </li>
                        <li class="nav-item hidden-sm-down">
                            <form class="app-search p-l-20">
                                <h2><font color="#F8F8F8">Fees Calculator for Girls Hostel
                                </font></h2>
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
                            <a href="Admin_laundry.jsp" class="waves-effect"><i class="fa fa-archive m-r-10" aria-hidden="true"></i>Laundry Service</a>
                        </li>
                        <li>
                            <a href="Admin_home_inout" class="waves-effect"><i class="fa fa-home m-r-10" aria-hidden="true"></i>Home In/Out Service</a>
                        </li>
                        <li>
                            <a href="room_service_req" class="waves-effect"><i class="fa fa-trash m-r-10" aria-hidden="true"></i>Room Service</a>
                        </li>
                        <li>
                            <a href="Admin_medical.jsp" class="waves-effect"><i class="fa fa-heartbeat m-r-10" aria-hidden="true"></i>Medical</a>
                        </li>
						<li>
                            <a href="Admin_fees_girls" class="waves-effect"><i class="fa fa-calculator m-r-10" aria-hidden="true"></i>Fees Calculation(Girls)</a>
                        </li>
						<li>
                            <a href="Admin_fees_boys" class="waves-effect"><i class="fa fa-calculator m-r-10" aria-hidden="true"></i>Fees Calculation(Boys)</a>
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
  				

	<div style="color: blue;padding-left: 500px;background-color: rgba(0,0,255,0.1);margin-bottom: 20px"><b>
                                
    				<%
    			
        if(request.getAttribute("servermsg3")!=null)
        	out.print(request.getAttribute("servermsg3"));%>
        	</div>				
<div><br>



   <%! List<GirlsHostelDetails> hlist=null; %>  
    
  <%
  hlist=(List<GirlsHostelDetails>)request.getAttribute("servermsg");
  if(hlist!=null){%>
<table>
 
  <tr>
    <th><b>Email</th>
    <th><b>Password</th>
        <th><b>University Roll</th>
        <th><b>First Name</th>
            <th><b>Last Name</th>
                <th><b>Year</th>
                <th><b>Stream</th>
                <th><b>Address</th>
                <th><b>Contact Details</th>
                <th><b>Hostel Name</th>
                <th><b>Parent Mobile Number</th>
                
            
        
    
  </tr>
   <%
  for(GirlsHostelDetails hobj:hlist){
  %>
  <tr>
    <td><%=hobj.getG_email() %></td>
    <td><%=hobj.getPassword() %></td>
        <td><%=hobj.getUni_roll() %></td>
        <td><%=hobj.getFirst_name() %></td>
        <td><%=hobj.getLast_name() %></td>
        <td><%=hobj.getYear() %></td>
        <td><%=hobj.getStream() %></td>
        <td><%=hobj.getAddress() %></td>
        <td><%=hobj.getMobile() %></td>
        <td><%=hobj.getHostel_name() %></td>
        <td><%=hobj.getParent_mob() %></td>
 		
      <td><a  href="calculate_fees?uni_roll=<%=hobj.getUni_roll()%>"><button type="button" class="btn btn-danger btn-sm"> Calculate Fees</button></a></button></td>      
                    
  </tr>
  
<%}} %>
</table>
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
