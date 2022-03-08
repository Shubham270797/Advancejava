package study.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.GroceryProduct;
import study.HibernateApp;

/**
 * Servlet implementation class Search
 */
@WebServlet("/search")
public class Search extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("productId");
		if(id!=null)
		{
			int id1=Integer.parseInt(id);
			HibernateApp ap=new HibernateApp();
			
			GroceryProduct gp=ap.searchProduct(id1);
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.append("<html><body>");
			
			pw.append("<p><b>"+gp.toString()+"</b/></p>");
			pw.append("</html></body>");
			response.sendRedirect("search.jsp");
		}
	}

}
