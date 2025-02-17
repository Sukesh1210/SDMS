<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page
	import="com.jspiders.cardekho_with_servletsandjsp.entity.CarEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	List<CarEntity> cars = (List<CarEntity>) request.getAttribute("cars");
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
				<td><%=car.getId() %></td>
				<td><%=car.getName()%>;</td>
				<td><%=car.getBrand()%></td>
				<td><%=car.getPrice()%></td>
			</tr>

			<%
			}
			%>

		</table>
	</div>
	<%
	}else{
		%>
		<div align="center"><h3>Car unavailable</h3></div>
	<% 	
	}
	%>
</body>
</html>