<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.rpm.model.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Profile</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
 <link rel="stylesheet" href="css/style.css">
     <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
    <script>
  $(document).ready(function () {
	    var date = new Date();
	    var currentMonth = date.getMonth();
	    var currentDate = date.getDate();
	    var currentYear = date.getFullYear();

	    $("#datepicker,#datepicker2").datepicker({
	       
	        dateFormat: 'yy-mm-dd'
	    });
	});
  </script>
</head>
<body>

<form action="leave" method="POST">
    <div class="main">

        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                    <form method="POST" id="signup-form" class="signup-form">
                        <h2 class="form-title">Leave Request</h2>
                         <div class="form-group">
                            <input  class="form-input" name="userid" id="eno" value="${mysession.getUserid()}" />
                        </div>
                         <div class="form-group">
                            <input  class="form-input" name="name" id="name" value="${mysession.getName()}" />
                        </div>
                          <div class="form-group">
                            <input type="text" class="form-input" name="l_type" id="l_type" placeholder="l_type"/>
                        </div>
                        <div class="form-group">
                            <input type="date" class="form-input" name="date_from" id="datepicker" placeholder="DateFrom(YY-MM-DD)"/>
                        </div>
                         <div class="form-group">
                            <input type="date" class="form-input" name="date_to" id="datepicker2" placeholder="DateTo(YY-MM-DD)"/>
                        </div>
                         <div class="form-group">
                            <input type="text" class="form-input" name="days" id="days" placeholder="Days"/>
                        </div>
                        
                        
                        <div class="form-group">
                            <input type="submit" name="submit" id="submit" class="form-submit" value="Leave Request"/>
                        </div>
                    </form>
                  
                </div>
            </div>
        </section>

    </div>
</form>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>