package bll;

import java.sql.SQLException;

import dal.IDAL;
import dal.PersonDAO;
import to.PersonTO;

public class PersonBO implements IBLL{
	private IDAL dao;
	
	public PersonBO () throws SQLException {
//		dao = new PersonDAO();
	}
	public PersonBO(IDAL dao) {
		this.dao = dao;
	}

	// CHECK SIBLINGS FUNCTION
	public boolean isSibling (int cnic1, int cnic2) {
		PersonTO p1 = dao.getPerson(cnic1);
		PersonTO p2 = dao.getPerson(cnic2);
		
		return checkFather(p1, p2) && checkMother(p1, p2);
	}
	
	// CHECK HALF SIBLINGS FUNCTION
	public boolean isHalfSibling(int cnic1, int cnic2) {
		PersonTO h1 = dao.getPerson(cnic1);
		PersonTO h2 = dao.getPerson(cnic2);
		return checkFather(h1, h2) || checkMother(h1, h2);
		
	}
	private boolean checkFather(PersonTO h1, PersonTO h2) {
		return h1.getFather() == h2.getFather();
	}
	private boolean checkMother(PersonTO h1, PersonTO h2) {
		return h1.getMother() == h2.getMother();
	}
	
	// SEARCH PERSON FUNCTION
	public String checkPerson (String name) {
		PersonTO person = dao.getName(name);
		String info= "Name: "+person.getName()+"  CNIC: "+person.getCnic()+"  Father-CNIC: "+person.getFather()+"  Mother-CNIC: "+person.getMother();
		
		return info;
	}
//	public static void main(String[] args) {};
}