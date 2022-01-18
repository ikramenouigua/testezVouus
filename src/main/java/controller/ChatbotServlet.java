package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuizDAO;
import model.Quiz;

/**
 * Servlet implementation class ChatbotServlet
 */
@WebServlet("/ChatbotServlet")
public class ChatbotServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatbotServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String lang = request.getParameter("rep");
	    System.out.println(lang);
	    String niv = request.getParameter("niv");
	    System.out.println(niv);
	    QuizDAO quizDAO2 = new QuizDAO();
		List<Quiz> listquiz = quizDAO2.selectQuizChatbot(lang,niv);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("COMPONENTS/etudiant/quizs.jsp");
		request.setAttribute("listquiz", listquiz);
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
