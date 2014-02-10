package org.exchange.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import oracle.sql.DATE;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class DataAccess {
	
	
	public DataAccess() {
		// TODO Auto-generated constructor stub
	}
	
	

	private Connection getConnection() {
		Connection con = null;
		try{
		Class.forName("com.mysql.jdbc.Driver");

		con = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/currencydb", "root", "root");
		}catch(Exception e) {
			
		}
		return con;
	}

	public String getCurrencyName(int id) {
		String name = null;
		Connection connection = getConnection();
		
		try {
		String sql = "SELECT * FROM currency WHERE (id ="+id+")";
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
		
		ResultSet result = statement.executeQuery();
		
		while (result.next()) {
		name = result.getString(2);
//		System.out.println("id: " + result.getString(1)
//				+ " currency name: " + name);
		}
		}catch(Exception e) {
			
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return name;
	}
	
	public void dataAccess() throws Exception {

		Connection con = getConnection();

		PreparedStatement statement = (PreparedStatement) con
				.prepareStatement("select * from currency");
		
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			System.out.println("id: " + result.getString(1)
					+ " currency name: " + result.getString(2));

		}
	}
		
	public double getCurrencyRate (int id) {
		double rate = 0;
		Connection connection = getConnection();
		try {
		String sql = "SELECT * FROM rate WHERE (id=" + id + ")";
		
		PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
		ResultSet result = statement.executeQuery();

		while (result.next()) {
			rate = result.getDouble("rate");
		}
		}catch(Exception e) {
			
		}
		return rate;
	}
	
	
//	public void insertData() throws ClassNotFoundException, SQLException {
//		
//		Connection connnection = getConnection();
//		
//		String sql = "INSERT INTO currencydb.currency ( id, name) VALUES ( ?, ?)";
//		
//		PreparedStatement statement = (PreparedStatement) connnection
//				.prepareStatement(sql);
//		
//		statement.setInt(1, 3);
//		statement.setString(2, "RUB");
//		
//		statement.executeUpdate();
//
//	}

}
