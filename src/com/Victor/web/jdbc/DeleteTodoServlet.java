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
 * Servlet implementation class DeleteTodoServlet
 */
@WebServlet("/DeleteTodoServlet")
public class DeleteTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TododbUtil tododbutil;
    @Resource(name="jdbc/todolist")
    private DataSource datasource;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public void init() throws ServletException{
    	super.init();
    	tododbutil = new TododbUtil(datasource);
    }
    public DeleteTodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int id = Integer.parseInt(request.getParameter("id"));
		String role = request.getParameter("role");
		String username = request.getParameter("username");
		HttpSession session = request.getSession();
		session.setAttribute("role", role);
		session.setAttribute("username", username);
		tododbutil.deletetodo(id);
		response.sendRedirect("TodoControllerServlet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
