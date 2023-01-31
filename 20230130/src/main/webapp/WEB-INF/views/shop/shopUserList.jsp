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
	<div align="center">
		<h1>🍓상점 점주 리스트🍓</h1>
		<table>
			<tr>
				<td width="150" align="center">아이디</td>
				<td width="150" align="center">패스워드</td>
				<td width="150" align="center">점주 이름</td>
				<td width="150" align="center">가게 이름</td>
				<td width="150" align="center">권한 구분</td>
			<tbody>
				<c:forEach items="${shops }" var="s">
					<tr style="cursor: pointer;"
						onmouseover="this.style.background='#fcecae'"
						onmouseleave="this.style.background='#FFFFFF'">
						<td width="150" align="center">${s.shUserId }</td>
						<td width="150" align="center">${s.shPassword }</td>
						<td width="150" align="center">${s.shUserName }</td>
						<td width="150" align="center">${s.shUserShopname }</td>
						<td width="150" align="center">${s.shGubun }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>