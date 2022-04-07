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

public class AdminPanel extends JFrame implements ActionListener {
	private JButton b,b1,b2;
	AdminPanel() {
		// GUI 
		  super("Admin Dashboard");
		  // Adding Label on panel
		  b=new JButton("Change Password");//create button
		  b.setBounds(200,100,160,40);          
		  add(b);//adding button on frame  
		  b.addActionListener(this);
		  
		  b1=new JButton("Profile");//create button
		  b1.setBounds(200,150,160,40);          
		  add(b1);//adding button on frame  
		  b1.addActionListener(this);
		  
		  b2=new JButton("Collect Payment");//create button
		  b2.setBounds(200,200,160,40);          
		  add(b2);//adding button on frame  
		  b2.addActionListener(this);
		  
		  setResizable(false);
		  setSize(800,600);  
		  setLayout(null);  
		  setVisible(true); 
		  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b2) {
			new CollectPayment("admin").setVisible(true);
//	    	this.dispose();
		}
		
	}
	public static void main(String[] args) {
		new AdminPanel().setVisible(true);
	}

}
