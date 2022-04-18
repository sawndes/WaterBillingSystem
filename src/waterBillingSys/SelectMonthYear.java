package waterBillingSys;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class SelectMonthYear extends JFrame implements ActionListener{
	private String selectedMonths[], selectedYears[];
	JButton b1;
	int client_idd;
	int arraySize;
	String usernamee;
	JComboBox comboMonth,comboYear;

	public SelectMonthYear(String username, int client_id) {
		try {
			Connect c2 = new Connect();
//			String s2 = "SELECT COUNT(DISTINCT Month, Year) FROM `clients` WHERE Unit_Consumed != \"NULL\" AND Read_by != \"NULL\"";
			String s2 = "SELECT COUNT(DISTINCT Month, Year) from clients where Unit_Consumed !=\"NULL\" AND client_id = '"+client_id+"'AND Read_by != \"NULL\"";
			ResultSet rs1 = c2.s.executeQuery(s2);
			while (rs1.next()) {
	        	arraySize = rs1.getInt("COUNT(DISTINCT Month, Year)");
//				arraySize = rs1.getInt("COUNT(Month)");
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
		client_idd = client_id;
		usernamee = username;
		System.out.println("Arraysize "+arraySize);
	
		System.out.println(username);
		System.out.println(client_id);
		selectedMonths = new String[arraySize];
		selectedYears = new String[arraySize];
		
		try {
			int i =0;
			Connect c2 = new Connect();
			String s2 = "SELECT DISTINCT Month, Year FROM `clients` WHERE Unit_Consumed != \"NULL\" AND Read_by != \"NULL\" AND client_id = '"+client_idd+"'";
			ResultSet rs1 = c2.s.executeQuery(s2);
			while (rs1.next()) {
//	        	arraySize = rs1.getInt("COUNT(DISTINCT Month, Year)");
				selectedMonths[i]=rs1.getString("Month");
				selectedYears[i]=rs1.getString("Year");
	        	i++;
	        }
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		comboMonth = new JComboBox(selectedMonths);
		comboMonth.setBounds(100, 50,90,20); 
		add(comboMonth);
		
		comboYear = new JComboBox(selectedYears);
		comboYear.setBounds(100, 150,90,20); 
		add(comboYear);
		
		
        b1 = new JButton("Next");
        b1.setBounds(250, 400, 100 ,30);
        add(b1);
        b1.addActionListener(this);
		
		setResizable(false);
		  setSize(800,600);  
		  setLayout(null);  
		  setVisible(true); 
		  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1){
			String year = (String) comboYear.getSelectedItem();
			int yearr = Integer.parseInt(year);
			String month = (String) comboMonth.getSelectedItem();
			new CalculateAmount(month,yearr, client_idd).setVisible(true);
			this.dispose();
//			double unit;
//			try {
//				Connect c2 = new Connect();
//				String s2 = "SELECT DISTINCT Unit_Consumed FROM `clients` WHERE Year = '"+yearr+"' AND Month='"+month+"' AND client_id = '"+client_idd+"'";
//				ResultSet rs1 = c2.s.executeQuery(s2);
//				while (rs1.next()) {
//		        	unit = rs1.getDouble("Unit_Consumed");
//		        	
//		        }
//				System.out.println("asdasd= "+unit);
//			}catch (Exception e1) {
//				e1.printStackTrace();
//			}
		}
		
	}
	public static void main(String[] args) {
		new SelectMonthYear("b",2).setVisible(true);

	}

}
