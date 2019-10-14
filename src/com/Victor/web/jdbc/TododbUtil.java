package com.Victor.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class TododbUtil {
private DataSource datasource;
public TododbUtil(DataSource datasource)
{
	this.setDatasource(datasource);
}
public DataSource getDatasource() {
	return datasource;
}
public void setDatasource(DataSource datasource) {
	this.datasource = datasource;
}
public List<Todo> getTodos() throws Exception {
	List<Todo> todos= new ArrayList<Todo>();
	Connection myConn=null;
	Statement myStmt = null;
	ResultSet myRs= null;
try {
	myConn = datasource.getConnection();
	myStmt= myConn.createStatement();
	String sql= "select * from todos";
	myRs = myStmt.executeQuery(sql);
	while(myRs.next())
	{
		int id = myRs.getInt("id");
		String content=myRs.getString("context");
		Todo tempTodo= new Todo(id,content);
		todos.add(tempTodo);
		}
	return todos;
		} 
finally{
	close(myConn,myStmt,myRs);
	}
}
public void AddTodo(Todo todo) {
	Connection myConn = null;
	PreparedStatement myStmt = null;
	ResultSet myRs= null;
	try {myConn = datasource.getConnection();
	String sql = "INSERT INTO todos (context) VALUES (?)";
	myStmt = myConn.prepareStatement(sql);    
	String content = todo.getContent();    
	myStmt.setString(1, content);
	myStmt.execute();} 
	catch(Exception e){System.out.println(e.getMessage());}
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

public Todo fetchtodo(int id) {
	Connection myConn=null;
	Statement myStmt = null;
	ResultSet myRs= null;
	Todo todo=null;
	try {
		myConn = datasource.getConnection();
		myStmt= myConn.createStatement();
		String sql= "select * from todos where id="+id;
		myRs = myStmt.executeQuery(sql);
		while(myRs.next()){
			String Content=myRs.getString("CONTEXT");
			todo = new Todo(id,Content);}
		return todo;
		}
	catch(Exception e){
		System.out.println(e.getMessage());
		return null;
} 
	finally{close(myConn,myStmt,myRs);}
	}
public void deletetodo(int id) {
	Connection myConn=null;
	Statement myStmt = null;
	ResultSet myRs= null;
	Todo todo=null;
	try {
		myConn = datasource.getConnection();
		myStmt= myConn.createStatement();
		String sql= "delete from todos where id="+id;
		myStmt.execute(sql);
	}
	catch(Exception e){System.out.println(e.getMessage());}
	finally{close(myConn,myStmt,myRs);}
}
public void updateTodo(Todo todo) {
	Connection myConn=null;
	PreparedStatement myStmt = null;
	try {
		myConn = datasource.getConnection();
		String sql = "update todos set context=? where id=?";
		myStmt = myConn.prepareStatement(sql);
		myStmt.setString(1,todo.getContent());
		myStmt.setInt(2,todo.getId());
		myStmt.execute();
		} 
	catch(Exception e){
		System.out.println(e.getMessage());
		}
	finally{
		close(myConn,myStmt,null);
		}
	}
}