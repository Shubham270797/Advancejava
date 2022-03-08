package study.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.GroceryProduct;
import study.HibernateApp;

/**
 * Servlet implementation class Addition
 */
@WebServlet("/Addition")
public class Addition extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GroceryProduct product = new GroceryProduct();

		product.setProductName(request.getParameter("productName"));

		product.setProductDesc(request.getParameter("productDesc"));
		
		String punit=request.getParameter("unit");
		int num=Integer.parseInt(punit);
		product.setUnit(num);

		String productCost = request.getParameter("cost");
		int cost = Integer.parseInt(productCost);
		product.setProductCost(cost);

		
		String productDate = request.getParameter("date");
		/* SimpleDateFormat formater = new SimpleDateFormat("dd-mm-yy");
		Date date1 = formater.parse(productDate);
	 */	
	     Date date=Date.valueOf(productDate); 
	    product.setExpiryDate(date);
		
		HibernateApp happ=new HibernateApp();
		happ.addProduct(product);
		
	}

}
