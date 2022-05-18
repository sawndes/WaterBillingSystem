package waterBillingSys;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.SwingConstants;

public class AdminFrame extends JFrame {

	private JPanel Main;
	private final JPanel panel = new JPanel();

	private PanelAdminProfile panelAdminProfile;
	private PanelAdminChange panelAdminChange;
	private PanelAdminCollect panelAdminCollect;
	public static String name,userid,username;
	public static String xx;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 492);
		Main = new JPanel();
		Main.setBackground(new Color(0, 128, 128));
		Main.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Main);
		Main.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 214, 492);
		Main.add(panel);
		panel.setLayout(null);
		xx = "x";
		try {
			Connect c1 = new Connect();
			String s2 = "SELECT * FROM logincheck ORDER BY No DESC LIMIT 1";
            ResultSet rs1  = c1.s.executeQuery(s2);
            while(rs1.next()){
            	username = rs1.getString("username");
            }
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(username);
		try {
			Connect c1 = new Connect();
			String s2 = "SELECT user_id,name FROM admin where username='"+username+"'";
            ResultSet rs1  = c1.s.executeQuery(s2);
            while(rs1.next()){
            	userid = rs1.getString("user_id");
            	name = rs1.getString("name");
            }
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(userid);
		panelAdminProfile = new PanelAdminProfile();
		panelAdminChange = new PanelAdminChange();
		panelAdminCollect = new PanelAdminCollect();
		
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(AdminFrame.class.getResource("/res/faucet-2.png")));
		lblLogo.setBounds(33, 21, 145, 142);
		panel.add(lblLogo);
		
		JPanel Profilepanel = new JPanel();
		Profilepanel.setBackground(new Color(47, 79, 79));
		Profilepanel.addMouseListener(new PanelButtonMouseAdapter(Profilepanel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelAdminProfile);
			}
		});
		Profilepanel.setBounds(0, 180, 214, 51);
		panel.add(Profilepanel);
		Profilepanel.setLayout(null);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setFont(new Font("Arial", Font.BOLD, 14));
		lblProfile.setForeground(Color.WHITE);
		lblProfile.setBounds(58, 16, 150, 16);
		Profilepanel.add(lblProfile);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(AdminFrame.class.getResource("/res/icons8-profile-48.png")));
		lblNewLabel_2.setBounds(6, 6, 49, 39);
		Profilepanel.add(lblNewLabel_2);
		
		JPanel Changepanel = new JPanel();
		Changepanel.setBackground(new Color(47, 79, 79));
		Changepanel.addMouseListener(new PanelButtonMouseAdapter(Changepanel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelAdminChange);
			}
		});
		Changepanel.setBounds(0, 230, 214, 51);
		panel.add(Changepanel);
		Changepanel.setLayout(null);
		
		JLabel lblAdminlogo = new JLabel("Change Password ");
		lblAdminlogo.setForeground(Color.WHITE);
		lblAdminlogo.setFont(new Font("Arial", Font.BOLD, 14));
		lblAdminlogo.setBounds(58, 16, 150, 16);
		Changepanel.add(lblAdminlogo);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(AdminFrame.class.getResource("/res/icons8-password-reset-48.png")));
		lblNewLabel_2_1.setBounds(6, 6, 49, 39);
		Changepanel.add(lblNewLabel_2_1);
		
		JPanel Signpanel = new JPanel();
		Signpanel.setBackground(new Color(47, 79, 79));
		Signpanel.addMouseListener(new PanelButtonMouseAdapter(Signpanel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to sign out?") == 0) {
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.setVisible(true);
					System.exit(0);
				}
			}
		});
		Signpanel.setBounds(1, 332, 214, 51);
		panel.add(Signpanel);
		Signpanel.setLayout(null);
		
		JLabel lblsignlogo = new JLabel("Sign Out");
		lblsignlogo.setForeground(Color.WHITE);
		lblsignlogo.setFont(new Font("Arial", Font.BOLD, 14));
		lblsignlogo.setBounds(58, 17, 150, 16);
		Signpanel.add(lblsignlogo);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setIcon(new ImageIcon(AdminFrame.class.getResource("/res/icons8-exit-sign-48.png")));
		lblNewLabel_2_3.setBounds(6, 6, 49, 39);
		Signpanel.add(lblNewLabel_2_3);
		
		JPanel Collectpanel = new JPanel();
		Collectpanel.setBounds(1, 281, 214, 51);
		Collectpanel.addMouseListener(new PanelButtonMouseAdapter(Collectpanel){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelAdminCollect);
			}
		});
		panel.add(Collectpanel);
		Collectpanel.setLayout(null);
		Collectpanel.setBackground(new Color(47, 79, 79));
		
		JLabel lblComsumerlogo_1 = new JLabel("Collect Payment");
		lblComsumerlogo_1.setForeground(Color.WHITE);
		lblComsumerlogo_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblComsumerlogo_1.setBounds(58, 16, 150, 16);
		Collectpanel.add(lblComsumerlogo_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("");
//		lblNewLabel_2_2_1.setIcon(new ImageIcon(AdminFrame.class.getResource("/res/icons8-paper-money-48.png")));
		lblNewLabel_2_2_1.setBounds(6, 2, 49, 45);
		Collectpanel.add(lblNewLabel_2_2_1);
		
		JLabel lblTitle = new JLabel("Admin Dashboard");
		lblTitle.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setBounds(33, 6, 145, 16);
		panel.add(lblTitle);
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure that you want close this application?", "Confrimation", JOptionPane.YES_NO_OPTION) == 0) {
					AdminFrame.this.dispose();
				}
				
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(Color.BLACK);
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_close.setBounds(781, 0, 31, 27);
		Main.add(lbl_close);
		
		JPanel paneMainFrame = new JPanel();
		paneMainFrame.setBounds(220, 6, 565, 480);
		Main.add(paneMainFrame);
		paneMainFrame.setLayout(null);
		
		paneMainFrame.add(panelAdminProfile);
		paneMainFrame.add(panelAdminChange);
		paneMainFrame.add(panelAdminCollect);
		
		menuClicked(panelAdminProfile
				);
		
	}
	
	public void menuClicked(JPanel panel) {
		panelAdminProfile.setVisible(false);
		panelAdminChange.setVisible(false);
		panelAdminCollect.setVisible(false);
		
		panel.setVisible(true);
		
	}
	private class PanelButtonMouseAdapter extends MouseAdapter {
		
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel){
			this.panel = panel;
		}
			public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(122, 128, 144));
		}
			
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(47, 79, 79));	
		}
			
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));	
		}
			
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));	
		}
	}
}
