<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<style>
/* General Styles */
body {
    font-family: 'Arial', sans-serif;
    margin: 0;
    padding: 0;
    background: linear-gradient(145deg, #e6f7ff, #ffffff);
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
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

/* Input and Table Styles */
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
    transition: border-color 0.3s;
}

table td:last-child input:focus {
    border-color: #004d99;
    outline: none;
    box-shadow: 0 0 5px rgba(0, 77, 153, 0.3);
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

/* Error Message */
h1 {
    color: #ff3333;
    font-size: 1.2em;
    margin-top: 20px;
    animation: shake 0.5s ease-in-out;
}

/* Sign Up Link */
h4 {
    margin-top: 20px;
    font-size: 1em;
    color: #555;
}

h4 a {
    color: #004d99;
    text-decoration: none;
    font-weight: bold;
    transition: color 0.3s;
}

h4 a:hover {
    color: #003366;
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

@keyframes shake {
    0%, 100% {
        transform: translateX(0);
    }
    25% {
        transform: translateX(-5px);
    }
    50% {
        transform: translateX(5px);
    }
    75% {
        transform: translateX(-5px);
    }
}
</style>
</head>
<body>
    <div class="form-container">
        <h2>Login</h2>
        <form action="./auth-user" method="post">
            <table>
                <tr>
                    <td>Email</td>
                    <td><input type="email" name="email" placeholder="Enter your email" required></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password" placeholder="Enter your password" required></td>
                </tr>
            </table>
            <input type="submit" value="Login">
        </form>
        <%
        String message = (String) request.getAttribute("message");
        if (message != null) {
        %>
        <h1><%=message%></h1>
        <%
        }
        %>
        <h4>New User? <a href="./sign-up-page">Sign up</a></h4>
    </div>
</body>
</html>
