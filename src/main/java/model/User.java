package model;

public class User {
  private int id;
  private String nom;
  private String email;
  private String mot_de_passe;
  private String role;
  


public User(int id, String nom, String email, String mot_de_passe, String role) {
	super();
	this.id = id;
	this.nom = nom;
	this.email = email;
	this.mot_de_passe = mot_de_passe;
	this.role = role;
}

public User(String nom, String email, String mot_de_passe, String role) {
	super();
	this.nom = nom;
	this.email = email;
	this.mot_de_passe = mot_de_passe;
	this.role = role;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getMot_de_passe() {
	return mot_de_passe;
}

public void setMot_de_passe(String mot_de_passe) {
	this.mot_de_passe = mot_de_passe;
}

public String getRole() {
	return role;
}

public void setRole(String role) {
	this.role = role;
}
  

 
}
