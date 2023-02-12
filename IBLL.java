package bll;

//import bll.PersonBO;

public interface IBLL {
	public boolean isSibling (int cnic1, int cnic2);
	public boolean isHalfSibling(int cnic1, int cnic2);
	public String checkPerson (String name);

}
