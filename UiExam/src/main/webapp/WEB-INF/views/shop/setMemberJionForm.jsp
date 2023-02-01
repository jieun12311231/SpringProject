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
			<h1>쇼핑몰 회원가입</h1>
		</div>
		<div>
			<form id="frm" onsubmit="return formSubmit()" method="post">
				<div>
					<table border="1">
						<tr>
							<th>아이디</th>
							<td><input type="text" id="shId" name="shId" required="required">
								<button type="button" id="idCheck" value="no" onclick="idcheck()">중복체크</button></td>
						</tr>
						<tr>
							<th>패스워드</th>
							<td><input type="password" id="shPassword" name="shPassword" required></td>
						</tr>
						<tr>
							<th>패스워드 확인</th>
							<td><input type="password" id="shPasswordCheck" name="shPasswordCheck" required="required">
							</td>
						</tr>
						<tr>
							<th>구분</th>
							<td>
								<input type="radio" id="shGubun" name="shGubun" value="C" onchange="showDiv('C')"
									checked="checked">고객
								<input type="radio" id="shGubun" name="shGubun" value="U" onchange="showDiv('U')">상점주
								<input type="radio" id="shGubun" name="shGubun" value="E" onchange="showDiv('E')">직원
							</td>
						</tr>
					</table>
					<div id="customer" style="display: block;">
						<table>
							<tr>
								<th>이름</th>
								<td><input type="text" id="shCustomerName" name="shCustomerName"></td>
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
								<td><input type="text" id="shUserShopname" name="shUserShopname"></td>
							</tr>
						</table>
					</div>
					<div id="employee" style="display: none;">
						<table>
							<tr>
								<th>이름</th>
								<td><input type="text" id="shEmployeeName" name="shEmployeeName" >
								</td>
							</tr>
							<tr>
								<th>부서</th>
								<td><select id="shEmployeePart" name="shEmployeePart">
										<option value="" disabled selected>::선택</option>
										<option value="Management">관리부</option>
										<option value="Marketing">마케팅부</option>
									</select></td>
							</tr>
							<tr>
								<th>입사일자</th>
								<td><input type="date" id="shEmployeeStartDate" name="shEmployeeStartDate"></td>
							</tr>
							<tr>
								<th>퇴사일자</th>
								<td><input type="date" id="shEmployeeLastDate" name="shEmployeeLastDate"></td>
							</tr>
							<tr>
								<th>직급</th>
								<td><select id="shEmployeePosition" name="shEmployeePosition" >
										<option value="" disabled selected>::선택</option>
										<option value="Team Leader">팀장</option>
										<option value="Employee">사원</option>
									</select></td>
							</tr>
						</table>
					</div>
				</div><br>
				<input type="submit" value="등록">&nbsp;&nbsp;
				<input type="reset" value="취소">
			</form>
		</div>
	</div>
	<script>
	//부서 select 
		let part = document.querySelector('#shEmployeePart')
		part.addEventListener('change',(event)=>{
			if (event.target.value !== "type") {
			part.value = event.target.value;
			}
		})

	//직급 select
		let position = document.querySelector('#shEmployeePosition')
		position.addEventListener('change',(event)=>{
			if (event.target.value !== "type") {
				position.value = event.target.value;
			}
		})
		function showDiv(option) {
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
				.then(response => response.text())
				.then(data => idCheckResult(data));
		}

		function idCheckResult(data) {
			if (data == "true") {
				alert("이미 사용하는 아이디 입니다.");
			} else if (data == "false") {
				alert("사용가능한 아이디 입니다.");
				document.getElementById("idCheck").value = "yes";
			}
		}

		function formSubmit() {
			//		let option = document.querySelector('input[name="shGubun"]:checked').value;
			let option = document.querySelector('#shGubun:checked').value;
			if (frm.idCheck.value == 'no') {
				alert("아이디 중복체크를 해주세요");
				return false;
			} else if (frm.shPassword.value != frm.shPasswordCheck.value) {
				alert("패스워드를 확인해주세요.");
				return false;
			}

			if (option == 'C') {
				if (frm.shCustomerName.value == "") {
					alert("사용자 이름을 입력하세요");
					return false;
				} else if (frm.shCustomerTel.value == "") {
					alert("사용자 전화번호를 입력하세요");
					return false;
				}
				frm.action = "shopCustomerJoin.do";
			} else if (option == 'U') {
				if (frm.shUserName.value == "") {
					alert("대표자 이름을 입력하세요");
					return false;
				} else if (frm.shUserShopname.value == "") {
					alert("상호명을 입력하세요");
					return false;
				}
				frm.action = "shopUserJoin.do";
			} else {
				//폼 체크 구문 작성
				if (frm.shEmployeeName.value == "") {
					alert("직원 이름을 입력하세요");
					return false;
				} else if (frm.shEmployeePart.value == "") {
					alert("부서를 입력하세요");
					return false;
				} else if (frm.shEmployeeStartDate.value == "") {
					alert("입사일자를 입력하세요");
					return false;
				} else if (frm.shEmployeePosition.value == "") {
					alert("직급을 입력하세요");
					return false;
				}
				frm.action = "shopEmployeeJoin.do";
			}

			return true;
		}
	</script>
</body>

</html>