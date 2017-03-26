package it.polito.tdp.libretto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnect {
	
	static public Connection getConnection() {
		final String jdbcURL = "jdbc:mysql://localhost/libretto" ;
		
		try {
			Connection c = DriverManager.getConnection(jdbcURL, "root", "root");
			
			return c ;
		} catch (SQLException e) {
			System.err.println("Impossibile collegarsi al database: "+e.getMessage()) ;
			e.printStackTrace();
		}
		
		return null ;
	}
	
	public static void main(String[] args) {
		DBConnect.getConnection() ;
	}

}
