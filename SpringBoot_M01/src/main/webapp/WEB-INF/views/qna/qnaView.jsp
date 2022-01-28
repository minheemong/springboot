<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/headerfooter/header.jsp" %>
<%@ include file="../include/sub04/sub_image.html" %> 
<%@ include file="../include/sub04/sub_menu.jsp" %>
<style>
tr{text-align:"left";}
</style>
<article>
<h2> 1:1 고객 게시판 </h2>
<h3> 고객님의 질문에 대해서 운영자가 1:1 답변을 드립니다.</h3>
	<form name="formm" method="post">
	<table width="600">
		<tr><th width="100" align="center">제목</th><td>${qnaVO.subject}</td></tr>
		<tr><th align="center">등록일</th><td align="left"><fmt:formatDate value="${qnaVO.indate}" type="date"/>
		</td></tr>
		<tr><th align="center">질문내용</th>
			<td style="text-align:left"><pre style="font-size:120%; text-align:left">${qnaVO.content}</pre></td></tr>
		<tr><th align="center">답변 내용</th><td style="text-align:left">${qnaVO.reply}</tr>
		</table>
		<div class="clear"></div>
		<div id="buttons" style="float:right">
			<input type="button"  value="목록보기" class="submit" onclick="location.href='qnaList'"> 
			<input type="button"  value="쇼핑 계속하기"  class="cancel" onclick="location.href='/'">  
		</div>	
	</form>	
</article>
<%@ include file="../include/headerfooter/footer.jsp" %>