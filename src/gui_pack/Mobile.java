package gui_pack;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.text.Position.Bias;
import java.sql.*;
import java.util.Base64;
import java.util.Vector;

public class Mobile extends JFrame{
	
	//JFrame frame;
	JTable table;
	JTextField t1;
	JButton b1;
	JButton b2,b3,b4,backBtn;

	JLabel l1;
	
	
	String un, upass;
	
	public Mobile(String uname, String pass) {
		this.un=uname;
		this.upass=pass;
		
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Online Shop");
		this.setVisible(true);
		//addComponentsToFrame();
		
		this.l1=new JLabel("Search your Mobile :");
		this.t1 = new JTextField();
		this.b1 = new JButton("Search");
		this.b2 = new JButton("Back");
		this.b3 = new JButton("Cart");
		this.b4 = new JButton("LogOut");
		this.table = new JTable();
		
		
		this.setLayout(null);
		l1.setBounds(30,30,200,30);
		t1.setBounds(200,30,200,30);
		b1.setBounds(450,30,80,30);
		b2.setBounds(550,30,80,30);
		b3.setBounds(550,80,80,30);
		b4.setBounds(830,10,80,30);
		//table.setBounds(40,130,920,400);
		
		
		
		this.add(this.l1);
		
		this.add(this.t1);
		
		this.add(this.b1);
		
		this.add(this.b2);
		this.add(this.b3);
		this.add(this.b4);
		
		
		b1.addActionListener(e->{
			this.setVisible(false);
			String txt = t1.getText();
			
			
			try{
				   Connection con = null;
				   Statement st = null;
				   ResultSet rs = null;
				   String s;

			   
			       con = DriverManager.getConnection("jdbc:mysql://localhost/shop","root","");
			       st = con.createStatement();
			       s = "select * from mobile where name='"+txt+"'";
			       rs = st.executeQuery(s);
			       ResultSetMetaData rsmt = rs.getMetaData();
			       int c = rsmt.getColumnCount();
			       Vector column = new Vector(c);
			       for(int i = 1; i <= c; i++)
			       {
			           column.add(rsmt.getColumnName(i));
			       }
			       Vector data = new Vector();
			       Vector row = new Vector();
			       while(rs.next())
			       {
			           row = new Vector(c);
			           for(int i = 1; i <= c; i++){
			               row.add(rs.getString(i));
			           }
			           data.add(row);
			       }
			       JButton btn;
			      btn=new JButton("Back");
			       JFrame frame = new JFrame("Ball");
			       frame.setSize(700,600);
			        frame.setLocationRelativeTo(null);
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			       btn.setBounds(500,300,70,20);
			       frame.add(btn);
                   btn.addActionListener(e1->{
                	   this.hide();
                	   this.setVisible(false);
                	   new Mobile(uname, pass);
                	   
                   });
			        
			        
			        //JPanel panel = new JPanel();
			        JTable table = new JTable(data,column);
			        table.setBounds(40,130,300,400);
			        JScrollPane jsp = new JScrollPane(table);
			      
			        frame.add(jsp);
			        //frame.setLayout(null);
			       // panel.setLayout(new BorderLayout());
			        //panel.add(jsp,BorderLayout.CENTER);
			       // frame.setContentPane(panel);
			        frame.setVisible(true);
			        
			       
			               
			               
			   }catch(Exception ex){
			       JOptionPane.showMessageDialog(null, "ERROR");
			   }
		});
		
	}
	public Mobile() {
		
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Online Shop");
		this.setVisible(true);
		//addComponentsToFrame();
		
		this.l1=new JLabel("Search your Mobile :");
		this.t1 = new JTextField();
		this.b1 = new JButton("Search");
		this.table = new JTable();
		this.backBtn = new JButton("Back");
		
		
		this.setLayout(null);
		l1.setBounds(30,30,200,30);
		t1.setBounds(200,30,200,30);
		b1.setBounds(450,30,80,30);
		backBtn.setBounds(830,10,80,30);
		//table.setBounds(40,130,920,400);
		
		
		
		this.add(this.l1);
		
		this.add(this.t1);
		
		this.add(this.b1);
		
		this.add(backBtn);
		
		backBtn.addActionListener(e->{
			this.setVisible(false);
			new CustomerView();
		});
		
		b1.addActionListener(e->{
			this.setVisible(false);
			String txt = t1.getText();
			
			
			try{
				   Connection con = null;
				   Statement st = null;
				   ResultSet rs = null;
				   String s;

			   
			       con = DriverManager.getConnection("jdbc:mysql://localhost/shop","root","");
			       st = con.createStatement();
			       s = "select * from mobile where name='"+txt+"'";
			       rs = st.executeQuery(s);
			       ResultSetMetaData rsmt = rs.getMetaData();
			       int c = rsmt.getColumnCount();
			       Vector column = new Vector(c);
			       for(int i = 1; i <= c; i++)
			       {
			           column.add(rsmt.getColumnName(i));
			       }
			       Vector data = new Vector();
			       Vector row = new Vector();
			       while(rs.next())
			       {
			           row = new Vector(c);
			           for(int i = 1; i <= c; i++){
			               row.add(rs.getString(i));
			           }
			           data.add(row);
			       }
			       JButton btn;
			      btn=new JButton("Back");
			       JFrame frame = new JFrame("Ball");
			       frame.setSize(700,600);
			        frame.setLocationRelativeTo(null);
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			       btn.setBounds(500,300,70,20);
			       frame.add(btn);
                   btn.addActionListener(e1->{
                	   this.hide();
                	   this.setVisible(false);
                	  new CustomerView();
                	   
                   });
			        
			        
			        //JPanel panel = new JPanel();
			        JTable table = new JTable(data,column);
			        table.setBounds(40,130,300,400);
			        JScrollPane jsp = new JScrollPane(table);
			      
			        frame.add(jsp);
			        //frame.setLayout(null);
			       // panel.setLayout(new BorderLayout());
			        //panel.add(jsp,BorderLayout.CENTER);
			       // frame.setContentPane(panel);
			        frame.setVisible(true);
			        
			       
			               
			               
			   }catch(Exception ex){
			       JOptionPane.showMessageDialog(null, "ERROR");
			   }
		});
		
		
		
	}
	
	
}