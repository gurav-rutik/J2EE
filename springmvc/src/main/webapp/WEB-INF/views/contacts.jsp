<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.jspiders.springmvc.dto.ContactDTO"%>
<html>
<head>
<meta charset="UTF-8">
<title>Contacts Page</title>
<style>
/* General Styles */
body {
	font-family: 'Roboto', Arial, sans-serif;
	background-color: #f4f7f9;
	margin: 0;
	padding: 0;
	color: #333;
}

h1 {
	text-align: center;
	color: #007acc;
	font-size: 1.8em;
	margin: 20px 0;
}

.container {
	width: 90%;
	max-width: 1200px;
	margin: 20px auto;
	background: #ffffff;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	border-radius: 8px;
	padding: 20px;
	overflow-x: auto;
	animation: fadeIn 0.8s ease;
}

@
keyframes fadeIn {from { opacity:0;
	transform: translateY(20px);
}

to {
	opacity: 1;
	transform: translateY(0);
}

}

/* Table Styles */
table {
	width: 100%;
	border-collapse: collapse;
	margin-top: 20px;
}

table th, table td {
	padding: 12px 15px;
	text-align: left;
	border: 1px solid #ddd;
	font-size: 14px;
}

table th {
	background-color: #007acc;
	color: white;
	text-transform: uppercase;
	font-size: 14px;
	letter-spacing: 0.5px;
}

table tr:nth-child(even) {
	background-color: #f9f9f9;
}

table tr:hover {
	background-color: #e6f7ff;
	transition: background-color 0.3s ease;
}

.action-links a {
	color: #007acc;
	text-decoration: none;
	font-weight: bold;
	padding: 5px 10px;
	border-radius: 5px;
	transition: background 0.3s ease, color 0.3s ease;
}

.action-links a:hover {
	background-color: #007acc;
	color: white;
}

/* Navigation Bar Styles */
nav {
	background: linear-gradient(90deg, #004d99, #0066cc);
	padding: 15px;
	display: flex;
	justify-content: center;
	align-items: center;
	position: sticky;
	top: 0;
	z-index: 1000;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

nav a {
	color: #fff;
	text-decoration: none;
	margin: 0 15px;
	font-size: 16px;
	font-weight: bold;
	transition: color 0.3s, transform 0.3s;
}

nav a:hover {
	color: #ffcc00;
	transform: scale(1.1);
}

nav a.active {
	color: #ffcc00;
	border-bottom: 2px solid #ffcc00;
}

/* Responsive Design */
@media ( max-width : 768px) {
	.container {
		padding: 15px;
	}
	table th, table td {
		font-size: 12px;
	}
}

@media ( max-width : 480px) {
	table {
		font-size: 11px;
	}
	.action-links a {
		font-size: 12px;
		padding: 3px 7px;
	}
}

/* General Styles for Centered Link */
.centered-link {
	display: block; /* Make it a block-level element */
	text-align: center; /* Center-align the text */
	padding: 10px 20px; /* Add some padding */
	font-family: 'Arial', sans-serif; /* Simple font */
	font-size: 16px; /* Standard font size */
	font-weight: bold; /* Make it bold */
	color: #004d99; /* Text color */
	text-decoration: none; /* Remove underline */
	border: 1px solid #004d99; /* Add a simple border */
	border-radius: 5px; /* Rounded corners */
	width: 100px; /* Set a fixed width */
}

/* Hover Effects */
.centered-link:hover {
	background-color: #004d99; /* Add background on hover */
	color: #ffffff; /* Change text color */
	cursor: pointer; /* Change cursor to pointer */
}

/* Search Bar Styles */
.search-bar-container {
	display: flex;
	justify-content: center;
	align-items: center;
	padding: 15px;
	background-color: #f0f4f8;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

.search-bar-input {
	width: 60%;
	max-width: 500px;
	padding: 10px;
	font-size: 16px;
	border: 1px solid #ccc;
	border-radius: 5px;
	outline: none;
	transition: border-color 0.3s ease;
}

.search-bar-input:focus {
	border-color: #007acc;
	box-shadow: 0 0 5px rgba(0, 122, 204, 0.5);
}

.search-bar-button {
	padding: 10px 20px;
	font-size: 16px;
	color: white;
	background-color: #007acc;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s ease, transform 0.2s ease;
	margin-left: 10px;
}

.search-bar-button:hover {
	background-color: #005fa3;
	transform: scale(1.05);
}

</style>
</head>
<body>
	<nav>
		<a href="./add-contact-page">ADD CONTACT</a> 
		<a href="./contacts">ALL CONTACTS</a> 
		<a href="./edit-user?id=${authenticatedUser.id}">EDIT USER</a> 
		<a href="./delete-user?id=${authenticatedUser.id}">DELETE USER</a> 
		<a href="./logout">LOG OUT</a>
	</nav>
	
	<div class="search-bar-container">
		<form action="./search" method="GET">
			<input type="text" name="query" placeholder="Search contacts..." class="search-bar-input" />
			<button type="submit" class="search-bar-button">Search</button>
		</form>
	</div>
	
	<%
	@SuppressWarnings("unchecked")
	List<ContactDTO> contacts = (List<ContactDTO>) request.getAttribute("contacts");
	if (contacts != null) {
	%>
	<div class="container">
		<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Work</th>
				<th>Gender</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Website</th>
				<th colspan="2">Action</th>
			</tr>
			<%
			for (ContactDTO contact : contacts) {
			%>
			<tr>
				<td><%=contact.getFirstName()%></td>
				<td><%=contact.getLastName()%></td>
				<td><%=contact.getEmail()%></td>
				<td><%=contact.getMobile()%></td>
				<td><%=contact.getWork()%></td>
				<td><%=contact.getGender()%></td>
				<td><%=contact.getDob()%></td>
				<td><%=contact.getAddress()%></td>
				<td><%=contact.getWebsite()%></td>
				<td class="action-links"><a
					href="./edit-contact?id=<%=contact.getId()%>">Edit</a></td>
				<td class="action-links"><a
					href="./delete-contact?id=<%=contact.getId()%>">Delete</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	<%
	}
	String message = (String) request.getAttribute("message");
	if (message != null) {
	%>
	<h1><%=message%></h1>
	<%
	}
	%>
	<div
		style="display: flex; justify-content: center; align-items: center;">
		<a href="./home" class="centered-link">HOME</a>
	</div>
</body>
</html>
