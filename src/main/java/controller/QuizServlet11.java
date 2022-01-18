package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.QuizDAO;

/**
 * Servlet implementation class QuizServlet11
 */
@WebServlet("/QuizServlet11")
public class QuizServlet11 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuizServlet11() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		 System.out.println("dddjj");
			String id = request.getParameter("id");
			int id1=Integer.parseUnsignedInt(id);
			System.out.println(id1);
			QuizDAO quizDAO2 = new QuizDAO();
			try {
				quizDAO2.deleteQuiz(id1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("COMPONENTS/prof/lisQuiz.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		 System.out.println("dddjj");
		int id = Integer.parseInt(request.getParameter("id"));
		QuizDAO quizDAO2 = new QuizDAO();
		quizDAO2.deleteQuiz(id);
		response.sendRedirect("list");
	}
	
}
