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
		<div>
			<h1>🍓쇼핑몰 회원가입🍓</h1>
		</div>
		<div>
			<form id="frm" method="post" onsubmit="return formSubmit()">
				<div>
					<table>
						<tr>
							<th width="100" align="left">아이디</th>
							<td><input type="text" id="shId" name="shId" required="required">
								<button type="button" id="idCheck" value="no" onclick="idcheck()">중복체크</button></td>
						</tr>
						<tr>
							<th width="100" align="left">패스워드</th>
							<td><input type="password" id="shPassword" name="shPassword" required="required"></td>
						</tr>
						<tr>
							<th width="100" align="left">패스워드 확인</th>
							<td><input type="password" id="shPasswordCheck" name="shPasswordCheck" required="required">
							</td>
						</tr>
						<tr>
							<th width="100" align="left">구분</th>
							<td><input type="radio" id="shGubun" name="shGubun" value="C" onchange="showDiv('C')"
									checked="checked">고객
								<input type="radio" id="shGubun" name="shGubun" value="U" onchange="showDiv('U')">점주
								<input type="radio" id="shGubun" name="shGubun" value="E" onchange="showDiv('E')">직원
							</td>
						</tr>
					</table>
					<div id="customer" style="display: block;">
						<table>
							<tr>
								<th>이름</th>
								<td><input type="text" id="shCustomerName" name="shCustomerName">
								</td>
							</tr>
							<tr>
								<th>연락처</th>
								<td><input type="tel" id="shCustomerTel" name="shCustomerTel"></td>
							</tr>
						</table>
					</div>
					<div id="user" style="display: none;">
						<table>
							<tr>
								<th>대표이름</th>
								<td><input type="text" id="shUserName" name="shUserName"></td>
							</tr>
							<tr>
								<th>상호명</th>
								<td><input type="text" id="shUserShopname" name="shUserShopname">
								</td>
							</tr>
						</table>
					</div>
					<div id="employee" style="display: none;">
						<table>
							<tr>
								<th>직원 이름</th>
								<td><input type="text" id="" name="" ></td>
							</tr>
							<tr>
								<th>직원 연락처</th>
								<td><input type="tel" id="" name="" ></td>
							</tr>
						</table>
					</div>
				</div><br>
				<input type="submit" value="등록" onclick="formSubmit()">&nbsp;
				<input type="reset" value="취소">
			</form>
		</div>
	</div>
	<script>
		function showDiv(n) {
			let option = document.querySelector('input[name="shGubun"]:checked').value;
			// alert(option)
			if (option == 'C') {
				document.getElementById('customer').setAttribute('style', 'display:block')
				document.getElementById('user').setAttribute('style', 'display:none')
				document.getElementById('employee').setAttribute('style', 'display:none')
			} else if (option == 'U') {
				document.getElementById('customer').setAttribute('style', 'display:none')
				document.getElementById('user').setAttribute('style', 'display:block')
				document.getElementById('employee').setAttribute('style', 'display:none')
			} else if (option == 'E') {
				document.getElementById('customer').setAttribute('style', 'display:none')
				document.getElementById('user').setAttribute('style', 'display:none')
				document.getElementById('employee').setAttribute('style', 'display:block')
			}
		}
		function idcheck() {
			let id = document.getElementById("shId").value;
			fetch("ajaxShopIdCheck.do?id=" + id)
				.then(res => res.text())
				.then((data) => {
					idCheckResult(data)
					console.log(data)
				})
				.catch(err => console.log(err))
		}
		function idCheckResult(data) {
			if (data == "true") {
				alert("사용가능한 아이디 입니다")
				document.getElementById('idCheck').value = "yes";
				document.getElementById("idCheck").disabled = true;
			} else if (data == "false") {
				alert("이미 사용중인 아이디 입니다.")
				document.getElementById("shId").value = "";
				document.getElementById("shId").focus()
			}
		}
		function formSubmit() { //id가 shGubun인것을 찾아서 
// 			let option = document.querySelector('input[name="shGubun"]:checked').value;
			let option = document.querySelector('#shGubun:checked').value;
			
			if (frm.idCheck.value == 'no') {
				alert("아이디 중복체크를 해주세요")
				return false
			} else if (frm.shPassword.value != frm.shPasswordCheck.value) {
				alert("비밀번호를 확인해주세요")
				return false;
			}
			if (option == 'C') { //고객
				if(frm.shCustomerName.value ==""){
					alert("사용자 이름을 입력하세요")
					frm.shCustomerName.focus();
					return false
				}else if(frm.shCustomerTel.value ==""){
					alert("사용자 전화번호를 입력하세요")
					frm.shCustomerTel.focus();
					return false
				}
				frm.action = "shopCustomerJoin.do"
			} else if (option == 'U') {
				if(frm.shUserName.value ==""){
					alert("대표 이름을 입력하세요")
					frm.shUserName.focus();
					return false
				}else if(frm.shUserShopname.value ==""){
					alert("상호명을 입력하세요")
					frm.shUserShopname.focus();
					return false
				}
				frm.action = "shopUserJoin.do"
			} else { //employee정보 넣기 
				//폼 체크 구문 작성
				// if(frm.shUserName.value =""){
				// 	alert("대표 이름을 입력하세요")
				// 	frm.shUserName.focus();
				// 	return false
				// }else if(frm.shUserShopname.value =""){
				// 	alert("상호명을 입력하세요")
				// 	frm.shUserShopname.focus();
				// 	return false
				// }
				frm.action = "shopEmployeeJoin.do"
			}
 			return true
		 //frm.submit();
		}
	</script>
</body>
</html>