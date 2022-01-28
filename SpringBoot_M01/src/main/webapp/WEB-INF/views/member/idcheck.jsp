<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{  background-color:pink;  font-family: Verdana;}
h1 {font-family:Verdana; font-size: 45px; color: #CCC; font-weight: normal;}
input[type=button], input[type=submit] { float: right;}
</style>
<script type="text/javascript">
function idok(){
		opener.formm.id.value="${id}"; 		opener.formm.reid.value="${id}";		self.close();
}
</script>
</head>
<body>
<div id="wrap">
<h1>ID 중복확인</h1>
<form method="post" name="formm" action="idCheckForm">
	User ID <input type=text name="id" value="${id}">
	<input type=submit value="검색" class="submit"><br>     
	<div style="margin-top: 20px">
		<c:if test="${result == 1}">
			<script type="text/javascript">opener.document.formm.id.value="";</script>
			${id}는 이미 사용중인 아이디입니다.
		</c:if>
		<c:if test="${result==-1}">
			${id}는 사용 가능한 ID입니다.    
			<input type="button" value="사용" class="cancel"	onclick="idok()">
		</c:if>
	</div>
</form>
</div>
</body>
</html>