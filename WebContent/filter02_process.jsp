<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>필터결과페이지-2</title>
</head>
<body>
	<%
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		
	%>
	<p>입력된 id 값 : <%= id %>
	<p>입력된 pw 값 : <%= pw %>
	
	
	
</body>
</html>