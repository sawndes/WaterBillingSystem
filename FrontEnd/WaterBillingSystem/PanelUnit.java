package WaterBillingSystem;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JButton;

public class PanelUnit extends JPanel {
	private JTextField textField;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelUnit() {
		setBounds(0, 0, 565, 480);
		setLayout(null);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(97, 405, 312, 26);
		add(textField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(24, 410, 61, 16);
		add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(24, 51, 516, 310);
		add(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(423, 405, 117, 29);
		add(btnNewButton);
		
	}
}
