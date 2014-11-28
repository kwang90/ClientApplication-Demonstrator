<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Flat UI Kit - Dribbble Rebound - CodePen</title>

<style>
/*! normalize.css v3.0.2 | MIT License | git.io/normalize */
html {
	font-family: sans-serif;
	-ms-text-size-adjust: 100%;
	-webkit-text-size-adjust: 100%
}

body {
	margin: 0
}

article,aside,details,figcaption,figure,footer,header,hgroup,main,menu,nav,section,summary
	{
	display: block
}

audio,canvas,progress,video {
	display: inline-block;
	vertical-align: baseline
}

audio




















:not










 










(
[
controls
]










 










){
display




















:










 










none




















;
height




















:










 










0
}
[hidden],template {
	display: none
}

a {
	background-color: transparent
}

a:active,a:hover {
	outline: 0
}

abbr[title] {
	border-bottom: 1px dotted
}

b,strong {
	font-weight: bold
}

dfn {
	font-style: italic
}

h1 {
	font-size: 2em;
	margin: 0.67em 0
}

mark {
	background: #ff0;
	color: #000
}

small {
	font-size: 80%
}

sub,sup {
	font-size: 75%;
	line-height: 0;
	position: relative;
	vertical-align: baseline
}

sup {
	top: -0.5em
}

sub {
	bottom: -0.25em
}

img {
	border: 0
}

svg




















:not










 










(
:root










 










){
overflow




















:










 










hidden






















}
figure {
	margin: 1em 40px
}

hr {
	-moz-box-sizing: content-box;
	-webkit-box-sizing: content-box;
	box-sizing: content-box;
	height: 0
}

pre {
	overflow: auto
}

code,kbd,pre,samp {
	font-family: monospace, monospace;
	font-size: 1em
}

button,input,optgroup,select,textarea {
	color: inherit;
	font: inherit;
	margin: 0
}

button {
	overflow: visible
}

button,select {
	text-transform: none
}

button,html input[type="button"],input[type="reset"],input[type="submit"]
	{
	-webkit-appearance: button;
	cursor: pointer
}

button[disabled],html input[disabled] {
	cursor: default
}

button::-moz-focus-inner,input::-moz-focus-inner {
	border: 0;
	padding: 0
}

input {
	line-height: normal
}

input[type="checkbox"],input[type="radio"] {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	padding: 0
}

input[type="number"]::-webkit-inner-spin-button,input[type="number"]::-webkit-outer-spin-button
	{
	height: auto
}

input[type="search"] {
	-webkit-appearance: textfield;
	-moz-box-sizing: content-box;
	-webkit-box-sizing: content-box;
	box-sizing: content-box
}

input[type="search"]::-webkit-search-cancel-button,input[type="search"]::-webkit-search-decoration
	{
	-webkit-appearance: none
}

fieldset {
	border: 1px solid #c0c0c0;
	margin: 0 2px;
	padding: 0.35em 0.625em 0.75em
}

legend {
	border: 0;
	padding: 0
}

textarea {
	overflow: auto
}

optgroup {
	font-weight: bold
}

table {
	border-collapse: collapse;
	border-spacing: 0
}

td,th {
	padding: 0
}
</style>

<link rel='stylesheet prefetch'
	href='https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/grid.css'>
<link rel='stylesheet prefetch'
	href='http://fonts.googleapis.com/css?family=Montserrat'>
<link rel='stylesheet prefetch'
	href='https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/icomoon-scrtpxls.css'>

<style>
*,*:before,*:after {
	box-sizing: border-box;
}

img {
	max-width: 100%;
	height: auto;
	vertical-align: sub;
}

body {
	font-family: 'Montserrat', sans-serif;
	background: #ebebeb;
	padding-top: 20px;
}

.btn {
	display: inline-block;
	padding: 6px 14px;
	background: #f2f2f2;
	border-radius: 3px;
	color: #7a7a7a;
	font-size: 0.8125em;
	transition: background .3s ease, color .3s ease;
	text-decoration: none;
}

