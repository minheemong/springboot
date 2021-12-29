<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginform</title>
<link rel="stylesheet" type="text/css" href="static/css/board.css">
<script type="text/javascript" src="/script/board.js"></script>
</head>
<body>
<form action="login" method="post">
	<div class="box2"><div id="title">로그인</div></div>
	<div class="box2"><div class="attr1">아이디</div>
		<div class="attr2">&nbsp;&nbsp;<input type="text" size="20" name="id"
			style="width:200px; height:20px;" value:"${dto.id}"></div></div>
	<div class="box2">
		<div class="attr1">비밀번호</div>
		<div class="attr2">&nbsp;&nbsp;
			<input type="password" size="20" name="pw" style="width:200px; height:20px;"> 
		</div>
	</div>
	<div class="box2"><div id="footer">
		<input type="submit" value="로그인"/>
		<input type="reset" value="다시작성"/>
		<input type="button" value="회원가입" onclick="location.href='memberJoinForm'"/>
	</div></div>
	<div class="box2"><div id="footer">${message}</div></div>
</form>
</body>
</html>