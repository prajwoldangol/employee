package com.registerlogin.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.registerlogin.model.Employee;

public class DbQuery {
	
	
	private static String dbuser	= "root";
	private static String dbpass	= "root";
	private static String dburl		= "jdbc:mysql:// localhost:3306/";
	private static String dbname	= "employees" ;

	
	protected static Connection getInstance() throws SQLException, ClassNotFoundException {
			Connection c = null;
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				c	= DriverManager.getConnection(dburl+dbname,dbuser,dbpass);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			return c;
	}
	
	
	
	
	public void insert( Employee emp) throws ClassNotFoundException, SQLException {
		
		try{
			String table_fields = "emp_name,emp_password,emp_ssn,emp_email,emp_phone,emp_bank,emp_qualification,emp_income";
			
			Connection con = getInstance();
			PreparedStatement st 	= con.prepareStatement("insert into emp_details ("+table_fields+") values (?,?,?,?,?,?,?,?)" );

			st.setString(1, emp.getName());
			st.setString(2, emp.getPassword());
			st.setString(3, emp.getSsn());
			st.setString(4, emp.getEmail());
			st.setString(5, emp.getPhone());
			st.setString(6, emp.getBank());
			st.setString(7, emp.getQualification());
			st.setString(8, emp.getIncome());
			st.executeUpdate();
	
			st.close();
			con.close();
			
			
		}catch( Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	public boolean isDuplicate(String params, String value) throws ClassNotFoundException, SQLException {

		String q = "select emp_email from emp_details where " + params ;
		Connection con = getInstance();
		PreparedStatement st 	= con.prepareStatement(q);
		st.setString(1, value);
		ResultSet rs = st.executeQuery();

		return rs.next();
		
	}
	public boolean loginCheck(String username, String password) throws ClassNotFoundException, SQLException {
		
		String query = "select emp_email,emp_password from emp_details where emp_email = ? " ;
		Connection con = getInstance();
		PreparedStatement ps 	= con.prepareStatement(query);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		boolean matched = false ;
		while(rs.next()) {
			
			if(rs.getString("emp_email").equals(username) && rs.getString("emp_password").equals(password)) {
				
				matched = true ;
			}
		}
		
		return matched ;
	}

}
