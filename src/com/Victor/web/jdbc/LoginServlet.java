package com.Victor.web.jdbc;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LogindbUtil logindbUtil;
	
	@Resource(name="jdbc/todolist")  
	private DataSource datasource;
	@Override
	public void init() throws ServletException{
        super.init();
        logindbUtil = new LogindbUtil(datasource);
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Login login = new Login(username,password);
		Boolean logged = false;
		try {
			logged = logindbUtil.tryLogin(login);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		if (logged==null || logged==false)
		{
			request.getRequestDispatcher("/login_failed.jsp").forward(request, response);
		}
		else
		{
			int role = -1;
			try {
				role = logindbUtil.retrieveRole(login);
			} 
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(role==0)
			{
			    response.sendRedirect("http://localhost:8080/TodoList/TodoControllerServlet");
			}
			else if(role==1)
			{
			    response.sendRedirect("http://localhost:8080/TodoList/TodoControllerStudentServlet");
			}
			else
			{
				System.out.print("CONNECTION FAILED");
			}
		}
	}

}
