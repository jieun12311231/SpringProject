<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<div>
			<h1>공지사항 상세내역</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="100">작성자</th>
					<td width="150" align="center">${notice.noticeWriter }</td>
					<th width="100">작성일자</th>
					<td width="150" align="center">${notice.noticeDate }</td>
					<th width="100">조회수</th>
					<td width="150" align="center">${notice.noticeHit }</td>
				</tr>

				<tr>
					<th>제목</th>
					<td colspan="5">${notice.noticeTitle }</td>
				</tr>

				<tr>
					<th>내용</th>
					<td colspan="3">${notice.noticeSubject }
					</td>
					<td colspan="2" width="50px" height="50px"><img src="resources/upload/${file}" alt="저장된 파일이 없습니다."></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="5">${notice.noticeFile }
				</td>
				</tr>
			</table>
		</div>
		<br>
		<div>
			<form id="frm" method="post">
				<c:if test="${name eq notice.noticeWriter }">
					<button type="button" onclick="noticeEdit('E')">글수정</button>
					<button type="button" onclick="noticeEdit('D')">글삭제</button>
				</c:if>
				<button type="button" onclick="location.href='noticeList.do'">목록으로</button>
				<!--★★form 이 하나밖에 없기때문에 폼이 submit되면 넘어오는 변수가 없게되기때문에 hidden으로 아이디를 넘겨줘야함
				 id를 넘겨서 E가 들어오면 edit로 이동하게 하고/ D가 들어오면 delete가 되도록 함 
				화면에는 보이지 않는 값
				받은 값을 넘기고 싶으면 value를 없애면됨/ 이미 넘어온 값은 value에 넣어줘야함-->
				<input type="hidden" name="noticeId" value="${notice.noticeId }" >
				<input type="hidden" name="noticeFileDir" id="noticeFileDir">
			</form>

		</div>
	</div>
	<script type="text/javascript">
		function noticeEdit(str) {
			if (str == 'E') {
				frm.action = "noticeEditForm.do";
			} else {
				let yn = confirm("작성글을 삭제하시겠습니까?");
				if (yn) {
					frm.action = "noticeDelete.do";
				} else {
					return false;
				}
			}
			frm.submit();
		}
		
	</script>
</body>
</html>