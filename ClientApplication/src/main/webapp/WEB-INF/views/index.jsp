<!DOCTYPE html>
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<title>ICeWater Demonstrator | Welcome</title>

<!-- Mobile Meta -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Favicon -->
<link rel="shortcut icon" href="images/favicon.ico">

<!-- Web Fonts -->
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,400,700,300&amp;subset=latin,latin-ext'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.googleapis.com/css?family=Raleway:700,400,300'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.css" rel="stylesheet">

<!-- Font Awesome CSS -->
<link href="fonts/font-awesome/css/font-awesome.css" rel="stylesheet">

<!-- Plugins -->
<link href="css/animations.css" rel="stylesheet">

<!-- Worthy core CSS file -->
<link href="css/style.css" rel="stylesheet">

<!-- Custom css -->
<link href="css/custom.css" rel="stylesheet">
</head>

<body class="no-trans">
	<!-- scrollToTop -->
	<!-- ================ -->
	<div class="scrollToTop">
		<i class="icon-up-open-big"></i>
	</div>

	<!-- header start -->
	<!-- ================ -->
	<header class="header fixed clearfix navbar navbar-fixed-top">
		<div class="container">
			<div class="row">
				<div class="col-md-4">

					<!-- header-left start -->
					<!-- ================ -->
					<div class="header-left clearfix">

						<!-- logo -->
						<div class="logo smooth-scroll">
							<a href="#banner"><img id="logo" src="images/logo.png"
								alt="Worthy"></a>
						</div>

						<!-- name-and-slogan -->
						<div class="site-name-and-slogan smooth-scroll">
							<div class="site-name">
								<a href="#banner">ICeWater</a>
							</div>
							<div class="site-slogan">Plug, Discover and Play!</div>
						</div>

					</div>
					<!-- header-left end -->

				</div>
				<div class="col-md-8">

					<!-- header-right start -->
					<!-- ================ -->
					<div class="header-right clearfix">

						<!-- main-navigation start -->
						<!-- ================ -->
						<div class="main-navigation animated">

							<!-- navbar start -->
							<!-- ================ -->
							<nav class="navbar navbar-default" role="navigation">
								<div class="container-fluid">

									<!-- Toggle get grouped for better mobile display -->
									<div class="navbar-header">
										<button type="button" class="navbar-toggle"
											data-toggle="collapse" data-target="#navbar-collapse-1">
											<span class="sr-only">Toggle navigation</span> <span
												class="icon-bar"></span> <span class="icon-bar"></span> <span
												class="icon-bar"></span>
										</button>
									</div>

									<!-- Collect the nav links, forms, and other content for toggling -->
									<div class="collapse navbar-collapse scrollspy smooth-scroll"
										id="navbar-collapse-1">
										<ul class="nav navbar-nav navbar-right">
											<li class="active"><a href="#banner">Home</a></li>
											<li><a href="#features">Features</a></li>
											<li><a href="#demo">Live Demo!</a></li>
										</ul>
									</div>

								</div>
							</nav>
							<!-- navbar end -->

						</div>
						<!-- main-navigation end -->

					</div>
					<!-- header-right end -->

				</div>
			</div>
		</div>
	</header>
	<!-- header end -->

	<!-- banner start -->
	<!-- ================ -->
	<div id="banner" class="banner">
		<div class="banner-image"></div>
		<div class="banner-caption">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 object-non-visible"
						data-animation-effect="fadeIn">
						<h1 class="text-center">
							ICeWater <span>Demonstrator</span>
						</h1>
						<p class="lead text-center">How about plugging in your
							sensors, building up your autonomous reasoning service and
							enjoying the orchestration flow? No sensors complexities, No
							development dependencies!</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- banner end -->

	<!-- section start -->
	<!-- ================ -->
	<div class="section translucent-bg bg-image-1 blue">
		<div class="container object-non-visible"
			data-animation-effect="fadeIn">
			<h1 id="features" class="text-center title">ICeWater Features</h1>
			<div class="space"></div>
			<div class="row">
				<div class="col-sm-6">
					<div class="media">
						<div class="media-body text-right">
							<h4 class="media-heading">Plug and Play</h4>
							<p>ICeWater system supports automatic device plug and play.
								Devices range from normal measurement sensors to complicated
								actuators. Thanks to our Smart Gateway Service (SGWs)!</p>
						</div>
						<div class="media-right">
							<i class="fa fa-play"></i>
						</div>
					</div>
					<div class="media">
						<div class="media-body text-right">
							<h4 class="media-heading">Sensor Web Integration</h4>
							<p>
								ICeWater system utilizes the <a target="_blank"
									href="http://www.opengeospatial.org/ogc/markets-technologies/swe">OGC
									SWE</a> to realize the paradigm of Sensor Web. List of services
								include the Sensor Observation Service (SOS), Sensor Planning
								Service (SPS) and Sensor Event Service (SES).
							</p>
						</div>
						<div class="media-right">
							<i class="fa fa-check"></i>
						</div>
					</div>
					<div class="media">
						<div class="media-body text-right">
							<h4 class="media-heading">Real-time Monitoring and Tasking</h4>
							<p>ICeWater system provides real-time monitoring and tasking
								for devices. Using the World Wide Web, control all your devices
								from anywhere using a click of a button!</p>
						</div>
						<div class="media-right">
							<i class="fa fa-desktop"></i>
						</div>
					</div>
					<div class="media">
						<div class="media-body text-right">
							<h4 class="media-heading">Secured Tasking Access</h4>
							<p>ICeWater system provides secured access to tasking
								resources using the OAuth 2.0 protocol. Don't worry, nobody can
								ever sneak into your system and change its state!</p>
						</div>
						<div class="media-right">
							<i class="fa fa-key"></i>
						</div>
					</div>
				</div>
				<div class="space visible-xs"></div>
				<div class="col-sm-6">
					<div class="media">
						<div class="media-left">
							<i class="fa fa-cog"></i>
						</div>
						<div class="media-body">
							<h4 class="media-heading">Autonomous Reasoning Services</h4>
							<p>ICeWater system allows developers to build up their own
								reasoning services (Web, Desktop, Mobile), independent of the
								underlying complexities. Devices integration is handled by our
								SGWs.</p>
						</div>
					</div>
					<div class="media">
						<div class="media-left">
							<i class="fa fa-area-chart"></i>
						</div>
						<div class="media-body">
							<h4 class="media-heading">Statistics</h4>
							<p>ICeWater system enables developers to retrieve up-to-date
								sensor monitoring statistics. Thanks to the Sensor Observation
								Service (SOS), as several search filters can be applied.</p>
						</div>
					</div>
					<div class="media">
						<div class="media-left">
							<i class="fa fa-bell"></i>
						</div>
						<div class="media-body">
							<h4 class="media-heading">Publish Subscriber Notifications</h4>
							<p>ICeWater system implements a publish subscriber mechanism
								to enable asynchronous delivery of notifications. It uses the
								existing support of the Sensor Event Service (SES).</p>
						</div>
					</div>
					<div class="media">
						<div class="media-left">
							<i class="fa fa-hdd-o"></i>
						</div>
						<div class="media-body">
							<h4 class="media-heading">Embedded Services</h4>
							<p>ICeWater system was fully developed and deployed over
								embedded devices. The SWGs is deployed on a Raspberry Pi while
								the SWE services are deployed on a BeagleBoard.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- section end -->

	<!-- section start -->
	<!-- ================ -->
	<div id="demo" class="default-bg space">
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1 class="text-center">Smart Devices are Approaching, And We
						Are Getting Ready!</h1>
				</div>
				<div class="text-center">
					<form action="/client/dashboard.html" method="post">
						<button class="btn btn-primary btn-lg">Start Live Demo!</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- section end -->

	<!-- footer start -->
	<!-- ================ -->
	<footer id="footer">

		<!-- .subfooter start -->
		<!-- ================ -->
		<div class="subfooter">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<p class="text-center">
							Copyright 2014 by Siemens AG</a>.
						</p>
					</div>
				</div>
			</div>
		</div>
		<!-- .subfooter end -->

	</footer>
	<!-- footer end -->

	<!-- JavaScript files placed at the end of the document so the pages load faster
		================================================== -->
	<!-- Jquery and Bootstap core js files -->
	<script type="text/javascript" src="plugins/jquery.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

	<!-- Modernizr javascript -->
	<script type="text/javascript" src="plugins/modernizr.js"></script>

	<!-- Isotope javascript -->
	<script type="text/javascript"
		src="plugins/isotope/isotope.pkgd.min.js"></script>

	<!-- Backstretch javascript -->
	<script type="text/javascript" src="plugins/jquery.backstretch.min.js"></script>

	<!-- Appear javascript -->
	<script type="text/javascript" src="plugins/jquery.appear.js"></script>

	<!-- Initialization of Plugins -->
	<script type="text/javascript" src="js/template.js"></script>

	<!-- Custom Scripts -->
	<script type="text/javascript" src="js/custom.js"></script>

</body>
</html>
