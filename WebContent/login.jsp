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
            color: white;
            font-size: 1.5em;
            display: flex;
            flex-direction: column;
            align-items: center;
		}
        .main {
            width: 50rem;
            margin-top: 5%;
        }
        .text-input, .pwd-input {
            font-size: 1.5rem;
            padding: 2%;
            background-color: #0B0B0B;
            color: white;
        }
        .field {
            display: flex;
            flex-direction: column;
            margin-top: 5%;
            margin-bottom: 5%;
        }
        .submit-btn {
            width: 100%;
            padding: 1%;
            text-align: center;
            font-size: 2.0rem;
            cursor: pointer;
            background-color: transparent;
            color: rgb(214, 202, 202);
            border: solid grey;
            border-radius: 2%;
        }
        .submit-btn:hover {
            border-color: tomato;
        }
        .heading {
            text-align: center;
        }
    </style>
</head>
<body>
	<form class="main" action="#" method="post">
        <h1 class="heading">Admin Login Page</h1>
        <span class="field">
            <label>Username</label>
            <input name="full_name" class ="text-input" type="text" >
        </span>
        <span class="field">
            <label>Password</label>
            <input name="password" class="pwd-input" type="password">
        </span>
        <input class="submit-btn" type="submit" value="LOGIN">
    </form>
</body>
</html>