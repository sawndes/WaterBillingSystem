package waterBillingSys;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddUnit extends JFrame implements ActionListener {

	JLabel l1;
	JButton b1;
	JTextField t1;
	AddUnit(int uid) {
		l1 = new JLabel("Enter Consumed Unit: ");
        l1.setBounds(50,160,400,30);
        l1.setFont(new Font("serif",Font.BOLD,17));
        add(l1);
        
        t1 = new JTextField();
        t1.setBounds(300,160,200,30);
        add(t1);
        
        b1 = new JButton("Add Unit");
        b1.setBounds(520, 160, 100 ,30);
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
		String unit = t1.getText();
		int unitConsumed = Integer.parseInt(unit);
		if(e.getSource() == b1){
			
		}
		
	}
	public static void main(String[] args) {
		new AddUnit(1).setVisible(true);
	}

}
