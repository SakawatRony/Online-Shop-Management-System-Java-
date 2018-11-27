package gui_pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//import com.mysql.jdbc.Connection;

public class ChangeInfo extends JFrame {
	
	JLabel lblFirst, lblSecond, lblThard;
	JTextField txtFirst, txtSecond, txtThard;
	JButton btnOK;
	

	String name,pass;
	
	public ChangeInfo(String un, String pa) {
		this.name=un;
		this.pass=pa;
		
		
		this.setSize(720, 480); 
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("ChangePassword");
		addComponentsToFrame();
		this.setVisible(true);
	}
	
	public void addComponentsToFrame()
	{
		this.lblFirst 	= new JLabel("Enter Old Password:");
		this.lblSecond 	= new JLabel("Enter New Password:");
		this.lblThard 	= new JLabel("Confirm Password :");
		
		this.txtFirst 	= new JTextField();
		this.txtSecond 	= new JTextField();
		this.txtThard 	= new JTextField();
		
		this.btnOK = new JButton("OK");
		
		
		this.setLayout(null);
		
		this.lblFirst.setBounds(15, 5, 120, 20);
		this.txtFirst.setBounds(150, 5, 150, 20);
		
		this.lblSecond.setBounds(15, 35, 130, 20);
		this.txtSecond.setBounds(150, 35, 150, 20);
		
		this.lblThard.setBounds(15, 65, 120, 20);
		this.txtThard.setBounds(150, 65, 150, 20);
		
		this.btnOK.setBounds(150, 95, 60, 20);
		
		this.add(this.lblFirst); 
		this.add(this.txtFirst);
		this.add(this.lblSecond); 
		this.add(this.txtSecond);
		this.add(this.lblThard); 
		this.add(this.txtThard);
		this.add(this.btnOK); 
		
		btnOK.addActionListener(e->{
			String oldPass=txtFirst.getText();
			String newPass=txtSecond.getText();
			String confirmPass=txtThard.getText();
			
			if (oldPass.isEmpty() || newPass.isEmpty() || confirmPass.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please fill up all setion");
			}
			else {
				if (oldPass.equals(pass)) {
					if (newPass.equals(confirmPass)) {
	                	if (newPass.length()>=6 && confirmPass.length()>=6) {
	                		
	                		Connection conn;

							try {

								PreparedStatement pst;
								Class.forName("com.mysql.jdbc.Driver");
								String url = "jdbc:mysql://localhost:3306/shop";
								conn = DriverManager.getConnection(url, "root", "");
								Statement stmt = conn.createStatement();
								
								String sql = "update signup SET password='"+confirmPass+"' WHERE uname='"+name+"'";
								stmt.executeUpdate(sql);
								conn.close();
								
								JOptionPane.showMessageDialog(null, "Password change successfully....!!!");
								this.setVisible(false);
								new Homepage();

							} catch (Exception e2) {
								e2.printStackTrace();
							} 
	                		
	                		
						}
	                	else {
	                		JOptionPane.showMessageDialog(null, "Password length must greater than 6 digit.");
	                	}
				}
					else {
						JOptionPane.showMessageDialog(null, "New password and Confirm password doesn't match...!!!");
					}
				
                	//JOptionPane.showMessageDialog(null, "");
				}
                 else {
                	 JOptionPane.showMessageDialog(null, "Doesn't match current password...!!!");
				}
			}
			
		});
		
		this.btnOK.setToolTipText("This is OK button");
	}
}
