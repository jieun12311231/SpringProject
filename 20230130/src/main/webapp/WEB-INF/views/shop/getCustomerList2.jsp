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
	<h2>🍓객체 중심으로 설계 한 고객 리스트🍓</h2>
	<table>
		<tr>
			<td width="150" align="center">고객 이름</td>
			<td width="150" align="center">아이디</td>
			<td width="150" align="center">패스워드</td>
			<td width="150" align="center">전화번호</td>
		<tbody>
			<c:forEach items="${customers2 }" var="c">
				<tr style="cursor: pointer;"
					onmouseover="this.style.background='#fcecae'"
					onmouseleave="this.style.background='#FFFFFF'">
					<td width="150" align="center">${c.shCustomerName }</td>
					<td width="150" align="center">${c.shopMember.shId }</td>
					<td width="150" align="center">${c.shopMember.shPassword }</td>
					<td width="150" align="center">${c.shCustomerTel }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>