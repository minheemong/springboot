<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/headerfooter/header.jsp" %>
<%@ include file="../include/sub03/sub_image.html" %> 
<%@ include file="../include/sub03/sub_menu.jsp" %>
<article>
<h2>${title}</h2>
<form name="formm" method="post">
<table id="cartList">
	<tr><th>일자</th><th>번호</th><th>상품명</th><th>금액</th><th>상세</th> <th>상태</th></tr>
      	<c:forEach items="${orderList}"  var="orderVO">
      	<tr><td><fmt:formatDate value="${orderVO.indate}" type="date"/></td>
      		<td>${orderVO.oseq} </td>   	<td>${orderVO.pname} </td>
        	<td><fmt:formatNumber value="${orderVO.price2}" type="currency"/> </td>
        	<td><a href="orderDetail?oseq=${orderVO.oseq}">조회</a></td><td>
			<c:if test="${orderVO.result=='1'}">미처리</c:if>
			<c:if test="${orderVO.result=='2'}">완료</c:if></td></tr>
      	</c:forEach>    
</table>
<div class="clear"></div>
<div id="buttons" style="float: right">
	<input type="button"    value="쇼핑 계속하기"  class="cancel"  onclick="location.href='/'"> 
</div>
</form>
</article>

<%@ include file="../include/headerfooter/footer.jsp" %>