<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fibonacciResult</title>
</head>
<body>
	<p
		style="font-family: Verdana, Arial; margin-left: 35px; color: black; font-weight: bold">
		<%
			// List<Long> fiboList = (List<Long>)request.getAttribute("fibolist");
			/*  for (int i = 0; i < fiboList.size(); i++) {
				  out.println(fiboList.get(i));
				} */
			//  out.println("The Fibonacci Sequence is:"+fiboList);  
			if (session.getAttribute("fibolist") != null) {
				List<Long> fiboList = (List<Long>) session.getAttribute("fibolist"); //从session里把a拿出来，并赋值给M 
				out.println(fiboList);
			} else {
				String errorInfo = (String) session.getAttribute("errorInfo"); //从session里把a拿出来，并赋值给M 
				out.println("sorry,there is something wrong!"+errorInfo);
			}
		%>
	</p>
</body>
</html>