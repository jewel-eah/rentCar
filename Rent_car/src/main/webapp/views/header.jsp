<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resource/rentcarGrid.css">
<title>뿡뿡이 렌트카</title>
</head>
<%
System.out.println("logid: "+ session.getAttribute("log"));
%>
<header>
	<h1>뿡뿡이 렌트카</h1>
</header>
<nav>
	<ul>
		<li><a href="/">HOME</a></li>
		<li><a href="vehicleList">예약</a></li>
		<li><a href="bookingList">예약확인</a></li>
		<li><a href="boardList">커뮤니티</a></li>
	</ul>

	<ul>
		<li><a href="../service?command=login"><%=session.getAttribute("log") == null ? "login" : "logout"%></a></li>
		<%if(session.getAttribute("log") == null){%>
		<li><a href="join">회원가입</a></li>
		<%} else {%>
		<li><a href="mypage">마이페이지</a></li>
		<%} %>
	</ul>
</nav>
</html>