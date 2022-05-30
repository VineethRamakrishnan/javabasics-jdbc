package main.java;

import java.sql.SQLException;

import main.java.jdbc.JDBCBasicExplainer;

public class JDBCMainApplication {

	public static void main(String[] args) throws SQLException {
		
		System.out.println("This application will talk about jdbc..!");
		JDBCBasicExplainer jdbcExplainer = new JDBCBasicExplainer();
		jdbcExplainer.executeBasicDBOperations();
		//jdbcExplainer.SQLInjectionAttackDemo();
		jdbcExplainer.PreparedStatementDemo();
	}

}
