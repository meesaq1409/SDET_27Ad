package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertTheDataIntoDataBase {
public static void main(String[] args) throws Throwable {
	//register the database
	Driver driver = new Driver();
	 DriverManager.registerDriver(driver);
	 //establish connection with database
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
	 
	//issue the statement
	Statement statement = connection.createStatement();


	//execute query
	
		String	query="insert into studentinfo values(6,'shahid','khan','delhi')";
		int result = statement.executeUpdate(query);
	if(result==1)
		System.out.println("student created successfully");
	else
		System.out.println("student not created");
	//close connection
	connection.close();
}
}
