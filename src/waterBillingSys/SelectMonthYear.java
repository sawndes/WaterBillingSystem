package waterBillingSys;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class SelectMonthYear extends JFrame implements ActionListener{
	private String selectedMonths[], selectedYears[];
	JButton b1;
	JLabel l1;
	int client_idd;
	int arraySize;
	String usernamee;
	JComboBox comboMonth,comboYear;

	public SelectMonthYear(int client_id) {
		try {
			Connect c2 = new Connect();
//			String s2 = "SELECT COUNT(DISTINCT Month, Year) FROM `clients` WHERE Unit_Consumed != \"NULL\" AND Read_by != \"NULL\"";
//			String s2 = "SELECT COUNT(DISTINCT Month, Year) from clients where Unit_Consumed !=\"NULL\" AND client_id = '"+client_id+"'AND Read_by != \"NULL\" AND Paid_Amount = \"NULL\"";
			String s2 = "SELECT COUNT(DISTINCT Month, Year) from clients where Unit_Consumed !=\"NULL\" AND client_id = '"+client_id+"'AND Read_by != \"NULL\"";
			ResultSet rs1 = c2.s.executeQuery(s2);
			while (rs1.next()) {
	        	arraySize = rs1.getInt("COUNT(DISTINCT Month, Year)");
//				arraySize = rs1.getInt("COUNT(Month)");
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Connect c2 = new Connect();
//			String s2 = "SELECT COUNT(DISTINCT Month, Year) from clients where Unit_Consumed !=\"NULL\" AND client_id = '"+client_id+"'AND Read_by != \"NULL\"";
			String s2 = "SELECT DISTINCT username FROM `clients` WHERE client_id='"+client_id+"'";
			ResultSet rs1 = c2.s.executeQuery(s2);
			while (rs1.next()) {
	        	usernamee = rs1.getString("username");
//				arraySize = rs1.getInt("COUNT(Month)");
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
		client_idd = client_id;
		System.out.println("Arraysize "+arraySize);
	
		System.out.println(usernamee+ " HHHHHH");
		System.out.println(client_id);
		selectedMonths = new String[arraySize];
		selectedYears = new String[arraySize];
		
		try {
			int i =0;
			Connect c2 = new Connect();
			String s2 = "SELECT DISTINCT Month, Year FROM `clients` WHERE Unit_Consumed != \"NULL\" AND Read_by != \"NULL\" AND client_id = '"+client_idd+"'";
//			String s2 = "SELECT DISTINCT Month, Year FROM `clients` WHERE Unit_Consumed != \"NULL\" AND Read_by != \"NULL\" AND client_id = '"+client_idd+"' AND Paid_Amount = \"NULL\"";
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
		l1 = new JLabel("Select Year and Month to Make Payment");
        l1.setBounds(130,0,400,30);
        l1.setFont(new Font("serif",Font.BOLD,17));
        add(l1);
        
		l1 = new JLabel("Month:");
        l1.setBounds(33,43,400,30);
        l1.setFont(new Font("serif",Font.BOLD,15));
        add(l1);
		comboMonth = new JComboBox(selectedMonths);
		comboMonth.setBounds(100, 50,90,20); 
		add(comboMonth);
		
		l1 = new JLabel("Year:");
        l1.setBounds(33,93,400,30);
        l1.setFont(new Font("serif",Font.BOLD,15));
        add(l1);
		
		comboYear = new JComboBox(selectedYears);
		comboYear.setBounds(100, 100,90,20); 
		add(comboYear);
		
		
        b1 = new JButton("Next");
        b1.setBounds(200, 150, 100 ,30);
        add(b1);
        b1.addActionListener(this);
		
		setResizable(false);
		  setSize(600,250);  
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
//			new CalculateAmount(month,yearr, client_idd).setVisible(true);
			new PanelPay(month,yearr,client_idd).setVisible(true);
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
		new SelectMonthYear(2).setVisible(true);

	}

}
