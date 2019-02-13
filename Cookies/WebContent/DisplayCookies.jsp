<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Disney Cookies</title>
</head>
<body>
<body style="background-color: ${color}">

<h1>Qui puoi vedere i tuoi cookies!</h1>
<p>Per visualizzare i cookies di Pippo:
<form action = "Pippo" method ="post">
<input type = submit ></form>
<p>Per visualizzare i cookies di Pluto:
<form action = "Pluto" method ="post">
<input type = submit ></form>
<p>

<c:forEach var = "Cookie" items = "${arraylist}">
	<c:out value = "${Cookie.name}"></c:out>
	: &nbsp<c:out value = "${Cookie.value}"></c:out>
	<br>
</c:forEach>


</body>
</html>