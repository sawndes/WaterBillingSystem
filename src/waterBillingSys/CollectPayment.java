package waterBillingSys;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import waterBillingSys.SelectCustomer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class CollectPayment extends JFrame implements ActionListener{
	JTable t1;
	JLabel l1;
	JButton b1;
	JTextField t2;
	String x[] = {"Client Id","Name","Username"};
    String months[] ={"Jan", "Feb", "March", "April","May","Jun","July","Aug","Sep","Oct","Nov","Dec",};
    String years[] = {"2022","2023"};
	String y[][] = new String[20][3];
	
	int i=0,j=0;
	int arraySize;
	private String selectedMonths[], selectedYears[];
	String clientIDs[] = new String[8];
CollectPayment(String username) {
		super("Collect Payment");
		try {
			Connect c1 = new Connect();
			String s1 = "select DISTINCT client_id, name, username from clients";
//			String s2 = "SELECT COUNT(DISTINCT Month, Year) FROM `clients` WHERE Unit_Consumed != \"NULL\" AND Read_by != \"NULL\"";
			ResultSet rs = c1.s.executeQuery(s1);
			
			while (rs.next()) {
				y[i][j++]=rs.getString("client_id");
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("username");
                i++;
                j=0;
			}
	
			t1 = new JTable(y,x);
	        JScrollPane sp = new JScrollPane(t1);
	        sp.setBounds(20,20,750,100);
	        add(sp);
	        
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		
//		try {
//			Connect c2 = new Connect();
//			String s2 = "SELECT COUNT(DISTINCT Month, Year) FROM `clients` WHERE Unit_Consumed != \"NULL\" AND Read_by != \"NULL\"";
//			ResultSet rs1 = c2.s.executeQuery(s2);
//			while (rs1.next()) {
//	        	arraySize = rs1.getInt("COUNT(DISTINCT Month, Year)");
//	        }
//	        System.out.println("asdasd= "+arraySize);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//		System.out.println(t1.getRowCount());
//		String value =t1.getModel().getValueAt(0, 1).toString();
//		System.out.println(value);
		
		
		selectedMonths = new String[arraySize];
		selectedYears = new String[arraySize];
		
		l1 = new JLabel("Enter client id to Make Payment: ");
        l1.setBounds(50,260,400,30);
        l1.setFont(new Font("serif",Font.BOLD,17));
        add(l1);
        
        t2 = new JTextField();
        t2.setBounds(300,260,200,30);
        add(t2);
        
        b1 = new JButton("Calculate amount");
        b1.setBounds(250, 400, 170 ,30);
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
			String inp = t2.getText();
			int client_id = Integer.parseInt(inp) -1 ;
//			int client_id = Integer.parseInt(inp);
			String username =t1.getModel().getValueAt(client_id, 2).toString();
			System.out.println(username);
			new SelectMonthYear(username,client_id+1).setVisible(true);
		}
		
	}
	public static void main(String[] args) {
		new CollectPayment("admin").setVisible(true);
	}

}
