package gui_pack;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.*;

public class Update extends JFrame {

	// TODO Auto-generated method stub
	JLabel lblElemnet;
	JTextField Element;
	JButton btnUpdate;
	JLabel lblQuantity;
	JTextField Quantity,model;

	JButton btnBack;

	String uname, upass;
	
	public Update(String uname, String upass) {
		this.uname=uname;
		this.upass=upass;
		
		this.setSize(720, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Update");
		this.setVisible(true);
	    addComponentsToFrame();

	}

	public void addComponentsToFrame() {
		this.lblElemnet = new JLabel("Element Update");
		this.lblQuantity = new JLabel("Quantity");
		this.lblQuantity = new JLabel("Quantity");
		this.btnUpdate = new JButton("Update");
		this.model = new JTextField();

		this.btnBack = new JButton("Back");
		this.Element = new JTextField();
		this.Quantity = new JTextField();

		this.setLayout(null);

		this.lblElemnet.setBounds(50, 30, 100, 20);
		this.lblQuantity.setBounds(50, 60, 100, 20);
		this.Element.setBounds(170, 30, 150, 20);
		this.Quantity.setBounds(170, 60, 150, 20);
		this.model.setBounds(170,150,100,20);

		this.btnUpdate.setBounds(250, 120, 80, 20);
		this.btnBack.setBounds(150, 120, 80, 20);

		this.add(this.lblElemnet);
		this.add(this.btnBack);
		btnBack.addActionListener(e->{
			new Admin(uname, upass);
		});
		this.add(this.lblQuantity);
		this.add(this.Element);
		this.add(model);
		this.add(this.Quantity);
		this.add(this.btnUpdate);
		
		btnUpdate.addActionListener(e->{
			Connection conn;

			try {

				PreparedStatement pst;
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/shop";
				conn = DriverManager.getConnection(url, "root", "");
				Statement stmt = conn.createStatement();
				
				String sql = "update mobile SET "+Element.getText()+" = '"+Quantity.getText()+"' WHERE model='"+model.getText()+"'";
				stmt.executeUpdate(sql);
				conn.close();
				
				JOptionPane.showMessageDialog(null, "Updated successfully....!!!");
				//this.setVisible(false);
				//new Homepage();
				Element.setText(null);
				Quantity.setText(null);
				model.setText(null);

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error 404!");
			} 
		});
		
		this.setVisible(true);

	}
}
