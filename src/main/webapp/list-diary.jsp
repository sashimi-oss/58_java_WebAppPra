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
<!--${diaryList}-->


<form action="delete-diary-servlet" method="post" id="delete">
</form>

<table>
<c:forEach var="diary" items="${requestScope.diaryList}">
<tr>


<td>${diary.title}</td>
<td>${diary.content}</td>

<td><button type="submit" value="${diary.id}" name="update-id" form="update">更新</button></td>
<td><input type="checkbox" name="delete-id" value=${diary.id} form="delete" /></td>

</tr>
</c:forEach>
</table>
<input type="submit" value="削除" form="delete">

<form action="update-diary-servlet" method="post" id="update">

</form>

</body>
</html>