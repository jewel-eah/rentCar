<%@page import="java.util.ArrayList"%>
<%@page import="board.controller.BoardDao"%>
<%@page import="board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="header"></jsp:include>
<title>커뮤니티</title>
</head>
<body>
	<%
BoardDao boardDao = BoardDao.getIstance();
ArrayList<Board> list = boardDao.getBoardAll();
%>
	<section>
		<h1>커뮤니티</h1>
		<table>
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>유형</th>
					<th>작성자</th>
					<th>등록일</th>
					<th>수정일</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Board board : list) {
					if (board.getWriter().equals("admin")) {
				%>
				<tr>
					<td name="writeCode"><%=board.getWriteCode()%></td>
					<td name="adminTitle"><a href="pickBoard"><%=board.getTitle()%></a></td>
					<td><%=board.getSubject()%>[공지사항]</td>
					<td><%=board.getWriter()%></td>
					<td><%=board.getRegisteredDate()%></td>
					<td><%=board.getModifiedDate()%></td>
				</tr>
				<%
				}
				}
				%>
			</tbody>
			<h1>이용후기</h1>
			<tbody>
				<%
				for (Board board : list) {
					if (!board.getWriter().equals("amdin")) {
				%>
				<tr>
					<td name="writeCode"><%=board.getWriteCode()%></td>
					
					<td id="title"><a href="pickBoard"><%=board.getTitle()%></a></td>
					<td><%=board.getSubject()%></td>
					<td><%=board.getWriter()%></td>
					<td id="wrtieDate"><%=board.getRegisteredDate()%></td>
					<td id="wrtieDate"><%=board.getModifiedDate()%></td>
				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
			<div class="writeButton">
				<input type="button"  value="글쓰기" onclick="location.href='/write'">
			</div>
	</section>

	<jsp:include page="footer"></jsp:include>
</body>
</html>