package study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.HibernateApp;

/**
 * Servlet implementation class Update1
 */
@WebServlet("/update")
public class Update1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("productId");
		System.out.println(id);
		String choice=request.getParameter("x");
		System.out.println(choice);
		String record=request.getParameter("record");
		if(id!=null && choice!=null && record!=null  )
		{System.out.println(record);
			int id1=Integer.parseInt(id);
			System.out.println(id1);
			int ch=Integer.parseInt(choice);
			System.out.println("Chioce"+choice);
			HibernateApp ap=new HibernateApp();
			System.out.println(id1+choice+record);
			ap.updateProduct(id1,ch,record);
			response.sendRedirect("update.jsp");
		}
	}

}
