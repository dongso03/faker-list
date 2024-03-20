<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>드래곤볼 캐릭터 이름</title>
</head>
<body>
	<c:if test="${ not empty dto.items }">

		<ul>
			<c:forEach var="dragonball" items="${ dto.items }">
				<li>${ dragonball.charactor }</li>
			</c:forEach>
		</ul>
	</c:if>
	<hr>
	<nav>
		<c:forEach var="i" begin="1" end="${ dto.totalPages }">
			<c:url var="url" value="/dragon">
				<c:param name="page" value="${ i }"></c:param>
				<c:param name="pagePer" value="20"></c:param>
			</c:url>
			<a href="${ url }">${ i }</a>
		</c:forEach>
	</nav>

</body>
</html>