.btn:hover {
	background: #e5e5e5;
	color: #929797;
}

.btn.btn-primary {
	background: #dd5555;
	color: rgba(255, 255, 255, 0.9);
}

.btn.btn-primary:hover,.btn.btn-primary.active {
	background: #d94040;
}

.btn.btn-large {
	padding: 12px 28px;
}

.btn.btn-caps {
	text-transform: uppercase;
}

.btn.btn-block {
	display: block;
	width: 100%;
	text-align: center;
}

input[type="text"] {
	width: 100%;
	border: 1px solid #cfcfcf;
	background: #ebebeb;
	height: 28px;
	font-size: 0.75em;
	padding: 5px;
	outline: none;
	border-radius: 3px;
	margin-bottom: 7px;
	transition: background .3s ease;
}

input[type="text"]:focus {
	background: #f0f0f0;
}

.checkbox {
	color: #ccc;
	text-shadow: 1px 1px 1px rgba(255, 255, 255, 0.4);
	font-size: 0.6875em;
	margin-bottom: 7px;
	display: inline-block;
}

.box {
	background: #f9f9f9;
	box-shadow: 0 0 1px rgba(0, 0, 0, 0.2), 0 2px 4px rgba(0, 0, 0, 0.1);
	border-radius: 5px;
	margin-bottom: 20px;
	text-shadow: 1px 1px 1px rgba(0, 0, 0, 0.1);
}

.box h2 {
	color: #dd5555;
	font-size: 0.875em;
}

.box p {
	font-size: 0.75em;
	color: #7d7d7d;
}

.locations {
	padding: 30px;
	text-align: center;
}

.locations .avatar {
	border-radius: 50%;
}

.locations .avatar img {
	border-radius: 50%;
}

.locations .details {
	margin-top: 30px;
}

.locations .btn {
	margin-top: 30px;
}

.calendar {
	text-align: center;
}

.calendar .header {
	padding: 10px 0;
}

.calendar [class*="icon-"] {
	color: #dd5555;
	position: relative;
	top: 2px;
	margin: 0 5px;
	display: inline-block;
	cursor: pointer;
}

.calendar .days {
	background: #dd5555;
	padding: 20px;
	border-radius: 0 0 5px 5px;
}

.calendar .days ul {
	margin: 0;
	padding: 0;
}

.calendar .days li {
	display: inline-block;
	color: #fff;
	padding: 5px 0;
	width: 30px;
	height: 30px;
	text-align: center;
	cursor: pointer;
}

@media ( max-width : 767px) {
	.calendar .days li {
		width: 20px;
		height: 20px;
	}
}

.calendar .days li.next,.calendar .days li.previous {
	color: rgba(0, 0, 0, 0.2);
}

.nav a {
	text-decoration: none;
	color: #cccccc;
	text-shadow: 1px 1px 1px rgba(255, 255, 255, 0.5);
	font-size: 0.75em;
}

.nav a:hover {
	color: #dd5555;
}

.nav [class*="icon-"] {
	font-size: 2em;
	margin-bottom: 5px;
	display: inline-block;
}

.nav ul {
	margin: 0;
	padding: 0;
	list-style: none;
	text-align: center;
}

.nav li {
	display: inline-block;
}

.nav li a {
	display: block;
	padding: 20px 18px;
}

.weather .header {
	border-radius: 5px 5px 0 0;
	padding: 20px 0;
	background: #dd5555;
	text-align: center;
	color: #fff;
	font-size: 3.125em;
}

.weather [class*="icon-"] {
	position: relative;
	top: 2px;
}

.weather article {
	text-align: center;
	padding: 5px 0;
}

.video {
	position: relative;
	cursor: pointer;
}

.video:before {
	content: '';
	border: 2px solid rgba(255, 255, 255, 0.8);
	background: rgba(255, 255, 255, 0.1);
	width: 50px;
	height: 50px;
	border-radius: 50%;
	display: block;
	position: absolute;
	left: 50%;
	top: 50%;
	margin: -20px 0 0 -20px;
	transition: background .3s ease;
}

