package waterBillingSys;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SelectCustomer extends JFrame implements ActionListener {
	JTable t1;
	JLabel l1;
	JButton b1;
	JTextField t2;
	String x[] = {"Client Id","Name","Username"};
    String months[] ={"Jan", "Feb", "March", "April","May","Jun","July","Aug","Sep","Oct","Nov","Dec",};
//    String years[] = {"2022","2023","2024","2025","2026","2027","2028","2029","2030","2031","2032","2033"};
    String years[] = {"2022","2023"};
	String y[][] = new String[20][3];
	int i=0,j=0;
	private String mrusername, conusername,conname,conaddress;
	SelectCustomer(String location, String username) {
		try {
			Connect c1 = new Connect();
			String s1 = "select DISTINCT client_id, name, username from clients where address = '"+location+"'";
			ResultSet rs = c1.s.executeQuery(s1);
			while (rs.next()) {
				y[i][j++]=rs.getString("client_id");
                y[i][j++]=rs.getString("name");
                conname = rs.getString("name");
                conusername = rs.getString("username");
                y[i][j++]=rs.getString("username");
                i++;
                j=0;
			}
			t1 = new JTable(y,x);
		}catch (Exception e) {
			e.printStackTrace();
		}
		mrusername = username;
		conaddress = location;
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20,20,750,100);
        add(sp);
        
        l1 = new JLabel("Enter client id to add unit: ");
        l1.setBounds(50,260,400,30);
        l1.setFont(new Font("serif",Font.BOLD,17));
        add(l1);
        
        t2 = new JTextField();
        t2.setBounds(300,260,200,30);
        add(t2);
        
        b1 = new JButton("Add Unit");
        b1.setBounds(520, 260, 100 ,30);
        add(b1);
        b1.addActionListener(this);
		
		
		
		
		setResizable(false);
		  setSize(800,600);  
		  setLayout(null);  
		  setVisible(true); 
		  setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		String uid = t2.getText();
		int uidd = Integer.parseInt(uid);
		if(e.getSource() == b1){
			Connect c1 = new Connect();
	         for (int i=0; i<12;i++){
	        	 for (int j =0;j<2;j++) {
	        		 if (months[i]=="Jan" && years[j] == "2022") {
	        			 continue;
	        		 }
	        		 else {
	        			 String a = "Insert into clients(client_id,name,username,address,month,year)  values('"+uid+"','"+conname+"', '"+conusername+"', '"+conaddress+"','"+months[i]+"','"+years[j]+"')";
	         			String b = "Update clients set client_id = '"+uid+"' WHERE name = '"+conname+"' AND username='"+conusername+"'";
	                     c1.s.executeUpdate(a);
	                     c1.s.executeUpdate(b);
//	        			 System.out.println(months[i]+years[j]);
	        		 }
	        		 
	        	 }
	        }
			
			
			
			
			
//			for (int i = 1; i<12;i++) {
//            	String a = "Insert into clients(client_id,name,username,address,month,year)  values('"+uid+"','"+conname+"', '"+conusername+"', '"+conaddress+"','"+months[i]+"','"+years[i]+"')";
//    			String b = "Update clients set client_id = '"+uid+"' WHERE name = '"+conname+"' AND username='"+conusername+"'";
//                c1.s.executeUpdate(a);
//                c1.s.executeUpdate(b);
//			}
			new AddUnit(uidd, mrusername).setVisible(true);
		}
		}catch (SQLException ex) {
        	JOptionPane.showMessageDialog(null, ex);
            setVisible(false);
//            this.dispose();
//            new SuperAdminPanel().setVisible(true);
           ex.printStackTrace(); 
       }
		
	}
	public static void main(String[] args) {
		new SelectCustomer("Naxal", "Mr").setVisible(true);
	}
}
