<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:include page="nav_bar.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h1>Enter car details</h1>
		<form action="add_car" method="post">
			<table border="1px solid">
				<tr>
					<td>Id</td>
					<td><input type="text" name="id"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>Brand</td>
					<td><input type="text" name="brand"></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price"></td>
				</tr>
			</table>
			<input type="submit" value="ADD">
		</form>
	</div>
	<% String message=(String)request.getAttribute("message"); %>
	<%
	if(message!=null){
		
		%>
		<div align="center">
		<h3><%=message %></h3>
		</div>
	<%	
	}
	%>
</body>
</html>