package waterBillingSys;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import java.awt.Button;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import waterBillingSys.CalculateAmount.BillPrintable;

import javax.swing.UIManager;

public class PanelPay extends JFrame {

	private JPanel contentPane;
	static float unit[]= new float[100];
	int i;
	JLabel l1,l2;
	JButton b1,b2;
	double perUnit,totalAmount,unitConsumed;
	int yearr,cid;
	String monthh;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPay frame = new PanelPay("Jan",2022,1);
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
	public PanelPay(String month, int year, int client_id) {
		
		
		try {
			Connect c2 = new Connect();
			String s2 = "SELECT DISTINCT Unit_Consumed FROM `clients` WHERE Year = '"+year+"' AND Month='"+month+"' AND client_id = '"+client_id+"'";
			ResultSet rs1 = c2.s.executeQuery(s2);
			i=0;
			while (rs1.next()) {
	        	unit[i] = rs1.getFloat("Unit_Consumed");
	        	i++;	
			}	
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		monthh = month;
		yearr = year;
		cid = client_id;
//		if (unit[0] <= 200) {
//			perUnit = 20.2;
//			System.out.println(perUnit);
//		}
//		else if (unit[0] <= 201) {
//			perUnit = 15.0;
//			System.out.println(perUnit);
//		}
		
		System.out.println(unit[0]);
		if (unit[0] <= 300) {
			perUnit = 15;
		}
		else {
			perUnit = 20;
		}
		unitConsumed = unit[0];
		System.out.println(perUnit);
		l1 = new JLabel("Unit= "+ unit[0]);
        l1.setBounds(50,100,400,30);
        l1.setFont(new Font("serif",Font.BOLD,17));
        add(l1);
        totalAmount = unit[0]*perUnit;
		l2 = new JLabel("Amount= "+ unit[0]*perUnit);
        l2.setBounds(50,130,400,30);
        l2.setFont(new Font("serif",Font.BOLD,17));
        add(l2);
		
//        b1 = new JButton("Pay and Create Receipt");
//        b1.setBounds(200,300,200,30);
//        b1.setFont(new Font("serif",Font.BOLD,15));
//        b1.addActionListener(this);
//        add(b1);
		
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
					try {
						Connect c1 = new Connect();
						String p = "UPDATE `clients` SET `Rate`='"+perUnit+"',`Paid_Amount`='"+totalAmount+"' WHERE `Month`='"+monthh+"' AND `Year`='"+yearr+"' AND `client_id`='"+cid+"' AND `Unit_Consumed`='"+unitConsumed+"'";
						c1.s.executeUpdate(p);
					}catch (SQLException ep) {
						ep.printStackTrace();
						}
			        PrinterJob pj = PrinterJob.getPrinterJob();        
			        pj.setPrintable(new BillPrintable(),getPageFormat(pj));
			        try {
			             pj.print();
			          
			        }
			         catch (PrinterException ex) {
			                 ex.printStackTrace();
			        }
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
		
		JLabel lblNewLabel = new JLabel(Float.toString(unit[0]));
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
				panel_1_1.setBounds(197, 55, 110, 65);
				panel.add(panel_1_1);
				
				JLabel lblJan = new JLabel(monthh);
				lblJan.setFont(new Font("Lucida Grande", Font.BOLD, 34));
				lblJan.setBounds(19, 22, 70, 37);
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
				
				JLabel lblNewLabel_1_1 = new JLabel(Integer.toString(yearr));
				lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 37));
				lblNewLabel_1_1.setBounds(16, 28, 108, 28);
				panel_1_1_1.add(lblNewLabel_1_1);
				
				JLabel lblNewLabel_2_2_1 = new JLabel("YEAR");
				lblNewLabel_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
				lblNewLabel_2_2_1.setBounds(37, 6, 62, 16);
				panel_1_1_1.add(lblNewLabel_2_2_1);
				
				JLabel lblNewLabel_1 = new JLabel("Price Per Unit :");
				lblNewLabel_1.setBackground(UIManager.getColor("Button.light"));
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
				
				JLabel lblNewLabel_4 = new JLabel("Rs "+Double.toString(perUnit));
				lblNewLabel_4.setBounds(191, 145, 61, 16);
				panel.add(lblNewLabel_4);
				
				JLabel lblNewLabel_4_1 = new JLabel("Rs "+Double.toString(totalAmount));
				lblNewLabel_4_1.setBounds(191, 187, 61, 16);
				panel.add(lblNewLabel_4_1);
				
				JPanel panel_3 = new JPanel();
				panel_3.setBackground(new Color(60, 179, 113));
				panel_3.setBounds(95, 262, 97, 29);
				panel.add(panel_3);
				
//				JLabel lblNewLabel_5 = new JLabel("Esewa");
//				lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD, 13));
//				lblNewLabel_5.setForeground(new Color(255, 255, 255));
//				lblNewLabel_5.setBackground(new Color(255, 255, 255));
//				panel_3.add(lblNewLabel_5);
				
