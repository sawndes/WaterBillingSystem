package WaterBillingSystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class PanelManageAdmin extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public PanelManageAdmin() {
		
		setBounds(0, 0, 565, 480);
		setLayout(null);
		
		JLabel lblreadername = new JLabel("UserName");
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
		
		JLabel lblreaderID = new JLabel("UserID");
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
		
		JButton btncreate = new JButton("Create");
		btncreate.setBounds(143, 423, 283, 29);
		add(btncreate);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(147, 263, 283, 44);
		add(passwordField);

	}
}
