package TP2.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import javax.sql.DataSource;

import com.mysql.cj.xdevapi.Statement;

import TP2.model.Formateur;
import TP2.model.Formation;
import TP2.model.Lieu;
import TP2.model.LigneFormationFormateur;
import jakarta.servlet.RequestDispatcher;

public class FormationDao {
	private Formation f;
	public FormationDao(){
		
	}
	
	public void insererFormation (Formation f) {
		int idFormation = f.getId();
		String theme = f.getTheme();
		int idLieu = f.getIdLieu();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JEETP2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","test");
			String sql = " insert into TP2 (id, theme, id_lieu)" + "values (?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);//"insert into TP2 (id, theme, id_lieu) values(?,?,?)"
			System.out.println("inserting records");
			pst.setInt(1,idFormation);
			pst.setString(2,theme);
			pst.setInt(3,idLieu);
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
	public void modifierThemeFormation(int id, String theme1) {
		int idFormation = id;
		String theme = theme1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JEETP2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","test");
			String sql = "update TP2 set theme = ? where id = ? " ;
			PreparedStatement pst = con.prepareStatement(sql);//"insert into TP2 (id, theme, id_lieu) values(?,?,?)"
			System.out.println("updating records");
			pst.setString(1,theme);
			pst.setInt(2,idFormation);
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
	public void modifierLieuFormation(int id, int idLieu2) {
		int idFormation = id;
		int idLieu = idLieu2;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JEETP2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","test");
			String sql = "update TP2 set id_lieu = ? where id = ? " ;
			PreparedStatement pst = con.prepareStatement(sql);//"insert into TP2 (id, theme, id_lieu) values(?,?,?)"
			System.out.println("updating records");
			pst.setInt(1,idLieu);
			pst.setInt(2,idFormation);
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
	public void supprimerFormation(int id) {
		int idFormation = id;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JEETP2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","test");
			String sql = "delete from TP2 where id = ? " ;
			PreparedStatement pst = con.prepareStatement(sql);//"insert into TP2 (id, theme, id_lieu) values(?,?,?)"
			System.out.println("updating records");
			pst.setInt(1,idFormation);
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
	public void selectFormation(int id) {
		int idFormation = id;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/JEETP2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","test");
			Statement pst = (Statement) con.createStatement(); //"insert into TP2 (id, theme, id_lieu) values(?,?,?)"
			String sql = "select * from TP2 where id = "+idFormation ;
			ResultSet rs= ((java.sql.Statement) pst).executeQuery(sql);
			while (rs.next()) {
				System.out.println ("ID de la Formation: " + rs.getInt(1));
				System.out.println ("Thème : " + rs.getString(2));
				System.out.println ("Lieu de la formation: " + rs.getInt(3));
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
	public Formation getF() {
		return f;
	}
	public void setF3(Formation f) {
		this.f = f;
	}
	
}
