package com.flipkart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBConnection {

	private static Connection connection = null;

    private static final Logger logger = LoggerFactory.getLogger(DBConnection.class);
	public static Connection getConnection() {
		
		if (connection != null)
			return connection;
		else {
			try {
//				Properties prop = new Properties();
//				logger.debug("in connection class");
//				System.out.println("sdooacok");
//				InputStream inputStream = DBConnection.class.getClassLoader().getResourceAsStream("./config.properties");
//				System.out.println(String.valueOf(inputStream)+"-----------");
//				prop.load(inputStream);
//				String driver = prop.getProperty("driver");
//				String url = prop.getProperty("url");
//				String user = prop.getProperty("user");
//				String password = prop.getProperty("password");
////				String user = "root";
////				String password = "honey@98";
//				Class.forName(driver);
//				connection = DriverManager.getConnection(url, user, password);
//				System.out.println("-----"+connection+"------");
				
				Properties prop = new Properties();
                InputStream inputStream = new FileInputStream("/home/harshil/eclipse-workspace/JEDI-04-G1-CRS-project/JEDI-CRS-DROPWIZARD-PROJECT/src/config.properties");
                prop.load(inputStream);
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}


}
