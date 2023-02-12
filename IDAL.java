package dal;

// interface of DAL

//import java.util.ArrayList;

import to.PersonTO;

public interface IDAL {
	
	public PersonTO getPerson(int cnic);
	public PersonTO getName(String name);
	

}
