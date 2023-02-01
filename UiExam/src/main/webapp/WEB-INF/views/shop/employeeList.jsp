<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<h2>🍓직원 정보 리스트🍓</h2>
		<div>
			<table>
				<tr>
					<td width="150" align="center">아이디</td>
					<td width="150" align="center">패스워드</td>
					<td width="150" align="center">직원 이름</td>
					<td width="150" align="center">직원 부서</td>
					<td width="150" align="center">입사 일자</td>
					<td width="150" align="center">퇴사 일자</td>
					<td width="150" align="center">직원 직급</td>
				<tbody>
					<c:forEach items="${employees }" var="e">
						<tr style="cursor: pointer;"
							onmouseover="this.style.background='#fcecae'"
							onmouseleave="this.style.background='#FFFFFF'">
							<td width="150" align="center">${e.shId }</td>
							<td width="150" align="center">${e.shPassword }</td>
							<td width="150" align="center">${e.shEmployeeName }</td>
							<td width="150" align="center">${e.shEmployeePart }</td>
							<td width="150" align="center">${e.shEmployeeStartDate }</td>
							<td width="150" align="center">${e.shEmployeeLastDate }</td>
							<td width="150" align="center">${e.shEmployeePosition }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>