<%@page import="com.java.miniproject.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Hobby</title>

</head>
<body>
<%// String uname=(String)request.getAttribute("User");
User nuser=(User)session.getAttribute("User");
String user_name =nuser.getFname()+" "+nuser.getLname();%>
 Welcome User <%=user_name %>
 
 <br/>
 Add Hobby
  <br/>
   <br/>
   <form action="AddHobbyServlet">
   <input type="text" name="hobby" id="hobby">
   <input type="submit" value="ADD">
</body>
</html>