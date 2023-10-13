package com.migrar.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.migrar.utils.Colors;

public class DatabaseConnection {
	private static final String url = "jdbc:mysql://localhost:3306/migrar";
	private static final String user = "root";
	private static final String password = "";

	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println(Colors.GREEN.get() + "Driver encontrado!" + Colors.RESET.get());
		} catch (ClassNotFoundException e) {
			System.out.println(
					Colors.RED.get() + "Driver não encontrado! Mensagem: " + e.getMessage() + Colors.RESET.get());
		}

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println(Colors.GREEN.get() + "Conectado com sucesso!" + Colors.RESET.get());
			return connection;
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "Não foi possível conectar ao banco! Mensagem: " + e.getMessage()
					+ Colors.RESET.get());
			return null;
		}
	}
}
