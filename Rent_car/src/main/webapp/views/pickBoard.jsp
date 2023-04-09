<%@page import="board.BoardRequestDto"%>
<%@page import="board.Board"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.controller.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header"></jsp:include>
<title>pickBoard</title>
</head>
<body>
<%
BoardDao boardDao = BoardDao.getIstance();
ArrayList<Board> list = boardDao.getBoardAll();
String writeCode = request.getParameter("writeCode");
String title = request.getParameter("title");
String text = request.getParameter("text");
%>

<section>
	<table>
		<tr>
	 		<td>제목 <%=title %></td>
			<td>글등록일</td>
		</tr>
		<tr>
			<td><%=text%></td>
		</tr>
	</table>
</section>

</body>
<jsp:include page="footer"></jsp:include>
</html>