package TP2.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

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
	public void supprimerLieu(int id) {
		int idLieu = id;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JEETP2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","test");
			String sql = "delete from Lieu where id = ? " ;
			PreparedStatement pst = con.prepareStatement(sql);//"insert into TP2 (id, theme, id_lieu) values(?,?,?)"
			System.out.println("updating records");
			pst.setInt(1,idLieu);
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
	public void selectLieu(int id) {
		int idLieu = id;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JEETP2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","test");
			Statement pst = (Statement) con.createStatement(); //"insert into TP2 (id, theme, id_lieu) values(?,?,?)"
			String sql = "select * from Lieu where id = "+idLieu ;
			ResultSet rs= ((java.sql.Statement) pst).executeQuery(sql);
			while (rs.next()) {
				System.out.println ("ID du lieu : " + rs.getInt(1));
				System.out.println ("Adresse : " + rs.getString(2));
				System.out.println ("Ville : " + rs.getInt(3));
			}
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
		//Exemple d'exécution
		//Lieu l2 = new Lieu(3, "Bd Ibn Tachefine", "Casablanca");
		LieuDao lieuDao = new LieuDao();
		//lieuDao.insererLieu(l2);
		//lieuDao.selectLieu(1);
		//lieuDao.modifierLieu(1,"Bd anfa","Temara");
		//lieuDao.supprimerLieu(1);
        
        }
}
