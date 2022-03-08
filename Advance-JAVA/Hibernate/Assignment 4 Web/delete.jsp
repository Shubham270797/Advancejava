<%@page import="study.HibernateApp"%>
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
<label>Enter the id of product</label><input type="text" name="productId" placehoder="Enter id"/>
<br>
<input type="button" value="submit"/>
</form>
<%
String id =request.getParameter("productId");
if(id!=null)
{
	int pId=Integer.parseInt(id);
	HibernateApp hp=new HibernateApp();
	hp.deleteProduct(pId);%>
	<%="Deleted successfully" %>
	<% 
}
%>
</body>
</html>