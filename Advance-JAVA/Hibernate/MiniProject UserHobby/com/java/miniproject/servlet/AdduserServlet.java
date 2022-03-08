package com.java.miniproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.miniproject.db.DBManager;
import com.java.miniproject.pojo.User;

@WebServlet("/AdduserServlet")
public class AdduserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User nuser=new User();
		
		//fetch data coming from html/jsp
		nuser.setFname(request.getParameter("firstName"));
	nuser.setLname(request.getParameter("lastName"));
	nuser.setEmailID(request.getParameter("email"));
	nuser.setMobileNo(request.getParameter("moNumber"));
	nuser.setUsername(request.getParameter("userName"));
	nuser.setPwd(request.getParameter("pwd"));
	
	
	DBManager db=new DBManager();
	db.addUser(nuser);
	
	
	
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
