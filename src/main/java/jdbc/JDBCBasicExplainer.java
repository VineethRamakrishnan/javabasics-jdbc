package main.java.jdbc;

import java.sql.*;

public class JDBCBasicExplainer {


	//SSL has been set as false to avoid warnings
	String dbConnection = "jdbc:mysql://localhost:3306/college?useSSL=false";
	String userName = "root";
	String password = "bAsics@2022";
	
	//Queries
	String selectionQueryString = "select * from employees";
	String insertionQueryString = "insert into employees (empName,address,deptId) values (\"Malliga\",\"Trichy\",\"103\")";
	
	//Get the empId after above insertionString been executed because update/delete been happening only with primarykey attribute
	String updateQueryString = "update employees set empName=\"Mallika\" where empId=1007";
	String deletionQueryString = "delete from employees where empId=1007";
		
	//PreparedStatement
	String updateQueryForPreparedStatment = "update employees set empName =? where empId = ?";
	
	
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
		
		boolean insertUpdateDeleteValue = false;	
		
		if(insertUpdateDeleteValue) {
			int rowsAffected = stmt.executeUpdate(insertionQueryString);		//executeUpdate for CUD operations (DML) or DDL operations
			System.out.println("\nRows Affected after insertion: "+rowsAffected);
			executeSelectStatement(stmt);
			
			rowsAffected = stmt.executeUpdate(updateQueryString);
			System.out.println("\nRows Affected after update: "+rowsAffected);
			executeSelectStatement(stmt);
			
			rowsAffected = stmt.executeUpdate(deletionQueryString);
			System.out.println("\nRows Affected after delete: "+rowsAffected);
			executeSelectStatement(stmt);

		}
	}
	
	private void executeSelectStatement(Statement stmt) throws SQLException {
		
		ResultSet resultSet = stmt.executeQuery(selectionQueryString);		//executeQuery for select statements
		
		System.out.println("\n\nPrinting employees' details:\n");
		while(resultSet.next()) {
			System.out.println(resultSet.getInt("empId")+","+resultSet.getString("empName")+","+resultSet.getString("address")+","+resultSet.getString("deptId"));
		}
	}
	
	public void SQLInjectionAttackDemo() throws SQLException{
		
		String maliciousString = "\"Mrs.Latha\" --";	//-- simply ignores following statments.. thus updating all the records in the table
		String updateString = "update employees set empName="+maliciousString+" where empId=1";
		Connection dbConn = DriverManager.getConnection(dbConnection, userName, password);
		Statement stmt = dbConn.createStatement();
		
		System.out.println("updated query string : "+updateString);
		int rowsAffected = stmt.executeUpdate(updateString);
		executeSelectStatement(stmt);
	}
	
	/**
	 * PreparedStatement extends Statement as to specify the parameters instead of dynamically creating query.
	 * Advantages:
	 * 		PS are pre-compiled so executes faster;
	 * 		Prevents SQL Injection attack; (whatever sends in data part it taken as data only- example below)
	 * 			https://stackoverflow.com/questions/8263371/how-can-prepared-statements-protect-from-sql-injection-attacks
	 * 
	 * @throws SQLException
	 */
	public void PreparedStatementDemo() throws SQLException{
				
		Connection dbConn = DriverManager.getConnection(dbConnection, userName, password);
		PreparedStatement stmt = dbConn.prepareStatement(updateQueryForPreparedStatment);
		
		stmt.setString(1, "\"Mrs.Latha\" --");
		stmt.setInt(2, 1);
		
		int rowsAffected = stmt.executeUpdate();
		executeSelectStatement(stmt);
	}
}
