<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Picture"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>View</title>

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
    
    <%  
    	ArrayList<Picture> list = new ArrayList<Picture>();
    	String add = "";
	 
    	if(session.getAttribute("PicList")!=null)
    	{
    		list = (ArrayList<Picture>) session.getAttribute("PicList");
    		
    		if(list.size() > 0)
    		{
	    		for(int i=0; i<list.size(); i++) 
	    		{		
	    			add = add + "<div class=\"row\">"+
	    	        "<div class=\"box\">"+
	    	            "<div class=\"col-lg-12 text-center\">"+
	    	            	"<img class=\"img-border\" id=\"change\" src="+ list.get(i).getPicture()+" height=\"250\" width=\"250\">"+
	    				"</div>"+
	    				"<div class=\"col-lg-12 text-center\">"+         
	    	            	"<label for=\"name\" class=\" h4 control-label text-left\">"+list.get(i).getCaption()+"</label>"+ 
	    	            "</div>"+
	    	            "<div class=\"col-lg-12 text-center\">"+  
	    					"<form action = \"DeletePicServlet\" name=\"register\" id=\"contactForm\" novalidate method = \"post\" >"+
	    	            	"<a href=\"myProfile.html\" class=\"btn btn-default btn-lg\" type=\"delete\">Delete</a>"+	         
	    	            	"</form>"+
	    	            	"<form action = \"EditPicServlet\" name=\"register\" id=\"contactForm\" novalidate method = \"post\" >"+
	    					"<a href=\"Edit.jsp\" class=\"btn btn-default btn-lg\" name ="+ String.valueOf(list.get(i).getPic_Id()) +"type=\"edit\">Edit</a>"+
	    					"</form>"+
	    				"</div>"+
	    	        	"</div>"+
	    	   	 	"</div>";
	    		}
    		}
    		else
    		{
    			add = add + "<div class=\"row\">"+
    	    	        "<div class=\"box\">"+
    	    	            "<div class=\"col-lg-12 text-center\">"+
    	    	            		"<img class=\"img-responsive img-border\" id=\"no\" src=\"img/cover.jng\" height=\"250\" width=\"250\">"+ 
    	    				"</div>"+
    	    	   	 	"</div>";
    		}
    	}
    	else 
    	{
    		System.out.println("null");
    	}
    	
 
	%>
	
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
				<ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
					<li>
						<a data-toggle="modal" data-target="#upload" >Upload</a>
					</li>
                </ul>
                						<div class="modal" id="upload">
							<div class="modal-dialog">
								<div class="modal-content">
								<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								&times;</button>
								<h4 class="modal-title">Upload</h4>
								</div>
								<div class="modal-body">
										<div class="row">
							                <div class="col-lg-12">
							                    <form action = "UploadPicServlet" name="register" id="register" novalidate method = "post" >
							                        <div class="row">
							                            <div class="col-md-6">
							                            	<img class="img-responsive img-border" id="change" src="img/intro-pic-big.png" height="250" width="250" alt="">
															<input id="image-upload" name = "picture" class="btn btn-link" type="file" accept="image/*" onchange="PreviewImage()">
															<div class="form-group">    					                    
							                                    <textarea class="form-control" rows="10" cols="2" placeholder="" name = "caption"></textarea>
							                                </div>
															
							
								                            <div class="col-lg-8 text-center">

								                               <button  type="submit" class="btn btn-xl" value = "submit">Upload</button>
								                            </div>
							                        	</div>       
							                   		</div>
							                	</form>
							            </div>
							        </div>
															
								</div>
								</div><!-- /.modal-content -->
								</div><!-- /.modal-dialog -->
						</div>
    <div class="brand">View</div>
    
    <div class="container">
    <%=add %>
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