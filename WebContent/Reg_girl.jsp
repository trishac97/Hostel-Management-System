<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <title>Register</title>
  
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="css_reg/style.css">

  <script>
  var check = function() {
	  if (document.getElementById('password').value ==
	    document.getElementById('cpassword').value) {
	    document.getElementById('message').style.color = 'green';
	    document.getElementById('message').innerHTML = 'matching';
	  } else {
	    document.getElementById('message').style.color = 'red';
	    document.getElementById('message').innerHTML = 'not matching';
	  }
	}</script>
</head>
<body background="css_reg/background.png">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Girls' Hostel Registration Form</title>
        <link rel="stylesheet" href="css_reg/normalize.css">
        <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="css_reg/main.css">
    </head>
    <body>

      <form action="Reg_girl" method="post">
      
        <h1>Hostel Registration</h1>
        
        <fieldset>
         <label for="mail">Email:</label>
          <input type=email id="g_email" name="g_email">
          
          <label for="password">Password:</label>
          <input type="password" id="password" name="password">
		  
		  <label for="cpassword">Confirm Password:</label>
          <input type="password" id="cpassword" name="cpassword"  onkeyup='check();'>
		  
          <label for="fname">First Name:</label>
          <input type="text" id="fname" name="first_name">
		  <label for="lname">Last Name:</label>
          <input type="text" id="lname" name="last_name">
		  
		  <label for="universityroll">University Roll:</label>
          <input type="text" id="universityroll" name="uni_roll">
		  <label for="phone">Phone Number:</label>
          <input type="text" id="phone" name="phone">
		  
		  <label for="stream">Stream:</label>
          <input type="text" id="stream" name="stream">
		  
		  <label for="year">Year:</label>
		  	<input type="radio" name="year" value="1st" checked> 1st Year<br>
 			<input type="radio" name="year" value="2nd"> 2nd Year<br>
 			<input type="radio" name="year" value="3rd"> 3rd Year<br>
			<input type="radio" name="year" value="4th"> 4th Year<br>
			<br>
			<label for="hostelname">Hostel Name:</label>
			&nbsp;&nbsp;&nbsp;&nbsp;
		  	<input type="radio" name="hostel_name" value="name1" checked> Sarojini Naidu Hostel&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 			<input type="radio" name="hostel_name" value="name2"> Nibedita Hostel<br>
			  <br>
			<label for="parentphone">Parent Phone No:</label>
          	<input type="text" id="parent_phone" name="user_parentphone">
			
		  	<label for="address">Address:</label>
          	<textarea id="address" name="address"></textarea>
          
        </fieldset>
        
        
        <button type="submit">Register</button>
      </form>
      
    </body>
</html>
  
  

</body>

</html>
