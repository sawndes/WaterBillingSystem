package waterBillingSys;

//Importing Required Packages
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


import waterBillingSys.SuperAdminPanel;

//AdminPanel Class that is child class of JFrame and implements ActionListener Interface
public class SuperAdminPanel extends JFrame implements ActionListener {
	// Private Variables which is used only in this class
	private JLabel l1;
	private JButton b,b1,b2,b3,b4;
	// Constructor AdminPanel
  SuperAdminPanel()
  {
  	  // GUI 
	  super("Water Billing System");
	  // Adding Label on panel
	  l1 = new JLabel("Welcome, Admin");
	  l1.setBounds(260,0,400,40);
	  l1.setFont(new Font("Senserif", Font.BOLD, 25));
	  add(l1);
	  
	  b=new JButton("Add Consumer");//create button
	  b.setBounds(200,100,120,40);          
	  add(b);//adding button on frame  
	  b.addActionListener(this);
	  
	  b2=new JButton("View Consumers");//create button
	  b2.setBounds(300,200,160,40);          
	  add(b2);//adding button on frame  
	  b2.addActionListener(this);
	  
	  b3=new JButton("Manage Meter Reader Account");//create button
	  b3.setBounds(200,300,230,40);          
	  add(b3);//adding button on frame  
	  b3.addActionListener(this);
	  
	  b4=new JButton("Manage Admin Account");//create button
	  b4.setBounds(200,350,230,40);          
	  add(b4);//adding button on frame  
	  b4.addActionListener(this);
	  
	  // Button for logout
	  b1 = new JButton("Logout");
	  b1.setBounds(260, 400, 115 ,30);
	  add(b1);
	  b1.addActionListener(this);
	  setResizable(false);
	  setSize(800,600);  
	  setLayout(null);  
	  setVisible(true); 
	  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	  
  }
 public static void main(String[] args){
      new SuperAdminPanel().setVisible(true);

  }
@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == b1){
    	new Login().setVisible(true);
    	this.dispose();
    }
	else if (e.getSource() == b) {
		new AddUser().setVisible(true);
	}
	else if (e.getSource() == b2) {
		new ViewConsumers().setVisible(true);
	}
	else if (e.getSource() == b3) {
		new MeterReaderManager().setVisible(true);
	}
	else if (e.getSource() == b4) {
		new AdminManager().setVisible(true);
	}
	
}
}