<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
시작페이지<br>
<c:if test="${not empty name}">
<h3>🍓 ${name} 사용 중 🍓</h3>
</c:if>
</body>
</html>