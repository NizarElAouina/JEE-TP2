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
	public Formation getF() {
		return f;
	}
	public void setF3(Formation f) {
		this.f = f;
	}
	public static void main(String[] args) {
			Lieu l1 = new Lieu(6, "Ziraoui", "Casablanca");
	        Formation f1 = new Formation(3,"Physics", l1);
	        FormationDao dao = new FormationDao();
	        dao.f = f1;
	        //System.out.println(f1.getIdLieu());
	        dao.modifierThemeFormation(3,"Maths");
	        }
}