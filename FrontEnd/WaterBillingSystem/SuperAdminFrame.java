package WaterBillingSystem;

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
import javax.swing.SwingConstants;

public class SuperAdminFrame extends JFrame {

	private static final Component Consumerpanel = null;
	private JPanel Main;
	private final JPanel panel = new JPanel();

	private PanelManageReader panelManageReader;
	private PanelManageAdmin panelManageAdmin;
	private PanelManageConsumer panelManageConsumer;
	private PanelViewConsumer panelViewConsumer;
	
	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuperAdminFrame frame = new SuperAdminFrame();
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
	public SuperAdminFrame() {
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
		
		panelManageReader = new PanelManageReader();
		panelManageAdmin = new PanelManageAdmin();
		panelManageConsumer = new PanelManageConsumer();
		panelViewConsumer = new PanelViewConsumer();
		
		
		JLabel lblLogo = new JLabel("New label");
		lblLogo.setIcon(new ImageIcon(SuperAdminFrame.class.getResource("/res/faucet-2.png")));
		lblLogo.setBounds(33, 21, 145, 142);
		panel.add(lblLogo);
		
		JPanel Readerpanel = new JPanel();
		Readerpanel.setBackground(new Color(47, 79, 79));
		Readerpanel.addMouseListener(new PanelButtonMouseAdapter(Readerpanel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelManageReader);
			}
		});
		Readerpanel.setBounds(0, 180, 214, 51);
		panel.add(Readerpanel);
		Readerpanel.setLayout(null);
		
		JLabel lblReader = new JLabel("Manage Meter Reader");
		lblReader.setFont(new Font("Arial", Font.BOLD, 14));
		lblReader.setForeground(Color.WHITE);
		lblReader.setBounds(58, 16, 150, 16);
		Readerpanel.add(lblReader);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(SuperAdminFrame.class.getResource("/res/icons8-ereader-48.png")));
		lblNewLabel_2.setBounds(6, 6, 49, 39);
		Readerpanel.add(lblNewLabel_2);
		
		JPanel Adminpanel = new JPanel();
		Adminpanel.setBackground(new Color(47, 79, 79));
		Adminpanel.addMouseListener(new PanelButtonMouseAdapter(Adminpanel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelManageAdmin);
			}
		});
		Adminpanel.setBounds(0, 230, 214, 51);
		panel.add(Adminpanel);
		Adminpanel.setLayout(null);
		
		JLabel lblAdminlogo = new JLabel("Manage Admin");
		lblAdminlogo.setForeground(Color.WHITE);
		lblAdminlogo.setFont(new Font("Arial", Font.BOLD, 14));
		lblAdminlogo.setBounds(58, 16, 150, 16);
		Adminpanel.add(lblAdminlogo);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(SuperAdminFrame.class.getResource("/res/icons8-admin-settings-male-48.png")));
		lblNewLabel_2_1.setBounds(6, 6, 49, 39);
		Adminpanel.add(lblNewLabel_2_1);
		
		JPanel Consumerpanel = new JPanel();
		Consumerpanel.setBackground(new Color(47, 79, 79));
		Consumerpanel.addMouseListener(new PanelButtonMouseAdapter(Consumerpanel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelManageConsumer);
			}
		});
		Consumerpanel.setBounds(0, 280, 214, 51);
		panel.add(Consumerpanel);
		Consumerpanel.setLayout(null);
		
		JLabel lblComsumerlogo = new JLabel("Add Consumer ");
		lblComsumerlogo.setForeground(Color.WHITE);
		lblComsumerlogo.setFont(new Font("Arial", Font.BOLD, 14));
		lblComsumerlogo.setBounds(58, 16, 150, 16);
		Consumerpanel.add(lblComsumerlogo);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(SuperAdminFrame.class.getResource("/res/icons8-add-user-male-48.png")));
		lblNewLabel_2_2.setBounds(6, 6, 49, 39);
		Consumerpanel.add(lblNewLabel_2_2);
		
		JPanel Signpanel = new JPanel();
		Signpanel.setBackground(new Color(47, 79, 79));
		Signpanel.addMouseListener(new PanelButtonMouseAdapter(Signpanel) {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(JOptionPane.showConfirmDialog(null,"Are you sure you want to sign out?") == 0) {
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.setVisible(true);
					SuperAdminFrame.this.dispose();
				}
			}
		});
		Signpanel.setBounds(0, 382, 214, 51);
		panel.add(Signpanel);
		Signpanel.setLayout(null);
		
		JLabel lblsignlogo = new JLabel("Sign Out");
		lblsignlogo.setForeground(Color.WHITE);
		lblsignlogo.setFont(new Font("Arial", Font.BOLD, 14));
		lblsignlogo.setBounds(58, 17, 150, 16);
		Signpanel.add(lblsignlogo);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setIcon(new ImageIcon(SuperAdminFrame.class.getResource("/res/icons8-exit-sign-48.png")));
		lblNewLabel_2_3.setBounds(6, 6, 49, 39);
		Signpanel.add(lblNewLabel_2_3);
		
		JPanel Viewpanel = new JPanel();
		Viewpanel.setBounds(0, 331, 214, 51);
		Viewpanel.addMouseListener(new PanelButtonMouseAdapter(Viewpanel){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelViewConsumer);
			}
		});
		panel.add(Viewpanel);
		Viewpanel.setLayout(null);
		Viewpanel.setBackground(new Color(47, 79, 79));
		
		JLabel lblComsumerlogo_1 = new JLabel("View Consumer ");
		lblComsumerlogo_1.setForeground(Color.WHITE);
		lblComsumerlogo_1.setFont(new Font("Arial", Font.BOLD, 14));
		lblComsumerlogo_1.setBounds(58, 16, 150, 16);
		Viewpanel.add(lblComsumerlogo_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("");
		lblNewLabel_2_2_1.setIcon(new ImageIcon(SuperAdminFrame.class.getResource("/res/icons8-customer-48.png")));
		lblNewLabel_2_2_1.setBounds(6, 6, 49, 39);
		Viewpanel.add(lblNewLabel_2_2_1);
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null, "Are you sure that you want close this application?", "Confrimation", JOptionPane.YES_NO_OPTION) == 0) {
					SuperAdminFrame.this.dispose();
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
		
		paneMainFrame.add(panelManageReader);
		paneMainFrame.add(panelManageAdmin);
		paneMainFrame.add(panelManageConsumer);
		paneMainFrame.add(panelViewConsumer);
		
		menuClicked(panelManageReader);
		
	}
	
	public void menuClicked(JPanel panel) {
		panelManageReader.setVisible(false);
		panelManageAdmin.setVisible(false);
		panelManageConsumer.setVisible(false);
		panelViewConsumer.setVisible(false);
		
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
