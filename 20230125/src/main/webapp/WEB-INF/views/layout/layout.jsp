<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  tiles쓰려면 이걸 넣어야함 -->
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- tiles에 설정된 title을 넣어주기 -->
<title><tiles:getAsString name="title"/></title>
</head>
<body>
<div align="center">
<div>
<tiles:insertAttribute name="header"/>
</div>
<div>
<tiles:insertAttribute name="body"/>
</div>
<hr>
<div>
<tiles:insertAttribute name="footer"/>
</div>
</div>
</body>
</html>