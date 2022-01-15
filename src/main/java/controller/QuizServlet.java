package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Quiz;
import model.User;
import dao.QuizDAO;



/**
 * Servlet implementation class QuizServlet
 */
@WebServlet("/QuizServlet")
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private QuizDAO quizDAO;
	
public void init() {
		quizDAO = new QuizDAO();
}
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		QuizDAO quizDAO2 = new QuizDAO();
		HttpSession ses= request.getSession(true);
		String email=(String) ses.getAttribute("email");
		List<Quiz> listquiz = quizDAO2.selectQuiz(email);
		
		request.getSession().setAttribute("listquiz", listquiz);
	    response.sendRedirect("COMPONENTS/prof/dashboard.jsp");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sujet = request.getParameter("sujet");
		System.out.println("sujet");
		System.out.println(sujet);
		String desc = request.getParameter("desc");
		String niveau = request.getParameter("niveau");
		System.out.println(niveau);
		System.out.println(desc);
		int x;
		HttpSession ses= request.getSession(true);
		String email=(String) ses.getAttribute("email");
		System.out.println("ha huwa email"+email);
		Quiz newQuiz = new Quiz(sujet, desc,niveau,email);
		
		
		QuizDAO quizDAO2 = new QuizDAO();
		try {
			quizDAO2.insertQuiz(newQuiz);
		    x=quizDAO2.searchQuiz(sujet, desc);
		    ses.setAttribute("quiz", x);
		    System.out.println(x);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 response.sendRedirect("COMPONENTS/prof/niveau.jsp");
		

	}
	
}
