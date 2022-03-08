<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
<label>product id whose record you want to update:</label><input type="text" name="productId" placeholder="product Id "/><br/>
<label>select your choice</label><select name="x" >
<option >enter your choice</option>
<option  value="2">product Name</option>
<option  value="3">product desc</option>
<option value="4">unit </option>
<option  value="5">cost</option>
</select><br/>
<label>new record:</label><input type="text" name="record" placeholder="new record"><br/>
<input type="submit" value="submit"/>
</form>
<a href="index.jsp">Go to main page</a>
</body>
</html>