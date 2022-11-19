package TP2.model;

public class LigneFormationFormateur {
	public int id;
	public String CIN;
	public Formation formation;
	public Formateur formateur;
	
	public LigneFormationFormateur(Formation f1, Formateur f2) {
		this.formation = f1;
		this.formateur = f2;
		this.id = formation.getId();
		this.CIN = formateur.getCIN();
	}
	/*public int idSetter() {
		this.id = formation.getId();		
		return this.id;
	}
	public String CINSetter() {
		this.CIN = formateur.getCIN();		
		return this.CIN;
	}*/
	@Override
	public String toString() {
		return CIN +" " + " " +id ;
	}/*
	 public static void main(String[] args) {
	        Formateur f11 = new Formateur("BJ2341", "Nizar", 21);
	        Lieu l1 = new Lieu(4, "Tachefine", "Casa");
	        Formation f22 = new Formation(1, "CS", l1);
	        System.out.println(f11.toString());
	        System.out.println(f22.toString());
	        LigneFormationFormateur jointure = new LigneFormationFormateur(f22, f11);
	        System.out.println(jointure.toString());
	        System.out.println(l1.toString());
	        l1.setId(5);
	        System.out.println(l1.toString());
	        System.out.println(f22.toString());
	        }*/
}
