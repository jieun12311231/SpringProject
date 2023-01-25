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
		<div>
			<h3>게시글 목록</h3>
		</div>
		<div id="n-list">
			<c:forEach items="${notices}" var="n">
				${n.noticeWriter } : ${n.noticeTitle } : ${n.noticeSubject}<br>
			</c:forEach>
			<div>
				<br>
				<form id="frm" method="post">
					<div>
						<table border="1">
							<tr>
								<td width="100"><select name="key" id="key">
										<option value="all">전체</option>
										<option value="title">제목</option>
										<option value="subject">내용</option>
										<option value="writer">작성자</option>
										<option value="date">작성일자</option>
									</select></td>
								<td width="250">
									&nbsp;<input type="text" name="val" id="val">&nbsp;
									<input type="button" onclick="searchList()" value="검색">
								</td>
							</tr>
						</table>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function searchList() { //검색 버튼을 누르면 진행되는 함수 
			let url = 'AjaxSearchList.do';
			let key = document.getElementById('key').value;
			let val = document.getElementById('val').value;

			let payload ='key=' + key + '&val=' + val
			//json방식으로 만들

			// fetch(url+'?key='+key+'&val='+val)  //get방식
			fetch(url, { //post방식
					method: 'post',
					headers: {
						'Content-Type': 'application/x-www-form-urlencoded'
					},
					body: payload

				})
				.then(response => response.json())
				.then(data => {
					htmlConvert(data)
					console.log(data)
				})
				// .catch(err => console.log(err))


		}
		function htmlConvert(data){
			//여기서 화면에 처리하는 과정을 작성 하면 됨 
		}
	</script>
</body>

</html>