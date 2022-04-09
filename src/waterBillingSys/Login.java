package waterBillingSys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
	private JLabel l1,l2,l3;
    private JTextField t1;
    private JPasswordField t2;
    private JComboBox<String> cb;
    private JButton b1,b2;
    String role[] ={"Please Choose a Role", "Super Admin", "Admin", "Meter Reader"};
	Login() {
		super("Login");

        setBackground(Color.white);
        setLayout(null);

        l1 = new JLabel("Username");
        l1.setBounds(40,20,100,30);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(40,70,100,30);
        add(l2);
        
        l3 = new JLabel("User Role");
        l3.setBounds(40,120,100,30);
        add(l3);
        
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(150,70,150,30);
        add(t2);
        
        cb = new JComboBox<String>(role);
        cb.setBounds(150,120,150,30);
        add(cb);
        
        b1 = new JButton("Login");
        b1.setBounds(40,200,120,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2=new JButton("Cancel");
        b2.setBounds(180,200,120,30);
        b2.setFont(new Font("serif",Font.BOLD,15));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,300);
        setLocation(500,300);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	 public void actionPerformed(ActionEvent ae) {
         if (ae.getSource() == b1) {
             try {
                 Connect c1 = new Connect();
                 String u = t1.getText();
                 String v = t2.getText();
                 String role = (String) cb.getSelectedItem();
                 System.out.println(role);
                 if (role == "Super Admin") {
                     String q = "select * from login where username='" + u + "' and pass='" + v + "' and role = '"+ "Super Admin" +"'";
//                	 String q = "select * from login where username='" + u + "' and pass='" + v + "'";
                     ResultSet rs = c1.s.executeQuery(q);
                     if (rs.next()) {
                    	 
                             this.dispose();
                             new SuperAdminPanel().setVisible(true);
                             System.out.println("Sucessful");  

                         
                     }
                       else {
                             JOptionPane.showMessageDialog(null, "Invalid login");
                             
                         }
                 }
                 else if (role == "Admin") {
                	 String q = "select * from login where username='" + u + "' and pass='" + v + "'and role = '"+ "Admin" +"'";
                     ResultSet rs = c1.s.executeQuery(q);
                     if (rs.next()) {
                    	 c1.s.execute("INSERT INTO `logincheck`(`username`, `role`) VALUES ('"+u+"','"+cb.getSelectedItem()+"')");
                             this.dispose();
                             new AdminPanel().setVisible(true);
                             System.out.println("Sucessful");  

                         
                     }
                       else {
                             JOptionPane.showMessageDialog(null, "Invalid login");
                             
                         }
                 }
                 else if (role == "Meter Reader") {
                	 String q = "select * from login where username='" + u + "' and pass='" + v + "' and role = '"+ "Meter Reader" + "'";
                     ResultSet rs = c1.s.executeQuery(q);
                     if (rs.next()) {
                    	 c1.s.execute("INSERT INTO `logincheck`(`username`, `role`) VALUES ('"+u+"','"+cb.getSelectedItem()+"')");
                             this.dispose();
                             new MeterReaderPanel().setVisible(true);
                             System.out.println("Sucessful");  

                         
                     }
                       else {
                             JOptionPane.showMessageDialog(null, "Invalid login");
                             
                         }
                 }
                 else {
                     JOptionPane.showMessageDialog(null, "Invalid login");
                 }

                 }
      
             catch (Exception e) {
             e.printStackTrace();
             }
         }
      if (ae.getSource()==b2){
             this.dispose();
         } 
	 }
	 
	 public static void main(String[] args) {
		new Login().setVisible(true);
	}
	 

}
