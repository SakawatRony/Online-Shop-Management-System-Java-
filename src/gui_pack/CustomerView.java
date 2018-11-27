package gui_pack;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class CustomerView extends JFrame {

	// TODO Auto-generated method stub
	JLabel lblFirst;
	// JTextField Search;
	// JButton btnSearch;
	JButton mSearchBtn;
	JButton lSearchBtn;
	JButton btnCategory;
	JButton btnLogOut, backBtn;
	
	JMenuBar bar;
	JMenu Menu;
	JMenu Help;
	JMenu Setting;
	JMenuItem ChangePassword;
	JMenuItem ChangeInformation;
	JMenuItem ShowInformation;
	JTextField defaultFocusWorkaround;

	String uname;
	String pass;

	public CustomerView(String un, String upass) {
		this.uname = un;
		this.pass = upass;

		this.setSize(720, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\KARNO\\Desktop\\New folder\\New folder\\cus.png")));
		this.setTitle("Online Shop");
		addComponentsToFrame();
		this.setVisible(true);
		this.getContentPane().setBackground(Color.BLUE);
		// this.setBackground(Color.BLUE);
		// this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\KARNO\\Desktop\\New
		// folder\\New folder\\cus.png")));
	}

	public void addComponentsToFrame() {
		this.lblFirst = new JLabel("Welcome To Our Shop");

		// this.Search = new JTextField();

		// this.btnSearch = new JButton("Search");
		// this.setBackground(Color.BLUE);
		this.mSearchBtn = new JButton("Mobile");
		this.lSearchBtn = new JButton("Laptop");
		this.btnCategory = new JButton("Category");
		
		this.btnLogOut = new JButton("LogOut");
	

		this.bar = new JMenuBar();
		this.Menu = new JMenu("Menu");
		this.Help = new JMenu("Help");
		this.Setting = new JMenu("Setting");

		this.ChangePassword = new JMenuItem("Change Password");
		this.ChangeInformation = new JMenuItem("Change Information");
		this.ShowInformation = new JMenuItem("Show Information");

		this.setLayout(null);

		this.lblFirst.setBounds(300, 10, 160, 20);
		// this.btnSearch.setBounds(45,30,75,20);
		// this.Search.setBounds(130,30,150,20);
		this.mSearchBtn.setBounds(45, 30, 75, 20);
		this.lSearchBtn.setBounds(130, 30, 150, 20);
		this.btnLogOut.setBounds(500, 30, 75, 20);

		this.mSearchBtn.addActionListener(e -> {
			this.setVisible(false);
			new Mobile(uname, pass);
			// new Mobile();
		});

		this.setJMenuBar(bar);
		this.bar.add(this.Menu);
		this.bar.add(this.Help);

		this.Menu.add(this.Setting);
		this.Setting.add(this.ChangePassword);
		this.Setting.add(this.ChangeInformation);
		this.Setting.add(this.ShowInformation);

		ChangePassword.addActionListener(e -> {
			this.setVisible(false);
			new ChangeInfo(uname, pass);
		});

		this.add(this.lblFirst);
		// this.add(this.btnSearch);
		// this.add(this.Search);
		this.add(mSearchBtn);
		this.add(lSearchBtn);
		this.add(this.btnCategory);
		
		this.add(this.btnLogOut);
		btnLogOut.addActionListener(e -> {
			this.setVisible(false);
			new Homepage();
		});

	}
	
	
	//--------------For General User-------------------->>
	
	public CustomerView() {
		

		this.setSize(720, 480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(new JLabel(new ImageIcon("C:\\Users\\KARNO\\Desktop\\New folder\\New folder\\cus.png")));
		this.setTitle("Online Shop");
		addComponentsToFrameForNormalUser();
		this.setVisible(true);
		this.getContentPane().setBackground(Color.BLUE);
		
	}
	
	public void addComponentsToFrameForNormalUser() {
		this.lblFirst = new JLabel("Welcome To Our Shop");

		// this.Search = new JTextField();

		// this.btnSearch = new JButton("Search");
		// this.setBackground(Color.BLUE);
		this.mSearchBtn = new JButton("Mobile");
		this.lSearchBtn = new JButton("Laptop");
		this.backBtn = new JButton("Back");
		
		backBtn.addActionListener(e->{
			this.setVisible(false);
			new Homepage();
		});

		this.setLayout(null);

		this.lblFirst.setBounds(300, 10, 160, 20);
		this.mSearchBtn.setBounds(45, 30, 75, 20);
		this.lSearchBtn.setBounds(130, 30, 150, 20);
		this.backBtn.setBounds(500, 30, 75, 20);
		
		this.mSearchBtn.addActionListener(e -> {
			this.setVisible(false);
			new Mobile();
		});

		this.add(this.lblFirst);
		// this.add(this.btnSearch);
		// this.add(this.Search);
		this.add(mSearchBtn);
		this.add(lSearchBtn);
		this.add(backBtn);

	}
	
	

}
