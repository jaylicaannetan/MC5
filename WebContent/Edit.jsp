<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Edit</title>

       <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/business-casual.css" rel="stylesheet">
	
	<!-- Custom CSS -->
    <link href="css/stylish-portfolio.css" rel="stylesheet">
	
	 <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
    
	<!-- Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
	
	<!-- For Search Bar -->
    <link rel="stylesheet" type="text/css" href="font-awesome/css/font-awesome.min.css" />
    <script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
        <script src="jquery-2.1.1.js"></script>
        <script>
         function PreviewImage() {
        var oFReader = new FileReader();
        oFReader.readAsDataURL(document.getElementById("image-upload").files[0]);

        oFReader.onload = function (oFREvent) {
            document.getElementById("change").src = oFREvent.target.result;
        };
    };
        </script>
	
</head>

<body>
    <!-- Navigation -->
      
<br>
<!-- Search Navbar - END -->
<!-- jQuery -->
    <script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
    
<!-- Custom Theme JavaScript -->

    <div class="brand">Edit</div>
    <div class="container">
    
    <% String caption = "";
    	if((String)session.getAttribute("caption") != null)
    	 caption = (String) session.getAttribute("caption");
    	%>

       		 <div class="row">
            		<div class="box">
            		<form action = "EditPicServlet" name="register" id="contactForm" novalidate method = "post">
          	        <img class="img-responsive img-border" id="change" src="<%= session.getAttribute("picture")%>" height="250" width="250" alt="">
					<input id="image-upload" name="image" class="btn btn-link" type="file" accept="image/*" value="<%= session.getAttribute("picture")%>" onchange="PreviewImage()">
					<input type="text" name="picture" class=" h4 control-label text-left hidden" value="<%= session.getAttribute("picture")%>"> 
					<br>
					 <input type="text" name ="caption" class="col-xs-4 col-sm-7 h4 control-label text-left" value="<%= caption%>"> 
					<input type="text" readonly="readonly" name="pic_id" class=" h4 control-label text-left hidden" value="<%= session.getAttribute("pic_id")%>"> 
					<input type="submit" name="Save" class="btn btn-default btn-lg" type="save"  value="Save">
					</form>
                    </div>
            </div>
        </div>

    </div>
    <!-- /.container -->

        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <p><font color="white">Copyright &copy; Nocturnals 2015</font></p>
                </div>
            </div>
        </div>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>