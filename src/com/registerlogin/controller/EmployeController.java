package com.registerlogin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeController
 */
//@WebServlet("/register")

@WebServlet(urlPatterns = {"/login","/register","/logout"})
public class EmployeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String process 	= request.getServletPath();
		PrintWriter out = response.getWriter();
		out.print(process);
		String url = getDomain(request);
		request.setAttribute("url", url);
		switch(process) {
		
		case "/register":
			doRegister(request,response);
			break;
		case "/login":
			out.print("I AM LOGIN");
//		default:
//			response.sendRedirect(url);
//			break;
			
		}
	}

	private void displayHome(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
			RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request,response);
	
		
	}
	public static String getDomain(HttpServletRequest request) {
		return request.getScheme()+"://"+ request.getServerName()+":"+request.getServerPort()+request.getContextPath() ;
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
