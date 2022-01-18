package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;

import dao.CertificatDAO;
import dao.QuestionDAO;
import dao.QuizDAO;
import dao.UserDAO;
import model.Certificat;
import model.Question;
import model.Quiz;
import model.User;

/**
 * Servlet implementation class CertificatServlet
 */
@WebServlet("/CertificatServlet")
public class CertificatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CertificatServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws SQLException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        //Set content type to application / pdf
        //browser will open the document only if this is set
        response.setContentType("application/pdf");
        //Get the output stream for writing PDF object        
        ServletOutputStream out=response.getOutputStream();
        try {
            Document document = new Document();
            /* Basic PDF Creation inside servlet */
            PdfWriter.getInstance(document, out);
            document.open();
            HttpSession ses= request.getSession(true);
    		String email=(String) ses.getAttribute("email");
    		int id= (int) ses.getAttribute("idQuiz");
    		QuizDAO quizDAO2 = new QuizDAO();
    		Quiz quiz=quizDAO2.selectQuiz(id);
    		String nom=(String) ses.getAttribute("nom");
    		Paragraph p=new Paragraph("Certificat de formation");

    	    p.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(p);
            document.add(new Paragraph(nom));
            document.add(new Paragraph("a terminé avec succès le cours en démontrant "));
            document.add(new Paragraph("une compréhension théorique de language"));
            document.add(new Paragraph(quiz.getSujet()));
            document.add(new Paragraph("Niveau :"+quiz.getNiveau()));
            document.close();
            
            Certificat newcert = new Certificat(quiz.getSujet(),quiz.getNiveau(),id,email);
    		
    		
            CertificatDAO CertificatDAO2 = new CertificatDAO();
    		try {
    			CertificatDAO2.insertCertificat(newcert); 
    			
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        }
                catch (DocumentException exc){
                throw new IOException(exc.getMessage());
                }
        finally {            
            out.close();
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
			processRequest(request, response);
		} catch (ServletException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
