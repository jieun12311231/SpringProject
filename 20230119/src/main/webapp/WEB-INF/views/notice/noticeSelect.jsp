<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../home/menu.jsp"></jsp:include>
	<div align="center">
	<br>
	<table border="1">
	<thead>
	<th>아이디</th>
	<th>작성자</th>
	<th>제목</th>
	<th>내용</th>
	</thead>
		<tbody>
			<td>${vo.noticeId}</td>

			<td>${vo.noticeWriter}</td>
			<td>${vo.noticeTitle }</td>
			<td>${vo.noticeSubject }</td>
		</tbody>
	</table>
	</div>
</body>
</html>