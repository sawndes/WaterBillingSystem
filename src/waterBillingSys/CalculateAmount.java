package waterBillingSys;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class CalculateAmount extends JFrame implements ActionListener{
	static float unit[]= new float[100];
	int i;
	JLabel l1,l2;
	JButton b1,b2;
	double perUnit,totalAmount,unitConsumed;
	int yearr,cid;
	String monthh;
	
	CalculateAmount(String month, int year, int client_id) {
	
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
		
        b1 = new JButton("Pay and Create Receipt");
        b1.setBounds(200,300,200,30);
        b1.setFont(new Font("serif",Font.BOLD,15));
        b1.addActionListener(this);
        add(b1);
        

		setResizable(false);
		  setSize(800,600);  
		  setLayout(null);  
		  setVisible(true); 
		  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
		  
	public static void main(String[] args) {
		new CalculateAmount("March",2022,1).setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
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

//		            g2d.drawString(" Item Name                  Price   ",10,y);y+=yShift;
//		            g2d.drawString("-------------------------------------",10,y);y+=headerRectHeight;
		            
		            
		            g2d.drawString(" Unit     Month        Year               ",10,y);y+=yShift;
		            g2d.drawString("-------------------------------------------",10,y);y+=headerRectHeight;
//		            g2d.drawString(" "+unit[0]+"     "+monthh+"        "+yearr+"           "+perUnit+" ",10,y);y+=yShift;
		            g2d.drawString(" "+unit[0]+"     "+monthh+"        "+yearr+"        ",10,y);y+=yShift;
		            g2d.drawString("-------------------------------------",10,y);y+=yShift;
		            g2d.drawString("  Price Per Unit: Rs "+perUnit+"",10,y);y+=yShift;
		            
//		            for(int s=0; s<r; s++)
//		            {
//		            g2d.drawString(" "+itemName.get(s)+"                            ",10,y);y+=yShift;
//		            g2d.drawString("      "+quantity.get(s)+" * "+itemPrice.get(s),10,y); 
//		            g2d.drawString(subtotal.get(s),160,y);y+=yShift;
//
//		            }
		          
		            g2d.drawString("-------------------------------------",10,y);y+=yShift;
		            g2d.drawString(" Total amount:             Rs "+totalAmount+"   ",10,y);y+=yShift;
		            g2d.drawString("-------------------------------------",10,y);y+=yShift;
		            g2d.drawString(" Paid:                     Rs "+totalAmount+"   ",10,y);y+=yShift;
		            g2d.drawString("-------------------------------------",10,y);y+=yShift;
//		            g2d.drawString(" Balance   :                 "+txtbalance.getText()+"   ",10,y);y+=yShift;
		  
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

