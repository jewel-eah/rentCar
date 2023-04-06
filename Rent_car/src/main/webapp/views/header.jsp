<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resource/grid.css">
<title>뿡뿡이 렌트카</title>
</head>
<%
System.out.println("logid: "+ session.getAttribute("log"));
%>
	<header>
		<h1>붕붕붕 렌트카</h1>
	</header>
	<nav>
		<ul>
			<li><a href="/">HOME</a></li>
			<li><a href="booking">예약</a></li>
			<li><a href="list">예약확인</a></li>
			<li><a href="comuunity">커뮤니티</a></li>
		</ul>
		<ul>
			<li><a href=<%=session.getAttribute("log") == null ? "login" : "/"%>><%=session.getAttribute("log") == null ? "login" : "logout"%></a></li>
			<li><a href="join">회원가입</a></li>
		</ul>
	</nav>
	<script src="..resource/logout.js"></script>
</html>