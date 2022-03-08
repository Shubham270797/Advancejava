
<%@page import="com.java.miniproject.pojo.Hobby"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.java.miniproject.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Hobby</title>
</head>
<body>
<%

ArrayList<Hobby> al1=(ArrayList)session.getAttribute("list");

for(Hobby h:al1)
{%>
<%=h.getHobby() %>	<br>
<%
}

%>
 <br/>
 <jsp:forward  page="ViewHobby"/>
 
 
</body>
</html>