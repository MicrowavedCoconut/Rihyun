<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method = "POST" action="/Ver1/user">
		<input type="hidden" name="action" value="login">
		<label>아이디</label>
		<input type="text" name="id" required>
		<label>비밀번호</label>
		<input type="password" name="password" required>
	<button type="submit">로그인</button>
	</form>
</body>
</html>