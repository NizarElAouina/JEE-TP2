package TP2.Dao;

import TP2.model.Formation;

public class DaoTest {
	
	public static void main(String[] args) {
		
        Formation f1 = new Formation(10,"Sciences humaines");
        FormationDao dao = new FormationDao(); //Instanciation de la classe FormationDao
        dao.ajouterFormation(f1,3);
        //dao.f = f1;
        //Formation f2 = new Formation(2,"Anglais", l1);
        //dao.f=f2; // This line is not necessary at all, idk why I even set an attribue Formation f
        //dao.insererFormation(f1);
        //dao.modifierLieuFormation(9,6);
        //System.out.println(f1.getIdLieu());
        //dao.modifierLieuFormation(3,4);
        //dao.selectFormation(7);
        }
}
