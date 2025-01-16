<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit User</title>
<style>
/* General Styles */
body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background: linear-gradient(145deg, #e6f7ff, #ffffff);
}

/* Navigation Bar */
nav {
	background: linear-gradient(90deg, #007acc, #005ea6);
	padding: 15px;
	display: flex;
	justify-content: center;
	align-items: center;
	position: sticky;
	top: 0;
	box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
	z-index: 10;
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
	color: #ffd700;
	transform: scale(1.1);
}

nav a.active {
	color: #ffd700;
	border-bottom: 2px solid #ffd700;
}

/* Main Content Wrapper */
.main-content {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: calc(100vh - 60px); /* Adjust height excluding nav bar */
    padding: 20px;
}

/* Form Container */
.form-container {
    background: #ffffff;
    border-radius: 15px;
    box-shadow: 0 6px 20px rgba(0, 0, 0, 0.1);
    padding: 40px 30px;
    width: 100%;
    max-width: 500px;
    text-align: center;
    animation: fadeIn 1s ease-in-out;
}

.form-container h2 {
    color: #004d99;
    margin-bottom: 20px;
    font-size: 1.8em;
}

/* Table Styles */
table {
    width: 100%;
    margin-bottom: 20px;
    border-spacing: 15px;
    font-size: 1em;
    color: #555;
}

table td:first-child {
    text-align: left;
    font-weight: bold;
    color: #333;
}

table td:last-child input {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 1em;
    transition: border-color 0.3s, box-shadow 0.3s;
}

table td:last-child input:focus {
    border-color: #004d99;
    outline: none;
    box-shadow: 0 0 8px rgba(0, 77, 153, 0.3);
}

/* Submit Button */
input[type="submit"] {
    background-color: #004d99;
    color: #fff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 1em;
    font-weight: bold;
    transition: background-color 0.3s, transform 0.3s;
}

input[type="submit"]:hover {
    background-color: #003366;
    transform: scale(1.05);
}

/* Responsive Design */
@media (max-width: 768px) {
    .form-container {
        padding: 30px;
    }

    table td {
        font-size: 0.9em;
    }

    input[type="submit"] {
        font-size: 0.9em;
    }
}

/* Animations */
@keyframes fadeIn {
    from {
        opacity: 0;
        transform: translateY(-20px);
    }
    to {
        opacity: 1;
        transform: translateY(0);
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
	margin-left:180px;
}

/* Hover Effects */
.centered-link:hover {
	background-color: #004d99; /* Add background on hover */
	color: #ffffff; /* Change text color */
	cursor: pointer; /* Change cursor to pointer */
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
    <div class="main-content">
        <div class="form-container">
            <h2>Edit User</h2>
            <form action="./update-user" method="post">
                <table>
                    <tr>
                        <td>ID</td>
                        <td><input type="text" name="id" value="${user.id}" readonly></td>
                    </tr>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username" value="${user.name}" required></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="email" name="email" value="${user.email}" required></td>
                    </tr>
                    <tr>
                        <td>Mobile</td>
                        <td><input type="text" name="mobile" value="${user.mobile}" required></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="${user.password}" required></td>
                    </tr>
                </table>
                <input type="submit" value="Update">
            </form>
            <div>
            <br>
                <a href="./home" class="centered-link">HOME</a>
            </div>
        </div>
    </div>
</body>
</html>
