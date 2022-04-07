package waterBillingSys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CalculateAmount extends JFrame implements ActionListener{
	static float unit[]= new float[100];
	int i;
	JLabel l1,l2;
	JButton b1,b2;
	double perUnit;
	CalculateAmount(String month, int year, int client_id) {
	
		try {
			Connect c2 = new Connect();
			String s2 = "SELECT DISTINCT Unit_Consumed FROM `clients` WHERE Year = '"+year+"' AND Month='"+month+"' AND client_id = '"+client_id+"'";
			ResultSet rs1 = c2.s.executeQuery(s2);
			i=0;
			while (rs1.next()) {
	        	unit[i] = rs1.getFloat("Unit_Consumed");
	        	i++;	
			}	
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
//		if (unit[0] <= 200) {
//			perUnit = 20.2;
//			System.out.println(perUnit);
//		}
//		else if (unit[0] <= 201) {
//			perUnit = 15.0;
//			System.out.println(perUnit);
//		}
		
		System.out.println(unit[0]);
		if (unit[0] <= 300) {
			perUnit = 15;
		}
		else {
			perUnit = 20;
		}
		System.out.println(perUnit);
		l1 = new JLabel("Unit= "+ unit[0]);
        l1.setBounds(50,100,400,30);
        l1.setFont(new Font("serif",Font.BOLD,17));
        add(l1);
        
		l2 = new JLabel("Amount= "+ unit[0]*perUnit);
        l2.setBounds(50,130,400,30);
        l2.setFont(new Font("serif",Font.BOLD,17));
        add(l2);
		
        b1 = new JButton("Pay and Create Receipt");
        b1.setBounds(200,300,200,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        add(b1);
        

		setResizable(false);
		  setSize(800,600);  
		  setLayout(null);  
		  setVisible(true); 
		  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
		  
	public static void main(String[] args) {
		new CalculateAmount("March",2022,1).setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
