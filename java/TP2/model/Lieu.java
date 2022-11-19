package TP2.model;

public class Lieu {
	private int id;
	private String adresse;
	private String ville;
	public Lieu(int id, String adresse, String ville) {
		this.setId(id);
		this.setAdresse(adresse);
		this.setVille(ville);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	@Override
	public String toString() {
		return id +" " +adresse+ " " +ville ;
	}

}
