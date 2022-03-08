package com.java.miniproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.miniproject.db.DBManager;
import com.java.miniproject.pojo.User;

/**
 * Servlet implementation class abc
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User nuser=new User();//create object of POJO class
		nuser.setUsername(request.getParameter("uname"));
		nuser.setPwd(request.getParameter("pass"));
		
		System.out.println(nuser.getUsername()+" "+nuser.getPwd());
		//verify with DB
		DBManager dbManager=new DBManager();
		if(dbManager.validateUser(nuser)==true)
		{
			//valid user.............redirect welcome.jsp
			//request.setAttribute("User",uname);//valid upto next page
			HttpSession session=request.getSession();
			session.setAttribute("User",nuser);//now we will use User which is valid upto whole session at any page
			ServletContext context=super.getServletContext();
			RequestDispatcher rd=context.getRequestDispatcher("/welcome.jsp");
			rd.forward(request, response);
		}
		else
		{
			//Invalid User.........redirect to error.jsp
			ServletContext context=super.getServletContext();
			RequestDispatcher rd=context.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
