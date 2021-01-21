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
        form {
            width: 50rem;

        }
        span {
            display: flex;
            
            flex-direction: column;
            margin-top: 5%;
            margin-bottom: 5%;
        }
        .text-input {
            font-size: 1.5rem;
            padding: 2%;
            background-color: #0B0B0B;
            color: white;
        }
        .text-input::selection {
            border-color:tomato;
            
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
	</style>
</head>
<body>
	<div class="main">
        <h1>Contact Us</h1>
        <p>Please fill this form in decent manner</p>
        <form action="contactus/save" method="post">
            <span>
                <label>Full Name </label>
                <input name="full_name" class ="text-input" type="text">
            </span>
            <span>
                <label>Email </label>
                <input name="email" class="text-input" type="text">
            </span>
            <span>
                <label>Comment</label>
                <textarea name="comment" rows="5" class="text-input"></textarea>
            </span>
            <input class="submit-btn" type="submit" value="SUBMIT">
        </form>
        <% if(request.getSession().getAttribute("error").equals("")) { } else { %> 
        	<h4 style="color: red"> Please Enter Valid Information </h4>
        <%}%>
    </div>
</body>
</html>