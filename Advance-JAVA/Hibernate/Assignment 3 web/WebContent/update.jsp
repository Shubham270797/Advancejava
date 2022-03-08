<%@page import="study.StudentEntity"%>
<%@page import="study.Insert"%>
<%@page import="study.HibernateDAO1"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
Enter the id of student to update:<input type="text" name="search">
<br>
Enter name to update<input type="text" name="nameUpdate">
<br/>
<input type="submit" value="submit">

</form>

<% String ids=request.getParameter("search");
  String name=request.getParameter("nameUpdate");
  if(ids!=null)
  {
	  int id=Integer.parseInt(ids);
	  HibernateDAO1 da=new  HibernateDAO1();
	StudentEntity k= da.update(id, name);
	%>

	<%=k.toString() %>
	<br>
	<a href="index.jsp">go to index page</a>
	
	<%
	
	}


	%>

</body>
</html>