.video:after {
	content: '';
	display: block;
	position: absolute;
	left: 50%;
	top: 50%;
	margin: -5px 0 0 2px;
	border: 10px solid transparent;
	border-left: 10px solid rgba(255, 255, 255, 0.8);
}

.video:hover:before {
	background: rgba(255, 255, 255, 0.3);
}

.video img {
	border-radius: 5px;
}

.post img {
	border-radius: 5px 5px 0 0;
}

.post .details {
	padding: 10px 20px;
}

.post .details p {
	line-height: 1.5em;
}

.audio {
	position: relative;
	height: 120px;
}

.audio .image {
	position: absolute;
	top: 0;
	left: 0;
}

.audio .image img {
	border-radius: 5px 0 0 5px;
}

.audio .details {
	padding: 10px 0;
	margin-left: 140px;
}

.audio .actions {
	position: absolute;
	right: 10px;
	bottom: 20px;
}

.audio .actions .btn {
	width: 25px;
	height: 25px;
	display: block;
	float: left;
	margin-left: 5px;
	padding: 5px 6px;
	color: #FFF;
}

.audio .player .bar {
	margin: 30px 0 0;
	height: 4px;
	background: #cccccc;
	width: 60%;
	border-radius: 2px;
}

.audio .player .bar .progress {
	width: 45%;
	background: #dd5555;
	border-radius: 2px;
	height: 4px;
	position: relative;
}

.audio .player .bar .progress:before {
	content: attr(data-time);
	background: #dd5555;
	display: inline;
	position: absolute;
	font-size: 0.6875em;
	color: #fff;
	padding: 4px 6px;
	border-radius: 3px;
	right: -14px;
	bottom: 9px;
}

.audio .player .bar .progress:after {
	content: '';
	border: 5px solid transparent;
	border-top: 5px solid #dd5555;
	position: absolute;
	right: -3px;
	bottom: 0px;
}

.find {
	padding: 10px;
}
</style>

<script src="js/prefixfree.min.js"></script>

<link href="bootstrap3/css/bootstrap.css" rel="stylesheet" />
<link href="bootstrap3/css/font-awesome.css" rel="stylesheet" />

<link href="assets/css/get-shit-done.css" rel="stylesheet" />
<link href="assets/css/demo.css" rel="stylesheet" />

<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Grand+Hotel'
	rel='stylesheet' type='text/css'>

</head>

<body>

	<div class="container">
		<div class="grid_12">
			<article class="box post">
				<div class="image">
					<img
						src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/6035/scrtpxls_post.png" />
				</div>
				<div class="details">
					<h2>Demonstration Site Milan</h2>
				</div>
			</article>
		</div>
		<div class="grid_6">
			<section class="box widget locations">
				<div class="details">
					<h2>Tasking</h2>
				</div>
			</section>
			<section class="switch has-switch">
				<div class="switch-on">
					<input type="checkbox" checked="" data-toggle="switch"
						class="ct-info"><span class="switch-left">ON</span><label>&nbsp;</label><span
						class="switch-right">OFF</span>
				</div>
			</section>
		</div>
		<div class="grid_6">
			<section class="box widget locations">
				<div class="details">
					<h2>Notifications</h2>
				</div>
			</section>
		</div>

	</div>

</body>

<script src="jquery/jquery-1.10.2.js" type="text/javascript"></script>
<script src="assets/js/jquery-ui-1.10.4.custom.min.js"
	type="text/javascript"></script>
<script src="bootstrap3/js/bootstrap.js" type="text/javascript"></script>
<script src="assets/js/gsdk-checkbox.js"></script>
<script src="assets/js/gsdk-radio.js"></script>
<script src="assets/js/gsdk-switch.js"></script>
<script src="assets/js/get-shit-done.js"></script>
<script src="assets/js/custom.js"></script>

</html>