package waterBillingSys;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AddUnit extends JFrame implements ActionListener {

	JLabel l1,l2;
	JButton b1;
	JTextField t1,t2;
    private JComboBox<String> monthcb,yearcb;
    private String username,name, meterReaderusername;
    private int clientId;
    String months[] ={"Jan", "Feb", "March", "April","May","Jun","July","Aug","Sep","Oct","Nov","Dec",};
    String years[] = {"2022","2023"};
	AddUnit(int uid, String mrusername) {
		try {
			Connect c1 = new Connect();
			String s1 = "select * from clients where client_id = '"+uid+"'";
			ResultSet rs = c1.s.executeQuery(s1);
			while (rs.next()) {
//				clientId = rs.getInt("client_id");
				name = rs.getString("name");
				username = rs.getString("username");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		clientId = uid;
		meterReaderusername = mrusername;
		
		l1 = new JLabel("Enter Consumed Unit of " +name+ ":");
        l1.setBounds(50,160,400,30);
        l1.setFont(new Font("serif",Font.BOLD,17));
        add(l1);
        
        t1 = new JTextField();
        t1.setBounds(300,160,200,30);
        add(t1);
        
		l2 = new JLabel("Month");
        l2.setBounds(50,200,400,30);
        l2.setFont(new Font("serif",Font.BOLD,17));
        add(l2);
        
        
        monthcb = new JComboBox<String>(months);
        monthcb.setBounds(300,200,200,30);
        add(monthcb);
        
        
		l2 = new JLabel("Year");
        l2.setBounds(50,240,400,30);
        l2.setFont(new Font("serif",Font.BOLD,17));
        add(l2);
        
        yearcb = new JComboBox<String>(years);
        yearcb.setBounds(300,240,150,30);
        add(yearcb);
        
        b1 = new JButton("Add Unit");
        b1.setBounds(350, 300, 100 ,30);
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
		
		if(e.getSource() == b1){
			String unit = t1.getText();
			int unitConsumed = Integer.parseInt(unit);
			String month = (String) monthcb.getSelectedItem();
			String year = (String) yearcb.getSelectedItem();
			Connect c1;
			try {
				c1 = new Connect();
		       	 String q = "UPDATE `clients` SET `Unit_Consumed`='"+unitConsumed+"',`Read_by`='"+meterReaderusername+"' WHERE `client_id`='"+clientId+"' AND `Month`='"+month+"' AND `Year`='"+year+"'" ;
		         c1.s.executeUpdate(q);
                 JOptionPane.showMessageDialog(null, "Unit Added Sucessfully");
                 System.out.println("Sucessful");
                 System.out.println(clientId);
                 this.dispose();
                 new MeterReaderPanel().setVisible(true);
                 
                 
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1);
				e1.printStackTrace();
			}
		}
	

		}
		
	
	public static void main(String[] args) {
		new AddUnit(1, "Mr").setVisible(true);
	}

}
