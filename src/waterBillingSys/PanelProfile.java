package waterBillingSys;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Component;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class PanelProfile extends JPanel {
	

	/**
	 * Create the panel.
	 */
	public PanelProfile() {
		setBounds(0, 0, 565, 480);
		setLayout(null);
//		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 20, 20));
		
		JLabel lblNewLabel = new JLabel("Profile");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(237, 6, 62, 37);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(89, 84, 386, 298);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1.setBounds(115, 44, 61, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(MeterReaderFrame.mrname);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2.setBounds(175, 44, 170, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("UserID:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(115, 74, 74, 16);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel(MeterReaderFrame.mruserid);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(185, 72, 109, 16);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Username:");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(115, 105, 100, 16);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel(MeterReaderFrame.mrusername);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_2_2.setBounds(210, 105, 109, 16);
		panel.add(lblNewLabel_2_2);
		
//		JLabel lblNewLabel_1_3 = new JLabel("Name:");
//		lblNewLabel_1_3.setFont(new Font("Arial", Font.BOLD, 18));
//		lblNewLabel_1_3.setBounds(115, 133, 61, 16);
//		panel.add(lblNewLabel_1_3);
//		
//		JLabel lblNewLabel_2_3 = new JLabel("New label");
//		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 18));
//		lblNewLabel_2_3.setBounds(175, 133, 109, 16);
//		panel.add(lblNewLabel_2_3);
	}
}
