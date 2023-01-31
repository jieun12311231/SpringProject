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
<div align="center">
<br>
<h2>시작페이지</h2><br>
<c:if test="${not empty name}">
<h3>🍓 ${name} 사용 중 🍓</h3>
</c:if>
<c:if test="${empty name }">
<h3>로그인이 되어있지않습니다</h3>
</c:if>
 </div>
</body>
</html>