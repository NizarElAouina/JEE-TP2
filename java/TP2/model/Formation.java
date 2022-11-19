package TP2.model;

public class Formation {
	private int id;
	private String theme;
	private int id_lieu;
	public Formation(int id, String theme, Lieu id_lieu) {
		this.id = id;
		this.theme = theme;
		this.id_lieu = id_lieu.getId();
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}
	public int getIdLieu() {
		return id_lieu;
	}
	@Override
	public String toString() {
		return id +" " + " " + theme + " " + id_lieu;
	}
}
