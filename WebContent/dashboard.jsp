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
    .tab {
        display: flex;
        justify-content: space-around;
    }
    .tablinks {
        border: solid white;
        background-color: #0B0B0B;
        color: white;
        margin-left: 2%;
        margin-right: 2%;
        padding: 2%;
        width: 100%;
        border-radius: 3%;
        font-size: 2.0em;
    }
    .tablinks:hover {
        border: solid tomato;
        cursor: pointer;
    }
    .section-header {
        margin-top: 5%;
        text-align: center;
        font-size: 2.0em;
    }

</style>
<title>Admin Dashboard</title>
</head>
<body>
	<h3 class="title">Admin Dashboard</h3>
		
	<div class="tab">
		<button id="recent_comments" class="tablinks" onclick="selectTab(event, 'unarchived')">Recent Comments</button>
		<button class="tablinks" onclick="selectTab(event, 'archived')">Archived</button>
	</div>
	
	<div id="archived" class="tabcontent">
		<h3 class="section-header">Archived List</h3>
		<ul class="dashboard">
		<c:forEach items="${archivedContacts}" var="contact">
			<li class="contact">
	            <h3 class="full-name">${contact.fullName}</h3>
	            <p class="comment">${contact.comment}</p>
	            <div class="links">
	                <a class="email" href="mailto:akash@example.com">${contact.email}</a>
	                <a class="archive" href="/ContactUs/updateData?contact_id=${contact.contactId}">UN-ARCHIVE</a>
	            </div>
	        </li>
		</c:forEach>
		</ul>

	</div>
	
	<div id="unarchived" class="tabcontent">
		<h3 class="section-header">New Messages</h3>
		<ul class="dashboard">
		<c:forEach items="${unArchivedContacts}" var="contact">
			<li class="contact">
	            <h3 class="full-name">${contact.fullName}</h3>
	            <p class="comment">${contact.comment}</p>
	            <div class="links">
	                <a class="email" href="mailto:akash@example.com">${contact.email}</a>
	                <a class="archive" href="/ContactUs/updateData?contact_id=${contact.contactId}">ARCHIVE</a>
	            </div>
	        </li>
		</c:forEach>
		</ul>
	</div>
	<script>
		function selectTab(evt, tab_name) {
			let i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tabcontent");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].style.display = "none";
			}
			tablinks = document.getElementsByClassName("tablinks");
			for (i = 0; i < tablinks.length; i++) {
				tablinks[i].className = tablinks[i].className.replace(" active", "");
			}
			document.getElementById(tab_name).style.display = "block";
			evt.currentTarget.className += " active";
		}
		document.getElementById("recent_comments").click();
	</script>
   
</body>
</html>