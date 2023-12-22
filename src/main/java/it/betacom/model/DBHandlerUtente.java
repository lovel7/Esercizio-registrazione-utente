package it.betacom.model;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;

public class DBHandlerUtente {

	private static final String URL = "jdbc:mysql://localhost:3306/esercizioutentiservlet";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	private static DBHandlerUtente instance;
	private Connection connection;

	private DBHandlerUtente() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Errore nel caricamento del driver");
			e.printStackTrace();
		}
	}

	public static synchronized DBHandlerUtente getInstance() {
		if (instance == null) {
			instance = new DBHandlerUtente();
		}
		return instance;
	}

	public Connection getConnection() {
		return this.connection;
	}
}
