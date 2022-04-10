package waterBillingSys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MeterReaderManager extends JFrame implements ActionListener {
	private JLabel l1,l3,l2, l4,l5;
	private JTextField t1,t2,t3,t4,t5;
	private JButton b1;
	private int idd;
	MeterReaderManager() {
		// GUI
		  super("Meter Reader Account");
		  l1 = new JLabel("Name");
	      l1.setBounds(40,40,100,30);
	      l1.setFont(new Font("Senserif", Font.BOLD, 20));
	      add(l1);

	      l2 = new JLabel("Username");
	      l2.setBounds(40,100,100,30);
	      l2.setFont(new Font("Senserif", Font.BOLD, 20));
	      add(l2);
	        
	      l3 = new JLabel("Password");
	      l3.setBounds(40,160,100,30);
	      l3.setFont(new Font("Senserif", Font.BOLD, 20));
	      add(l3);
	      
//	      l4 = new JLabel("User ID");
//	      l4.setBounds(40,220,100,30);
//	      l4.setFont(new Font("Senserif", Font.BOLD, 20));
//	      add(l4);
	      
	      l5 = new JLabel("Location");
	      l5.setBounds(40,280,100,30);
	      l5.setFont(new Font("Senserif", Font.BOLD, 20));
	      add(l5);
	      
	      t1=new JTextField();
	      t1.setBounds(150,40,150,30);
	      add(t1);
	      
	      t2=new JTextField();
	      t2.setBounds(150,100,150,30);
	      add(t2);
	      
	      t3=new JTextField();
	      t3.setBounds(150,160,150,30);
	      add(t3);
	      
//	      t4=new JTextField();
//	      t4.setBounds(150,220,150,30);
//	      add(t4);
	      
	      t5=new JTextField();
	      t5.setBounds(150,280,150,30);
	      add(t5);
	      
	      b1 = new JButton("Create");
	      b1.setBounds(300,400,120,30);
	      b1.setFont(new Font("serif",Font.BOLD,15));
	      b1.addActionListener(this);
	      add(b1);
	      
	    Connect c1;
		try {
			c1 = new Connect();
		      String p = "SELECT `user_id` FROM `login` ORDER BY user_id DESC LIMIT 1";
				ResultSet rs= c1.s.executeQuery(p);
	            while(rs.next()){
	            	idd = rs.getInt("user_id");
	            }
				System.out.println(idd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		if (e.getSource() == b1) {
			try {
				int uid = idd+1;
				Connect c1 = new Connect();
				String name = t1.getText();
				String username =t2.getText();
				String password = t3.getText();
//				String user_id = t4.getText();
				String location = t5.getText();
//				String q = "INSERT INTO `login`(`user_id`,`name`,`username`, `pass`, `Role`) VALUES ('"+user_id+"','"+name+"','"+username+"','"+password+"','Meter Reader')";
				String q = "INSERT INTO `login`(`name`,`username`, `pass`, `Role`) VALUES ('"+name+"','"+username+"','"+password+"','Meter Reader')";
				String s = "INSERT INTO `meter_reader`(`user_id`,`username`,`name`, `location`) VALUES ('"+uid+"','"+username+"','"+name+"','"+location+"')";
				c1.s.executeUpdate(q);
				c1.s.executeUpdate(s);
				 JOptionPane.showMessageDialog(null, "Meter Reader Added Successfully");
	             setVisible(false);
			} catch (SQLException e1) {
				 JOptionPane.showMessageDialog(null, e1);
	             setVisible(false);
//				e1.printStackTrace();
			}

		}
		
	}
	public static void main(String[] args) {
		new MeterReaderManager().setVisible(true);
	}

}
