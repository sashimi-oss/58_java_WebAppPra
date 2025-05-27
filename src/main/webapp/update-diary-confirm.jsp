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
<c:set target="${sessionScope.diary}" property="categoryId" value="${param['category-id']}"/>

<c:forEach var="dia" items="${diaryList}">
${dia}
</c:forEach>

<br>aaa
${diaryList[1]}<br>


<h2>この内容に変更します、よろしいですか？</h2>

${diary.title}<br>
${diary.content}<br>
${diary.createdAt}<br>
${diary.categoryId }<br>
${diary.categoryName }<br>
<c:forEach var="category" items="${categoryList}" varStatus="status">
<c:choose>
	<c:when test="${diary.categoryId == category.categoryId}">${category.categoryName }</c:when>
</c:choose>
</c:forEach>

<form action="update-decision-servlet" method="post">
	<input type="submit" value="更新">
</form>
<form action="update-cancel-servlet" method="post">
	<input type="hidden" name="update-id" value=${diary.id}>
	<input type="submit" value="cansel">
</form>

</body>
</html>