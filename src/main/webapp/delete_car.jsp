<%@page import="java.util.List"%>
<%@page import="com.jspiders.cardekho_with_servletsandjsp.jdbc.CarJDBC"%>
<%@page
	import="com.jspiders.cardekho_with_servletsandjsp.entity.CarEntity"%>
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
	<%
	CarJDBC carJDBC = new CarJDBC();

	List<CarEntity> cars = carJDBC.getAllCars();
	%>
	<%
	if (cars != null && cars.size() > 0) {
	%>
	<div align="center">
		<table border="1px soli">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Price</th>
			</tr>

			<%
			for (CarEntity car : cars) {
			%>
			<tr>
				<td><%=car.getId()%></td>
				<td><%=car.getName()%></td>
				<td><%=car.getBrand()%></td>
				<td><%=car.getPrice()%></td>
			</tr>

			<%
			}
			%>

		</table>
	</div>
	<%
	} else {
	%>
	<div align="center">
		<h3>Car unavailable</h3>
	</div>
	<%
	}
	%>
	<br>
	<div align="center">
		<form action="delete_car" method="post">
			<table border="1px solid">
				<tr>
					<td><label>Enter Car id</label></td>
					<td><input type="text" name="id"></td>
				</tr>
			</table>
			<input type="submit" value="DELETE">
		</form>
	</div>
	<%
	String message = (String) request.getAttribute("message");
	if(message!=null){
		%>
		<div align="center">
		<h4><%=message%></h4>
	</div>
	<%	
	}
	%>
	
</body>
</html>