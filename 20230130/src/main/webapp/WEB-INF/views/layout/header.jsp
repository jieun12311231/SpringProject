<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/menu.css">
<style type="text/css">
@font-face {
    font-family: 'GangwonEdu_OTFBoldA';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_2201-2@1.0/GangwonEdu_OTFBoldA.woff') format('woff');
    font-weight: normal;
    font-style: normal;
}
*{
font-family:'GangwonEdu_OTFBoldA';
}
</style>
</head>
<body>
	<nav id="topMenu">
		<ul>
			<li><a class="menuLink" href="home.do">Home</a></li>
			<li><a class="menuLink" href="noticeList.do">Notice</a></li>

			<li><a class="menuLink" href="setMemberJoinForm.do">StoreJoin</a></li>
			<li><a class="menuLink" href="getCustomerList2.do">Customer</a></li>
			<li><a class="menuLink" href="shopUserList.do">User</a></li>
			<li><a class="menuLink" href="employeeList.do">Employee</a></li>
			
			<c:if test="${author eq 'ADMIN' }">
				<li><a class="menuLink" href="memberListSelect.do">Member</a></li>
			</c:if>
			<c:if test="${empty id }">
				<li><a class="menuLink" href="memberJoinForm.do">Join</a></li>
				<li><a class="menuLink" href="memberLoginForm.do">Login</a></li>
			</c:if>
			<c:if test="${not empty id }">
				<li><a class="menuLink" href="memberLogout.do">Logout</a></li>
			</c:if>
		</ul>
	</nav>
</body>
</html>