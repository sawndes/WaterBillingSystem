package waterBillingSys;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ViewConsumers extends JFrame implements ActionListener{
	JLabel l1;
	JTable t1;
	JButton b1;
	JTextField t2;
	String x[] = {"Name","Username","Address"};
	String y[][] = new String[20][3];
	int i=0,j=0;
	ViewConsumers() {
		super("View Consumers");
		
		try {
			Connect c1 = new Connect();
			String s1 = "select DISTINCT name, username, address from clients";
			ResultSet rs = c1.s.executeQuery(s1);
			while (rs.next()) {
				y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("username");
                y[i][j++]=rs.getString("address");
                i++;
                j=0;
			}
			t1 = new JTable(y,x);
		}catch (Exception e) {
			e.printStackTrace();
		}
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20,20,950,200);
        add(sp);
        
        l1 = new JLabel("Enter username to delete client: ");
        l1.setBounds(50,260,400,30);
        l1.setFont(new Font("serif",Font.BOLD,17));
        add(l1);
        
        t2 = new JTextField();
        t2.setBounds(300,260,200,30);
        add(t2);
        
        b1 = new JButton("Delete");
        b1.setBounds(520, 260, 100 ,30);
        add(b1);
            
        
        b1.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
		setSize(1000,400);
		setLocation(200,200);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 
        Connect c1;
		try {
			c1 = new Connect();
	        if(e.getSource() == b1){
	            try{
	                String a = t2.getText();
	                String q = "delete from `clients` where username = '"+a+"'";
	                c1.s.executeUpdate(q);
	                this.setVisible(false);
	                new ViewConsumers().setVisible(true);
	            }catch(Exception e2){}
	        }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		new ViewConsumers().setVisible(true);
	}

}
