<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>카드 결제</p>
<form action="buyTicketCard">
	고객 아이디 : <input type="text" name="id"><br/>
	티켓 구매 수 : <input type="text" name="amount"><br/>
	에러 발생 여부 : <input type="text" name="error" value="0"><br/>
	<input type="submit" value="구매"><br/>
</form>
<hr>
에러 발생 여부에 1을 입력하면 에러가 발생합니다
</body>
</html>