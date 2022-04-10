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

public class SuperAdminPanelViewConsumer extends JPanel {
	private JTable t1;
	private JTextField textField;
	String x[] = {"Name","Username","Address"};
	String y[][] = new String[20][3];
	int i=0,j=0;
	/**
	 * Create the panel.
	 */
	public SuperAdminPanelViewConsumer() {
		setBounds(0, 0, 565, 480);
		setLayout(null);
		
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
        sp.setBounds(20,20,516,200);
        add(sp);
		
		JLabel lblNewLabel = new JLabel("Enter username to delete client: ");
		lblNewLabel.setBounds(23, 250, 200, 16);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(240, 245, 270, 26);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(250, 385, 117, 29);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Connect c1;
				try {
					c1 = new Connect();
			            try{
			                String a = textField.getText();
			                String q = "delete from `clients` where username = '"+a+"'";
			                c1.s.executeUpdate(q);
			                setVisible(false);
			                new SuperAdminFrame().setVisible(true);
			                new ViewConsumers().setVisible(true);
			            }catch(Exception e2){}
			        
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});

	    
	}
}
