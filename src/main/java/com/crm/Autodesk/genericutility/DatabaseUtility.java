package com.crm.Autodesk.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection connection=null;
	public void databaseConnect(Connection connection) throws SQLException {
	
		//register the database
		Driver driver=new Driver();
		//get connection
		DriverManager.registerDriver(driver);
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students\",\"root\",\"root\"");
		//issue the statement
		Statement statement = connection.createStatement();
		//execute the querries
		ResultSet result = statement.executeQuery("Select*from project");
		while(result.next())
		{
			System.out.println(result.getString(0)+"\t"+result.getString(1)+"\t"+result.getString(2));
		}
		
		
	}	


	public void DatabaseClose() throws SQLException	
{
	connection.close();
}
}
