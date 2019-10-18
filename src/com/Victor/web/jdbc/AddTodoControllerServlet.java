package com.Victor.web.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddTodoControllerServlet
 */
@WebServlet("/AddTodoControllerServlet")
public class AddTodoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTodoControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
		if(role==null || username==null) request.getRequestDispatcher("/login.jsp").forward(request,response);
		
		HttpSession session = request.getSession();
		session.setAttribute("role", role);
		session.setAttribute("username", username);
		request.getRequestDispatcher("/add-todo.jsp").forward(request,response);
	}

}
