package TP2.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import TP2.model.Formateur;

public class FormateurDao {
	public FormateurDao() {
		
	}
	public void insererFormateur(Formateur f) {
		String idCIN = f.getCIN();
		String nom = f.getNom();
		int age = f.getAge();
		//int idLieu = f.getIdLieu();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JEETP2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","test");
			String sql = " insert into formateur (CIN, nom, age)" + "values (?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);//"insert into TP2 (id, theme, id_lieu) values(?,?,?)"
			System.out.println("inserting records");
			pst.setString(1,idCIN);
			pst.setString(2,nom);
			pst.setInt(3,age);
			//pst.setInt(3,idLieu);
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
	public void modifierFormateur(String newCIN, String newName,int newAge) {
		String CIN = newCIN;
		String name = newName;
		int age = newAge;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JEETP2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","test");
			String sql = "update formateur set nom = ?, age = ? where CIN = ? " ;
			PreparedStatement pst = con.prepareStatement(sql);//"insert into TP2 (id, theme, id_lieu) values(?,?,?)"
			System.out.println("updating records");
			pst.setString(1,name);
			pst.setInt(2,age);
			pst.setString(3,CIN);
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
	public void supprimerFormateur(String deleteCIN) {
		String CIN = deleteCIN;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JEETP2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","test");
			String sql = "delete from Formateur where CIN = ? " ;
			PreparedStatement pst = con.prepareStatement(sql);//"insert into TP2 (id, theme, id_lieu) values(?,?,?)"
			System.out.println("updating records");
			pst.setString(1,CIN);
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
		
        Formateur f1 = new Formateur("BJ472110","Nizar EL AOUINA", 21);
        FormateurDao dao = new FormateurDao(); //Instanciation de la classe FormationDao
        //dao.modifierFormateur("BJ472110","Zaineb EL AOUINA",23);
        dao.insererFormateur(f1);
        //dao.supprimerFormateur("BJ472110");
        }

}
