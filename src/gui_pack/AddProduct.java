package gui_pack;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

public class AddProduct extends JFrame {
	
	JLabel lblFirst, lblSecond, lblthree, lblfour, lblfive, lblsix, lblseven,lbleight ;
	JTextField txtFirst, txtSecond, txtthree, txtfour, txtfive, txtsix, txtseven, txteight; 
	JButton btnOK,backBtn;
	
	String uname, upass;
	
	public AddProduct(String uname, String upass) {
		this.uname=uname;
		this.upass=upass;
		
		this.setSize(720, 480); 
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Add Product");
		addComponentsToFrame();
		this.setVisible(true);
	}
	
	public void addComponentsToFrame()
	{
		this.lblFirst 	= new JLabel("Product Name:");
		this.lblSecond 	= new JLabel("Model:");
		this.lblthree 	= new JLabel("Ram:");
		this.lblfour 	= new JLabel("Rear Camera:");
		this.lblfive 	= new JLabel("Font Camera:");
		this.lblsix 	= new JLabel("Display:");
		this.lblseven 	= new JLabel("Battery:");
		this.lbleight 	= new JLabel("Price:");
		
		this.txtFirst 	= new JTextField();
		this.txtSecond 	= new JTextField();
		this.txtthree 	= new JTextField();
		this.txtfour 	= new JTextField();
		this.txtfive 	= new JTextField();
		this.txtsix 	= new JTextField();
		this.txtseven 	= new JTextField();
		this.txteight 	= new JTextField();
		
		this.btnOK = new JButton("ADD");
		this.backBtn = new JButton("Back");
		
		
		this.setLayout(null);
		
		this.lblFirst.setBounds(20, 10, 120, 30);
		this.txtFirst.setBounds(150, 10, 150, 25);
		
		this.lblSecond.setBounds(320, 10, 120, 30);
		this.txtSecond.setBounds(450, 10, 150, 25);
		
		
		this.lblthree.setBounds(20, 40, 120, 30);
		this.txtthree.setBounds(150, 40, 150, 25);
		
		this.lblfour.setBounds(320, 40, 120, 30);
		this.txtfour.setBounds(450, 40, 150, 25);
		
		this.lblfive.setBounds(20, 70, 120, 30);
		this.txtfive.setBounds(150, 70, 150, 25);
		
		this.lblsix.setBounds(320, 70, 120, 30);
		this.txtsix.setBounds(450, 70, 150, 25);
		
		this.lblseven.setBounds(20, 100, 120, 30);
		this.txtseven.setBounds(150, 100, 150, 25);
		
		this.lbleight.setBounds(320, 100, 120, 30);
		this.txteight.setBounds(450, 100, 150, 25);
		
		this.btnOK.setBounds(530, 160, 65, 25);
		this.backBtn.setBounds(450, 160, 70, 25);
		
		this.add(this.lblFirst); 
		this.add(this.txtFirst);
		this.add(this.lblSecond); 
		this.add(this.txtSecond);
		this.add(this.lblthree); 
		this.add(this.txtthree);
		this.add(this.lblfour); 
		this.add(this.txtfour);
		this.add(this.lblfive); 
		this.add(this.txtfive);
		this.add(this.lblsix); 
		this.add(this.txtsix); 
		this.add(this.txtseven);
		this.add(this.lblseven); 
		this.add(this.lbleight);
		this.add(this.txteight);
		this.add(this.btnOK);
		
		String name = txtFirst.getText();
		String model = txtSecond.getText();
		String ram = txtthree.getText();
		String rear = txtfour.getText();
		String font = txtfive.getText();
		String display = txtsix.getText();
		String battery = txtseven.getText();
		String price = txteight.getText();
		
		
		btnOK.addActionListener(e->{
			
			Connection conn;
			try {

				PreparedStatement pst;
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/shop";
				conn = DriverManager.getConnection(url, "root", "");
				String sql = "insert into mobile values (?,?,?,?,?,?,?,?)";

				pst = (PreparedStatement) conn.prepareStatement(sql);
				pst.setString(1, name);
				pst.setString(2, model);
				pst.setString(3, ram);
				pst.setString(4, rear);
				pst.setString(5, font);
				pst.setString(6, display);
				pst.setString(7, battery);
				pst.setString(8, price);
				pst.executeUpdate();
				
				
				JOptionPane.showMessageDialog(null, "Added Successfully...!!!!");
				
				txtFirst.setText(null);
				txtSecond.setText(null);
				txtthree.setText(null);
				txtfour.setText(null);
				txtfive.setText(null);
				txtsix.setText(null);
				txtseven.setText(null);
				txteight.setText(null);

			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "Error 404!");
			} 
			
		});
		
		this.add(backBtn);
		backBtn.addActionListener(e->{
			this.setVisible(false);
			new Admin(uname, upass);
		});
		
	}
}	
	