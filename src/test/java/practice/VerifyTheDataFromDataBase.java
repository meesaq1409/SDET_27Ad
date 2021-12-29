package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyTheDataFromDataBase {

	public static void main(String[] args) throws SQLException {
		String expextedResult = "meesaq";
		Connection connection=null;
		// register the database
		try {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		// get the connection with database
		
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
		
		//issue the statement
		Statement statement = connection.createStatement();
		//execute result
		
		ResultSet result = statement.executeQuery("Select * from studentinfo");
		while (result.next()) {
			if (result.getString(2).equals(expextedResult))
				System.out.println("passed");
		}
		}
		//close the connection
		finally {
		connection.close();
	}
		}

}
