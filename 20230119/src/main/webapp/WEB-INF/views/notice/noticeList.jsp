<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${message }</h1>
<c:forEach items="${list }" var="l"> 

${l.noticeId } 
${l.noticeWriter } 
${l.noticeTitle }
<a href="noticeSelect.do?noticeId=${l.noticeId}">게시글 상세조회</a>
<br></c:forEach>
</body>
<!-- noticeSelect.do? 뒤에 넘길 파라미터를 vo와 동일하게 넣어주면 알아서 맞춰서 들어감 -->
</html>