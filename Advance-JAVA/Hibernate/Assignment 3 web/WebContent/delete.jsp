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
<form >
Enter id of student to delete:<input type="text" name="delete"/>
<br>
<input type="submit" value="OK"/>
</form>

<%
String ids=request.getParameter("delete");
if(ids!=null)
{
int id=Integer.parseInt(ids);
HibernateDAO1 hd=new HibernateDAO1();
hd.delete(id);

response.sendRedirect("index.jsp");
}


%>
</body>
</html>