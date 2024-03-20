<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${ empty authUser }">
		<c:url var="url" value="/join"></c:url>
		<a href="${ url }">회원가입</a>
		<c:url var="url2" value="/login"></c:url>
		<a href="${ url2 }">로그인 하기</a>
	</c:if>
	<br />
</body>
</html>