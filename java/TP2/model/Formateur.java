package TP2.model;

public class Formateur {
	private String CIN;
	private String nom;
	private int age;
	
	public Formateur(String CIN, String nom, int age) {
		this.CIN=CIN;
		this.nom=nom;
		this.age=age;
	}

	public String getCIN() {
		return CIN;
	}

	public void setCIN(String cIN) {
		CIN = cIN;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return CIN +" " + " " +nom + " " +age + "ans";
	}
}
