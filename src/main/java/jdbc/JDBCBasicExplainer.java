package main.java.jdbc;

import java.sql.*;

public class JDBCBasicExplainer {


	//SSL has been set as false to avoid warnings
	String dbConnection = "jdbc:mysql://localhost:3306/college?useSSL=false";
	String userName = "root";
	String password = "bAsics@2022";
	
	/**
	 * This method is for doing basic CRUD operations on MySQL db.
	 * prerequisite: Make sure you have included jdbc connector in the project's CLASSPATH;
	 * 					If MySQL been installed through installer.msi then connector can be 
	 * 					found in ProgramFiles/MySQL : mysql-connector-java-8.0.29 
	 * @throws SQLException - mainly due to bad credentials
	 */
	public void executeBasicDBOperations() throws SQLException{
		
		//To create connection for mentioned db alongwith credentials 
		Connection dbConn = DriverManager.getConnection(dbConnection, userName, password);
		
		//To send SQL statements to the database
		Statement stmt = dbConn.createStatement();
		
		//executeQuery for select statements
		executeSelectStatement(stmt);
		
		boolean insertUpdateDeleteValue = true;
		String insertionString = "insert into employees (empName,address,deptId) values (\"Malliga\",\"Trichy\",\"103\")";
		
		//Get the empId after above insertionString been executed because update/delete been happening only with primarykey attribute
		String updateString = "update employees set empName=\"Mallika\" where empId=1007";
		String deletionString = "delete from employees where empId=1007";
		
		if(insertUpdateDeleteValue) {
			int rowsAffected = stmt.executeUpdate(insertionString);		//executeUpdate for CUD operations (DML) or DDL operations
			System.out.println("\nRows Affected after insertion: "+rowsAffected);
			executeSelectStatement(stmt);
			
			rowsAffected = stmt.executeUpdate(updateString);
			System.out.println("\nRows Affected after update: "+rowsAffected);
			executeSelectStatement(stmt);
			
			rowsAffected = stmt.executeUpdate(deletionString);
			System.out.println("\nRows Affected after delete: "+rowsAffected);
			executeSelectStatement(stmt);

		}
	}
	
	private void executeSelectStatement(Statement stmt) throws SQLException {
		
		ResultSet resultSet = stmt.executeQuery("select * from employees");
		
		System.out.println("Printing employees' name:");
		
		while(resultSet.next()) {
			System.out.println(resultSet.getString("empName"));
		}
	}
}
