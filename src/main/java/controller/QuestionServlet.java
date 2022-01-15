package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.QuestionDAO;
import dao.QuizDAO;
import model.Question;

/**
 * Servlet implementation class QuestionServlet
 */
@WebServlet("/QuestionServlet")
public class QuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		QuestionDAO quizDAO2 = new QuestionDAO();
		List<Question> qsts=quizDAO2.selectQuestions(id);
		String[][] tab= new String[8][5];
		Iterator<Question> iter = qsts.iterator();
		int j=0;
		while(iter.hasNext()){
        	Question qst = iter.next();
        	tab[j][0]=qst.getQuestion();
        	tab[j][1]=qst.getChoix1();
        	tab[j][2]=qst.getChoix2();
        	tab[j][3]=qst.getChoix3();
        	tab[j][4]=qst.getReponse();
        	j++;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("COMPONENTS/etudiant/qstt.jsp");
		request.setAttribute("qsts", qsts);
		request.setAttribute("tab", tab);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);  
		
		int id=(int) session.getAttribute("quiz");
		System.out.println(id);
		String qst1 = request.getParameter("qst1");
		
		String choix1_1 = request.getParameter("choix1_1");
		String choix1_2 = request.getParameter("choix1_2");
		String choix1_3 = request.getParameter("choix1_3");
		String rep1 = request.getParameter("rep1");
		int x=6;
		Question newQst1 = new Question(qst1,choix1_1,choix1_2,choix1_3,rep1,id);
		
		String qst2 = request.getParameter("qst2");
		System.out.println("sujet");
		String choix2_1 = request.getParameter("choix2_1");
		String choix2_2 = request.getParameter("choix2_2");
		String choix2_3 = request.getParameter("choix2_3");
		String rep2 = request.getParameter("rep2");
		Question newQst2 = new Question(qst2,choix2_1,choix2_2,choix2_3,rep2,id);
		
		
		String qst3 = request.getParameter("qst3");
		System.out.println("sujet");
		String choix3_1 = request.getParameter("choix3_1");
		String choix3_2 = request.getParameter("choix3_2");
		String choix3_3 = request.getParameter("choix3_3");
		String rep3 = request.getParameter("rep3");
		Question newQst3 = new Question(qst3,choix3_1,choix3_2,choix3_3,rep3,id);
		
		
		String qst4 = request.getParameter("qst4");
		System.out.println("sujet");
		String choix4_1 = request.getParameter("choix4_1");
		String choix4_2 = request.getParameter("choix4_2");
		String choix4_3 = request.getParameter("choix4_3");
		String rep4 = request.getParameter("rep4");
		Question newQst4 = new Question(qst4,choix4_1,choix4_2,choix4_3,rep4,id);
		
		String qst5 = request.getParameter("qst3");
		System.out.println("sujet");
		String choix5_1 = request.getParameter("choix5_1");
		String choix5_2 = request.getParameter("choix5_2");
		String choix5_3 = request.getParameter("choix5_3");
		String rep5 = request.getParameter("rep5");
		Question newQst5 = new Question(qst5,choix5_1,choix5_2,choix5_3,rep5,id);
		
		String qst6 = request.getParameter("qst6");
		System.out.println("sujet");
		String choix6_1 = request.getParameter("choix6_1");
		String choix6_2 = request.getParameter("choix6_2");
		String choix6_3 = request.getParameter("choix6_3");
		String rep6 = request.getParameter("rep6");
		Question newQst6 = new Question(qst6,choix6_1,choix6_2,choix6_3,rep6,id);
		
		String qst7 = request.getParameter("qst7");
		System.out.println("sujet");
		String choix7_1 = request.getParameter("choix7_1");
		String choix7_2 = request.getParameter("choix7_2");
		String choix7_3 = request.getParameter("choix7_3");
		String rep7 = request.getParameter("rep7");
		Question newQst7 = new Question(qst7,choix7_1,choix7_2,choix7_3,rep7,id);
		
		String qst8 = request.getParameter("qst8");
		System.out.println("sujet");
		String choix8_1 = request.getParameter("choix8_1");
		String choix8_2 = request.getParameter("choix8_2");
		String choix8_3 = request.getParameter("choix8_3");
		String rep8 = request.getParameter("rep8");
		Question newQst8 = new Question(qst8,choix8_1,choix8_2,choix8_3,rep8,id);
		
		QuestionDAO questionDAO2 = new QuestionDAO();
		try {
			questionDAO2.insertQuestion(newQst1);
			questionDAO2.insertQuestion(newQst2);
			questionDAO2.insertQuestion(newQst3);
			questionDAO2.insertQuestion(newQst4);
			questionDAO2.insertQuestion(newQst5);
			questionDAO2.insertQuestion(newQst6);
			questionDAO2.insertQuestion(newQst7);
			questionDAO2.insertQuestion(newQst8);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
