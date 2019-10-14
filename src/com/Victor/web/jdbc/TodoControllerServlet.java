package com.Victor.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class UserControllerServlet
 */
@WebServlet(name = "TodoControllerServlet", urlPatterns = { "/TodoControllerServlet" })
public class TodoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TododbUtil tododbUtil;
	
	@Resource(name="jdbc/todolist")
	private DataSource datasource;
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		tododbUtil = new TododbUtil(datasource);
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			listTodos(request,response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	private void listTodos(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		List<Todo> todos = tododbUtil.getTodos();
		request.setAttribute("TODOS_LIST", todos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-todo.jsp");
		dispatcher.forward(request, response);
	}
	protected void   doPost(HttpServletRequest   req,HttpServletResponse   resp)   throws ServletException, IOException 
	{
	String content= req.getParameter("content");
	Todo todo = new Todo(content);
	tododbUtil.AddTodo(todo);
	try {listTodos(req,resp);} 
	catch (Exception e) {e.printStackTrace();}
	}
}
