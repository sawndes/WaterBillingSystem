package WaterBillingSystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelAdminCollect extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelAdminCollect() {
		setBounds(0, 0, 565, 480);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter client id to Make Payment:");
		lblNewLabel.setBounds(178, 172, 208, 16);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(176, 200, 208, 43);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Calculate amount");
		btnNewButton.setBounds(178, 305, 208, 29);
		add(btnNewButton);


	}
}
