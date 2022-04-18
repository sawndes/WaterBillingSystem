package waterBillingSys;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

public class PanelViewConsumer extends JPanel {
	private JTable t1;
	private JTextField textField;
	String x[] = {"Client Id","Name","Username"};
    String months[] ={"Jan", "Feb", "March", "April","May","Jun","July","Aug","Sep","Oct","Nov","Dec",};
    String years[] = {"2022","2023"};
	String y[][] = new String[20][3];
	int i=0,j=0;
	private String mrusername, conusername,conname,conaddress;
	public PanelViewConsumer(String location, String username) {
		setBounds(0, 0, 565, 480);
		setLayout(null);
		try {
			Connect c1 = new Connect();
			String s1 = "select DISTINCT client_id, name, username from clients where address = '"+location+"'";
			ResultSet rs = c1.s.executeQuery(s1);
			while (rs.next()) {
				y[i][j++]=rs.getString("client_id");
                y[i][j++]=rs.getString("name");
                conname = rs.getString("name");
                conusername = rs.getString("username");
                y[i][j++]=rs.getString("username");
                i++;
                j=0;
			}
			t1 = new JTable(y,x);
		}catch (Exception e) {
			e.printStackTrace();
		}
		 JScrollPane sp = new JScrollPane(t1);
	        sp.setBounds(23,31,516,250);
	        add(sp);

		JLabel lblNewLabel = new JLabel("Enter client id to add unit: ");
		lblNewLabel.setBounds(23, 310, 160, 16);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(180,305, 290, 26);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Unit");
		btnNewButton.setBounds(200, 385, 117, 29);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					String uid = textField.getText();
					int uidd = Integer.parseInt(uid);
					Connect c1 = new Connect();
//			         for (int i=0; i<12;i++){
//			        	 for (int j =0;j<2;j++) {
//			        		 if ((months[i]=="Jan" && years[j] == "2022") || (months[i]=="Jan" && years[j] == "2023")) {
//			        			 continue;
//			        		 }
//			        		 else {
//			        			 String a = "Insert into clients(client_id,name,username,address,month,year)  values('"+uid+"','"+conname+"', '"+conusername+"', '"+conaddress+"','"+months[i]+"','"+years[j]+"')";
//			         			String b = "Update clients set client_id = '"+uid+"' WHERE name = '"+conname+"' AND username='"+conusername+"'";
//			                     c1.s.executeUpdate(a);
//			                     c1.s.executeUpdate(b);
//			        		 }
//			        		 
//			        	 }
//			         }
					System.out.println(uidd);
					new AddUnit(uidd, MeterReaderFrame.mrusername).setVisible(true);
					
					}catch (SQLException ex) {
			        	JOptionPane.showMessageDialog(null, ex);
			            setVisible(false);
//			            this.dispose();
//			            new SuperAdminPanel().setVisible(true);
			           ex.printStackTrace(); 
			       }

			}
	    
		});
	}
}
