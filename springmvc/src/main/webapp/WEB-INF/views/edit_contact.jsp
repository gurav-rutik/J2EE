<!DOCTYPE html>
<%@page import="com.jspiders.springmvc.dto.ContactDTO"%>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Contact Page</title>
<style>
/* General Styles */
body {
    font-family: Arial, sans-serif;
    background-color: #f9f9f9;
    margin: 0;
    padding: 0;
    display: flex;
    flex-direction: column;
    align-items: center;
}

.form-container {
    background: #ffffff;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    padding: 20px 30px;
    width: 100%;
    max-width: 450px;
    margin-top: 20px;
}

.form-container h2 {
    text-align: center;
    margin-bottom: 20px;
    color: #333333;
}

table {
    width: 100%;
    border-spacing: 10px;
}

td {
    color: #555555;
    font-size: 14px;
    vertical-align: middle;
}

input[type="text"], input[type="email"], input[type="number"], input[type="date"],
input[type="submit"] {
    width: 100%;
    padding: 8px;
    border: 1px solid #cccccc;
    border-radius: 4px;
    font-size: 14px;
    margin-top: 5px;
    box-sizing: border-box;
}

input[type="radio"] {
    margin-right: 5px;
}

label {
    font-size: 14px;
    vertical-align: middle;
}

input[type="submit"] {
    background-color: #007BFF;
    color: white;
    border: none;
    cursor: pointer;
    font-weight: bold;
    transition: background-color 0.3s;
}

input[type="submit"]:hover {
    background-color: #0056b3;
}

tr td:first-child {
    width: 30%;
    font-weight: bold;
    vertical-align: middle;
}

tr td:last-child {
    width: 70%;
}

.form-container div {
    text-align: center;
    margin-top: 20px;
}

/* Navigation Bar Styles */
nav {
    background: linear-gradient(90deg, #004d99, #0066cc);
    padding: 10px 20px;
    display: flex;
    justify-content: space-around;
    align-items: center;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
    width: 100%;
    position: fixed;
    top: 0;
    left: 0;
    z-index: 1000;
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

body {
    padding-top: 60px; /* Adjust for fixed navbar */
}

/* Responsive Design */
@media (max-width: 480px) {
    .form-container {
        padding: 15px 20px;
    }

    nav a {
        font-size: 14px;
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
    <%
        ContactDTO contact = (ContactDTO) request.getAttribute("contact");
    %>
    <div class="form-container">
        <h2>Edit Contact Details</h2>
        <form action="./update-contact" method="post">
            <table>
                <tr>
                    <td>Id</td>
                    <td><input type="text" name="id" value="<%=contact.getId()%>" readonly></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="first_name" value="<%=contact.getFirstName()%>" required></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="last_name" value="<%=contact.getLastName()%>" required></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" value="<%=contact.getEmail()%>" required></td>
                </tr>
                <tr>
                    <td>Mobile</td>
                    <td><input type="text" name="mobile" value="<%=contact.getMobile()%>" required></td>
                </tr>
                <tr>
                    <td>Work</td>
                    <td><input type="text" name="work" value="<%=contact.getWork()%>" required></td>
                </tr>
                <tr>
                    <td>Gender</td>
                    <td>
                        <label><input type="radio" name="gender" value="Male" <%= "Male".equals(contact.getGender()) ? "checked" : "" %>> Male</label>
                        <label><input type="radio" name="gender" value="Female" <%= "Female".equals(contact.getGender()) ? "checked" : "" %>> Female</label>
                    </td>
                </tr>
                <tr>
                    <td>DOB</td>
                    <td><input type="date" name="dob" value="<%=contact.getDob()%>" required></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address" value="<%=contact.getAddress()%>" required></td>
                </tr>
                <tr>
                    <td>Website</td>
                    <td><input type="text" name="website" value="<%=contact.getWebsite()%>"></td>
                </tr>
            </table>
            <div>
                <input type="submit" value="Update">
            </div>
        </form>
        <div
		style="display: flex; justify-content: center; align-items: center;">
		<a href="./home" class="centered-link">HOME</a>
	</div>
    </div>
</body>
</html>
