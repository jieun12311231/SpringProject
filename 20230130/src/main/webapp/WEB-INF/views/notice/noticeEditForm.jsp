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
			<h1>공지사항 수정</h1>
		</div>
		<div align="center">
			<form id="frm" action="noticeEdit.do" method="post"
				enctype="multipart/form-data">
				<div>
					<table border="1">
						<tr>
							<th width="150">작성자</th>
							<!-- input박스 없으면 값이 넘어가지 않음! -->
							<td width="200"><input type="text" id="noticeWriter"
								name="noticeWriter" value="${name }" readonly="readonly"></td>
							<th width="150">작성일자</th>
							<td width="200"><input type="date" id="noticeDate"
								name="noticeDate" value="${notice.noticeDate }" required="required"></td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="3"><input type="text" size="76"
								id="noticeTitle" name="noticeTitle" value="${notice.noticeTitle }" required="required"></td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3"><textarea rows="10" cols="80"
									id="noticeSubject" name="noticeSubject" >${notice.noticeSubject }</textarea></td>
						</tr>
						<tr>
							<th>첨부파일</th>
							<td colspan="3">${notice.noticeFile }&nbsp;&nbsp;<input type="file" id="file"
								name="file"></td>
						</tr>
					</table>
				</div>
				<div>
				<input type="hidden" name="noticeId" value="${notice.noticeId }">
				<input type="hidden" name="noticeHit" value="${notice.noticeHit }">						
				<input type="hidden" name="noticeWriter" value="${notice.noticeWriter }">
				</div>
				<br>
				<div>
					<input type="submit" value="수정">&nbsp;&nbsp; 
<!-- 					<input type="reset" value="취소"> -->
					<input type="button" value="취소" onclick="location.href='noticeList.do'">
				</div>
			</form>
		</div>
	</div>
</body>
</html>