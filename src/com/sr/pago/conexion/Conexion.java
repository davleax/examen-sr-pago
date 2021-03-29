package com.sr.pago.conexion;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class Conexion {

	public Connection conexion() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/compras_sr_pago", "root",
					"");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return connection;
	}

}
