package gui_pack;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.sql.*;

//import com.mysql.jdbc.PreparedStatement;

public class Signup extends JFrame {

	public Signup() {

		JFrame j = new JFrame("SIGN UP");
		j.setSize(900, 480);
		j.setLayout(null);
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setLocationRelativeTo(null);
		j.setBackground(Color.LIGHT_GRAY);
		j.setContentPane(new JLabel(new ImageIcon("C:\\Users\\KARNO\\Desktop\\New folder\\New folder\\HomePage.png")));
		// Homepage hm;

		JLabel l1 = new JLabel("Name : ");
		l1.setBounds(50, 40, 150, 20);
		l1.setFont(new Font("Times new Rooman", Font.PLAIN, 20));
		// l1.setForeground(Color.black);
		j.add(l1);

		JLabel l2 = new JLabel("Address : ");
		l2.setBounds(50, 80, 150, 20);
		l2.setFont(new Font("Times new Rooman", Font.PLAIN, 20));
		// l2.setForeground(Color.black);
		j.add(l2);

		JLabel l3 = new JLabel("Username : ");
		l3.setBounds(50, 120, 150, 20);
		l3.setFont(new Font("Times new Rooman", Font.PLAIN, 20));
		// l3.setForeground(Color.black);
		j.add(l3);

		JLabel l4 = new JLabel("Password : ");
		l4.setBounds(50, 160, 150, 20);
		l4.setFont(new Font("Times new Rooman", Font.PLAIN, 20));
		// l4.setForeground(Color.black);
		j.add(l4);

		JLabel l5 = new JLabel("Phone No : ");
		l5.setBounds(50, 240, 150, 20);
		l5.setFont(new Font("Times new Rooman", Font.PLAIN, 20));
		// l5.setForeground(Color.black);
		j.add(l5);
		
		JLabel l6 = new JLabel("Confirm : ");
		l6.setBounds(50, 200, 150, 20);
		l6.setFont(new Font("Times new Rooman", Font.PLAIN, 20));
		// l5.setForeground(Color.black);
		j.add(l6);
		
		JLabel l7 = new JLabel("Sigu Up Rules:");
		l7.setBounds(450, 10, 150, 30);
		l7.setFont(new Font("Times new Rooman", Font.PLAIN, 20));
		// l5.setForeground(Color.black);
		j.add(l7);

		/*
		 * JLabel l6=new JLabel("Credit Card No: "); l6.setBounds(50,240,150,20);
		 * l6.setFont(new Font("Times new Rooman",Font.PLAIN,20));
		 * //l6.setForeground(Color.black); j.add(l6);
		 */

		JTextField text1 = new JTextField();
		text1.setBounds(200, 40, 150, 20);
		j.add(text1);

		JTextField text2 = new JTextField();
		text2.setBounds(200, 80, 150, 20);
		j.add(text2);

		JTextField text3 = new JTextField();
		text3.setBounds(200, 120, 150, 20);
		j.add(text3);

		JPasswordField text4 = new JPasswordField();
		text4.setBounds(200, 160, 150, 20);
		j.add(text4);

		JTextField text5 = new JTextField();
		text5.setBounds(200, 240, 150, 20);
		j.add(text5);
		
		JPasswordField text6 = new JPasswordField();
		text6.setBounds(200, 200, 150, 20);
		j.add(text6);

		/*
		 * JTextField text6 =new JTextField(); text6.setBounds(200,240,150,20);
		 * j.add(text6);
		 * 
		 */
		JTextArea ta1 = new JTextArea();
		String ta = ("1.Mobile number 11 Number" + '\n' + "2.Telephone number 09 Number" + '\n'
				+ "3.Credit Card No 16 Number" + '\n' + "4.ID (at least) 04 Character" + '\n'
				+ "5.password(at least) 06 Character" + '\n' + "6.Add Contact Number FROM Bangladesh" + '\n');

		ta1.setText(ta);
		ta1.setEditable(false);
		ta1.setForeground(Color.RED);
		ta1.setFont(new Font("Times new Rooman", Font.PLAIN, 20));
		ta1.setBounds(450, 50, 400, 250);
		j.add(ta1);
		ta1.setVisible(true);

		/*JCheckBox jd = new JCheckBox("Show SignUp Rules");
		jd.setFont(new Font("Algerian", Font.PLAIN, 15));
		jd.setForeground(Color.BLUE);
		jd.setBounds(200, 270, 200, 20);
		j.add(jd);
		jd.addActionListener(e -> {
			boolean selected = jd.isSelected();
			if (selected) {

				ta1.setVisible(true);
				// j.add(ta1);
			} else {
				// j.remove(ta1);
				ta1.setVisible(false);

			}
		});*/

		JButton signup = new JButton("Sign up");
		signup.setBounds(100, 300, 150, 30);
		signup.setForeground(Color.black);
		signup.setBackground(Color.orange);
		j.add(signup);
		signup.addActionListener(e -> {
			String name = text1.getText();
			String address = text2.getText();
			String id = text3.getText();
			String pass = text4.getText();
			String pass2=text6.getText();
			String phone = text5.getText();
			
	    	if(pass.equals(pass2)) {

			if (!name.isEmpty() && !address.isEmpty() && !id.isEmpty() && !pass.isEmpty() && !phone.isEmpty()) {

				if (id.length() >= 4 && pass.length() >= 6 && (phone.length() == 11 || phone.length() == 9 )) {

					if ("016".equals(phone.substring(0, 3)) || "017".equals(phone.substring(0, 3))
							|| "018".equals(phone.substring(0, 3)) || "019".equals(phone.substring(0, 3))
							|| "015".equals(phone.substring(0, 3)) || "011".equals(phone.substring(0, 3))
							|| ("02".equals(phone.substring(0, 2)) && phone.length() == 9)) {
						//if(pass==pass2) {

						Connection conn;

						try {

							PreparedStatement pst;
							Class.forName("com.mysql.jdbc.Driver");
							String url = "jdbc:mysql://localhost:3306/shop";
							conn = DriverManager.getConnection(url, "root", "");
							String sql = "insert into signup values (?,?,?,?,?)";

							pst = (PreparedStatement) conn.prepareStatement(sql);
							pst.setString(1, id);
							pst.setString(2, pass);
							pst.setString(3, name);
							pst.setString(4, phone);
							pst.setString(5, address);
							pst.executeUpdate();

						} catch (SQLException e2) {
							e2.printStackTrace();
						} 
						
						catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						j.setVisible(false);
						new Homepage();
						JOptionPane.showMessageDialog(null,
								"Signed Up Suclcessfuly!!!!! .Now LogIN with user Id nd Password");
					   //}else {
				    	//JOptionPane.showMessageDialog(null, "Password does not match");
				    // }
					} else {
						JOptionPane.showMessageDialog(null, "Error;Invalid phone number");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Error;You should follow the SignUp Rules:");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Error;Please Fill the blank field & try again");
			}
		   }
	    	else {
		    	JOptionPane.showMessageDialog(null, "Password does not match");
		   }

		});

		JButton c = new JButton("Cancel");
		c.setBounds(300, 300, 150, 30);
		c.setForeground(Color.black);
		c.setBackground(Color.orange);
		j.add(c);
		c.addActionListener(e -> {

			new Homepage();
			j.setVisible(false);
		});

		j.setVisible(true);
		// j.revalidate();
		// j.repaint();
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
