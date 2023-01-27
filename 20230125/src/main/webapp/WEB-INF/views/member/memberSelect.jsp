<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<br>
	<div><h1>회원 상세조회</h1></div>
	<br>
	<div>
	<table border="1">
	<thead>
	<tr>
	<th width="150" align="center">아이디</th>
	<th width="150" align="center">이 름</th>
	<th width="150" align="center">나 이</th>
	<th width="150" align="center">전화번호</th>
	<th width="150" align="center">주소</th>
	<th width="150" align="center">권한</th>
	</tr>
	</thead>
	<tbody>
	
	<tr>
	<td width="150" align="center">${member.memberId }</td>
	<td width="150" align="center">${member.memberName }</td>
	<td width="150" align="center">${member.memberAge }</td>
	<td width="150" align="center">${member.memberTel }</td>
	<td width="150" align="center">${member.memberAddress }</td>
	<td width="150" align="center">${member.memberAuthor }</td>
	
	</tr>
	
	</tbody>
	
	</table>
	</div>
</div>	
</body>
</html>