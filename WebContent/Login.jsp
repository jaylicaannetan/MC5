<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Mini Challenge #5</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/agency.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href='http://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

	<%
			String username = "";
			String password = "";
	%>
</head>

<body background="img/bg.jpg">

    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <a class="navbar-brand page-scroll" href="index.html">MINI CHALLENGE 5</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
					<li>
						<a data-toggle="modal" data-target="#signUp" >Sign Up</a>
					</li>
					<li>
						<a data-toggle="modal" data-target="#signIn" >Log In</a>
					</li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

			<!-- Sign In -->			
						<div class="modal" id="signIn">
							<div class="modal-dialog">
								<div class="modal-content">
								<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								&times;</button>
								<h4 class="modal-title">Log In</h4>
								</div>
								<div class="modal-body">
									<div class="row">
						                <div class="col-lg-12">
						                    <form action = "LoginServlet" name="register" id="contactForm" novalidate method = "post" >
						                        <div class="row">
						                            <div class="col-md-6">
						                               
														<div class="form-group">    					                    
						                                    <input type="username" class="form-control" placeholder="Username *" name="username" value = "<%=username %>" required data-validation-required-message="Please enter your username.">
						                                    <p class="help-block text-danger"></p>
						                                </div>
														
														<div class="form-group">
						                                    <input type="password" class="form-control" placeholder="Password *" name="password" value = "<%=password %>"required data-validation-required-message="Please enter your password.">
						                                    <p class="help-block text-danger"></p>
						                                </div>
														
						
						                            <div class="col-lg-8 text-center">
						                                <div id="success"></div>
						                                <button  type="submit" class="btn btn-xl" value = "submit">Log In</button>
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
						<!-- Sign Up -->			
						<div class="modal" id="signUp">
							<div class="modal-dialog">
								<div class="modal-content">
								<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
								&times;</button>
								<h4 class="modal-title">Sign Up</h4>
								</div>
								<div class="modal-body">
										<div class="row">
                <div class="col-lg-12">
                    <form name="register" id="contactForm" novalidate action = "RegisterServlet" method="post">
                        <div class="row">
                            <div class="col-md-7">
								<div class="form-group">
                                    <input type="username" name = "username" class="form-control" placeholder="Username *" id="username" required data-validation-required-message="Please enter your username.">
                                    <p class="help-block text-danger"></p>
                                </div>
								<div class="form-group">
                                    <input type="password" name = "password" class="form-control" placeholder="Password *" id="password" required data-validation-required-message="Please enter your password.">
                                    <p class="help-block text-danger"></p>
                                </div>
								<div class="form-group">
                                    <input type="password" name = "cfmpassword" class="form-control" placeholder="Confirm Password *" id="cfmpassword" required data-validation-required-message="Please confirm your password.">
                                    <p class="help-block text-danger"></p>
                                </div>

                            <div class="col-lg-8 text-center">
                                <div id="success"></div>
                                			<input type="submit"  class="btn btn-xl" value="Join the Club" >
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
															
								</div>
								</div><!-- /.modal-content -->
								</div><!-- /.modal-dialog -->
						</div>

    <!-- Header -->
    <header>
        <div class="container">
            <div class="intro-text">
            </div>
        </div>
    </header>

    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-20">
                    <span class="copyright">Copyright &copy; Nocturnals 2015</span>
                </div>
            </div>
        </div>
    </footer>
	
    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
    <script src="js/classie.js"></script>
    <script src="js/cbpAnimatedHeader.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="js/jqBootstrapValidation.js"></script>
    <script src="js/contact_me.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="js/agency.js"></script>
	
</body>

</html>