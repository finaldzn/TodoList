package com.Victor.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * Servlet implementation class editTodo
 */
@WebServlet("/editTodo")
public class editTodo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TododbUtil TodoDbUtil;
	@Resource(name="jdbc/todolist")
	private DataSource dataSource;
	int id;   
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() throws ServletException {
		super.init();
		TodoDbUtil = new TododbUtil(dataSource);
		}
    public editTodo() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		id=Integer.parseInt(request.getParameter("id"));
		String role="";
		String username="";
		
		try
		{
		role = request.getParameter("role");
		username = request.getParameter("username");
		}
		catch(Exception e)
		{
			request.getRequestDispatcher("/add-todo.jsp").forward(request,response);
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("role", role);
		session.setAttribute("username", username);
		Todo todo= TodoDbUtil.fetchtodo(id);
		request.setAttribute("Todo", todo);
		request.getRequestDispatcher("edit-todo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String content= request.getParameter("content");
		Todo todo = new Todo(id,content);
		TodoDbUtil.updateTodo(todo);
		response.sendRedirect("TodoControllerServlet");}
	

}
