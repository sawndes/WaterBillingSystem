package waterBillingSys;

//Importing Required Packages
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;



public class MeterReaderPanel extends JFrame implements ActionListener {
	private JButton b,b1,b2;
	private String username,mrlocation;
	MeterReaderPanel() {
		// GUI 
		  super("Meter Reader Dashboard");
		  // Adding Label on panel
		  
		  b=new JButton("Change Password");//create button
		  b.setBounds(200,100,160,40);          
		  add(b);//adding button on frame  
		  b.addActionListener(this);
		  
		  b1=new JButton("Profile");//create button
		  b1.setBounds(200,150,160,40);          
		  add(b1);//adding button on frame  
		  b1.addActionListener(this);
		  
		  b2=new JButton("Add Unit");//create button
		  b2.setBounds(200,200,160,40);          
		  add(b2);//adding button on frame  
		  b2.addActionListener(this);
		  
	        try {
	        	Connect c3 = new Connect();
	            String s2 = "SELECT * FROM logincheck ORDER BY No DESC LIMIT 1";
	            ResultSet rs1  = c3.s.executeQuery(s2);
	            while(rs1.next()){
	            	username = rs1.getString("username");
	            }
	        }catch (Exception e) {
	        	e.printStackTrace();
	        }
	        
	        try {
	        	Connect c3 = new Connect();
	            String s2 = "SELECT location FROM meter_reader where username= '"+username+"'";
	            ResultSet rs1  = c3.s.executeQuery(s2);
	            while(rs1.next()){
	            	mrlocation = rs1.getString("location");
	            }
	        }catch (Exception e) {
	        	e.printStackTrace();
	        }
		  
		  setResizable(false);
		  setSize(800,600);  
		  setLayout(null);  
		  setVisible(true); 
		  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b2) {
			new SelectCustomer(mrlocation).setVisible(true);
	    	this.dispose();
		}
		
	}
	public static void main(String[] args) {
		new MeterReaderPanel().setVisible(true);
	}

}
