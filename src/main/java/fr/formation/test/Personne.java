package fr.formation.test;

public class Personne {

	private String nom;
	private String prenom;
	private int age;
	
	
	public Personne(String nom, String prenom, int age){
		setNom(nom);
		setPrenom(prenom);
		setAge(age);
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
