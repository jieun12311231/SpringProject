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
		<br>
		<div>
			<h1>★회원목록★</h1>
		</div>
		<br>
		<div>
			<table border="1">
				<thead>
					<tr>
						<td width="150" align="center">아이디</td>
						<td width="150" align="center">이 름</td>
						<td width="150" align="center">나 이</td>
						<td width="150" align="center">전화번호</td>
						<td width="150" align="center">주 소</td>
						<td width="150" align="center">권 한</td>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${list }" var="m">
						<tr style="cursor: pointer;"
						 onmouseover="this.style.background='#fcecae'"
							onmouseleave="this.style.background='#FFFFFF'"
							onclick="memberSelect('${m.memberId}')">
							<td width="150" align="center">${m.memberId }</td>
							<td width="150" align="center">${m.memberName }</td>
							<td width="150" align="center">${m.memberAge }</td>
							<td width="150" align="center">${m.memberTel }</td>
							<td width="150" align="center">${m.memberAddress }</td>
							<td width="150" align="center">${m.memberAuthor }</td>
						</tr>
					</c:forEach>
				</tbody>

			</table>
		</div>
		<br>
		<!--포스트 방식으로 데이터를 넘기기 위해 키값을 주기위한 히든폼 
		memberSelect(${m.memberId})에서 넘어온 값을 
		폼에 담고 -->
		<div>
			<form id="frm" action="memberSelect.do" method="post">
				<input type="hidden" id="memberId" name="memberId">
			</form>
		</div>
	</div>
	<!-- frm을 서밋하면 memberSelect.do 얘가 실행-->
	<script type="text/javascript">
		function memberSelect(id) {
			document.getElementById("memberId").value = id;
			frm.submit(); // 숨겨진 폼을 전송.

		}
	</script>
</body>