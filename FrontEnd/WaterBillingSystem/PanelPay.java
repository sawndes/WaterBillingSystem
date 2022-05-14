package WaterBillingSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JMonthChooser;
import com.toedter.components.JLocaleChooser;
import com.toedter.components.JSpinField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Button;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class PanelPay extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPay frame = new PanelPay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PanelPay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		panel.setBounds(0, 0, 565, 480);
		
		JLabel Payment = new JLabel("Payment");
		Payment.setForeground(SystemColor.controlHighlight);
		Payment.setFont(new Font("Kailasa", Font.BOLD, 20));
		Payment.setBounds(204, -16, 125, 79);
		panel.add(Payment);
		
		JButton btnNewButton = new JButton("Pay and Create Receipt");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(155, 303, 199, 29);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_3.setFont(new Font("Apple Braille", Font.BOLD, 16));
		lblNewLabel_3.setBounds(474, 0, 16, 16);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(70, 55, 125, 65);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("500.1");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 37));
		lblNewLabel.setBounds(11, 28, 108, 28);
		panel_1.add(lblNewLabel);
		
				
				JLabel lblNewLabel_2 = new JLabel("UNIT");
				lblNewLabel_2.setBounds(11, 6, 39, 16);
				panel_1.add(lblNewLabel_2);
				lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				
				JPanel panel_1_1 = new JPanel();
				panel_1_1.setLayout(null);
				panel_1_1.setBackground(Color.WHITE);
				panel_1_1.setBounds(202, 55, 97, 65);
				panel.add(panel_1_1);
				
				JLabel lblJan = new JLabel("Jan");
				lblJan.setFont(new Font("Lucida Grande", Font.BOLD, 34));
				lblJan.setBounds(20, 22, 58, 37);
				panel_1_1.add(lblJan);
				
				JLabel lblNewLabel_2_2 = new JLabel("Month");
				lblNewLabel_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				lblNewLabel_2_2.setBounds(19, 6, 63, 16);
				panel_1_1.add(lblNewLabel_2_2);
				
				JPanel panel_1_1_1 = new JPanel();
				panel_1_1_1.setLayout(null);
				panel_1_1_1.setBackground(Color.WHITE);
				panel_1_1_1.setBounds(311, 55, 130, 65);
				panel.add(panel_1_1_1);
				
				JLabel lblNewLabel_1_1 = new JLabel("2022");
				lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 37));
				lblNewLabel_1_1.setBounds(16, 28, 108, 28);
				panel_1_1_1.add(lblNewLabel_1_1);
				
				JLabel lblNewLabel_2_2_1 = new JLabel("YEAR");
				lblNewLabel_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				lblNewLabel_2_2_1.setBounds(37, 6, 62, 16);
				panel_1_1_1.add(lblNewLabel_2_2_1);
				
				JLabel lblNewLabel_1 = new JLabel("Price Per Unit :");
				lblNewLabel_1.setBounds(95, 145, 125, 16);
				panel.add(lblNewLabel_1);
				
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(SystemColor.windowText);
				panel_2.setForeground(SystemColor.windowText);
				panel_2.setBounds(82, 173, 347, 2);
				panel.add(panel_2);
				
				JLabel lblNewLabel_1_2 = new JLabel("Total Amount :");
				lblNewLabel_1_2.setBounds(95, 187, 125, 16);
				panel.add(lblNewLabel_1_2);
				
				JLabel lblNewLabel_4 = new JLabel("New label");
				lblNewLabel_4.setBounds(191, 145, 61, 16);
				panel.add(lblNewLabel_4);
				
				JLabel lblNewLabel_4_1 = new JLabel("New label");
				lblNewLabel_4_1.setBounds(191, 187, 61, 16);
				panel.add(lblNewLabel_4_1);
				
				JPanel panel_3 = new JPanel();
				panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_3.setBackground(new Color(60, 179, 113));
				panel_3.setBounds(95, 262, 97, 29);
				panel.add(panel_3);
				
				JLabel lblNewLabel_5 = new JLabel("Esewa");
				lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD, 13));
				lblNewLabel_5.setForeground(new Color(255, 255, 255));
				lblNewLabel_5.setBackground(new Color(255, 255, 255));
				panel_3.add(lblNewLabel_5);
				
				JPanel panel_3_1 = new JPanel();
				panel_3_1.setBackground(new Color(72, 61, 139));
				panel_3_1.setBounds(204, 262, 97, 29);
				panel.add(panel_3_1);
				
				JLabel lblNewLabel_5_1 = new JLabel("Khalti");
				lblNewLabel_5_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
				lblNewLabel_5_1.setForeground(new Color(255, 255, 255));
				panel_3_1.add(lblNewLabel_5_1);
				
				JPanel panel_3_2 = new JPanel();
				panel_3_2.setBackground(new Color(47, 79, 79));
				panel_3_2.setBounds(313, 262, 97, 29);
				panel.add(panel_3_2);
				
				JLabel lblNewLabel_5_1_1 = new JLabel("Bank");
				lblNewLabel_5_1_1.setFont(new Font("DialogInput", Font.BOLD, 13));
				lblNewLabel_5_1_1.setForeground(new Color(255, 255, 255));
				panel_3_2.add(lblNewLabel_5_1_1);
	}
}
