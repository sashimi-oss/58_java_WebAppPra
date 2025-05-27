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

<h1>更新</h1>

<form action="update-diary-confirm-servlet" method="post">
	<input type="text" name="title" value=${sessionScope.diary.title} /><br>
	<select name="category-id">
		<c:forEach var="category" items="${categoryList}">
			<option value=${category.categoryId}>${category.categoryName}</option>
		</c:forEach>
	
	</select>
	<textarea name="content">${sessionScope.diary.content}</textarea><br>
	${sessionScope.diary.createdAt}<br>

	<input type="submit" value="更新">
</form>

</body>
</html>