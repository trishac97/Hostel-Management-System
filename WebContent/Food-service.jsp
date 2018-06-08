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
                            <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark" href="" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><img src="assets/images/users/1.jpg" alt="user" class="profile-pic m-r-5" />Ujjwal Barman</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </header>
          <%! String first_name="",uni_roll=""; %>
                    <% first_name=(String)session.getAttribute("first_name");
                    uni_roll=(String)session.getAttribute("uni_roll");
                    %>
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
                            <a href="Notice.jsp" class="waves-effect"><i class="fa fa-bell m-r-10" aria-hidden="true"></i>Notice Board</a>
                        </li>
                        <li>
                            <a href="profile_details_fetch" class="waves-effect"><i class="fa fa-user m-r-10" aria-hidden="true"></i>Profile</a>
                        </li>
                        <li>
                            <a href="Food-service.jsp" class="waves-effect"><i class="fa fa-cutlery m-r-10" aria-hidden="true"></i>Food Service</a>
                        </li>
                        <li>
                            <a href="Laundry-service.jsp" class="waves-effect"><i class="fa fa-archive m-r-10" aria-hidden="true"></i>Laundry Service</a>
                        </li>
                        <li>
                            <a href="Home-In-out.jsp" class="waves-effect"><i class="fa fa-home m-r-10" aria-hidden="true"></i>Home In/Out Service</a>
                        </li>
                        <li>
                            <a href="Room-Service.jsp" class="waves-effect"><i class="fa fa-trash m-r-10" aria-hidden="true"></i>Room Service</a>
                        </li>
                        </li>
                        <li>
                            <a href="Health-Care.html" class="waves-effect"><i class="fa fa-heartbeat m-r-10" aria-hidden="true"></i>Health Care</a>
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
  				<a href="breakfast" class="btn pull-center hidden-sm-down btn-success" style="margin-right: 300px;margin-left: 150px">Breakfast</a>
             	<a href="lunch" class="btn pull-center hidden-sm-down btn-success" style="margin-right: 300px;">Lunch</a>
              	<a href="dinner" class="btn pull-center hidden-sm-down btn-success">Dinner</a><br><br>
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
  <h1>Breakfast Menu:</h1><br>
 <table id="alter">  
   <tr>
      <th>Item 1</th>
      <th>Item 2</th>
      <th>Item 3</th>
      <th>Item 4</th>
      <th>Item 5</th>
      <th>Item 6</th>
      <th>Item Code</th>
      <th>Item Price</th>
     
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
          <td><%=breakobj.getItem_6() %></td>
     <td><%= breakobj.getItem_code() %></td>
          <td><%= breakobj.getPrice() %></td>
             
                     <td><button class="btn btn-danger" style="color: white"><a  href="Food-service2.jsp?item_code=<%=breakobj.getItem_code()%>&price=<%=breakobj.getPrice()%>&item_1=<%=breakobj.getItem_1()%>&item_2=<%=breakobj.getItem_2()%>&item_3=<%=breakobj.getItem_3()%>&item_4=<%=breakobj.getItem_4()%>&item_5=<%=breakobj.getItem_5()%>&item_6=<%=breakobj.getItem_6()%>"> Book Meal </a></button></td>      
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
  <h1>Lunch Menu:</h1><br>
 <table id="alter">  
   <tr>
      <th>Item 1</th>
      <th>Item 2</th>
      <th>Item 3</th>
      <th>Item 4</th>
      <th>Item 5</th>
      <th>Item 6</th>
      <th>Item Code</th>
      <th>Item Price</th>
     
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
          <td><%=lunchobj.getItem_6() %></td>
     <td><%= lunchobj.getItem_code() %></td>
          <td><%= lunchobj.getPrice() %></td>
             
                     <td><button class="btn btn-danger" style="color: white"><a  href="Food-service2.jsp?item_code=<%=lunchobj.getItem_code()%>&price=<%=lunchobj.getPrice()%>&item_1=<%=lunchobj.getItem_1()%>&item_2=<%=lunchobj.getItem_2()%>&item_3=<%=lunchobj.getItem_3()%>&item_4=<%=lunchobj.getItem_4()%>&item_5=<%=lunchobj.getItem_5()%>&item_6=<%=lunchobj.getItem_6()%>"> Book Meal </a></button></td>        
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
  <h1>Dinner Menu:</h1><br>
 <table id="alter">  
   <tr>
      <th>Item 1</th>
      <th>Item 2</th>
      <th>Item 3</th>
      <th>Item 4</th>
      <th>Item 5</th>
      <th>Item 6</th>
      <th>Item Code</th>
      <th>Item Price</th>
     
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
          <td><%=dinnerobj.getItem_6() %></td>
     <td><%= dinnerobj.getItem_code() %></td>
          <td><%= dinnerobj.getPrice() %></td>
             
                     <td><button class="btn btn-danger" style="color: white">  <a  href="Food-service2.jsp?item_code=<%=dinnerobj.getItem_code()%>&price=<%=dinnerobj.getPrice()%>&item_1=<%=dinnerobj.getItem_1()%>&item_2=<%=dinnerobj.getItem_2()%>&item_3=<%=dinnerobj.getItem_3()%>&item_4=<%=dinnerobj.getItem_4()%>&item_5=<%=dinnerobj.getItem_5()%>&item_6=<%=dinnerobj.getItem_6()%>"> Book Meal </a></button></td>        
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
