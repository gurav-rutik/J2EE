<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!int num1;
	int num2;
	int sum;%>
	<%
	num1 = Integer.parseInt(request.getParameter("num1"));
	num2 = Integer.parseInt(request.getParameter("num2"));
	sum = num1 + num2;
	%>
	<h1>
		The sum of
		<%=num1%>
		and
		<%=num2%>
		is :
		<%=sum%></h1>
</body>
</html>