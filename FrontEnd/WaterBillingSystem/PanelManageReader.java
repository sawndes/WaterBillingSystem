package WaterBillingSystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class PanelManageReader extends JPanel {
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public PanelManageReader() {
		
		setBounds(0, 0, 565, 480);
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(143, 74, 283, 44);
		add(textField);
		
		JLabel lblreadername = new JLabel("UserName");
		lblreadername.setBounds(197, 48, 114, 14);
		add(lblreadername);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PanelManageReader.class.getResource("/res/icons8-user-48.png")));
		lblNewLabel_1.setBounds(143, 28, 54, 44);
		add(lblNewLabel_1);
		
		JLabel lblreaderpassword = new JLabel("Password");
		lblreaderpassword.setBounds(197, 235, 114, 14);
		add(lblreaderpassword);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(PanelManageReader.class.getResource("/res/icons8-pass-fail-48.png")));
		lblNewLabel_1_1.setBounds(143, 215, 54, 44);
		add(lblNewLabel_1_1);
		
		JLabel lblreaderID = new JLabel("UserID");
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
		
		JLabel lblreaderlocation = new JLabel("Location ");
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
		
		JButton btncreate = new JButton("Create");
		btncreate.setBounds(143, 422, 283, 29);
		add(btncreate);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(143, 264, 283, 44);
		add(passwordField);
		setVisible(true);

	}

}
