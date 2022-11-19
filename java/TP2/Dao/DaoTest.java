package TP2.Dao;

import TP2.model.Formation;
import TP2.model.Lieu;

public class DaoTest {
	
	public static void main(String[] args) {
		Lieu l2 = new Lieu(2, "Agdal", "Rabat");
        Formation f1 = new Formation(7,"Solfège", l2);
        //dao.f = f1;
        //Formation f2 = new Formation(2,"Anglais", l1);
        FormationDao dao = new FormationDao(); //Instanciation de la classe FormationDao
        //dao.f=f2; // This line is not necessary at all, idk why I even set an attribue Formation f
        //dao.insererFormation(f1);
        //System.out.println(f1.getIdLieu());
        //dao.modifierLieuFormation(3,4);
        }
}
