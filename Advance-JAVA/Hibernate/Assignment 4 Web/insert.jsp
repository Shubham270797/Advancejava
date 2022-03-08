<%@page import="study.HibernateApp"%>
<%@page import="java.sql.Date"%>
<%@page import="study.GroceryProduct"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- <form action="Addition" method="post"> -->
<form >
<label>product name:</label><input type="text" name="productName" placeholder="product name"><br/>
<label>product desc:</label><input type="text" name="productDesc" placeholder="product Desc"/><br/>
<label>unit</label><input type="text" name="unit" placeholder="no of unit"/><br/>
<label>cost</label><input type="text" name="cost" placeholder="product cost"/>
<br/>
<label>expiryDate</label><input type="text" name="date" placeholder="expiry date(yy-mm-dd)"/><br/>
	<input type="submit" value="submit"/>
</form>
	<%
		GroceryProduct product = new GroceryProduct();
		String pname = request.getParameter("productName");
		if (pname != null) {
			product.setProductName(pname);
		}
		String pdesc = request.getParameter("productDesc");
		if (pdesc != null) {
			product.setProductDesc(pdesc);
		}
		String punit = request.getParameter("unit");
		if (punit != null) {
			int num = Integer.parseInt(punit);
			product.setUnit(num);
		}
		String productCost = request.getParameter("cost");
		if (productCost != null) {
			int cost = Integer.parseInt(productCost);
			product.setProductCost(cost);
		}

		String productDate = request.getParameter("date");
		/* SimpleDateFormat formater = new SimpleDateFormat("dd-mm-yy");
		Date date1 = formater.parse(productDate);
		*/
		if (productDate != null) {
			Date date = Date.valueOf(productDate);
			product.setExpiryDate(date);
		}
		HibernateApp happ = new HibernateApp();
		happ.addProduct(product);
		response.sendRedirect("index.jsp");
	%>
</body>
</html>