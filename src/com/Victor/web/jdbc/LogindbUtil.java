package com.Victor.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class LogindbUtil {
	
	private DataSource datasource;
	
	public LogindbUtil(DataSource datasource)
	{
		this.setDatasource(datasource);
	}
	public DataSource getDatasource() {
		return datasource;
	}
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
	public Boolean tryLogin(Login login) throws Exception {
		Boolean logged = false;
		
		Connection myConn=null;
		Statement myStmt = null;
		ResultSet myRs= null;
		try {
			myConn = datasource.getConnection();
			myStmt= myConn.createStatement();
			String sql= "select password from users where username='"+login.getUsername()+"'";
			myRs = myStmt.executeQuery(sql);
			myRs.next();
			String password=myRs.getString("password");
			System.out.println("Retrieved : " +password + "\nEntered : " + login.getPassword());
			return (password.equals(login.getPassword()));
		}
		catch(Exception e)
			{
			System.out.println(e.getMessage());
			return null;
			} 
		finally{close(myConn,myStmt,myRs);}
		}	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try
		{
			if(myStmt!=null)myStmt.close();
			if(myRs!=null)myRs.close();
			if(myConn!=null)myConn.close();
			}
		catch(Exception e)
		{System.out.println(e.getMessage());
		}
		}
}