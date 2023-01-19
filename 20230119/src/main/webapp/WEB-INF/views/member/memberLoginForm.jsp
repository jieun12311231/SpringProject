<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 타일즈 대신에 사용하는것  타일즈 없으면 안써도 됨-->
	<jsp:include page="../home/menu.jsp"></jsp:include>

	<div align="center">
		<div>
			<h1>로그인</h1>
		</div>
		<div>
			<form action="memberLogin.do" id="frm" method="post">
			<div>
			<table border="1">
			<tr>
			<th width="150">*아이디</th>
			<td width="200"><input type="text" id="memberId" name="memberId"></td>
			</tr>
			<tr>
			<th>*비밀번호</th>
			<td><input type="password" id="memberPassword" name="memberPassword"></td>
			</tr>
			</table>
			</div><br>
			<input type="submit" value="Login">&nbsp;&nbsp;
			<input type="reset" value="Cancle"> 
			</form>
		</div>

	</div>
</body>
</html>