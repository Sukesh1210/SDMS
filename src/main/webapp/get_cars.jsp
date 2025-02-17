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
	List<CarEntity> cars = (List<CarEntity>)request.getAttribute("cars");
	%>
	<%
	if (cars != null && cars.size() > 0) {
	%>
	
	<div align="center">
		<table border="1px solid">
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Price</th>
				<th>Action1</th>
				<th>Action2</th>
			</tr>
			<%for(CarEntity car:cars){
				%>
				<tr>
				<td><%=car.getId() %></td>
				<td><%=car.getName() %></td>
				<td><%=car.getBrand() %></td>
				<td><%=car.getPrice() %></td>
				<td><a href="edit_car?id=<%=car.getId()%>">update</a></td>
				<td><a href="delete_car.jsp">delete</a></td>
			</tr>
			<% 	
			}
			%>
		</table>
	</div>
	<%
	}else{
		%>
		<div align="center"><h3>Car not found</h3></div>
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