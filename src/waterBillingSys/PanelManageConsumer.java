package waterBillingSys;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class PanelManageConsumer extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2,textField_3,textField_4;
    String months[] ={"Jan", "Feb", "March", "April","May","Jun","July","Aug","Sep","Oct","Nov","Dec",};
    String years[] = {"2022","2023"};
	/**
	 * Create the panel.
	 */
	public PanelManageConsumer() {
		
		setBounds(0, 0, 565, 480);
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(143, 74, 283, 44);
		add(textField);
		
		JLabel lblreadername = new JLabel("Name");
		lblreadername.setBounds(197, 48, 114, 14);
		add(lblreadername);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelManageReader.class.getResource("/res/icons8-user-48.png")));
		lblNewLabel_1.setBounds(143, 28, 54, 44);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(PanelManageReader.class.getResource("/res/icons8-pass-fail-48.png")));
		lblNewLabel_1_1.setBounds(143, 215, 54, 44);
		add(lblNewLabel_1_1);
		
		JLabel lblreaderID = new JLabel("Username");
		lblreaderID.setBounds(197, 133, 114, 14);
		add(lblreaderID);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(143, 159, 283, 44);
		add(textField_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(PanelManageReader.class.getResource("/res/icons8-identity-theft-48.png")));
		lblNewLabel_1_2.setBounds(143, 113, 54, 44);
		add(lblNewLabel_1_2);
		
		JLabel lblreaderlocation = new JLabel("Address ");
		lblreaderlocation.setBounds(197, 329, 114, 14);
		add(lblreaderlocation);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(143, 355, 283, 44);
		add(textField_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("");
		lblNewLabel_1_3.setIcon(new ImageIcon(PanelManageReader.class.getResource("/res/icons8-location-48.png")));
		lblNewLabel_1_3.setBounds(143, 309, 54, 44);
		add(lblNewLabel_1_3);
		
		JLabel lblConsumerAdress = new JLabel("Client ID");
		lblConsumerAdress.setBounds(201, 235, 114, 14);
		add(lblConsumerAdress);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(147, 261, 283, 44);
		add(textField_4);
		
		JButton btncreate = new JButton("Create");
		btncreate.setBounds(143, 423, 283, 29);
		add(btncreate);
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
	            	String uid = textField_4.getText();
	            	int userid = Integer.parseInt(uid);
	                Connect c1 = new Connect();
	                String name = textField.getText();
	                String username = textField_2.getText();
	                String address = textField_3.getText();
	                for (int i=0; i<12;i++){
	                  	 for (int j =0;j<2;j++) {
	                    	String a = "Insert into clients(client_id,name,username,address,month,year)  values('"+userid+"','"+name+"', '"+username+"', '"+address+"','"+months[i]+"','"+years[j]+"')";
//	                    	System.out.println(a);
	                       c1.s.executeUpdate(a);
	                  	 }
	                   }
					 JOptionPane.showMessageDialog(null, "Client Added Successfully");
		             setVisible(false);
		             new SuperAdminFrame().setVisible(true);
	            } catch (SQLException ex) {
	            	JOptionPane.showMessageDialog(null, ex);
		             setVisible(false);
	                ex.printStackTrace(); 
	            }
			}
		});

	}
}
