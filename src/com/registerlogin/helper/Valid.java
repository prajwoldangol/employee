package com.registerlogin.helper;
import com.registerlogin.query.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpSession;

import com.registerlogin.model.Errors;

@WebFilter({"/login","/dologin"})
public class Valid implements Filter {

 
 

	public void destroy() {
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// db class
		DbQuery q 	= new DbQuery();
		//error msg list
		List<Errors> messages 	= new ArrayList<>();
		String email 	=  request.getParameter("username");
		String password	=  request.getParameter("password") ;
		
		if( email == null && password == null ) {
//			messages.add(new Errors("Enter Username/Password ")) ;
			RequestDispatcher disptacher 	= request.getRequestDispatcher("login.jsp");
			disptacher.forward(request,response);
			//return ;
		}
		boolean userexists = false ;
		try {
			userexists = q.isDuplicate("emp_email = ?", email);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean correctData = false;
		try {
			correctData = q.loginCheck(email, password);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		PrintWriter out = response.getWriter();
		
		if( userexists) {
			
			if( !correctData ) {
				messages.add(new Errors("Username/Password doesn't match")) ;
				request.setAttribute("error", messages);
				RequestDispatcher disptacher 	= request.getRequestDispatcher("login.jsp");
				disptacher.forward(request,response);
			}else {
				chain.doFilter(request, response);
			}
		}else {
			messages.add(new Errors("Enter Valid Username and Password "));
			request.setAttribute("error", messages);
			RequestDispatcher disptacher 	= request.getRequestDispatcher("login.jsp");
			disptacher.forward(request,response);
		}
		
		

	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
