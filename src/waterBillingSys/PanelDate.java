package waterBillingSys;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class PanelDate extends JFrame {

	private JPanel contentPane;
	private String selectedMonths[], selectedYears[];
	int client_idd;
	int arraySize;
	String usernamee;
	JComboBox comboMonth,comboYear;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelDate frame = new PanelDate(12);
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
	public PanelDate(int client_id) {
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
		
		try {
			Connect c2 = new Connect();
//			String s2 = "SELECT COUNT(DISTINCT Month, Year) FROM `clients` WHERE Unit_Consumed != \"NULL\" AND Read_by != \"NULL\"";
			String s2 = "SELECT COUNT(DISTINCT Month, Year) from clients where Unit_Consumed !=\"NULL\" AND client_id = '"+client_id+"'AND Read_by != \"NULL\"";
			ResultSet rs1 = c2.s.executeQuery(s2);
			while (rs1.next()) {
	        	arraySize = rs1.getInt("COUNT(DISTINCT Month, Year)");
//				arraySize = rs1.getInt("COUNT(Month)");
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			Connect c2 = new Connect();
//			String s2 = "SELECT COUNT(DISTINCT Month, Year) from clients where Unit_Consumed !=\"NULL\" AND client_id = '"+client_id+"'AND Read_by != \"NULL\"";
			String s2 = "SELECT DISTINCT username FROM `clients` WHERE client_id='"+client_id+"'";
			ResultSet rs1 = c2.s.executeQuery(s2);
			while (rs1.next()) {
	        	usernamee = rs1.getString("username");
//				arraySize = rs1.getInt("COUNT(Month)");
	        }
		}catch (Exception e) {
			e.printStackTrace();
		}
		selectedMonths = new String[arraySize];
		selectedYears = new String[arraySize];
		
		try {
			int i =0;
			Connect c2 = new Connect();
			String s2 = "SELECT DISTINCT Month, Year FROM `clients` WHERE Unit_Consumed != \"NULL\" AND Read_by != \"NULL\" AND client_id = '"+client_idd+"'";
			ResultSet rs1 = c2.s.executeQuery(s2);
			while (rs1.next()) {
//	        	arraySize = rs1.getInt("COUNT(DISTINCT Month, Year)");
				selectedMonths[i]=rs1.getString("Month");
				selectedYears[i]=rs1.getString("Year");
	        	i++;
	        }
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		comboMonth = new JComboBox(selectedMonths);
		comboMonth.setBounds(100, 50,90,20); 
		add(comboMonth);
		
		comboYear = new JComboBox(selectedYears);
		comboYear.setBounds(100, 150,90,20); 
		add(comboYear);
		
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
				String year = (String) comboYear.getSelectedItem();
				int yearr = Integer.parseInt(year);
				String month = (String) comboMonth.getSelectedItem();
				new CalculateAmount(month,yearr, client_idd).setVisible(true);
				PanelDate.this.dispose();
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
