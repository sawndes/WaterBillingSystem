package WaterBillingSystem;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelViewConsumer extends JPanel {
	private JTable table;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelViewConsumer() {
		setBounds(0, 0, 565, 480);
		setLayout(null);
		
		table = new JTable();
		table.setBounds(23, 31, 516, 310);
		add(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(23, 390, 61, 16);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(96, 385, 312, 26);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(422, 385, 117, 29);
		add(btnNewButton);
	    
	}
}
