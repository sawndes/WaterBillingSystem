package waterBillingSys;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;

public class PanelAdminCollect extends JPanel {
	JTable t1;
	private JTextField textField;
	String x[] = {"Client Id","Name","Username"};
    String months[] ={"Jan", "Feb", "March", "April","May","Jun","July","Aug","Sep","Oct","Nov","Dec",};
    String years[] = {"2022","2023"};
	String y[][] = new String[20][3];
	int i=0,j=0;
	int arraySize;
	private String selectedMonths[], selectedYears[];
	String clientIDs[] = new String[8];

	/**
	 * Create the panel.
	 */
	public PanelAdminCollect() {
		setBounds(0, 0, 565, 480);
		setLayout(null);
		
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
	        sp.setBounds(23,31,516,150);
	        add(sp);
	        
	        
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Enter client id to Make Payment:");
		lblNewLabel.setBounds(30, 270, 208, 16);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(220, 265, 150, 25);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Calculate amount");
		btnNewButton.setBounds(178, 305, 208, 29);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String inp = textField.getText();
				int client_id = Integer.parseInt(inp) -1 ;
				String username =t1.getModel().getValueAt(client_id, 2).toString();
				System.out.println(username);
				new SelectMonthYear(username,client_id).setVisible(true);
			}
		});


	}
}
