<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="static/css/board.css">
<script type="text/javascript">
function selectimg(){
	var opt="toolbar=no, munubar=no, resizable=no, width=450, height=200";
	window.open('selectimg', 'selectimg', opt);
	
}
</script>
</head>
<body>
<div id="wrap" align="center">
<h1>게시글 수정</h1>
<form name="frm" method="post" action="boardUpdate">
<input type="hidden" name="num" value="${dto.num}">
<table>
	<tr><th>작성자</th><td>${loginUser.id}
		<input type="hidden" value="${loginUser.id}" size="12" name="userid"></td></tr>
	<tr><th>비밀번호</th><td><input type="password" name="pass" size="12"> 
		* 필수(게시물 수정 삭제 시 필요합니다)</td></tr>
	<tr><th>이메일</th><td><input type="text" value="${dto.email}" size="12" name="email"></td></tr>
	<tr><th>제목</th><td><input type="text" value="${dto.title}" size="12" name="title"></td></tr>
	<tr><th>내용</th><td><textarea cols="70" rows="15" name="content">${dto.content}</textarea>
		</td></tr>
	<tr><th>이미지</th><td>
		<c:choose>
			<c:when test="${empty dto.imgfilename}">
				<img src="static/upload/noname.jpg" height="80" width="80"><br>
			</c:when>
			<c:otherwise>
				<img src="static/upload/${dto.imgfilename}" height="80" width="80"><br>
			</c:otherwise>
		</c:choose>
			<input type="text" name="image" disabled>
			<input type="hidden" name="imgfilename">
			<input type="button" value="파일선택" onclick="selectimg();">
			<br>파일을 수정하고자 할 때만 선택하세요
		<input type="hidden" name="oldfilename" value="${dto.imgfilename}">
	</td>
	</tr>
</table>
<input type="submit" value="수정">
<input type="button" value="목록" onclick="location.href='main'">
${message}
</form>
</div>

</body>
</html>