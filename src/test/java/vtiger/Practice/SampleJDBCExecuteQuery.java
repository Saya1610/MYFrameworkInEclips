package vtiger.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class SampleJDBCExecuteQuery {
public static void main(String[] args) throws SQLException {
	Driver driverRef=new Driver();
	//register driver
	DriverManager.registerDriver(driverRef);
	//get connection
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb","root","root");
	//create issue statement
	Statement statement = con.createStatement();
	//exeute query
	 ResultSet result = statement.executeQuery("select * from customerinfo;");
	 while(result.next()) {
		 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
	 }
	 con.close();
	
}
}
