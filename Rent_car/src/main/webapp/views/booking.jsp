<%@page import="customer.Customer"%>
<%@page import="customer.controller.CustomerDao"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="vehicle.VehicleRequestDto"%>
<%@page import="vehicle.controller.VehicleDao"%>
<%@page import="booking.controller.BookingDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약페이지</title>
</head>
<jsp:include page="header"></jsp:include>
<body>

	<%
	BookingDao bookingDao = BookingDao.getInstance();
	CustomerDao customerDao = CustomerDao.getInstacne();
	String getBookCode = String.valueOf(bookingDao.getBookCodeMax() + 1);
	String bookCode = "book" + getBookCode;
	String carCode = request.getParameter("carcode");
	Customer customer = (Customer) session.getAttribute("log");
	String totalPrice = request.getParameter("totalPrice");
	String startDate = request.getParameter("startDate");
	String periodDate = request.getParameter("periodDate");
	String startHour = request.getParameter("startDate");
	String endHour = request.getParameter("startDate");
	String carName = request.getParameter("carName");
	%>
	<section>
		<h2>예약하기</h2>
		<br>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="booking"> 
			<input
				type="hidden" id="bookCode" name="bookCode" value=<%=bookCode%>
				readonly> <input type="date" id="bookDate" name="bookDate"
				value="<%=new Timestamp(System.currentTimeMillis()).toString().split(" ")[0]%>"
				readonly>
			<h4>대여 차량</h4>
			<input type="text" id="carName" name="carName" value="<%=carName%>"
				readonly><br>
			<h4>대여장소</h4>
			<select id="venueId" name="venueId">
				<option value="0" selected="selected"></option>
				<option value="1">서울시 서초구 신논현역 앞</option>
				<option value="2">서울시 서초구 강남역앞</option>
				<option value="3">서울시 강남구 강남호텔 주차장</option>
				<option value="4">서울시 강동구 천호역 4번출구</option>
				<option value="5">경기도 시흥시 초원아파트 주차장</option>
				<option value="6">경기도 안산시 목련아파트 101동 앞</option>
				<option value="7">부산시 부산역 KTX 주차장</option>
				<option value="8">부산시 광안리 스타벅스 주차장</option>
				<option value="9">제주시 감나무골 공터</option>
				<option value="10">제주시 제주공항 본사</option>
			</select><br>
			<h4>예약자 이름</h4>
			<%
			if (session.getAttribute("log") != null) {
			%>
			<input type="text" id="cusName" name="cusName"
				value="<%=customer.getCusname()%>" readonly> <br>
			<%
			} else {
			%>
			<input type="text" id="cusName" name="cusName">
			<%
			}
			%>
			<br>
			<div class="bookDate">
				<h4>대여일</h4>
				<input type="date" id="startDate" name="startDate"
					min="datetime-local"
					value="<%=startDate != null ? startDate : new Timestamp(System.currentTimeMillis()).toString().split(" ")[0]%>">
				<input type="time" id="startHour" name="startHour"
					value="<%=startHour != null ? startHour : ""%>"
					<%=startHour == null ? "autofocus" : ""%>>
			</div>
			<br>
			<div class="bookDate">
				<h4>반납일</h4>
				<input type="date" id="periodDate" name="periodDate"
					value="<%=periodDate != null ? periodDate : new Timestamp(System.currentTimeMillis()).toString().split(" ")[0]%>">
				<input type="time" id="endHour" name="endHour"
					value="<%=endHour != null ? endHour : ""%>"
					<%=endHour == null ? "autofocus" : ""%>> <br>
			</div>
			<div>
				<input type="button" value="예약" onclick="checkBookingInfo(form)">
			</div>
		</form>
	</section>
	<script src="../resource/checkBookingInfo.js"></script>

</body>
<jsp:include page="footer"></jsp:include>
</html>