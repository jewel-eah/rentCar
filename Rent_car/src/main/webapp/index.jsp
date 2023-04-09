<%@page import="Util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="resource/index.js"></script>
</head>
<body>
<jsp:include page="header"></jsp:include>
<%
Object welcome = request.getAttribute("welcome");
if(welcome != null && (boolean) welcome) {%>
	<script>alertWelcome();</script>
<%} %>
	<section>
		<h1>뿡뿡이 렌트카 =33</h1>
	</section>

</body>
<jsp:include page="footer"></jsp:include>
</html>