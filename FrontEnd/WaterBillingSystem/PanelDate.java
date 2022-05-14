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

public class PanelDate extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelDate frame = new PanelDate();
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
	public PanelDate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 500, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setBounds(0, 0, 565, 480);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose Date");
		lblNewLabel.setBounds(187, 6, 125, 79);
		lblNewLabel.setForeground(SystemColor.controlHighlight);
		lblNewLabel.setFont(new Font("Kailasa", Font.BOLD, 20));
		panel.add(lblNewLabel);

		
		JLabel lblNewLabel_2 = new JLabel("Month :");
		lblNewLabel_2.setBounds(122, 106, 69, 16);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		panel.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Next");
		btnNewButton.setBounds(187, 252, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("X");
		lblNewLabel_3.setBounds(474, 0, 16, 16);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblNewLabel_3.setFont(new Font("Apple Braille", Font.BOLD, 16));
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Year :");
		lblNewLabel_4.setBounds(122, 156, 61, 16);
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		panel.add(lblNewLabel_4);
		
		JComboBox Year = new JComboBox();
		Year.setBounds(169, 153, 221, 27);
		panel.add(Year);
		
		JComboBox Month = new JComboBox();
		Month.setBounds(189, 103, 158, 27);
		panel.add(Month);
	}
}
