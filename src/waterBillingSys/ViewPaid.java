package waterBillingSys;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ViewPaid extends JFrame implements ActionListener{
	JLabel l1;
	JTable t1;
	JButton b1;
	JTextField t2;
	String x[] = {"Name","Client Id","Paid Amount", "Month", "Year"};
	String y[][] = new String[20][5];
	int i=0,j=0;
	ViewPaid(int client_id) {
		super("View Consumers");
		
		try {
			Connect c1 = new Connect();
			String s1 = "SELECT Name, client_id,Paid_Amount, Month, Year FROM `clients` where Paid_Amount != \"NULL\" and client_id = '"+client_id+"'";
			ResultSet rs = c1.s.executeQuery(s1);
			while (rs.next()) {
				y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("client_id");
                y[i][j++]=rs.getString("Paid_Amount");
                y[i][j++]=rs.getString("Month");
                y[i][j++]=rs.getString("Year");
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
        

       
        

            
        
        
        getContentPane().setBackground(Color.WHITE);
		setSize(1000,400);
		setLocation(200,200);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 
	}
}
