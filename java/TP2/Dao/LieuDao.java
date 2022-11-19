package TP2.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import TP2.model.Lieu;

public class LieuDao {

	public LieuDao() {
		
	}
	public void insererLieu(Lieu l) {
		int idLieu= l.getId();
		String adresse = l.getAdresse();
		String ville = l.getVille();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JEETP2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","test");
			String sql = " insert into lieu (id, adresse, ville)" + "values (?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);//"insert into TP2 (id, theme, id_lieu) values(?,?,?)"
			System.out.println("inserting records");
			pst.setInt(1,idLieu);
			pst.setString(2,adresse);
			pst.setString(3,ville);
			pst.execute();
			con.close();
		}  catch (Exception e)
		  {
			  System.err.println("Got an exception!");
			  // printStackTrace method 
			  // prints line numbers + call stack
			  e.printStackTrace();
			  // Prints what exception has been thrown 
			  System.out.println(e); 
			  }
	}
	public void modifierLieu(int id, String newAdress, String newVille) {
		int idLieu = id;
		String adresse = newAdress;
		String ville = newVille;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JEETP2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","test");
			String sql = "update lieu set adresse = ?, ville = ? where id = ? " ;
			PreparedStatement pst = con.prepareStatement(sql);//"insert into TP2 (id, theme, id_lieu) values(?,?,?)"
			System.out.println("updating records");
			pst.setString(1,adresse);
			pst.setString(2,ville);
			pst.setInt(3,idLieu);
			pst.execute();
			con.close();
			
		}catch(Exception e){
			System.err.println("Got an exception!");
			  // printStackTrace method 
			  // prints line numbers + call stack
			  e.printStackTrace();
			  // Prints what exception has been thrown 
			  System.out.println(e); 
		}
		
	}
	public static void main(String[] args) {
		//Lieu l1 = new Lieu(1, "Agdal", "Rabat");
		LieuDao lieuDao = new LieuDao();
		//lieuDao.insererLieu(l1);
		lieuDao.modifierLieu(1,"Bd anfa","Temara");
        
        }
}
