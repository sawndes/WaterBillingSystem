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

public class PanelAddUnit extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAddUnit frame = new PanelAddUnit();
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
	public PanelAddUnit() {
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
		
		JLabel lblNewLabel = new JLabel("ADD UNITY");
		lblNewLabel.setForeground(SystemColor.controlHighlight);
		lblNewLabel.setFont(new Font("Kailasa", Font.BOLD, 20));
		lblNewLabel.setBounds(187, 6, 125, 79);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Consumed Unit of bidahn:");
		lblNewLabel_1.setFont(new Font("Al Bayan", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(80, 88, 244, 16);
		panel.add(lblNewLabel_1);

		
		JLabel lblNewLabel_2 = new JLabel("Month :");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(80, 133, 69, 16);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(307, 76, 113, 39);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add Unit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(187, 252, 117, 29);
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
		
		JLabel lblNewLabel_4 = new JLabel("Year :");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(80, 184, 61, 16);
		panel.add(lblNewLabel_4);
		
		JComboBox Year = new JComboBox();
		Year.setBounds(127, 181, 221, 27);
		panel.add(Year);
		
		JComboBox Month = new JComboBox();
		Month.setBounds(147, 130, 158, 27);
		panel.add(Month);
	}
}
