package WaterBillingSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Canvas;
import javax.swing.JMenuBar;

public class Login extends JFrame {
	
//	private Image img_Logo = new ImageIcon(Login.class.getResource("res/water.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
//	private Image img_username = new ImageIcon(Login.class.getResource("res/user.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
//	private Image img_password = new ImageIcon(Login.class.getResource("res/pass.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
//	private Image img_login = new ImageIcon(Login.class.getResource("res/login.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtpassword;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 577, 430);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new LineBorder(Color.BLACK, 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(161, 191, 281, 49);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Arial", Font.PLAIN, 12));
		txtUsername.setBackground(Color.WHITE);
		txtUsername.setToolTipText("");
		txtUsername.setText("Username");
		txtUsername.setBounds(6, 10, 170, 20);
		panel.add(txtUsername);
		txtUsername.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBounds(161, 252, 281, 49);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		txtpassword = new JPasswordField();
		txtpassword.setText("Password");
		txtpassword.setBounds(6, 6, 170, 20);
		panel_1.add(txtpassword);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(161, 335, 281, 49);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel btnLogin = new JLabel("Login ");
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
		btnLogin.setBounds(117, 6, 61, 27);
		panel_2.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("X");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(549, 0, 20, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblIconlogo = new JLabel("");
		lblIconlogo.setIconTextGap(5);
		lblIconlogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconlogo.setBounds(161, 28, 281, 151);
		contentPane.add(lblIconlogo);
		lblIconlogo.setIcon(new ImageIcon(Login.class.getResource("/res/istockphoto-1126448977-612x612.jpg")));
		setUndecorated(true);
	}
}
