package waterBillingSys;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class PanelManageAdmin extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private int idd;

	/**
	 * Create the panel.
	 */
	public PanelManageAdmin() {
		
		setBounds(0, 0, 565, 480);
		setLayout(null);
		
	      Connect c1;
		try {
			c1 = new Connect();
		      String p = "SELECT `user_id` FROM `login` ORDER BY user_id DESC LIMIT 1";
				ResultSet rs= c1.s.executeQuery(p);
	            while(rs.next()){
	            	idd = rs.getInt("user_id");
	            }
				System.out.println(idd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblreadername = new JLabel("Name");
		lblreadername.setBounds(201, 48, 114, 14);
		add(lblreadername);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelManageAdmin.class.getResource("/res/icons8-user-48.png")));
		lblNewLabel_1.setBounds(147, 28, 54, 44);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(147, 74, 283, 44);
		add(textField);
		
		JLabel lblNewLabel_1_2 = new JLabel("");
		lblNewLabel_1_2.setIcon(new ImageIcon(PanelManageAdmin.class.getResource("/res/icons8-identity-theft-48.png")));
		lblNewLabel_1_2.setBounds(147, 118, 54, 44);
		add(lblNewLabel_1_2);
		
		JLabel lblreaderID = new JLabel("Username");
		lblreaderID.setBounds(201, 133, 114, 14);
		add(lblreaderID);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 159, 283, 44);
		add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(PanelManageAdmin.class.getResource("/res/icons8-pass-fail-48.png")));
		lblNewLabel_1_1.setBounds(147, 215, 54, 44);
		add(lblNewLabel_1_1);
		
		JLabel lblreaderpassword = new JLabel("Password");
		lblreaderpassword.setBounds(201, 235, 114, 14);
		add(lblreaderpassword);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(147, 263, 283, 44);
		add(passwordField);
		
		JButton btncreate = new JButton("Create");
		btncreate.setBounds(143, 423, 283, 29);
		add(btncreate);
		btncreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					int uid = idd+1;
					Connect c1 = new Connect();
					String name = textField.getText();
					String username =textField_1.getText();
					String password = passwordField.getText();
					String q = "INSERT INTO `login`(`name`,`username`, `pass`, `Role`) VALUES ('"+name+"','"+username+"',md5('"+password+"'),'Admin')";
					String s = "INSERT INTO `admin`(`user_id`,`username`,`name`) VALUES ('"+uid+"','"+username+"','"+name+"')";
					c1.s.executeUpdate(q);

					c1.s.executeUpdate(s);
					 JOptionPane.showMessageDialog(null, "Admin Account Added Successfully");
		             setVisible(false);
		             new SuperAdminFrame().setVisible(true);
				} catch (SQLException e1) {
					 JOptionPane.showMessageDialog(null, e1);
		             setVisible(false);
//					e1.printStackTrace();
				}
			}

		});

	}
}
