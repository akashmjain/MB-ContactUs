<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Josefin+Slab:wght@300&amp;display=swap" rel="stylesheet">
<style>
    body {
        font-family: 'Josefin Slab', serif;
        background: #0B0B0B;
        color: white;
        
	} 
    .title {
        text-align: center;
        font-size: 2.5rem;
    }
    .dashboard {
        padding-left: 20%;
        padding-right: 20%;
    }
    .contact {
        list-style: none;
        margin: 5%;
    }
    ::selection {
        color: yellow;
        background: grey;
    }
   
    .email {
        color: yellow;
        padding: 10px;
        font-size: 2.0rem;
    }
    .archive {
        color: white;
        font-size: 1.2rem;
        font-weight: bold;
        text-decoration: none;
        padding: 0.8rem;
        width: 8rem;
        text-align: center;
        border: solid grey;
        border-radius: 15%;
        
    }
    .archive:hover {
        border-color: tomato;
    }
    .full-name {
        font-size: 2.0rem;
    }
    .comment {
        font-size: 1.5rem;
    }
    .links {
        display: flex;
        justify-content: space-between;
    }
</style>
<title>Admin Dashboard</title>
</head>
<body>
	<h3 class="title">Admin Dashboard</h3>
	<ul class="dashboard">
	<c:forEach items="${contacts}" var="contact">
		<li class="contact">
            <h3 class="full-name">${contact.fullName}</h3>
            <p class="comment">${contact.comment}</p>
            <div class="links">
                <a class="email" href="mailto:${contact.email}">${contact.email}</a>
                <c:set var="btnText" scope="session" value = "ARCHIVED"/>
                <c:if test = "${contact.isArchived}" >
                	<a class="archive" href="/ContactUs/updateData?contact_id=${contact.contactId}">${contact.isArchived}</a>
                </c:if>
            </div>
        </li>
	</c:forEach>
	</ul>
</body>
</html>