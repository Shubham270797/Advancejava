package study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Servlet implementation class Insert
 */
@WebServlet("/insert")
public class Insert extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int roll = Integer.parseInt(request.getParameter("rollNo"));
		System.out.println(roll);
		  String name = request.getParameter("name");
		  System.out.println(name);
		
		  HibernateDAO1 dao = new HibernateDAO1();
		  dao.addStudent(roll, name);
		  response.sendRedirect("index.jsp");
	}
}
