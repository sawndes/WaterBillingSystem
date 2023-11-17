package waterBillingSys;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class PanelAdminChange extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Create the panel.
	 */
	public PanelAdminChange() {
		setBounds(0, 0, 565, 480);
		setLayout(null);
		
		JLabel lblreadername = new JLabel("UserName");
		lblreadername.setBounds(196, 88, 114, 14);
		add(lblreadername);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelChange.class.getResource("/res/icons8-user-48.png")));
		lblNewLabel_1.setBounds(142, 68, 54, 44);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(142, 114, 283, 44);
		add(textField);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(196, 295, 114, 14);
		add(lblNewPassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(PanelChange.class.getResource("/res/icons8-pass-fail-48.png")));
		lblNewLabel_1_1.setBounds(142, 275, 54, 48);
		add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(142, 324, 283, 44);
		add(passwordField);
		
		JLabel lblCurrentPassword = new JLabel("Current Password");
		lblCurrentPassword.setBounds(196, 190, 114, 14);
		add(lblCurrentPassword);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(PanelChange.class.getResource("/res/icons8-pass-fail-48.png")));
		lblNewLabel_1_1_1.setBounds(142, 170, 54, 48);
		add(lblNewLabel_1_1_1);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(142, 219, 283, 44);
		add(passwordField_1);
		
		JButton btnNewButton = new JButton("Chanage");
		btnNewButton.setBounds(142, 413, 283, 29);
		add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					Connect c1 = new Connect();
					String username = textField.getText();
					String newpass = passwordField.getText();
					String oldpass = passwordField_1.getText();
					String s1 = "UPDATE `login` SET `pass`='"+newpass+"'WHERE `username`='"+username+"' AND `pass`='"+oldpass+"'";
					c1.s.executeUpdate(s1);
					JOptionPane.showMessageDialog(null, "Password Changed Sucessfully");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}
}
