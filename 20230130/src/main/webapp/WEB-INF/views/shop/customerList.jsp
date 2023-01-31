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
		<h2>🍓고객 정보 리스트🍓</h2>
		<div>
			<table>
				<tr>
					<td width="150" align="center">아이디</td>
					<td width="150" align="center">패스워드</td>
					<td width="150" align="center">권한 구분</td>
					<td width="150" align="center">이 름</td>
					<td width="150" align="center">전화번호</td>
				<tbody>
				<!-- DB이름 그대로 넣어줘야함!! -->
					<c:forEach items="${customers }" var="C">
						<tr style="cursor: pointer;"
							onmouseover="this.style.background='#fcecae'"
							onmouseleave="this.style.background='#FFFFFF'">
							<td width="150" align="center">${C.SH_ID }</td>
							<td width="150" align="center">${C.SH_PASSWORD }</td>
							<td width="150" align="center">${C.SH_GUBUN }</td>
							<td width="150" align="center">${C.SH_CUSTOMER_NAME }</td>
							<td width="150" align="center">${C.SH_CUSTOMER_TEL }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br> <a href="shopUserList.do">🍓상점 점주 리스트</a><br> 
			<a href="getCustomerList2.do">🍓객체 형태로 고객 리스트 만들기</a><br>
			<a href="setMemberJoinForm.do">🍓쇼핑몰 회원가입</a>
		</div>
	</div>
</body>
</html>