<%@page import="Util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<jsp:include page="header"></jsp:include>
<%
DBManager.getConnection();
%>
	<section>
		<h1>붕붕붕 렌트카</h1>
	</section>

</body>
<jsp:include page="footer"></jsp:include>
</html>