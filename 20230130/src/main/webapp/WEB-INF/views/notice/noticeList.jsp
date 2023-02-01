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
							<td width="250">&nbsp;<input type="text" name="val" id="val">&nbsp;
								<input type="button" onclick="searchListJson()" value="검색">
							</td>
						</tr>
					</table>
				</div>
			</form>
		</div>
		<br>
		<div>
			<c:if test="${not empty id }">
				<button type="button" onclick="location.href='noticeInsertForm.do'">글쓰기</button>
			</c:if>
		</div>
		<br>
		<table border="1" id="list-table">
			<thead>
				<tr align="center">
					<td width="100">순번</td>
					<td width="250">제목</td>
					<td width="100">작성자</td>
					<td width="100">작성일자</td>
					<td width="100">조회수</td>
					<td width="100">첨부파일</td>
				</tr>
			</thead>
			<tbody id="notice-list">
				<c:forEach items="${notices}" var="n">
					<tr style="cursor: pointer;"
						onmouseover='this.style.background="#fcecae";'
						onmouseleave='this.style.background="#FFFFFF"'
						onclick="noticeSel(${n.noticeId})">
						<td align="center">${n.noticeId}</td>
						<td align="center">${n.noticeTitle}</td>
						<td align="center">${n.noticeWriter}</td>
						<td align="center">${n.noticeDate}</td>
						<td align="center">${n.noticeHit}</td>
						<td align="center"><c:if test="${not empty n.noticeFile}">
								${n.noticeFile }
							</c:if></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br>

		<div>
			<form id="hiddenFrm" action="noticeSelect.do" method="post">
				<input type="hidden" name="noticeId" id="noticeId">
			</form>
		</div>
	</div>
	<script type="text/javascript">
	
// 		function searchList() { //검색 버튼을 누르면 진행되는 함수 
// 			let url = 'AjaxSearchList.do';
// 			let key = document.getElementById('key').value;
// 			let val = document.getElementById('val').value;

// 			let payload = 'key=' + key + '&val=' + val
// 			//json방식으로 만들

// 			// fetch(url+'?key='+key+'&val='+val)  //get방식
// 			fetch(url, { //post방식
// 					method: 'post',
// 					headers: {
// 						'Content-Type': 'application/x-www-form-urlencoded'
// 					},
// 					body: payload

// 				})
// 				.then(response => response.json())
// 				.then(data => {
// 					htmlConvert(data)
// 					console.log(data)
// 				})
// 			// .catch(err => console.log(err))
// 		}
		function searchListJson() { //검색 버튼을 누르면 진행되는 함수 
			let url = 'AjaxSearchListJson.do';
			let key = document.getElementById('key').value;
			let val = document.getElementById('val').value;

			let payload = {"key":key, "val":val};
			//json방식으로 만들

			// fetch(url+'?key='+key+'&val='+val)  //get방식
			fetch(url, { //post방식
					method: 'post',
					headers: {'Content-Type': 'application/json'},  //데이터를 json형태로 넘기겠다
					body: JSON.stringify(payload)
				})
				.then(response => response.json())
				.then(data => {
					htmlConvert(data)
					console.log(data)
				})
			// .catch(err => console.log(err))
		}

		function htmlConvert(datas) {  //json을 html로 변환해서 화면에 뿌림
			//여기서 화면에 처리하는 과정을 작성 하면 됨 
			document.querySelector('#notice-list').remove();  //리스트의 tbody삭제
			const container = document.createElement('tbody'); //<tbody>태그 생성
			container.id = 'notice-list' //tbody에 id부여
			container.innerHTML = datas.map(data => createHTMLString(data)).join(""); //map을 이용해서 한줄의 데이터를 받아서 꾸밀수있음 => 꾸민 데이터를 join
			document.querySelector('#list-table').appendChild(container);  //원하는 위치에 append시키기
		}

		function createHTMLString(data) {  //html변환코드 css,event listner를 활용
			if (data.noticeFile == null)  //첨부파일 존재유무 확인
				data.noticeFile = "" //존재하지않으면 공백
			else
				data.noticeFile = "💾" //존재하면 @

			let str = "<tr onmouseover=this.style.background='#fcecae';"
			str += " onmouseleave=this.style.background='#FFFFFF';"
			str += " onclick=";
			str += "noticeSel('" + data.noticeId + "')" + ">";
			str += "<td align=center>" + data.noticeId + "</td>";
			str += "<td>" + data.noticeTitle + "</td>";
			str += "<td align=center>" + data.noticeWriter + "</td>";
			str += "<td align=center>" + data.noticeDate + "</td>";
			str += "<td align=center>" + data.noticeHit + "</td>";
			str += "<td align=center>" + data.noticeFile + "</td></tr>";
			return str;
		}

		function noticeSel(n) {
			//여기에서 상세보기 호출
			document.getElementById('noticeId').value = n; //hidden 폼 안에 있는 id값 -> 여기에 담기면 hidden폼에 value가 매개변수로 넘어온 n으로 생김
			hiddenFrm.submit() //noticeId를 가지고 넘어가서 값을 찾아오도록
		}
	</script>
</body>

</html>