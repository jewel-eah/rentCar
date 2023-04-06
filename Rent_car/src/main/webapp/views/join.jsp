<%@page import="java.sql.Timestamp"%>
<%@page import="customer.controller.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<jsp:include page="header"></jsp:include>
<body>
	<%
	CustomerDao customerDao = CustomerDao.getInstacne();
	int cuscode = customerDao.getCuscodeMax() + 1;
	String cusname = request.getParameter("cusname");
	String contact = request.getParameter("contact");
	String email = request.getParameter("email");
	String id = request.getParameter("id");
	String password = request.getParameter("password");
	String age = request.getParameter("age");
	String joindate = request.getParameter("joindate");
	%>

	<section>
		<h2>회원가입</h2>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="join">
			<table border="1">
				<tr>
					<th>회원번호</th>
					<td><input type="number" id="cuscode" name="cuscode"
						value="<%=cuscode%>" readonly></td>
				</tr>
				<tr>
					<th>이름</th>
					<td><input type="text" id="cusname" name="cusname"
						value="<%=cusname != null ? cusname : ""%>"
						<%=cusname == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type="text" id="contact" name="contact"
						value="<%=contact != null ? contact : ""%>"
						<%=contact == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" id="email" name="email"
						value="<%=email != null ? email : ""%>"
						<%=email == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type="text" id="id" name="id"
						value="<%=id != null ? id : ""%>"
						<%=id == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="text" id="password" name="password"
						value="<%=password != null ? password : ""%>"
						<%=password == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type="text" id="age" name="age"
						value="<%=age != null ? age : ""%>"
						<%=age == null ? "autofocus" : ""%>></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type="date" id="joindate" name="joindate"
						value="<%=joindate != null ? joindate : new Timestamp(System.currentTimeMillis()).toString().split(" ")[0]%>"
						<%=joindate == null ? "autofocus" : ""%>></td>
				</tr>
			</table>
			<div>
				<input type="button" value="등록" onclick="checkValues(form)">
				<input type="button" value="취소" onclick="location.href='/'">
			</div>
		</form>
	</section>
		<script src="../resource/validation.js"></script>
</body>
<jsp:include page="footer"></jsp:include>
</html>