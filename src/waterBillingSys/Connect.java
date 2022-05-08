package waterBillingSys;
import java.sql.*;

//Connect class
public class Connect{
	Connection c;
 public Statement s;
 // Constructor
 public Connect() throws SQLException {
 	// Connect and create database
     try{
     	
         Class.forName("com.mysql.cj.jdbc.Driver");
         c = DriverManager.getConnection("jdbc:mysql://localhost:3306","root", "");
         s = c.createStatement();
         int rs = s.executeUpdate("Create Database if not exists water_billing_system");

     }catch (ClassNotFoundException e){
         e.printStackTrace();

     }
     String url = "jdbc:mysql://localhost:3306/water_billing_system";
     c = DriverManager.getConnection(url, "root", "");
     s = c.createStatement();
     // Create Required Table
//     s.executeUpdate("Create Table if not exists Admin(Uname varchar(50),pass varchar(150))");
     s.executeUpdate("Create Table if not exists Login(user_id int(100) AUTO_INCREMENT,name varchar(200),username varchar(150) UNIQUE,pass varchar(150),Role varchar(50),PRIMARY KEY(user_id))");
     ResultSet rs = s.executeQuery("SELECT * FROM Login WHERE username!='"+"' ");
//     ResultSetMetaData rsmetadata = rs.getMetaData();
     if (!rs.next()) {
     	// Super Admin Login Credentials
         s.executeUpdate("INSERT INTO Login(user_id,name,username, pass, Role) VALUES(1,'Super','sadmin',md5('admin'),'Super Admin')");
     }
  // Create table
     s.executeUpdate("Create Table if not exists meter_reader(user_id int(100) AUTO_INCREMENT, name varchar(200),username varchar(150),location varchar(150),PRIMARY KEY(user_id), FOREIGN KEY (user_id) REFERENCES Login(user_id))");
     s.executeUpdate("Create Table if not exists clients(client_id int(100), name varchar(50),username varchar(150), address varchar(200),Unit_Consumed float(20,2),Rate float(20,2),Month varchar(100),Year int(100),Read_by varchar(200),Paid_Amount float(50,2))");
     s.executeUpdate("Create Table if not exists admin(user_id int(100) AUTO_INCREMENT, name varchar(200),username varchar(150), FOREIGN KEY (user_id) REFERENCES Login(user_id))");
     s.executeUpdate("Create Table if not exists LoginCheck(No int NOT NULL AUTO_INCREMENT,username varchar(150), role varchar(200),PRIMARY KEY (No))");
//     s.executeUpdate("Create Table if not exists admin(user_id int(100) AUTO_INCREMENT, name varchar(200), FOREIGN KEY (user_id) REFERENCES Login(user_id))");     
 }

}
