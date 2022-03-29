package waterBillingSys;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AddUser extends JFrame implements ActionListener {
	private JLabel l1, l,l2,l3;
    private JTextField t1,t2,t3;
    private JButton b1;
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
      
      l3 = new JLabel("Address");
      l3.setBounds(10,160,150,30);
      add(l3);
      
      t3=new JTextField();
      t3.setBounds(135,164,170,25);
      add(t3);
      
      // Button for logout
      b1 = new JButton("Save");
      b1.setBounds(250, 380, 115 ,30);
      add(b1);
      b1.addActionListener(this);
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
                Connect c1 = new Connect();
                String name = t1.getText();
                String username = t2.getText();
                String address = t3.getText();
                String a = "Insert into clients(name,username,address)  values('"+name+"', '"+username+"', '"+address+"')";
                c1.s.executeUpdate(a);
            } catch (SQLException ex) {
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