				JLabel lblNewLabel_5 = new JLabel("Esewa");
				lblNewLabel_5.setFont(new Font("Lucida Grande", Font.BOLD, 13));
				lblNewLabel_5.setForeground(new Color(255, 255, 255));
				lblNewLabel_5.setBackground(new Color(255, 255, 255));
				panel_3.add(lblNewLabel_5);
				panel_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							new Esawe().setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
					}
				});
				
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
				panel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							new Khalti().setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
					}
				});
				
				JLabel lblNewLabel_5_1_1 = new JLabel("Bank");
				lblNewLabel_5_1_1.setFont(new Font("DialogInput", Font.BOLD, 13));
				lblNewLabel_5_1_1.setForeground(new Color(255, 255, 255));
				panel_3_2.add(lblNewLabel_5_1_1);
				panel_3_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							new Bank().setVisible(true);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
					}
				});
	}
	public PageFormat getPageFormat(PrinterJob pj)
	{
	    
	    PageFormat pf = pj.defaultPage();
	    Paper paper = pf.getPaper();    

	    double bodyHeight = 1.0;  
	    double headerHeight = 5.0;                  
	    double footerHeight = 5.0;        
	    double width = cm_to_pp(8); 
	    double height = cm_to_pp(headerHeight+bodyHeight+footerHeight); 
	    paper.setSize(width, height);
	    paper.setImageableArea(0,10,width,height - cm_to_pp(1));  
	            
	    pf.setOrientation(PageFormat.PORTRAIT);  
	    pf.setPaper(paper);    

	    return pf;
	}
	    
	    protected static double cm_to_pp(double cm)
	    {            
		        return toPPI(cm * 0.393600787);            
	    }
	 
	protected static double toPPI(double inch)
	    {            
		        return inch * 72d;            
	    }

		public class BillPrintable implements Printable { 
		    
			  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
			  throws PrinterException 
			  {    
			      
			      int r= 1;
			      ImageIcon icon=new ImageIcon("C:\\Users\\me111\\eclipse-workk\\collaborative\\src\\Photos\\water-bill.png"); 
			      int result = NO_SUCH_PAGE;    
			        if (pageIndex == 0) {                    
			        
			            Graphics2D g2d = (Graphics2D) graphics;                    
			            double width = pageFormat.getImageableWidth();                               
			            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 



			          //  FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,7));
			        
			        try{
			            int y=20;
			            int yShift = 10;
			            int headerRectHeight=15;
			           // int headerRectHeighta=40;
			            
			                
			            g2d.setFont(new Font("Monospaced",Font.PLAIN,9));
			            g2d.drawImage(icon.getImage(), 50, 20, 90, 30, rootPane);y+=yShift+30;
			            g2d.drawString("-------------------------------------",12,y);y+=yShift;
			            g2d.drawString("         Water Billing System        ",12,y);y+=yShift;
			            g2d.drawString("        No 00000 Address Line One    ",12,y);y+=yShift;
			            g2d.drawString("             Naxal, Nepal          	 ",12,y);y+=yShift;
			            g2d.drawString("        www.waterbillingNepal.com    ",12,y);y+=yShift;
			            g2d.drawString("        +977-011664548               ",12,y);y+=yShift;
			            g2d.drawString("-------------------------------------",12,y);y+=headerRectHeight;

//			            g2d.drawString(" Item Name                  Price   ",10,y);y+=yShift;
//			            g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
			            
			            
			            g2d.drawString(" Unit     Month        Year               ",10,y);y+=yShift;
			            g2d.drawString("-------------------------------------------",10,y);y+=headerRectHeight;
//			            g2d.drawString(" "+unit[0]+"     "+monthh+"        "+yearr+"           "+perUnit+" ",10,y);y+=yShift;
			            g2d.drawString(" "+unit[0]+"     "+monthh+"        "+yearr+"        ",10,y);y+=yShift;
			            g2d.drawString("-------------------------------------",10,y);y+=yShift;
			            g2d.drawString("  Price Per Unit: Rs "+perUnit+"",10,y);y+=yShift;
			            
//			            for(int s=0; s<r; s++)
//			            {
//			            g2d.drawString(" "+itemName.get(s)+"                            ",10,y);y+=yShift;
//			            g2d.drawString("      "+quantity.get(s)+" * "+itemPrice.get(s),10,y); 
//			            g2d.drawString(subtotal.get(s),160,y);y+=yShift;
	//
//			            }
			          
			            g2d.drawString("-------------------------------------",10,y);y+=yShift;
			            g2d.drawString(" Total amount:             Rs "+totalAmount+"   ",10,y);y+=yShift;
			            g2d.drawString("-------------------------------------",10,y);y+=yShift;
			            g2d.drawString(" Paid:                     Rs "+totalAmount+"   ",10,y);y+=yShift;
			            g2d.drawString("-------------------------------------",10,y);y+=yShift;
//			            g2d.drawString(" Balance   :                 "+txtbalance.getText()+"   ",10,y);y+=yShift;
			  
			            g2d.drawString("*************************************",10,y);y+=yShift;
			            g2d.drawString("       THANK YOU COME AGAIN            ",10,y);y+=yShift;
			            g2d.drawString("*************************************",10,y);y+=yShift;
			            g2d.drawString("   CONTACT: contact@waterBillSystem.com       ",10,y);y+=yShift;       
			           

			    }
			    catch(Exception e){
			    e.printStackTrace();
			    }

			              result = PAGE_EXISTS;    
			          }    
			          return result;    
			      }

		}
}
