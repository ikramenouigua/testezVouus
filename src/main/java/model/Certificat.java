package model;

public class Certificat {
  private int id;
  private String sujet;
  private String niveau_quiz;
  private int idQuiz;
  private String emailuser;
  
public Certificat(int id, String sujet, String niveau_quiz, int idQuiz, String emailuser) {
	super();
	this.id = id;
	this.sujet = sujet;
	this.niveau_quiz = niveau_quiz;
	this.idQuiz = idQuiz;
	this.emailuser = emailuser;
}

public Certificat(String sujet, String niveau_quiz, int idQuiz, String emailuser) {
	super();
	this.sujet = sujet;
	this.niveau_quiz = niveau_quiz;
	this.idQuiz = idQuiz;
	this.emailuser = emailuser;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getSujet() {
	return sujet;
}

public void setSujet(String sujet) {
	this.sujet = sujet;
}

public String getNiveau_quiz() {
	return niveau_quiz;
}

public void setNiveau_quiz(String niveau_quiz) {
	this.niveau_quiz = niveau_quiz;
}

public int getIdQuiz() {
	return idQuiz;
}

public void setIdQuiz(int idQuiz) {
	this.idQuiz = idQuiz;
}

public String getEmailuser() {
	return emailuser;
}

public void setEmailuser(String emailuser) {
	this.emailuser = emailuser;
}
  
  
}
