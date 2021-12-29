package com.rmgyantra.testscript;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertDataToRmgApplication {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
	try {	
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement statement = connection.createStatement();
		int query = statement.executeUpdate("insert into project value('TY_PRJ_5654','Mr.mhhhn sir','16/12/2021','testyafnra9','completed',0)");
		
		if(query==1)
			System.out.println("test passed==> row ceated");
		
		else
			System.out.println("test failed");
		String expectedResult="meesaq nabi";
	ResultSet result = statement.executeQuery("select * from project");
	while(result.next())
	{
		if(result.getString(2).equals(expectedResult))
		System.out.println("test case passed==>manager name present");
	}
	
	}
	finally {
	connection.close();
	}
	}
}
