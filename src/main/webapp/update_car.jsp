<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.jspiders.cardekho_with_servletsandjsp.jdbc.CarJDBC"%>
<%@page
	import="com.jspiders.cardekho_with_servletsandjsp.entity.CarEntity"%>
	<jsp:include page="nav_bar.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	CarJDBC carJDBC = new CarJDBC();
	CarEntity carEntity = (CarEntity) request.getAttribute("car");
	if(carEntity!=null){
		%>
		<div align="center">
		<form action="update_car" method="post">
			<table border="1px solid">
				<tr>
					<td>Id</td>
					<td><input type="text" name="id" readonly="true" value="<%= carEntity.getId()%>"></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" name="name" value="<%= carEntity.getName()%>"></td>
				</tr>
				<tr>
					<td>Brand</td>
					<td><input type="text" name="brand" value="<%= carEntity.getBrand()%>"></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="text" name="price" value="<%= carEntity.getPrice()%>"></td>
				</tr>
			</table>
			<input type="submit" value="UPDATE">
		</form>
	</div>
	<%	
	}
	%>
	<%
	String message=(String)request.getAttribute("message");
	if(message!=null){
		%>
		<div align="center"><h3><%=message %></h3></div>
	<% 	
	}
	%>
	
</body>
</html>