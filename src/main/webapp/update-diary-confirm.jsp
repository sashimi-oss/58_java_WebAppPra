<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored= "false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set target="${sessionScope.diary}" property="title" value="${param.title}"/>
<c:set target="${sessionScope.diary}" property="content" value="${param.content}"/>


<h2>この内容に変更します、よろしいですか？</h2>

<table>
<tr><td>${diary.title}</td></tr>
<tr><td>${diary.content}</td></tr>
<tr><td>${diary.createdAt}</td></tr>
</table>

<form action="update-decision-servlet" method="post">
	<input type="submit" value="更新">
</form>
<form action="update-cancel-servlet" method="post">
	<input type="hidden" name="update-id" value=${diary.id}>
	<input type="submit" value="更新">
</form>

</body>
</html>