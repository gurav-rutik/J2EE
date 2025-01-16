<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<style>
/* General Styles */
body {
	font-family: 'Arial', sans-serif;
	margin: 0;
	padding: 0;
	background: linear-gradient(to right, #e6f7ff, #ffffff);
	color: #333;
	overflow-x: hidden;
	animation: fadeIn 1.5s ease-in-out;
}

/* Navigation Styles */
nav {
	background: linear-gradient(90deg, #004d99, #0066cc);
	padding: 15px 20px;
	display: flex;
	justify-content: center;
	align-items: center;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
	position: sticky;
	top: 0;
	z-index: 1000;
	animation: slideDown 1s ease-in-out;
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

/* Header Styles */
div[align="center"] {
	margin: 100px auto;
	padding: 30px;
	text-align: center;
	max-width: 800px;
	background: linear-gradient(145deg, #ffffff, #e6f7ff);
	border-radius: 15px;
	box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
	opacity: 0;
	animation: fadeIn 2s ease-in-out 0.5s forwards;
}

h1 {
	color: #004d99;
	font-size: 2.8em;
	margin-bottom: 20px;
	letter-spacing: 1px;
	opacity: 0;
	animation: bounceIn 1.5s ease-in-out 1s forwards;
}

p {
	font-size: 1.2em;
	line-height: 1.6;
	color: #555;
	margin-bottom: 20px;
	opacity: 0;
	animation: fadeIn 2s ease-in-out 1.5s forwards;
}

/* Button/CTA */
button {
	padding: 10px 20px;
	font-size: 16px;
	font-weight: bold;
	color: #fff;
	background-color: #004d99;
	border: none;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s, transform 0.3s;
	animation: fadeInUp 2s ease-in-out 2s forwards;
	opacity: 0;
}

button:hover {
	background-color: #003366;
	transform: scale(1.05);
}

/* Responsive Design */
@media (max-width: 768px) {
	nav {
		flex-direction: column;
		align-items: center;
	}
	nav a {
		margin: 10px 0;
		font-size: 14px;
	}
	h1 {
		font-size: 2.2em;
	}
	p {
		font-size: 1em;
	}
}

/* Animations */
@keyframes fadeIn {
	from {
		opacity: 0;
	}
	to {
		opacity: 1;
	}
}

@keyframes slideDown {
	from {
		transform: translateY(-50px);
		opacity: 0;
	}
	to {
		transform: translateY(0);
		opacity: 1;
	}
}

@keyframes bounceIn {
	0% {
		transform: scale(0.8);
		opacity: 0;
	}
	50% {
		transform: scale(1.2);
		opacity: 0.5;
	}
	100% {
		transform: scale(1);
		opacity: 1;
	}
}

@keyframes fadeInUp {
	from {
		transform: translateY(30px);
		opacity: 0;
	}
	to {
		transform: translateY(0);
		opacity: 1;
	}
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
	<div align="center">
		<h1>WELCOME TO CONTACT MANAGER</h1>
		<p>Contact Manager is a powerful and intuitive application designed to streamline contact management. Developed by <span style="color: orange; weight:bold; ">Rutik Gurav</span> , this platform enables users to effortlessly add, edit, search, and organize their contacts. With a user-friendly interface, advanced search capabilities, and customizable features, this application aims to enhance productivity and provide a seamless experience for managing personal and professional connections.</p>
		
		<button onclick="location.href='./contacts';">Get Started</button>
	</div>
</body>
</html>
