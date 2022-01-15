package model;

public class Question {
	private int id;
	private String question;
	private String choix1;
	private String choix2;
	private String choix3;
	private String reponse;
	
	private int idQuiz ;
	

	public Question(int id, String question, String choix1, String choix2, String choix3, String reponse
			) {
		super();
		this.id = id;
		this.question = question;
		this.choix1 = choix1;
		this.choix2 = choix2;
		this.choix3 = choix3;
		this.reponse = reponse;
		
	}
	
	public Question(String question, String choix1, String choix2, String choix3, String reponse,
			 int idQuiz) {
		super();
		this.question = question;
		this.choix1 = choix1;
		this.choix2 = choix2;
		this.choix3 = choix3;
		this.reponse = reponse;
		
		this.idQuiz = idQuiz;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getChoix1() {
		return choix1;
	}

	public void setChoix1(String choix1) {
		this.choix1 = choix1;
	}

	public String getChoix2() {
		return choix2;
	}

	public void setChoix2(String choix2) {
		this.choix2 = choix2;
	}

	public String getChoix3() {
		return choix3;
	}

	public void setChoix3(String choix3) {
		this.choix3 = choix3;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public int getIdQuiz() {
		return idQuiz;
	}

	public void setIdQuiz(int idQuiz) {
		this.idQuiz = idQuiz;
	}


	
	
	
}
