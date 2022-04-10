package waterBillingSys;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Cursor;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setUndecorated(true);
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
	public LoginFrame() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 346, 490);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Water Billing System");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(new Color(240, 248, 255));
		lblNewLabel.setBounds(79, 305, 222, 27);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				 xx = e.getX();
			     xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
	            int y = arg0.getYOnScreen();
	            LoginFrame.this.setLocation(x - xx, y - xy);  
			}
		});
		label.setBounds(0, 0, 346, 270);
		label.setIcon(new ImageIcon(LoginFrame.class.getResource("/res/Watter.jpg")));
		panel.add(label);
		
		JLabel lblWeGotYou = new JLabel("....We got you....");
		lblWeGotYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWeGotYou.setForeground(new Color(240, 248, 255));
		lblWeGotYou.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWeGotYou.setBounds(111, 343, 141, 27);
		panel.add(lblWeGotYou);
		
		JLabel lblLogin = new JLabel("");
		lblLogin.setIcon(new ImageIcon(LoginFrame.class.getResource("/res/icons8-login-48.png")));
		lblLogin.setBounds(437, 369, 54, 44);
		contentPane.add(lblLogin);
		
		textField = new JTextField();
		textField.setBounds(395, 83, 283, 44);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(449, 57, 114, 14);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(449, 148, 96, 14);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(395, 186, 283, 44);
		contentPane.add(passwordField);
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure that you want close this application?", "Confrimation", JOptionPane.YES_NO_OPTION) == 0) {
					LoginFrame.this.dispose();
				}
				
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(Color.BLACK);
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_close.setBounds(691, 0, 37, 27);
		contentPane.add(lbl_close);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/res/icons8-user-48.png")));
		lblNewLabel_1.setBounds(395, 37, 54, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/res/icons8-pass-fail-48.png")));
		lblNewLabel_1_1.setBounds(395, 139, 54, 44);
		contentPane.add(lblNewLabel_1_1);
		
		String s1[] = { "Super Admin", "Admin" ,"Meter Reader"};
		JComboBox comboBox = new JComboBox(s1);
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		comboBox.setBounds(395, 270, 283, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_2 = new JLabel("Role");
		lblNewLabel_2.setBounds(449, 242, 61, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/res/icons8-management-48.png")));
		lblNewLabel_1_1_1.setBounds(395, 222, 54, 44);
		contentPane.add(lblNewLabel_1_1_1);
		
		Button button = new Button("Login");
		button.setFont(new Font("Arial", Font.BOLD, 14));
		button.setActionCommand("Login");
		button.setForeground(Color.GRAY);
		button.setBackground(Color.WHITE);
		button.setBounds(395, 363, 283, 55);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
	             try {
	                 Connect c1 = new Connect();
	                 String u = textField.getText();
	                 String v = passwordField.getText();
	                 String role = (String) comboBox.getSelectedItem();
	                 System.out.println(role);
	                 if (role == "Super Admin") {
	                     String q = "select * from login where username='" + u + "' and pass='" + v + "' and role = '"+ "Super Admin" +"'";
//	                	 String q = "select * from login where username='" + u + "' and pass='" + v + "'";
	                     ResultSet rs = c1.s.executeQuery(q);
	                     if (rs.next()) {
	                    	 LoginFrame.this.dispose();
	                             new SuperAdminFrame().setVisible(true);
	                             System.out.println("Sucessful");  

	                         
	                     }
	                       else {
	                             JOptionPane.showMessageDialog(null, "Invalid login");
	                             
	                         }
	                 }
	                 else if (role == "Admin") {
	                	 String q = "select * from login where username='" + u + "' and pass='" + v + "'and role = '"+ "Admin" +"'";
	                     ResultSet rs = c1.s.executeQuery(q);
	                     if (rs.next()) {
	                    	 c1.s.execute("INSERT INTO `logincheck`(`username`, `role`) VALUES ('"+u+"','"+comboBox.getSelectedItem()+"')");
	                    	 LoginFrame.this.dispose();
	                             new AdminPanel().setVisible(true);
	                             System.out.println("Sucessful");  

	                         
	                     }
	                       else {
	                             JOptionPane.showMessageDialog(null, "Invalid login");
	                             
	                         }
	                 }
	                 else if (role == "Meter Reader") {
	                	 String q = "select * from login where username='" + u + "' and pass='" + v + "' and role = '"+ "Meter Reader" + "'";
	                     ResultSet rs = c1.s.executeQuery(q);
	                     if (rs.next()) {
	                    	 c1.s.execute("INSERT INTO `logincheck`(`username`, `role`) VALUES ('"+u+"','"+comboBox.getSelectedItem()+"')");
	                    	 LoginFrame.this.dispose();
	                             new MeterReaderFrame().setVisible(true);
	                             System.out.println("Sucessful");  

	                         
	                     }
	                       else {
	                             JOptionPane.showMessageDialog(null, "Invalid login");
	                             
	                         }
	                 }
	                 else {
	                     JOptionPane.showMessageDialog(null, "Invalid login");
	                 }

	                 }
	      
	             catch (Exception e) {
	             e.printStackTrace();
	             }
				
			}
		});
	}
}
