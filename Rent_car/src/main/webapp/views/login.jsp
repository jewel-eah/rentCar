<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../resource/grid.css">
<title>로그인 페이지</title>
</head>
<jsp:include page="header"></jsp:include>
<body>
	<section>
		<h2>로그인</h2>
		<form method="POST" action="../service">
			<input type="hidden" name="command" value="login">
			<label for="id">아이디</label><br>
			<input type="text" id="id" name="id"><br>
			<label for="password" tyep="hidden">비밀번호</label><br>
			<input type="text" id="password" name="password"><br>
			<div>
				<input type="button" value="로그인" onclick="checkLoginInfo(form)">
			</div>
		</form>

	</section>
	<script src="../resource/loginfo.js"></script>
</body>
<jsp:include page="footer"></jsp:include>
</html>