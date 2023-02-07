package pl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import bll.PersonBO;

public class FamilyTreeView implements ActionListener {

	private JFrame frame1;
	private JFrame frame2;
	private JTextField cnic1;
	private JTextField cnic2;
	private JTextField name;
	private JButton button;
	private JButton namebutton;
	private JTextArea result;
	private JTextArea nameresult;
	private PersonBO bo;
	
	public FamilyTreeView() throws SQLException {
		bo = new PersonBO();
		frame1 = new JFrame("Half Siblings Check App");
		frame2 = new JFrame("Name Check App");
		cnic1 = new JTextField("person 1 CNIC");
		cnic2 = new JTextField("Person 2 CNIC");
		button = new JButton("Check");
		result = new JTextArea();
		name=new JTextField("Enter Name");
		nameresult = new JTextArea();
		namebutton = new JButton("Search");
	}
	public void viewSibling() {

		cnic1.setBounds(50, 50, 200, 50);
		cnic2.setBounds(50, 100, 200, 50);
		button.setBounds(50, 150, 100, 50);
		button.addActionListener(this);
		result.setBounds(50, 200, 200, 200);
		frame1.add(cnic1);
		frame1.add(cnic2);
		frame1.add(result);
		frame1.add(button);
		
		frame1.setSize(400,500);
		frame1.setLayout(null);
		frame1.setVisible(true);
	}
	public void viewHalfSibling() {

		cnic1.setBounds(50, 50, 200, 50);
		cnic2.setBounds(50, 100, 200, 50);
		button.setBounds(50, 150, 100, 50);
		button.addActionListener(this);
		result.setBounds(50, 200, 400, 200);
		frame1.add(cnic1);
		frame1.add(cnic2);
		frame1.add(result);
		frame1.add(button);
		
		frame1.setSize(500,600);
		frame1.setLayout(null);
		frame1.setVisible(true);
	}
	
	public void viewName() {
		name.setBounds(50, 50, 200, 50);
		namebutton.setBounds(50, 150, 100, 50);
		namebutton.addActionListener(this);
		nameresult.setBounds(50, 200, 400, 200);
		frame2.add(name);
		frame2.add(nameresult);
		frame2.add(namebutton);
		
		frame2.setSize(500,600);
		frame2.setLayout(null);
		frame2.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource()==button)
        {
			int nic1 = Integer.parseInt(cnic1.getText());
			int nic2 = Integer.parseInt(cnic2.getText());
			if (bo.isHalfSibling(nic1, nic2)) {
				result.setText("Yes, the two citizens are half siblings");
			} else {
				result.setText("No, the two citizens are not half siblings");
			}
        }
		if (e.getSource()==namebutton)
        {
			String name1 = name.getText();
			nameresult.setText(bo.checkPerson(name1));
        }
//		if (bo.isSibling(nic1, nic2)) {
//			result.setText("Yes, the two citizens are siblings");
//		} else {
//			result.setText("No, the two citizens are not siblings");
//		}
		
		
	}
	public static void main(String[] args) {
		FamilyTreeView app;
		try {
			app = new FamilyTreeView();
//			app.viewSibling();
			app.viewHalfSibling();
			app.viewName();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
