package com.registerlogin.query;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			String table_fields = "emp_name,emp_password,emp_ssn,emp_email,emp_phone,emp_bank";
			// splitting returns array of table Fields
			String[] field = table_fields.split(",");
			String capitalized = "";
			Connection con = getInstance();
			PreparedStatement st 	= con.prepareStatement("insert into employees ("+table_fields+") values (?,?,?,?,?,?,?,?)" );
			
			// loop from array fields
			for(int i=0; i< field.length; i++) {
				// get string after _
				capitalized =  field[i].substring(field[i].lastIndexOf("_") + 1);
				// capitalize first letter of string and set the query parameters
				st.setString(i+1,"get"+capitalized.substring(0, 1).toUpperCase() + capitalized.substring(1)+"()");
				
			}
			st.executeUpdate();
			st.close();
			con.close();
			
			
		}catch( Exception e ) {
			e.printStackTrace();
		}
		
	}

}
