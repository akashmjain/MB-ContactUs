<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Josefin+Slab:wght@300&amp;display=swap" rel="stylesheet">
	<style>
		body {
			font-family: 'Josefin Slab', serif;
			background: #0B0B0B;
		}
		div {
			display: flex;
		    height: 340px;
			justify-content: center;
		    align-items: center;         
		}
		form {
			margin: 4%;
		}
		input {
		    height: 10.0rem;
		    width: 25.0rem;
		    font-size: 2.0rem;
		    cursor: pointer;
		    background-color: transparent;
		    color: rgb(214, 202, 202);
		    border: solid grey;
		    border-radius: 2%;
		}
		input[type="submit"]:hover {
		    border-color: tomato;
		}
	</style>
</head>
<body>
	<div id="menu">
		<form action="admin/contactus/requests" method="post">
			<input type="submit" value="Admin Login">
		</form>
		<form action="contactus" method="post">
			<input type="submit" value="ContactUs Page">
		</form>
	</div>
</body>
</html>