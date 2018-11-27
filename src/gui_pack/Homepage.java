package gui_pack;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.ResultSet;
//package gui_pack;

//import javax.swing.*;
public class Homepage extends JFrame {
	// JFrame j;
	JLabel lblFirst, lblSecond, lblDF;
	JTextField txtFirst;
	JPasswordField txtSecond;
	JButton btnSignUp, btnSearchProduct, btnLogIn, btnCancel;
	JCheckBox ShowPass, Rem;

	JTextField defaultFocusWorkaround;
	// Signup sign;

	public Homepage() {
		this.setSize(720, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Online Shop");
		//this.getContentPane().setBackground(Color.GREEN);
		this.setBackground(Color.LIGHT_GRAY);
		//this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\KARNO\\Desktop\\New folder\\New folder\\HomePage.png")));
		// this.setVisible(true);

		this.lblDF = new JLabel("RKB Online Shop");

		lblDF.setFont(new Font("Cooper Black", Font.PLAIN, 20));
		///lblDF.setForeground(Color.black);

		this.lblFirst = new JLabel("User Name");
		this.lblSecond = new JLabel("Password");

		this.ShowPass = new JCheckBox("Show password");
		this.Rem = new JCheckBox("Remember Me");
		this.txtFirst = new JTextField();
		this.txtSecond = new JPasswordField();
		this.txtSecond.setEchoChar('*');

		this.btnSignUp = new JButton("Sign Up");
		this.btnLogIn = new JButton("Log In");
		this.btnSearchProduct = new JButton("Search All Product");
		this.btnCancel = new JButton("Cancel");
		this.setLayout(null);
		this.lblDF.setBounds(200, 10, 200, 20);
		this.lblDF.setBackground(Color.blue);
		this.lblFirst.setBounds(50, 60, 80, 25);
		this.txtFirst.setBounds(130, 60, 200, 25);
		this.lblSecond.setBounds(50, 95, 80, 25);
		this.txtSecond.setBounds(130, 95, 200, 25);

		this.btnLogIn.setBounds(250, 200, 70, 30);
		btnLogIn.setBackground(Color.ORANGE);
		this.btnSignUp.setBounds(450, 100, 100, 30);
		this.btnSignUp.setBackground(Color.CYAN);
		this.btnCancel.setBounds(170, 200, 100, 20);
		this.btnSearchProduct.setBounds(450, 55, 150, 30);
		this.btnSearchProduct.setBackground(Color.PINK);

		this.ShowPass.setBounds(130, 130, 120, 15);
		this.Rem.setBounds(130, 150, 120, 15);

		this.add(this.lblDF);
		this.add(this.lblFirst);
		this.add(this.txtFirst);
		this.add(this.lblSecond);
		this.add(this.txtSecond);
		this.add(this.btnSignUp);
		btnSignUp.addActionListener(e -> {
			this.setVisible(false);
			new Signup();
		});

		this.add(this.btnLogIn);
		btnLogIn.addActionListener(e -> {
			this.setVisible(false);
			
			if (txtFirst.getText().equals("Admin") && txtSecond.getText().length()<=5) {
				
				Connection conn;
				PreparedStatement pst;
				ResultSet rs;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "");
					String query = "select * from admin WHERE uname='" + txtFirst.getText() + "' and password='"
							+ txtSecond.getText() + "'";
					pst = (PreparedStatement) conn.prepareStatement(query);
					rs = (ResultSet) pst.executeQuery(query);

					int count = 0;
					while (rs.next()) {
						count = count + 1;
						//this.setVisible(true);

					}
					if (count == 1) {
						String un = txtFirst.getText();
						String upass = txtSecond.getText();
						new Admin(un, upass);
						this.setVisible(false);

						// JOptionPane.showMessageDialog(this,"Login Successfully.");
						//this.setVisible(true);
					} else {
						//this.setVisible(true);
						new Homepage();
						JOptionPane.showMessageDialog(this, "Invalid Username or Password.");
						
						//this.setVisible(true);

					}
					//this.setVisible(true);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
			
			else {
				Connection conn;
				PreparedStatement pst;
				ResultSet rs;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "root", "");
					String query = "select * from signup WHERE uname='" + txtFirst.getText() + "' and password='"
							+ txtSecond.getText() + "'";
					pst = (PreparedStatement) conn.prepareStatement(query);
					rs = (ResultSet) pst.executeQuery(query);

					int count = 0;
					while (rs.next()) {
						count = count + 1;
						//this.setVisible(true);

					}
					if (count == 1) {
						String un = txtFirst.getText();
						String upass = txtSecond.getText();
						new CustomerView(un, upass);
						this.setVisible(false);

						// JOptionPane.showMessageDialog(this,"Login Successfully.");
						//this.setVisible(true);
					} else {
						//this.setVisible(true);
						new Homepage();
						JOptionPane.showMessageDialog(this, "Invalid Username or Password.");
						

					}
					//this.setVisible(true);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			
			

		});

		//this.add(this.btnCancel);
		this.add(this.btnSearchProduct);
		this.add(this.ShowPass);
		
		btnSearchProduct.addActionListener(e->{
			this.setVisible(false);
			new CustomerView();
		});
		

		ShowPass.addActionListener(e -> {
			boolean selected = ShowPass.isSelected();
			if (selected) {
				txtSecond.setEchoChar((char) 0);
				this.revalidate();
				this.repaint();
			} else {
				txtSecond.setEchoChar('*');
				this.revalidate();
				this.repaint();

			}
		});

		this.add(this.Rem);
		Rem.addActionListener(e -> {

		});

		this.setVisible(true);
	}

}
