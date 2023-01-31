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
		<div>
			<h2>🍓회원가입🍓</h2>
		</div>
		<div>
			<form action="" id="frm" method="post">
				<div>
					<table>
						<tr>
							<th width="100" align="left">아이디</th>
							<td><input type="text" id="shId" name="shId" required="required">
								<button type="button" id="btnId" onclick="idCk()">중복확인</button>
							</td>
						</tr>
						<tr>
							<th width="100" align="left">비밀번호</th>
							<td><input type="password" id="shPassword" name="shPassword" required="required"></td>
						</tr>
						<tr>
							<th width="100" align="left">비밀번호 확인</th>
							<td><input type="password" id="shPasswordCk" name="shPasswordCk" required="required"></td>
						</tr>
						<tr>
						<th width="100" align="left">구분</th>
						<td><label><input type="radio" name="c" value="c" checked="checked">고객</label>
						<label><input type="radio"  value="s">상점주</label>
						<label><input type="radio" value="e">직원</label></td>
						</tr>
						<div id="customer" style="display: none;">
						<tr>
						<th>이름</th>
						<td><input type="text" id="shCustomerId" name="shCustomerId"></td>
						</tr>
						<tr>
						<th>연락처</th>
						<td><input type="tel" id="shCustomerTel" name="shCustomerTel"></td>
						</tr>
					</div>
					</table>
				</div>
			</form>
		</div>
	</div>
	<script type="text/javascript">
	$('input[type=radio][name=c]').on('click',function(){
		var chkVal = $('input[type=radio][name=c]')
	})
	</script>
</body>
</html>