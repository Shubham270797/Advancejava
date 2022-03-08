package com.java.miniproject.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.miniproject.db.DBManager;
import com.java.miniproject.pojo.Hobby;
import com.java.miniproject.pojo.User;

@WebServlet("/ViewHobby")
public class ViewHobby extends HttpServlet {
	@WebServlet("/ViewHobbyServlet")
	public class ViewHobbyServlet extends HttpServlet {
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session=request.getSession();
			User currentUser=(User)session.getAttribute("username");
			DBManager mgr=new DBManager();
			ArrayList<Hobby>al=mgr.viewHobby(currentUser);
			//PrintWriter pw=response.getWriter();
			 //ArrayList<String> al=( ArrayList)session.getAttribute("list");
			/*
			for( Hobby a:al)
			 {
				 System.out.println(a);
			 }*/
				
			//request forward
			session.setAttribute("list", al);
			ServletContext cx=super.getServletContext();
			RequestDispatcher rd=cx.getRequestDispatcher("/viewHobby1.jsp");
			rd.forward(request, response);
			
			
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}

}
}