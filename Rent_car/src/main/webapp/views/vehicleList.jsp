<%@page import="venue.controller.VenueDao"%>
<%@page import="vehicle.VehicleRequestDto"%>
<%@page import="venue.VenueRequestDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="vehicle.Vehicle"%>
<%@page import="vehicle.controller.VehicleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>차량리스트</title>
</head>
<jsp:include page="header"></jsp:include>
<body>

<%
VehicleDao vehicleDao = VehicleDao.getInstance();
VenueDao venueDao = VenueDao.getInstance();
ArrayList<Vehicle> list = vehicleDao.getVehicleAll();
%>

<section>
	<h1>차량 선택하기</h1>
	<table>
		<thead>
		<tr>
			<th>기종</th>
			<th>브랜드</th>
			<th>예약 상태</th>
			<th>시간당 가격</th>
			<th>포함 옵션</th>
			<th>최대 승차인원</th>
			<th>위치</th>
		</tr>
		</thead>		
			<tbody>
				<% 
				for(Vehicle vehicle : list) {
				%>
				<tr>
					<td><a href="booking?carName=<%=vehicle.getCarname()%>">예약하기</a></td>
					<td name="carName"><%=vehicle.getCarname() %></td>
					<td><%=vehicle.getCarbrand() %></td>
					<td><%=vehicle.getBookstatus() %></td>
					<td><%=vehicle.getPrice() %></td>
					<td><%=vehicle.getOption() %></td>
					<td><%=vehicle.getSeat() %>명</td>
					<td><%=vehicle.getVenueid()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
	</table>
</section>
<jsp:include page="footer"></jsp:include>
</body>
</html>