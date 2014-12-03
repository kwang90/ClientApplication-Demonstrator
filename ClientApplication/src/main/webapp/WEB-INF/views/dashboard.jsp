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
			<div class="col-lg-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<i class="fa fa-image fa-fw"></i> Control Layout
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="row">

							<i
								style="position: relative; display: inline-block; border: 50px solid #428bca; left: 40%; top: 0px"></i>
							<i
								style="position: relative; display: inline-block; border: 50px solid #428bca; left: 40%; top: 0px"></i>
						</div>
					</div>
					<!-- /.panel-body -->
				</div>
			</div>
			<!-- /.col-lg-12 -->
		</div>
		<!-- /.row -->

		<!-- <span class="text-center"
							style="display: inline-block; width: 300px; height: 300px"><span
							style="position: relative; display: inline-block; width: 300px; height: 300px"><i
								style="position: absolute; display: inline-block; width: 0; height: 0; line-height: 0; border: 51.315789473684205px solid #428bca; border-bottom: 51.315789473684205px solid #428bca; left: 189.4736842105263px; top: 0px"></i><i
								style="position: absolute; display: inline-block; width: 0; height: 0; line-height: 0; border: 51.315789473684205px solid #428bca; border-bottom: 51.315789473684205px solid #428bca; left: 189.4736842105263px; top: 205.26315789473682px"></i><i
								style="position: absolute; display: inline-block; width: 0; height: 0; line-height: 0; border: 51.315789473684205px solid #428bca; border-bottom: 51.315789473684205px solid #428bca; left: 386.84210526315786px; top: 102.63157894736841px"></i><i
								style="position: absolute; display: inline-block; width: 0; height: 0; line-height: 0; border: 51.315789473684205px solid #428bca; border-bottom: 51.315789473684205px solid #428bca; left: 0px; top: 102.63157894736841px"></i></span></span> -->
		<div class="row">
			<div class="col-lg-6">
				<div class="panel panel-info">
					<div class="panel-heading">
						<i class="fa fa-cogs fa-fw"></i> Control Panel
					</div>
					<!-- /.panel-heading -->
					<div class="panel-body"></div>
					<!-- /.panel-body -->
				</div>
			</div>
			<div class="col-lg-6">
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
</body>

</html>
