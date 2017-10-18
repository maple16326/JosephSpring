<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>

<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fibonacciResult</title>
</head>
<body>
	<p
		style="font-family: Verdana, Arial; margin-left: 35px; color: black; font-weight: bold">

	</p>
	<c:set var="fibolist" scope="session" value="${fibolist}" />
	<c:set var="errorInfo" scope="session" value="${errorInfo}" />
	<c:choose>
		<c:when test="${fibolist!=null}">
			<c:forEach var="fibolist" items="${fibolist}">
				<c:out value="${fibolist}"></c:out>
			</c:forEach>
		</c:when>

		<c:otherwise>
			<h3>sorry,there is something wrong!</h3>
			<c:out value="${errorInfo}"></c:out>
		</c:otherwise>
	</c:choose>

</body>
</html>