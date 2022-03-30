package waterBillingSys;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

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
	String y[][] = new String[20][3];
	int i=0,j=0;
	SelectCustomer(String location) {
		try {
			Connect c1 = new Connect();
			String s1 = "select * from clients where address = '"+location+"'";
			ResultSet rs = c1.s.executeQuery(s1);
			while (rs.next()) {
				y[i][j++]=rs.getString("client_id");
                y[i][j++]=rs.getString("name");
                y[i][j++]=rs.getString("username");
                i++;
                j=0;
			}
			t1 = new JTable(y,x);
		}catch (Exception e) {
			e.printStackTrace();
		}
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
		String uid = t2.getText();
		int uidd = Integer.parseInt(uid);
		if(e.getSource() == b1){
			new AddUnit(uidd).setVisible(true);
		}
		
	}
	public static void main(String[] args) {
		new SelectCustomer("Naxal").setVisible(true);
	}
}
