<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/admin/admin.css">
<script type="text/javascript" src="/admin/product.js"></script>
<body>
<div id="wrap">
	<header>			
		<div id="logo">
			<a href="admin"> 
				<img src="<c:url value='admin/bar_01.gif'/>"  style="float:left;">
				<img src="<c:url value='admin/text.gif'/>">
			</a>
		</div>	
		<input class="btn" type="button" value="logout" style="float: right;"
		onClick="location.href='adminLogout'">			
	</header>
	<div class="clear"></div>