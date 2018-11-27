package gui_pack;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Admin extends JFrame {

	// TODO Auto-generated method stub
	JLabel lblFirst;
	JTextField Search;
	JButton btnSearch;
	JButton btnAddProduct;
	JButton btnUpdateProduct;
	JButton btnDeleteProduct;
	 JButton btnLogOut;

	JMenuBar bar;
	JMenu Menu;
	JMenu LogOut;
	//JMenu Setting;
	//JMenuItem ChangePassword;
	//JMenuItem ChangeInformation;
	//JMenuItem ShowInformation;
	JTextField defaultFocusWorkaround;

	String uname, upass;
	
	public Admin(String un, String pass) {
		this.uname=un;
		upass=pass;
		
		
		this.setSize(720, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Admin");
		addComponentsToFrame();
		this.setVisible(true);
	}

	public void addComponentsToFrame() {
		this.lblFirst = new JLabel("Welcome Admin");

		//this.btnSearch = new JButton("Search");
		//this.Search = new JTextField();
		this.btnAddProduct = new JButton("ADD Product");
		this.btnUpdateProduct = new JButton("Update Product");
		this.btnDeleteProduct = new JButton("Delete Product");
		this.btnLogOut = new JButton("LogOut");

		this.bar = new JMenuBar();
		//this.Menu = new JMenu("Menu");
		this.LogOut = new JMenu("LogOut");
		//this.Setting = new JMenu("Setting");

		//this.ChangePassword = new JMenuItem("Change Password");
		//this.ChangeInformation = new JMenuItem("Change Information");
		//this.ShowInformation = new JMenuItem("Show Information");

		this.setLayout(null);

		this.lblFirst.setBounds(300, 10, 160, 20);
		//this.btnSearch.setBounds(45, 30, 75, 20);
		//this.Search.setBounds(130, 30, 150, 20);
		this.btnAddProduct.setBounds(45, 80, 140, 40);
		this.btnUpdateProduct.setBounds(45, 130, 140, 40);
		this.btnDeleteProduct.setBounds(45, 180, 140, 40);
		this.btnLogOut.setBounds(580,35,80,25);

		//this.setJMenuBar(bar);
		//this.bar.add(this.Menu);
		//this.bar.add(this.LogOut);

		//this.Menu.add(this.Setting);
		//this.Setting.add(this.ChangePassword);
		//this.Setting.add(this.ChangeInformation);
		//this.Setting.add(this.ShowInformation);

		this.add(this.lblFirst);
		this.add(this.btnLogOut);
		btnLogOut.addActionListener(e->{
			this.setVisible(false);
			new Homepage();
		});
		
		//this.add(this.btnSearch);
		//this.add(this.Search);
		this.add(this.btnAddProduct);
		btnAddProduct.addActionListener(e->{
			this.setVisible(false);
			new AddProduct(uname, upass);
		});
		
		
		this.add(this.btnUpdateProduct);
		btnUpdateProduct.addActionListener(e->{
			this.setVisible(false);
			new Update(uname, upass);
		});
		
		
		this.add(this.btnDeleteProduct);
		this.setVisible(true);

	}

}