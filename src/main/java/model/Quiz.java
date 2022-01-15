package model;

public class Quiz {
	private int id;
	private String sujet;
	private String description;
	private String Niveau;
	private String emailuser;
	
	

	public Quiz(int id, String sujet, String description, String niveau, String emailuser) {
		super();
		this.id = id;
		this.sujet = sujet;
		this.description = description;
		Niveau = niveau;
		this.emailuser = emailuser;
	}

	
	public Quiz(String sujet, String description, String niveau, String emailuser) {
		super();
		this.sujet = sujet;
		this.description = description;
		Niveau = niveau;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getNiveau() {
		return Niveau;
	}


	public void setNiveau(String niveau) {
		Niveau = niveau;
	}


	public String getEmailuser() {
		return emailuser;
	}


	public void setEmailuser(String emailuser) {
		this.emailuser = emailuser;
	}
	
	
	
}
