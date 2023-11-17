package waterBillingSys;

import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException {
		Connect c = new Connect();
		LoginFrame l = new LoginFrame();
		l.setUndecorated(true);
		l.setVisible(true);
	}
}
