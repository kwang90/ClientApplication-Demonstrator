<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>ICeWater Demonstrator | Dashboard</title>

<!-- Bootstrap Core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="css/plugins/metisMenu/metisMenu.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="fonts/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">

<!-- Layout shapes CSS -->
<link href="css/shapelayout.css" rel="stylesheet">

<link href="css/get-shit-done.css" rel="stylesheet" />

<link href="css/demo.css" rel="stylesheet" />

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand">ICeWater Demonstrator</a>
			</div>
			<!-- /.navbar-header -->

			<div class="navbar-default sidebar" role="navigation">
				<div class="sidebar-nav navbar-collapse">
					<ul class="nav" id="side-menu">
						<li><a href="/client/dashboard.html"><i
								class="fa fa-dashboard fa-fw"></i> Dashboard<span
								class="fa arrow"></span></a></li>
						<li><a href="/client/statistics.html"><i
								class="fa fa-bar-chart-o fa-fw"></i> Statistics</a></li>
					</ul>
				</div>
				<!-- /.sidebar-collapse -->
			</div>
			<!-- /.navbar-static-side -->
		</nav>
	</div>
	<!-- Page Content -->
	<div id="page-wrapper">
		<br>
		<div class="row">
			<div class="col-lg-6">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<i class="fa fa-image fa-fw"></i> Control Layout
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div id="container">
							<div id="navi">
								<div class="sewage" onclick="onProcessClicked('Sewage')">Waste</div>
								<div class="utility" onclick="onProcessClicked('Fresh')">Fresh</div>
								<div class="house1" onclick="onProcessClicked('House 1')">House
									1</div>
								<div class="house2" onclick="onProcessClicked('House 2')">House
									2</div>
							</div>
							<div id="infoi2">
								<hr class="house1Line"></hr>
							</div>
							<div id="infoi3">
								<hr class="house2Line"></hr>
							</div>
							<div id="infoi4">
								<hr class="connectingLine"></hr>
							</div>
							<div id="infoi5">
								<hr class="sewageLine"></hr>
							</div>
							<div id="infoi6">
								<hr class="house11Line"></hr>
							</div>
							<div id="infoi7">
								<hr class="house22Line"></hr>
							</div>
							<div id="infoi8">
								<hr class="connecting2Line"></hr>
							</div>

						</div>
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
			<!-- /.col-lg-12 -->

			<div class="col-lg-6">
				<div class="row">
					<div class="panel panel-info">
						<div class="panel-heading">
							<i class="fa fa-cogs fa-fw"></i> Control Panel
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body well">
							<div>
								<h4 id="panelPropertyId"></h4>
							</div>
							<div id="panelDevicesList" class="list-group"></div>
						</div>
						<!-- /.panel-body -->
					</div>
				</div>
				<div class="row">
					<div class="panel panel-red">
						<div class="panel-heading">
							<i class="fa fa-bell fa-fw"></i> Notifications Panel
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="list-group">
								<a href="#" class="list-group-item"> <i
									class="fa fa-bell fa-fw"></i> New Sensor: Sensor 1 inserted <span
									class="pull-right text-muted small"><em>4 minutes
											ago</em> </span>
								</a> <a href="#" class="list-group-item"> <i
									class="fa fa-bell fa-fw"></i> Flow 1 reached threshold value <span
									class="pull-right text-muted small"><em>12 minutes
											ago</em> </span>
								</a><a href="#" class="list-group-item"> <i
									class="fa fa-bell fa-fw"></i> Pump 1 is on<span
									class="pull-right text-muted small"><em>12 minutes
											ago</em> </span>
								</a><a href="#" class="list-group-item"> <i
									class="fa fa-bell fa-fw"></i> Level 1<span
									class="pull-right text-muted small"><em>12 minutes
											ago</em> </span>
								</a>
							</div>
							<!-- /.list-group -->
						</div>
						<!-- /.panel-body -->
					</div>
				</div>
			</div>
		</div>
		<!-- /.row -->
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="bootstrap/js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="js/plugins/metisMenu/metisMenu.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/sb-admin-2.js"></script>

	<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="js/jquery-ui-1.10.4.custom.min.js" type="text/javascript"></script>

	<script src="js/gsdk-checkbox.js"></script>
	<script src="js/gsdk-radio.js"></script>
	<script src="js/gsdk-bootstrapswitch.js"></script>
	<script src="js/get-shit-done.js"></script>

	<!-- Custom Script -->
	<script src="js/custom.js"></script>

</body>

</html>
