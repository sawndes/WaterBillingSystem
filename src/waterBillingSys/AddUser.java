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
import javax.swing.JTextField;


public class AddUser extends JFrame implements ActionListener {
	private JLabel l1, l,l2,l3,l4;
    private JTextField t1,t2,t3,t4;
    private JButton b1;
    private int idd;
    String months[] ={"Jan", "Feb", "March", "April","May","Jun","July","Aug","Sep","Oct","Nov","Dec",};
    String years[] = {"2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033"};
	AddUser() {
	  super("Add Consumer");
	  
	  l = new JLabel("Add Consumer");
	  l.setBounds(220,0,400,40);
	  l.setFont(new Font("Senserif", Font.BOLD, 20));
	  add(l);
	  
      l1 = new JLabel("Consumer Name");
      l1.setBounds(10,60,100,30);
      add(l1);
      
      t1=new JTextField();
      t1.setBounds(135,64,170,25);
      add(t1);
      
      l2 = new JLabel("Consumer username");
      l2.setBounds(10,110,150,30);
      add(l2);
      
      t2=new JTextField();
      t2.setBounds(135,114,170,25);
      add(t2);
      
      l4 = new JLabel("Consumer id");
      l4.setBounds(10,160,150,30);
      add(l4);
      
      t4=new JTextField();
      t4.setBounds(135,164,170,25);
      add(t4);
      
      l3 = new JLabel("Address");
      l3.setBounds(10,210,150,30);
      add(l3);
      
      t3=new JTextField();
      t3.setBounds(135,204,170,25);
      add(t3);
      
      // Button for logout
      b1 = new JButton("Save");
      b1.setBounds(250, 380, 115 ,30);
      add(b1);
      b1.addActionListener(this);
      
      
//      Connect c1;
//	try {
//		c1 = new Connect();
//	      String p = "SELECT `user_id` FROM `login` ORDER BY user_id DESC LIMIT 1";
//			ResultSet rs= c1.s.executeQuery(p);
//            while(rs.next()){
//            	idd = rs.getInt("user_id");
//            }
//			System.out.println(idd);
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
//    Connect c2;
//	try {
//		c2 = new Connect();
//	      String p = "SELECT `user_id` FROM `login` ORDER BY user_id DESC LIMIT 1";
//			ResultSet rs= c2.s.executeQuery(p);
//          while(rs.next()){
//          	idd = rs.getInt("user_id");
//          }
//			System.out.println(idd);
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
      
      
      setResizable(false);
	  setSize(600,500);  
	  setLayout(null);  
	  setVisible(true); 
	  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()== b1){
            try {
//            	int uid = idd+1;
            	String uid = t4.getText();
            	int userid = Integer.parseInt(uid);
                Connect c1 = new Connect();
                String name = t1.getText();
                String username = t2.getText();
                String address = t3.getText();
            	String a = "Insert into clients(client_id,name,username,address,month,year)  values('"+userid+"','"+name+"', '"+username+"', '"+address+"','Jan','2022')";
                c1.s.executeUpdate(a);
                
            } catch (SQLException ex) {
            	JOptionPane.showMessageDialog(null, ex);
	             setVisible(false);
//	             this.dispose();
//	             new SuperAdminPanel().setVisible(true);
                ex.printStackTrace(); 
            }
		 }
        JOptionPane.showMessageDialog(null, "Client Added Successfully");
        setVisible(false);
	}
	 public static void main(String[] args){
	      new AddUser().setVisible(true);

	  }

}
