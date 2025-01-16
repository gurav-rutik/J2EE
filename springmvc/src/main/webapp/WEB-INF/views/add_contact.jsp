<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Contact Page</title>
<style>
/* General Styles */
body {
	font-family: 'Roboto', Arial, sans-serif;
	background: #eef2f3;
	margin: 0;
	padding: 0;
	color: #333;
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

/* Form Styles */
.form-container {
	background: white;
	margin: 60px auto;
	padding: 40px;
	border-radius: 12px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	max-width: 500px;
	animation: fadeIn 1s ease;
}

@
keyframes fadeIn {from { opacity:0;
	transform: translateY(-20px);
}

to {
	opacity: 1;
	transform: translateY(0);
}

}
h2 {
	color: #005ea6;
	text-align: center;
	margin-bottom: 20px;
}

table {
	width: 100%;
	border-spacing: 10px;
}

td {
	font-size: 14px;
	color: #555;
}

input[type="text"], input[type="email"], input[type="number"], input[type="radio"],
	input[type="submit"] {
	width: 100%;
	padding: 10px;
	margin-top: 5px;
	border: 1px solid #ddd;
	border-radius: 8px;
	box-sizing: border-box;
	font-size: 14px;
	transition: border-color 0.3s ease, box-shadow 0.3s ease;
}

input[type="text"]:focus, input[type="email"]:focus, input[type="number"]:focus
	{
	border-color: #007acc;
	box-shadow: 0 0 8px rgba(0, 122, 204, 0.3);
}

input[type="radio"] {
	width: auto;
	margin-right: 5px;
}

input[type="submit"] {
	background: #007acc;
	color: white;
	font-weight: bold;
	cursor: pointer;
	transition: background 0.3s ease, transform 0.2s ease;
}

input[type="submit"]:hover {
	background: #005ea6;
	transform: scale(1.05);
}

label {
	margin-left: 5px;
	font-size: 14px;
}

div {
	text-align: center;
	margin-top: 20px;
}

/* Responsive Design */
@media ( max-width : 768px) {
	.form-container {
		width: 90%;
		padding: 20px;
	}
	h2 {
		font-size: 1.5em;
	}
}

@media ( max-width : 480px) {
	h2 {
		font-size: 1.2em;
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
	<div class="form-container">
		<h2>Contact Details</h2>
		<form action="./add-contact" method="post">
			<table>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="first_name" required></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="last_name" required></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" required></td>
				</tr>
				<tr>
					<td>Mobile</td>
					<td><input type="text" name="mobile" required></td>
				</tr>
				<tr>
					<td>Work</td>
					<td><input type="text" name="work"></td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="radio" name="gender" value="MALE" required><label>MALE</label>
						<input type="radio" name="gender" value="FEMALE" required><label>FEMALE</label>
						<input type="radio" name="gender" value="OTHERS" required><label>OTHERS</label>
					</td>
				</tr>
				<tr>
					<td>DOB</td>
					<td><input type="text" name="dob"></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address"></td>
				</tr>
				<tr>
					<td>Website</td>
					<td><input type="text" name="website"></td>
				</tr>
			</table>
			<div>
				<input type="submit" value="ADD">
			</div>
		</form>
		<div
			style="display: flex; justify-content: center; align-items: center;">
			<a href="./home" class="centered-link">HOME</a>
		</div>
	</div>
</body>
</html>
