package com.registerlogin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.registerlogin.model.Employee;
import com.registerlogin.model.Errors;
import com.registerlogin.query.DbQuery;
import com.registerlogin.helper.ValidateData;

/**
 * Servlet implementation class EmployeController
 */
//@WebServlet("/register")

@WebServlet({"/login","/register","/logout","/userportal","/doregister","/dologin"})
public class EmployeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DbQuery query ;
//	private Errors error ;
	//	public PrintWriter out ;
	@Override
	public void init() {

		query 	= new DbQuery() ;
//		error	= new Errors();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String process 	= request.getServletPath();
		PrintWriter out = response.getWriter();


//		PrintWriter out = response.getWriter();
		
//				out.print(q);
		String url = getDomain(request);
		request.setAttribute("url", url);
		switch(process) {
		case "/userportal":
			try {
				showPortal(request,response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			break;
		case "/register":
			registerForm(request,response);
			break;
		case "/doregister":
			
			try {
				doRegister(request,response);
			} catch (ClassNotFoundException | ServletException | IOException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			break;
		case "/login":
			loginForm(request,response);
			break;
		case "/dologin" :
			try {
				doLogin(request,response) ;
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break ;
		case "/logout" :
			doLogout(request,response);
			break ;
		default:
			try {
				displayHome(request,response);
			} catch (ClassNotFoundException | SQLException | IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;

		}
	}

	private void doLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		
//		HttpSession session = request.getSession();
		if(request.getSession() != null ) {
			request.getSession().invalidate();
		}
//		session.invalidate();
		
		response.sendRedirect(getDomain(request)+"/login");
	}
	private void showPortal(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		HttpSession session 	= request.getSession();
		Object user		= session.getAttribute("user") ;
		//String filter  = request.getParameter("filter");
		List<Errors> messages 	= new ArrayList<>();
		RequestDispatcher dispatcher;
		if( user == null ) {
			messages.add(new Errors("You Must Login First"));
			request.setAttribute("error", messages);
//			response.sendRedirect(getDomain(request)+"/login");
			 dispatcher = request.getRequestDispatcher("login.jsp");
//			dispatcher.forward(request,response);
//			return;
		}else {
			
			List <Employee> em 	= query.getAll() ;
			Iterator <Employee> itr = em.iterator();
			try {
				String filter  = request.getParameter("filter");
				if(ValidateData.isValidNum(filter) && filter != null ) {
					
					while(itr.hasNext()) {
						Employee emps = itr.next() ;
						if( Integer.parseInt(emps.getIncome()) < Integer.parseInt(filter) ) {
							itr.remove();
						}
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			finally {
				
				request.setAttribute("employee", em);
				dispatcher = request.getRequestDispatcher("userportal.jsp");
			}
			
		}
		dispatcher.forward(request,response);
	}
	
	private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, ServletException, IOException {
		// TODO Auto-generated method stub
		String email 	=  request.getParameter("username");
		String password	=  request.getParameter("password") ;
		boolean userexists 		= query.isDuplicate("emp_email = ?", email);
		boolean correctData		= query.loginCheck(email, password) ;
		List<Errors> messages 	= new ArrayList<>();
//		PrintWriter out = response.getWriter();
		
		if( userexists) {
			
			if( !correctData ) {
				messages.add(new Errors("Username/Password doesn't match")) ;
				request.setAttribute("error", messages);
				loginForm(request,response);
			}else {
				HttpSession session 	= request.getSession(true);
				session.setAttribute("user", "loggedin");
				response.sendRedirect(getDomain(request)+"/userportal");
			}
		}else {
			messages.add(new Errors("Username Doesn't Exists"));
			request.setAttribute("error", messages);
			loginForm(request,response);
		}
		
//		
//		if(userexists && correctData) {
//			response.sendRedirect(getDomain(request)+"/userportal");
//		}else {
//			request.setAttribute("error", messages);
//			loginForm(request,response);
//			return ;
//		}
		
		
	}
	private void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// b

		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request,response);

	}
	private void displayHome(HttpServletRequest request, HttpServletResponse response) throws ClassNotFoundException, SQLException, IOException, ServletException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("welcome.jsp");
		dispatcher.forward(request,response);
	}
	private void doRegister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		String phone 		= request.getParameter("phone") ;
		String income		= request.getParameter("income");
		String email		= request.getParameter("email") ;
		String name			= request.getParameter("name");
		String ssn			= request.getParameter("ssn");
		String bank			= request.getParameter("bank");
		String qualification			= request.getParameter("qualification");
		boolean emailexists 		= query.isDuplicate("emp_email = ?", email);
		boolean salary = false;
		List <String> formdata 	= new ArrayList<>();
		//setting arraylist of errors
		List<Errors> messages 	= new ArrayList<>();
		if( ValidateData.isValidNum(income)) {
			
			if(! ValidateData.isGreaterThan(Integer.parseInt(income), 5000)){
				messages.add(new Errors("Salary should be greater than 5000"));
			}else {
				salary= true;
			}
		}else {
			messages.add(new Errors("Income Should be number"));
		}
		if(emailexists) {
			messages.add(new Errors("Email Already Exists"));
			
		}
		if(! ValidateData.isValidPhoneNum(phone)) {
			messages.add(new Errors("Invalid phone number "));
		}
			
		if(! emailexists && ValidateData.isValidPhoneNum(phone) &&  salary ) {
			
		Employee emp 	= new Employee(name,request.getParameter("password"),ssn,email,phone,bank,qualification,income);

		query.insert(emp);
		response.sendRedirect(getDomain(request)+"/login");
		}else {
			formdata.add( name) ;
			formdata.add( ssn) ;
			formdata.add(email) ;
			formdata.add( phone) ;
			formdata.add( bank) ;
			formdata.add( qualification) ;
			formdata.add( income) ;
			request.setAttribute("formdata", formdata);
			request.setAttribute("error", messages);
			registerForm(request,response);
		}
		
	}
	



	private void registerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


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
