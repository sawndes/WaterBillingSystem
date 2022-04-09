package WaterBillingSystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class PanelManageConsumer extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public PanelManageConsumer() {
		
		setBounds(0, 0, 565, 480);
		setLayout(null);
		
		JLabel lblConsumerName = new JLabel("UserName");
		lblConsumerName.setBounds(201, 48, 114, 14);
		add(lblConsumerName);
		
		JLabel ConsumerName = new JLabel("");
		ConsumerName.setIcon(new ImageIcon(PanelManageConsumer.class.getResource("/res/icons8-user-48.png")));
		ConsumerName.setBounds(147, 28, 54, 44);
		add(ConsumerName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(147, 74, 283, 44);
		add(textField);
		
		JLabel lblConsumerID = new JLabel("");
		lblConsumerID.setIcon(new ImageIcon(PanelManageConsumer.class.getResource("/res/icons8-identity-theft-48.png")));
		lblConsumerID.setBounds(147, 118, 54, 44);
		add(lblConsumerID);
		
		JLabel lblreaderID = new JLabel("UserID");
		lblreaderID.setBounds(201, 133, 114, 14);
		add(lblreaderID);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 159, 283, 44);
		add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(PanelManageConsumer.class.getResource("/res/icons8-location-48.png")));
		lblNewLabel_1_1.setBounds(147, 215, 54, 44);
		add(lblNewLabel_1_1);
		
		JLabel lblConsumerAdress = new JLabel("Address");
		lblConsumerAdress.setBounds(201, 235, 114, 14);
		add(lblConsumerAdress);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 261, 283, 44);
		add(textField_2);
		
		JButton btncreate = new JButton("Create");
		btncreate.setBounds(143, 423, 283, 29);
		add(btncreate);

	}
}
