<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">


<!-- body
	text-align: justify;   text-align: justify and the following few lines of codes inclusive allows my navigation elements to have equal spaces within between them no matter how many elements there are
-->
<style type="text/css">
body {
	min-height: 100vh;
	position: relative;
}

* {
	box-sizing: border-box;
}

.body-wrapper {
	margin: 0 auto;
	/* Shorthand for margin. Auto on left and right allows .wrap to be centered in the browser */
}

/* Left and right column */
.column-left {
	margin-top: 50px; /*na apexei apo panw toso */
	float: left;
	width: 25%;
}

.column-right {
	margin-top: 50px; /*na apexei apo panw toso */
	float: right;
	text-align: center;
	width: 25%;
}
/* Middle column */
.column-middle {
	margin-top: 50px;
	display: inline-block;
	width: 50%;
	/* text-align: justify; */
	/* text-align: justify and the following few lines of codes inclusive allows my navigation elements to have equal spaces within between them no matter how many elements there are.*/
}

.login {
	float: left;
}

.image {
	content: url("https://www.hua.gr/images/photos/IMG_6544.jpg");
	width: 950px;
	height: 500px;
	opacity: 100%;
}

.map {
	content: url("../resources/photos/map-jpeg.JPG");
	width: 500px;
	height: 800px;
	opacity: 100%;
	vertical-align: right;
}
​
</style>

<title>Home Page</title>
</head>
<body>

	<div class="body-wrapper">
		<div class="column-left">
			<ul>
				<li><a>Announcements</a></li>
				<li>Events</li>
				<li>Lectures</li>
				<li>Workshops</li>
				<li>Photos</li>
			</ul>
		</div>


		<div class="column-middle">
			<div class="login">
				You can <a href="/Education/login/"> login </a> here.
			</div>

			<br />
			<h3>General information about the application</h3>
		 <br />
			<div class="image"></div>
		</div>

		<div class="column-right">Latest News <br/>
		<div class="map"></div></div>
	</div>