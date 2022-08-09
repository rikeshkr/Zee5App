package com.zee.zee5app.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zee.zee5app.exceptions.UnabletoGenerateIdException;

public class DBUtils {

//	public static void main(String[] args) {
//		DBUtils dbUtils = DBUtils.getInstance();
//		Properties properties = dbUtils.loadProperties();
//		System.out.println(properties);
//	}

	private DBUtils() {
		// TODO Auto-generated constructor stub
	}

	private static DBUtils dbUtils;

	public static DBUtils getInstance() {
		// userRepo object

		if (dbUtils == null) {
			dbUtils = new DBUtils();

		}

		return dbUtils;
	}

	public Connection getConnection() {

		Properties properties = loadProperties();
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(properties.getProperty("db.url"),
					properties.getProperty("db.username"), properties.getProperty("db.password"));
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	because it can read the line and assign key and value
	private Properties loadProperties() {
		Properties properties = new Properties();
		InputStream inputStream = null;
		try {
			inputStream = DBUtils.class.getClassLoader().getResourceAsStream("application.properties");
			System.out.println(inputStream != null);
			properties.load(inputStream);
			return properties;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
//		properties.load();
		return properties;
	}

	public String idGenerator(String firstName, String lastName) throws UnabletoGenerateIdException {
		// It is responsible to generate the userid for user entity
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int id = 0;
		int updateResult = 0;
		String newId = null;
		String query = "select id from useridgenerator";
		String updatequery = "update useridgenerator set id=?";

		connection = this.getConnection();
		try {
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
				id++;
				newId = "" + firstName.charAt(0) + lastName.charAt(0) + id;
				System.out.println(newId);
				preparedStatement = connection.prepareStatement(updatequery);
				preparedStatement.setInt(1, id);
				updateResult = preparedStatement.executeUpdate();
				if (updateResult == 0) {
					throw new UnabletoGenerateIdException("unable to generate userid");
				}
				return newId;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UnabletoGenerateIdException("uanble to generate id since some sql exceptions" + e.getMessage());
		}

		finally {
			this.closeConnection(connection);
		}
		return null;
		// 1st retrieve value (db stored value from idgen table)
		// take first char from first name and last name then increment the number
		// retrive from id table
		// concat and return
	}

//	public static void main(String[] args) {
//		String res=null;
//		try {
//			res = DBUtils.getInstance().idGenerator("Rikesh", "Kumar");
////			System.out.println(res);
//		} catch (UnabletoGenerateIdException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(res);
//	}
}
